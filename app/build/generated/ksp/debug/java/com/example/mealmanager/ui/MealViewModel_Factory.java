package com.example.mealmanager.ui;

import com.example.mealmanager.data.MealRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class MealViewModel_Factory implements Factory<MealViewModel> {
  private final Provider<MealRepository> repositoryProvider;

  public MealViewModel_Factory(Provider<MealRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MealViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static MealViewModel_Factory create(Provider<MealRepository> repositoryProvider) {
    return new MealViewModel_Factory(repositoryProvider);
  }

  public static MealViewModel newInstance(MealRepository repository) {
    return new MealViewModel(repository);
  }
}
