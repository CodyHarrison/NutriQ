package islab.nutriq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = MyDatabaseHelper.class.getSimpleName();

    //Name der Datenbank
    public static final String DB_NAME = "nutriq.db";
    //Version der Datenbank
    public static final int DB_VERSION = 1;

    //Name der 1. Tabelle Frage
    public static final String FRAGE = "Frage";
    //Namen der Attribute aus der Tabelle Frage
    public static final String COLUMN_FRAGE_ID = "FrageId";
    public static final String COLUMN_FRAGE_TEXT = "FrageText";

    //CREATE Statement zur Erstellung der Tabelle Frage
    public static final String CREATE_FRAGE =
            "CREATE TABLE " + FRAGE +
                    "(" + COLUMN_FRAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FRAGE_TEXT + " TEXT NOT NULL, ";
    //________________________________________________________________________________

    //Name der 2. Tabelle NuAntwort
    public static final String NUANTWORT = "NuAntwort";
    //Namen der Attribute aus der Tabelle NuAntwort
    public static final String COLUMN_NUAN_ID = "NuAnId";
    public static final String COLUMN_NUAN_TEXT = "NuAnText";
    public static final String COLUMN_FK_FRAGE_ID = "FrageId";

    //CREATE Statement zur Erstellung der Tabelle NuAntwort
    public static final String CREATE_NUANTWORT =
            "CREATE TABLE" + NUANTWORT +
                    "(" + COLUMN_NUAN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NUAN_TEXT + " TEXT NOT NULL, " +
                    COLUMN_FK_FRAGE_ID + " INTEGER," +
                    " FOREIGN KEY (" + COLUMN_FK_FRAGE_ID + ") REFERENCES " + FRAGE + "(" + COLUMN_FRAGE_ID + "));";
    //________________________________________________________________________________

    //Name der 3. Tabelle SysAntwort
    public static final String SYSANTWORT = "SysAntwort";
    //Namen der Attribute aus der Tabelle SysAntwort
    public static final String COLUMN_SYSAN_ID = "SysAnId";
    public static final String COLUMN_SYSAN_TEXT = "SysAnText";
    public static final String COLUMN_FK_NUAN_ID = "NuAnId";

    //CREATE Statement zur Erstellung der Tabelle SysAntwort
    public static final String CREATE_SYSANTWORT =
            "CREATE TABLE" + SYSANTWORT +
                    "(" + COLUMN_SYSAN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT. " +
                    COLUMN_SYSAN_TEXT + " TEXT NOT NULL, " +
                    " FOREIGN KEY (" + COLUMN_FK_NUAN_ID + ") REFERENCES " + NUANTWORT + "(" + COLUMN_NUAN_ID + "));";


    public MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + CREATE_FRAGE + " angelegt.");
            db.execSQL(CREATE_FRAGE);
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + CREATE_NUANTWORT + " angelegt");
            db.execSQL(CREATE_NUANTWORT);
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + CREATE_SYSANTWORT + " angelegt");
            db.execSQL(CREATE_SYSANTWORT);
        } catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_FRAGE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_NUANTWORT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_SYSANTWORT);
        onCreate(db);
    }
}
