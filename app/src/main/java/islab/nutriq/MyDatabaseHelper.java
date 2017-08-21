package islab.nutriq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = MyDatabaseHelper.class.getSimpleName();

    //____________________________________________________________
    //Fragen, die in die Datenbank eingefügt werden sollen
    private static String frage1 = "Hallo User. Macht spätes essen dick?";

    //_____________________________________________________________
    //Nutzerantworten, die in die Datenbank eingefügt werden sollen
    private static String nutzerAntwort01 = "Ja";
    private static String nutzerAntwort02 = "Nein";
    private static String nutzerAntwort03 = "Es kommt auf die Mahlzeit an";

    //_____________________________________________________________
    private static String systemAntwort01 = "Das ist korrekt. Die Uhrzeit der Nahrungsmittelaufnahme ist nicht entscheidend für die Gewichtszunahme. Es kommt auf die Gesamtzahl der Kalorien an, die am Tag aufgenommen werden.";
    private static String systemAntwort02 = "Das stimmt so leider nicht. Die Uhrzeit der Nahrungsmittelaufnahme ist nicht entscheidend für die Gewichtszunahme. Es kommt auf die Gesamtzahl der Kalorien an, die am Tag aufgenommen werden.";
    private static String systemAntwort03 = "Prinzipiell ist das korrekt. Wenn die Gesamtzahl der aufgenommenen Kalorien bis spät Abends noch nicht zu groß ist, kann man Abends ruhig essen ohne zuzunehmen.";

    //Insert Statements
    String IN_FRAGE1 = "INSERT INTO " + TABLE_FRAGE + " (" + COLUMN_FRAGE_TEXT + ") VALUES ('" + frage1 + "');";

    String IN_NuAN1 = "INSERT INTO " + TABLE_NUANTWORT + " (" + COLUMN_NUAN_TEXT + ", " + COLUMN_FK_FRAGE_ID + ") VALUES ('" + nutzerAntwort01 + "','1');";
    String IN_NuAN2 = "INSERT INTO " + TABLE_NUANTWORT + " (" + COLUMN_NUAN_TEXT + ", " + COLUMN_FK_FRAGE_ID + ") VALUES ('" + nutzerAntwort02 + "','1');";
    String IN_NuAN3 = "INSERT INTO " + TABLE_NUANTWORT + " (" + COLUMN_NUAN_TEXT + ", " + COLUMN_FK_FRAGE_ID + ") VALUES ('" + nutzerAntwort03 + "','1');";

    String IN_SysAN1 = "INSERT INTO " + TABLE_SYSANTWORT + " (" + COLUMN_SYSAN_TEXT + ", " +COLUMN_FK_NUAN_ID + ") VALUES ('" + systemAntwort01 + "','1');";
    String IN_SysAN2 = "INSERT INTO " + TABLE_SYSANTWORT + " (" + COLUMN_SYSAN_TEXT + ", " +COLUMN_FK_NUAN_ID + ") VALUES ('" + systemAntwort02 + "','2');";
    String IN_SysAN3 = "INSERT INTO " + TABLE_SYSANTWORT + " (" + COLUMN_SYSAN_TEXT + ", " +COLUMN_FK_NUAN_ID + ") VALUES ('" + systemAntwort03 + "','3');";

    //Name der Datenbank
    public static final String DB_NAME = "nutriq.db";
    //Version der Datenbank
    public static final int DB_VERSION = 2;

    //Name der 1. Tabelle Frage
    public static final String TABLE_FRAGE = "Frage";
    //Namen der Attribute aus der Tabelle Frage
    public static final String COLUMN_FRAGE_ID = "FrageId";
    public static final String COLUMN_FRAGE_TEXT = "FrageText";

    //CREATE Statement zur Erstellung der Tabelle Frage
    public static final String CREATE_FRAGE =
            "CREATE TABLE " + TABLE_FRAGE +
                    "(" + COLUMN_FRAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FRAGE_TEXT + " TEXT NOT NULL);";
    //________________________________________________________________________________

    //Name der 2. Tabelle NuAntwort
    public static final String TABLE_NUANTWORT = "NuAntwort";
    //Namen der Attribute aus der Tabelle NuAntwort
    public static final String COLUMN_NUAN_ID = "NuAnId";
    public static final String COLUMN_NUAN_TEXT = "NuAnText";
    public static final String COLUMN_FK_FRAGE_ID = "FrageId";

    //CREATE Statement zur Erstellung der Tabelle NuAntwort
    public static final String CREATE_NUANTWORT =
            "CREATE TABLE " + TABLE_NUANTWORT +
                    "(" + COLUMN_NUAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NUAN_TEXT + " TEXT NOT NULL, " +
                    COLUMN_FK_FRAGE_ID + " INTEGER," +
                    " FOREIGN KEY (" + COLUMN_FK_FRAGE_ID + ") REFERENCES " + TABLE_FRAGE + "(" + COLUMN_FRAGE_ID + "));";
    //________________________________________________________________________________

    //Name der 3. Tabelle SysAntwort
    public static final String TABLE_SYSANTWORT = "SysAntwort";
    //Namen der Attribute aus der Tabelle SysAntwort
    public static final String COLUMN_SYSAN_ID = "SysAnId";
    public static final String COLUMN_SYSAN_TEXT = "SysAnText";
    public static final String COLUMN_FK_NUAN_ID = "NuAnId";

    //CREATE Statement zur Erstellung der Tabelle SysAntwort
    public static final String CREATE_SYSANTWORT =
            "CREATE TABLE " + TABLE_SYSANTWORT +
                    "(" + COLUMN_SYSAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_SYSAN_TEXT + " TEXT NOT NULL, " +
                    COLUMN_FK_NUAN_ID + " INTEGER," +
                    " FOREIGN KEY (" + COLUMN_FK_NUAN_ID + ") REFERENCES " + TABLE_NUANTWORT + "(" + COLUMN_NUAN_ID + "));";


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
            db.execSQL(IN_FRAGE1);
            db.execSQL(IN_NuAN1);
            db.execSQL(IN_NuAN2);
            db.execSQL(IN_NuAN3);
            db.execSQL(IN_SysAN1);
            db.execSQL(IN_SysAN2);
            db.execSQL(IN_SysAN3);
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
