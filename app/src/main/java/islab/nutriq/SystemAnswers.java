package islab.nutriq;

/**
 * Created by Harun on 18.08.17.
 */

public class SystemAnswers {
    private long id;
    private String systemAnswer;
    private long userAnswerId;

    public SystemAnswers(long id, String systemAnswer, long userAnswerId) {
        this.id = id;
        this.systemAnswer = systemAnswer;
        this.userAnswerId = userAnswerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSystemAnswer() {
        return systemAnswer;
    }

    public void setSystemAnswer(String systemAnswer) {
        this.systemAnswer = systemAnswer;
    }

    public long getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(long userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    @Override
    public String toString() {
        String output = id + " : " + systemAnswer + "FK: " + userAnswerId;

        return output;
    }
}
