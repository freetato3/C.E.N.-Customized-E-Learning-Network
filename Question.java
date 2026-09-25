public class Question {
    private String question;
    private String correctAnswer;
    private String topic;
    private String difficulty;


    public Question(
            String question,
            String correctAnswer,
            String topic,
            String difficulty) {

        this.question = question;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
        this.difficulty = difficulty;
    }


    public String getQuestion() {
        return question;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }


    public String getTopic() {
        return topic;
    }


    public String getDifficulty() {
        return difficulty;
    }


    // ========================================================
    // POLYMORPHIC METHOD
    // ========================================================
    public boolean checkAnswer(String answer) {

        return answer.equalsIgnoreCase(correctAnswer);
    }


    public void displayQuestion() {

        System.out.println(question);
    }    
}
