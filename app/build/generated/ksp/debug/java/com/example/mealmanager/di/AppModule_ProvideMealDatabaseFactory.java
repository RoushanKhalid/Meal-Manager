package com.example.mealmanager.di;

import android.content.Context;
import com.example.mealmanager.data.local.MealDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideMealDatabaseFactory implements Factory<MealDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideMealDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MealDatabase get() {
    return provideMealDatabase(contextProvider.get());
  }

  public static AppModule_ProvideMealDatabaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideMealDatabaseFactory(contextProvider);
  }

  public static MealDatabase provideMealDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMealDatabase(context));
  }
}
