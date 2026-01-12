package com.example.mealmanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mealmanager.ui.MealViewModel
import java.util.*

@Composable
fun CalendarScreen(viewModel: MealViewModel) {
    val mealRecords by viewModel.mealRecords.collectAsState(initial = emptyList())
    var selectedDate by remember { mutableStateOf(Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis) }

    // State for displayed month/year
    var displayedYear by remember { mutableStateOf(Calendar.getInstance().get(Calendar.YEAR)) }
    var displayedMonth by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MONTH)) }

    val currentMonthCalendar = Calendar.getInstance().apply {
        set(Calendar.YEAR, displayedYear)
        set(Calendar.MONTH, displayedMonth)
        set(Calendar.DAY_OF_MONTH, 1)
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }

    val daysInMonth = currentMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDayOfWeek = currentMonthCalendar.get(Calendar.DAY_OF_WEEK) - 1 // 0-indexed Sun

    val dates = (1..daysInMonth).map { day ->
        val cal = currentMonthCalendar.clone() as Calendar
        cal.set(Calendar.DAY_OF_MONTH, day)
        cal.timeInMillis
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "📅 Meal Calendar",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Combined Year and Month Navigation
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Year Controls
                IconButton(
                    onClick = {
                        displayedYear -= 1
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        Icons.Default.Remove,
                        contentDescription = "Previous Year",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Text(
                    displayedYear.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                IconButton(
                    onClick = {
                        displayedYear += 1
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Next Year",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Separator
                Text(
                    "•",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 6.dp)
                )

                // Month Controls
                IconButton(
                    onClick = {
                        if (displayedMonth == 0) {
                            displayedMonth = 11
                            displayedYear -= 1
                        } else {
                            displayedMonth -= 1
                        }
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        Icons.Default.Remove,
                        contentDescription = "Previous Month",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Text(
                    currentMonthCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) ?: "",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                IconButton(
                    onClick = {
                        if (displayedMonth == 11) {
                            displayedMonth = 0
                            displayedYear += 1
                        } else {
                            displayedMonth += 1
                        }
                    },
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Next Month",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // Calendar Grid
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Weekday labels
                Row(modifier = Modifier.fillMaxWidth()) {
                    val weekdays = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
                    weekdays.forEach { day ->
                        Text(
                            day,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(7),
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Empty spaces before first day
                    items(firstDayOfWeek) {
                        Spacer(modifier = Modifier.aspectRatio(1f))
                    }

                    items(dates) { dateMillis ->
                        val record = mealRecords.find { it.date == dateMillis }
                        val count = record?.count ?: 0
                        val isSelected = dateMillis == selectedDate

                        Card(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clickable { selectedDate = dateMillis },
                            shape = CircleShape,
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = if (isSelected) 6.dp else 1.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = when {
                                    isSelected -> MaterialTheme.colorScheme.primary
                                    count > 0 -> MaterialTheme.colorScheme.secondaryContainer
                                    else -> MaterialTheme.colorScheme.surface
                                }
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        Calendar.getInstance().apply { timeInMillis = dateMillis }.get(Calendar.DAY_OF_MONTH).toString(),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary
                                               else if (count > 0) MaterialTheme.colorScheme.onSecondaryContainer
                                               else MaterialTheme.colorScheme.onSurface
                                    )
                                    if (count > 0) {
                                        Text(
                                            "$count",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = if (isSelected) MaterialTheme.colorScheme.onPrimary
                                                   else MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Meal Counter Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val selectedRecord = mealRecords.find { it.date == selectedDate }
                val selectedCount = selectedRecord?.count ?: 0

                Text(
                    "Meals for ${Calendar.getInstance().apply { timeInMillis = selectedDate }.get(Calendar.DAY_OF_MONTH)} ${currentMonthCalendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Meal Counter
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilledIconButton(
                        onClick = { viewModel.updateMealCount(selectedDate, (selectedCount - 1).coerceAtLeast(0)) },
                        modifier = Modifier.size(56.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        ),
                        enabled = selectedCount > 0
                    ) {
                        Icon(
                            Icons.Default.Remove,
                            contentDescription = "Decrease",
                            modifier = Modifier.size(28.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            "Meals",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            selectedCount.toString(),
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    FilledIconButton(
                        onClick = { viewModel.updateMealCount(selectedDate, selectedCount + 1) },
                        modifier = Modifier.size(56.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Increase",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Text(
                    "Tap any date above to select",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
