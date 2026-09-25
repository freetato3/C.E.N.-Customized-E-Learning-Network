public class TrueFalse extends Question{
    public TrueFalse(
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

        return answer.equalsIgnoreCase(
            getCorrectAnswer()
        );
    }


    @Override
    public void displayQuestion() {

        System.out.println(getQuestion());

        System.out.println("   A. True");
        System.out.println("   B. False");
    }    
}
