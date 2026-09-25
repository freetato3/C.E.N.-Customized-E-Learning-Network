public class Identification extends Question{
    public Identification(
            String question,
            String correctAnswer,
            String topic,
            String difficulty) {

        super(
            question,
            correctAnswer,
            topic,
            difficulty
        );
    }


    @Override
    public boolean checkAnswer(String answer) {

        return answer.trim().equalsIgnoreCase(
            getCorrectAnswer().trim()
        );
    }
}
