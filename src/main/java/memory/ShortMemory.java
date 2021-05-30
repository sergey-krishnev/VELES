package memory;

public class ShortMemory {

    private int questionPositionFromConnection;

    private int answerPositionFromAnswers = -1;

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

}
