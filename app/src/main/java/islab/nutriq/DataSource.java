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

    private String[] columns = {
            MyDatabaseHelper.COLUMN_FRAGE_ID,
            MyDatabaseHelper.COLUMN_FRAGE_TEXT,
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
                columns, MyDatabaseHelper.COLUMN_FRAGE_ID + "=" + insertId,
                null, null, null, null);

        cursor.moveToFirst();
        Questions questions = cursorToQuestions(cursor);
        cursor.close();

        return questions;
    }

    private Questions cursorToQuestions(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FRAGE_ID);
        int idFrage = cursor.getColumnIndex(MyDatabaseHelper.COLUMN_FRAGE_TEXT);

        String frage = cursor.getString(idFrage);
        long id = cursor.getLong(idIndex);

        Questions questions = new Questions(id, frage);

        return questions;
    }


}
