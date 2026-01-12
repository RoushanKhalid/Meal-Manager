package com.example.mealmanager.di;

import com.example.mealmanager.data.local.MealDao;
import com.example.mealmanager.data.local.MealDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideMealDaoFactory implements Factory<MealDao> {
  private final Provider<MealDatabase> databaseProvider;

  public AppModule_ProvideMealDaoFactory(Provider<MealDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MealDao get() {
    return provideMealDao(databaseProvider.get());
  }

  public static AppModule_ProvideMealDaoFactory create(Provider<MealDatabase> databaseProvider) {
    return new AppModule_ProvideMealDaoFactory(databaseProvider);
  }

  public static MealDao provideMealDao(MealDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMealDao(database));
  }
}
