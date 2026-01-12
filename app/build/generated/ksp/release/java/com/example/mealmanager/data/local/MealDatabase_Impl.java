package com.example.mealmanager.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MealDatabase_Impl extends MealDatabase {
  private volatile MealDao _mealDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `meal_records` (`date` INTEGER NOT NULL, `count` INTEGER NOT NULL, PRIMARY KEY(`date`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `deposits` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `amount` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `settings` (`key` TEXT NOT NULL, `value` TEXT NOT NULL, PRIMARY KEY(`key`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '820d7af3a6137c6205a5070454b992a4')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `meal_records`");
        db.execSQL("DROP TABLE IF EXISTS `deposits`");
        db.execSQL("DROP TABLE IF EXISTS `settings`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsMealRecords = new HashMap<String, TableInfo.Column>(2);
        _columnsMealRecords.put("date", new TableInfo.Column("date", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealRecords.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealRecords = new TableInfo("meal_records", _columnsMealRecords, _foreignKeysMealRecords, _indicesMealRecords);
        final TableInfo _existingMealRecords = TableInfo.read(db, "meal_records");
        if (!_infoMealRecords.equals(_existingMealRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "meal_records(com.example.mealmanager.data.local.MealRecord).\n"
                  + " Expected:\n" + _infoMealRecords + "\n"
                  + " Found:\n" + _existingMealRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsDeposits = new HashMap<String, TableInfo.Column>(3);
        _columnsDeposits.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeposits.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeposits.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDeposits = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDeposits = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDeposits = new TableInfo("deposits", _columnsDeposits, _foreignKeysDeposits, _indicesDeposits);
        final TableInfo _existingDeposits = TableInfo.read(db, "deposits");
        if (!_infoDeposits.equals(_existingDeposits)) {
          return new RoomOpenHelper.ValidationResult(false, "deposits(com.example.mealmanager.data.local.Deposit).\n"
                  + " Expected:\n" + _infoDeposits + "\n"
                  + " Found:\n" + _existingDeposits);
        }
        final HashMap<String, TableInfo.Column> _columnsSettings = new HashMap<String, TableInfo.Column>(2);
        _columnsSettings.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSettings.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSettings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSettings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSettings = new TableInfo("settings", _columnsSettings, _foreignKeysSettings, _indicesSettings);
        final TableInfo _existingSettings = TableInfo.read(db, "settings");
        if (!_infoSettings.equals(_existingSettings)) {
          return new RoomOpenHelper.ValidationResult(false, "settings(com.example.mealmanager.data.local.Setting).\n"
                  + " Expected:\n" + _infoSettings + "\n"
                  + " Found:\n" + _existingSettings);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "820d7af3a6137c6205a5070454b992a4", "85865a6cf939cff575341b8a67d0991a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "meal_records","deposits","settings");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `meal_records`");
      _db.execSQL("DELETE FROM `deposits`");
      _db.execSQL("DELETE FROM `settings`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MealDao.class, MealDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MealDao mealDao() {
    if (_mealDao != null) {
      return _mealDao;
    } else {
      synchronized(this) {
        if(_mealDao == null) {
          _mealDao = new MealDao_Impl(this);
        }
        return _mealDao;
      }
    }
  }
}
