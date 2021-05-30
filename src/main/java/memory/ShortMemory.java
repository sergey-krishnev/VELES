package memory;

import java.util.HashMap;
import java.util.Map;

public class ShortMemory {

    private int questionPositionFromConnection;

    private int answerPositionFromAnswers = -1;

    private int previousDistanceBetweenStrings = 0;

    private Map<Integer, Integer> connection = new HashMap<>();

    private String response;

    private boolean hasQuestion = true;

    public boolean isHasQuestion() {
        return hasQuestion;
    }

    public void setHasQuestion(boolean hasQuestion) {
        this.hasQuestion = hasQuestion;
    }

    public int getAnswerPositionFromAnswers() {
        return answerPositionFromAnswers;
    }

    public void setAnswerPositionFromAnswers(int answerPositionFromAnswers) {
        this.answerPositionFromAnswers = answerPositionFromAnswers;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getQuestionPositionFromConnection() {
        return questionPositionFromConnection;
    }

    public void setQuestionPositionFromConnection(int questionPositionFromConnection) {
        this.questionPositionFromConnection = questionPositionFromConnection;
    }

    public int getPreviousDistanceBetweenStrings() {
        return previousDistanceBetweenStrings;
    }

    public void setPreviousDistanceBetweenStrings(int previousDistanceBetweenStrings) {
        this.previousDistanceBetweenStrings = previousDistanceBetweenStrings;
    }

    public Map<Integer, Integer> getConnection() {
        return connection;
    }

    public void setConnection(Map<Integer, Integer> connection) {
        this.connection = connection;
    }
}
