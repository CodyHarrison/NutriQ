package islab.nutriq;


import com.github.bassaer.chatmessageview.utils.TimeUtils;

import java.util.Calendar;

public class Chatbot {

    DataSource dataSource;
    static MainActivity mainActivity;

    public static String answer(String username, String message) {
        String receive = message.toLowerCase();
        if (receive.contains("hallo")) {
            String user = "";
            if (username != null) {
                user = " " + username;
            }
            return "Hello" + user + "!";
        } else if (receive.contains("hey")) {
            return "Hey " + username + "!";
        } else if (receive.startsWith("do ")) {
            return "Yes, I do.";
        } else if (receive.contains("time")) {
            return "It's " + TimeUtils.calendarToString(Calendar.getInstance(), null) + ".";
        } else if (receive.contains("today")) {
            return "It's " + TimeUtils.calendarToString(Calendar.getInstance(), "M/d(E)");

        } else {
            String reply = "nope";
            if (receive.length() > 7) {
                reply += ", consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
            }
            return reply;
        }
    }
}
