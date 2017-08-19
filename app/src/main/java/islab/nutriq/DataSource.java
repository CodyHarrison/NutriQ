package islab.nutriq;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataSource {

    private static final String LOG_TAG = DataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;

    private String[] columnsFrage = {
            MyDatabaseHelper.COLUMN_FRAGE_ID,
            MyDatabaseHelper.COLUMN_FRAGE_TEXT,
    };

    private String[] columsNuAn = {
            MyDatabaseHelper.COLUMN_NUAN_ID,
            MyDatabaseHelper.COLUMN_NUAN_TEXT,
            MyDatabaseHelper.COLUMN_FK_FRAGE_ID,
    };

    private String[] columnsSysAn = {
            MyDatabaseHelper.COLUMN_SYSAN_ID,
            MyDatabaseHelper.COLUMN_SYSAN_TEXT,
            MyDatabaseHelper.COLUMN_FK_NUAN_ID,
    };


    public DataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new MyDatabaseHelper(context);
    }

    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }

    public Questions createQuestions(String frageText) {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_FRAGE_TEXT, frageText);

        long insertId = database.insert(MyDatabaseHelper.TABLE_FRAGE, null, values);

        Cursor cursor = database.query(MyDatabaseHelper.TABLE_FRAGE,
                columnsFrage, MyDatabaseHelper.COLUMN_FRAGE_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        Questions questions = cursorToQuestions(cursor);
        cursor.close();

        return questions;
    }

    public UserAnswers createUserAnswers(String userAnswer, int fkFrageId) {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_NUAN_TEXT, userAnswer);
        values.put(MyDatabaseHelper.COLUMN_FK_FRAGE_ID, fkFrageId);

        long insertId = database.insert(MyDatabaseHelper.TABLE_NUANTWORT, null, values);

        Cursor cursor = database.query(MyDatabaseHelper.TABLE_NUANTWORT,
                columsNuAn, MyDatabaseHelper.COLUMN_NUAN_ID + "=" + insertId,
                null, null, null, null);
        cursor.moveToFirst();
        UserAnswers userAnswers = cursorToUserAnswers(cursor);
        cursor.close();

        return userAnswers;
    }

    public SystemAnswers systemAnswers(String systemAnswer, int fkUserAnswerId) {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_SYSAN_TEXT, systemAnswer);
        values.put(MyDatabaseHelper.COLUMN_FK_NUAN_ID, fkUserAnswerId);

        long insertId = database.insert(MyDatabaseHelper.TABLE_SYSANTWORT, null, values);

        Cursor cursor = database.query(MyDatabaseHelper.TABLE_SYSANTWORT,
                columnsSysAn, MyDatabaseHelper.COLUMN_SYSAN_ID + "=" + insertId,
                null, null, null, null);
        cursor.moveToFirst();
        SystemAnswers systemAnswers = cursorToSystemAnswers(cursor);
        cursor.close();

        return systemAnswers;
    }


    private Questions cursorToQuestions(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FRAGE_ID);
        int idFrage = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FRAGE_TEXT);

        long id = cursor.getLong(idIndex);
        String frage = cursor.getString(idFrage);

        Questions questions = new Questions(id, frage);

        return questions;
    }

    private UserAnswers cursorToUserAnswers(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_NUAN_ID);
        int idNuAn = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_NUAN_TEXT);
        int idFkFrageId = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FK_NUAN_ID);

        long id = cursor.getLong(idIndex);
        String nuAn = cursor.getString(idNuAn);
        long fkFrageId = cursor.getLong(idFkFrageId);

        UserAnswers userAnswers = new UserAnswers(id, nuAn, fkFrageId);

        return userAnswers;
    }

    private SystemAnswers cursorToSystemAnswers(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_SYSAN_ID);
        int idSysAn = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_SYSAN_TEXT);
        int idFkNuAnId = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FK_NUAN_ID);

        long id = cursor.getLong(idIndex);
        String sysAn = cursor.getString(idSysAn);
        long fkNuAnId = cursor.getLong(idFkNuAnId);

        SystemAnswers systemAnswers = new SystemAnswers(id, sysAn, fkNuAnId);

        return systemAnswers;
    }


}
