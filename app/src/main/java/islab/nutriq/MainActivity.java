package islab.nutriq;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private static final int SIGN_IN_REQUEST_CODE = 1;

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private DataSource dataSource;

    public Questions questions;

    ListView list_avatar;
    String[] avatarNames = {"Chris", "Melanie", "Daniel"};
    Integer[] imageID = {R.drawable.image1, R.drawable.image2, R.drawable.image3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Datenbank
        dataSource = new DataSource(this);

        Log.d(LOG_TAG, "Die Datenquelle wird geöffnet.");
        dataSource.open();

        insertQuestions();

        Log.d(LOG_TAG, "Die Datenquelle wird geschlossen.");
        dataSource.close();


        //Adapter für die Liste der Avatare
        CustomList avatarAdapter = new CustomList(MainActivity.this, avatarNames, imageID);

        list_avatar = (ListView) findViewById(R.id.list_avatar);
        list_avatar.setAdapter(avatarAdapter);
        list_avatar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, avatarNames[+position] + " ist im Prototyp nicht verfügbar.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            // Start sign in/sign up activity
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .build(),
                    SIGN_IN_REQUEST_CODE
            );
        } else {
            // User is already signed in. Therefore, a welcome Toast
            Toast.makeText(this,
                    "Willkommen " + FirebaseAuth.getInstance()
                            .getCurrentUser()
                            .getDisplayName(),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void insertQuestions() {
        questions = dataSource.createQuestions("Wie viel Kalorien hat Iso Sport?");
        Log.d(LOG_TAG, "Es wurde der folgende Eintrag in die Datenbank geschrieben:");
        Log.d(LOG_TAG, "ID: " + questions.getId() + ", Inhalt: " + questions.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this,
                                    "Sie wurden abgemeldet.",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // Close activity
                            finish();
                        }
                    });
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Erfolgreich angemeldet. Herzlich Willkommen!",
                        Toast.LENGTH_LONG)
                        .show();
                //displayChatMessages();
            } else {
                Toast.makeText(this,
                        "Es gab einen Fehler. Bitte versuchen Sie es später erneut.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app
                finish();
            }
        }

    }
}
