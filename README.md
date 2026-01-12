# 🍽️ Meal Manager - Take Control of Your Meal Records

**A powerful, privacy-focused Android app for individuals who want to track their own meal expenses and records without relying on external managers or service providers.**

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-API%2024+-green.svg)](https://developer.android.com)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 🎯 Why Meal Manager?

### The Problem
Many people participate in meal systems (hostels, offices, communities) where they pay for meals but have **no control over their records**. They must rely on:
- Mess managers who might make errors
- Service providers with questionable record-keeping
- Manual tracking that gets lost or forgotten
- No transparency in calculations

### The Solution
**Meal Manager gives you complete control** over your meal records:
- ✅ **Track your own meals** - No more relying on others
- ✅ **Monitor your deposits** - See exactly what you've paid
- ✅ **Real-time balance calculation** - Know your financial status instantly
- ✅ **Private & secure** - All data stays on your device
- ✅ **Offline-first** - Works without internet connection
- ✅ **Transparent calculations** - You control the meal rate and see all math

## 🚀 Key Features

### 📅 Smart Calendar Tracking
- **Daily meal logging** with intuitive calendar interface
- **Navigate through months and years** to view past records
- **Visual indicators** show days with recorded meals
- **Easy meal counter** with plus/minus buttons

### 💰 Financial Management
- **Deposit tracking** - Record all money you've added
- **Automatic calculations** - Balance = Deposits - (Meals × Rate)
- **Real-time updates** - See changes instantly
- **Customizable meal rates** - Set your own pricing

### 🔒 Privacy & Security
- **100% offline** - No data sent to servers
- **Local storage only** - Room database on your device
- **No account required** - Start using immediately
- **Your data, your control** - Export, backup, or delete anytime

### 🎨 Beautiful UI/UX
- **Modern Material Design 3** interface
- **Dark/Light theme support** (follows system settings)
- **Intuitive navigation** with bottom tabs
- **Responsive design** for all screen sizes

## 📱 Screenshots & Demo
<img width="1920" height="1080" alt="Untitled design" src="https://github.com/user-attachments/assets/42641729-4d5a-4b6b-bb92-595bba4bc21f" />

## 🛠️ Installation & Setup

### Prerequisites
- **Android Studio** (latest version recommended)
- **Android SDK API 24+** (Android 7.0+)
- **Minimum Android Version**: API 24 (Android 7.0)

### Quick Start

#### Option 1: Android Studio (Recommended)
1. **Download/Clone** this repository
2. **Open Android Studio**
3. **File → Open** → Select the `Meal-Manager` folder
4. **Wait for Gradle sync** to complete
5. **Run** → Select your device/emulator
6. **Start tracking** your meals!

#### Option 2: Build APK for Sharing
```bash
# Build debug APK (for testing)
./gradlew assembleDebug

# Build release APK (for sharing)
./gradlew assembleRelease
```

**Find your APK at:** `app/build/outputs/apk/`

## 📊 How It Works

### 1. Set Your Meal Rate
- Go to **Settings** tab
- Set the cost per meal (e.g., ৳50)
- This rate applies to all calculations

### 2. Track Your Deposits
- Go to **Deposits** tab
- Add money when you deposit funds
- View all deposit history

### 3. Log Daily Meals
- Go to **Calendar** tab
- Navigate to any date
- Use +/- buttons to record meals eaten
- Visual indicators show recorded days

### 4. Monitor Your Balance
- **Dashboard** shows real-time calculations:
  - Total Meals × Meal Rate = Total Cost
  - Total Deposits - Total Cost = Current Balance
- Green = Positive balance
- Light red = Negative balance

## 🏗️ Technical Architecture

```
📁 Meal Manager
├── 🏠 Dashboard (Balance overview & summaries)
├── 📅 Calendar (Meal logging & history)
├── 💰 Deposits (Payment tracking)
├── ⚙️ Settings (Meal rate configuration)
└── 💾 Local Database (Room + SQLite)
```

### Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Repository pattern
- **Database**: Room (SQLite wrapper)
- **Dependency Injection**: Dagger Hilt
- **Navigation**: Jetpack Navigation Compose
- **Material Design**: Material 3 components

### Project Structure
```
app/src/main/java/com/example/mealmanager/
├── data/           # Database entities & DAOs
├── di/            # Dependency injection modules
├── domain/        # Business logic & models
├── ui/            # UI layer (Compose screens & ViewModels)
│   ├── screens/   # Individual screens
│   └── theme/     # App theming
└── MainActivity.kt
```

## 🤝 Contributing

We welcome contributions! This app was built to give users control over their meal records.

### Development Setup
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Make your changes
4. Test thoroughly on multiple devices
5. Submit a pull request

### Guidelines
- Follow Kotlin coding standards
- Use meaningful commit messages
- Test on different screen sizes
- Maintain Material Design 3 principles

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with ❤️ for meal system participants worldwide
- Special thanks to the Android & Kotlin communities
- Icons and design inspired by Material Design guidelines

## 📞 Support

- **Issues**: [GitHub Issues](https://github.com/yourusername/meal-manager/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/meal-manager/discussions)
- **Email**: For private inquiries

---

**Take control of your meal records today!** 🎉

*Built by Sk. Roushan Khalid* 👨‍💻
