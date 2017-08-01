package islab.nutriq;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.bassaer.chatmessageview.models.Message;
import com.github.bassaer.chatmessageview.models.User;
import com.github.bassaer.chatmessageview.views.MessageView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
        //User name
        String myName = "Chris";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
        String yourName = "Harun";

        final User me = new User(myId, myName, myIcon);
        final User you = new User(yourId, yourName, yourIcon);


        Message message1 = new Message.Builder()
                .setUser(me) // Sender
                .setRightMessage(true) // This message Will be shown right side.
                .setMessageText("Hello!") //Message contents
                .build();
        Message message2 = new Message.Builder()
                .setUser(you) // Sender
                .setRightMessage(false) // This message Will be shown left side.
                .setMessageText("What's up?") //Message contents
                .build();

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        MessageView messageView = (MessageView)findViewById(R.id.message_view);
        messageView.init(messages);
    }
}
