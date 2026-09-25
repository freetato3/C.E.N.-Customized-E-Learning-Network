public class MultipleChoice extends Question{
    private String[] choices;


    public MultipleChoice(
            String question,
            String correctAnswer,
            String topic,
            String difficulty,
            String[] choices) {

        super(
            question,
            correctAnswer,
            topic,
            difficulty
        );

        this.choices = choices;
    }


    public String[] getChoices() {
        return choices;
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

        for (int i = 0; i < choices.length; i++) {

            char letter =
                (char) ('A' + i);

            System.out.println(
                "   " + letter +
                ". " + choices[i]
            );
        }
    }    
}
