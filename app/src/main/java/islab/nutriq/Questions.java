package islab.nutriq;


public class Questions {

    private String mQuestions[] = {
            "Welches Gericht hat am wenigsten Kalorien?",
            "Wann sollte man keine Mahltzeit mehr zu sich nehmen?",
            "Welches Getränk hat den meisten Zuckergehalt?"
    };

    private String mChoices[][] = {
            {"Döner", "Pizza", "Salat"},
            {"14 Uhr", "16 Uhr", "20 Uhr"},
            {"Cola", "Organensaft", "Wasser"}
    };

    private String mCorrectAnswers[] = {
            "Salat", "20 Uhr", "Cola"
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice0(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice1(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice2(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
