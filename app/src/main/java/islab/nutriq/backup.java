package islab.nutriq;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.bassaer.chatmessageview.models.Message;
import com.github.bassaer.chatmessageview.models.User;
import com.github.bassaer.chatmessageview.views.MessageView;

import java.util.ArrayList;

/**
 * Created by Harun on 16.08.17.
 */

public class backup {

    /* Button buttonA;
    Button buttonB;
    Button buttonC;

    Message message3;
    ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);

        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        //User name
        String myName = "Harun";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
        String yourName = "Chris";

        final User me = new User(myId, myName, myIcon);
        final User you = new User(yourId, yourName, yourIcon);


        Message message1 = new Message.Builder()
                .setUser(you) // Sender
                .setRightMessage(false) // This message Will be shown right side.
                .setMessageText("Hello!") //Message contents
                .build();
        Message message2 = new Message.Builder()
                .setUser(me) // Sender
                .setRightMessage(true) // This message Will be shown left side.
                .setMessageText("What's up?") //Message contents
                .build();

        messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        final MessageView messageView = (MessageView) findViewById(R.id.message_view);
        messageView.init(messages);
        messageView.setRefreshInterval(1000);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message3 = new Message.Builder()
                        .setUser(you)
                        .setRightMessage(true)
                        .setMessageText("adidads")
                        .build();
                messages.add(message3);
            }
        });

    } */
}
