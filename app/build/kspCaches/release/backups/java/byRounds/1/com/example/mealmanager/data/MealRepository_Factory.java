package com.example.mealmanager.data;

import com.example.mealmanager.data.local.MealDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class MealRepository_Factory implements Factory<MealRepository> {
  private final Provider<MealDao> mealDaoProvider;

  public MealRepository_Factory(Provider<MealDao> mealDaoProvider) {
    this.mealDaoProvider = mealDaoProvider;
  }

  @Override
  public MealRepository get() {
    return newInstance(mealDaoProvider.get());
  }

  public static MealRepository_Factory create(Provider<MealDao> mealDaoProvider) {
    return new MealRepository_Factory(mealDaoProvider);
  }

  public static MealRepository newInstance(MealDao mealDao) {
    return new MealRepository(mealDao);
  }
}
