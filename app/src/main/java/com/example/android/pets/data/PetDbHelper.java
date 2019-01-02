package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PetDbHelper extends SQLiteOpenHelper {

    //Once change on db schema has made, the db version must increment;
    public static final int DATABASE_VERSION = 1;

    /** Name of the database file */
    public static final String DATABASE_NAME = "shelter.db";

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    /**
     * Constructs a new instance of {@link PetDbHelper}.
     * @param context
     */
    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " ("
                + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetContract.PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);
        Log.e(LOG_TAG, "PetDbHelper: Database created.");
    }

    /**
     * This is called when the database needs to be upgraded.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
       //onUpgrade(db, oldVersion, newVersion);
        Log.e(LOG_TAG, "PetDbHelper: data upgraded.");
    }
}
