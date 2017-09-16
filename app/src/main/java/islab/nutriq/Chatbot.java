package islab.nutriq;


import com.github.bassaer.chatmessageview.utils.TimeUtils;

import java.util.Calendar;
import java.util.Random;


public class Chatbot {

    private static boolean isGuess = false;
    private static int tmpX;
    public static String answer(String username, String message) {
        String receive = message.toLowerCase();
        String toReturn = "Das habe ich nicht verstanden. Bitte einen Satz mit 'fragen' bilden." + (isGuess?"(Wait for answer)":"");
        if(isGuess) {
            for(int i = 0; i < Data.answer[tmpX].length; i++){
                if(receive.toString().length()>0 && Data.answer[tmpX][i].toLowerCase().contains(receive.toString().toLowerCase())){
                    toReturn = Data.rep[tmpX][i];
                    isGuess = false;
                }
            }
        }
        if ((receive.startsWith("frag")) ||receive.contains("frag")){
            Random rand = new Random();

            tmpX = rand.nextInt(Data.frage.length);
            if(tmpX + 1 <= Data.frage.length && Data.frage[tmpX] != null) {
                isGuess = true;
                toReturn = Data.frage[tmpX] + "\n";
                for(int i = 0; i < Data.answer[tmpX].length; i++){
                    toReturn += i+1 + ") " + Data.answer[tmpX][i] + "\n";
                }
                toReturn += "-------------------\nAntwort als Satz!";
            }
        }
        else { }









        // if (receive.contains("hallo")) {
        //     String user = "";
        //     if (username != null) {
        //         user = " " + username;
        //     }
        //     return "Hallo" + user + "!";
        // } else if (receive.contains("hey")) {
        //     return "Hey " + username + "!";
        // } else if (receive.startsWith("frag")) {
        //     return Data.frage0;
        // } else if (receive.contains("time")) {
        //     return "Es ist " + TimeUtils.calendarToString(Calendar.getInstance(), null) + ".";
        // } else if (receive.contains("today")) {
        //     return "Es ist " + TimeUtils.calendarToString(Calendar.getInstance(), "M/d(E)");
//
        // } else {
        //     String reply = "nope";
        //     if (receive.length() > 7) {
        //         reply += ", consectetur adipiscing elit, " +
        //                 "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        //     }
        //     return reply;
        // }
        return toReturn;
    }
}
