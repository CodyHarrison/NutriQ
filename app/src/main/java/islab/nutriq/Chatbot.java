package islab.nutriq;



import java.util.Random;


public class Chatbot {

    private static boolean isGuess = false;
    private static int tmpX;
    public static String answer(String username, String message) {
        String receive = message.toLowerCase();
        String toReturn = "Das habe ich nicht verstanden. Bitte einen Satz mit 'frag' bilden." + (isGuess?"(Wait for answer)":"");
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
                toReturn += "-------------------\nAntwort als Satz angeben!";
            }
        }
        return toReturn;
    }
}
