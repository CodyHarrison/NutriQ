package islab.nutriq;

/**
 * Created by Harun on 18.08.17.
 */

public class UserAnswers {
    private long id;
    private String userAnswer;
    private long questionsId;

    public UserAnswers(long id, String userAnswer, long questionsId) {
        this.id = id;
        this.userAnswer = userAnswer;
        this.questionsId = questionsId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(long questionsId) {
        this.questionsId = questionsId;
    }

    @Override
    public String toString() {
        String output = id + " : " + userAnswer + "FK: " + questionsId;

        return output;
    }
}
