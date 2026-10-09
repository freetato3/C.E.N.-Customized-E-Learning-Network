import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    private int score;
    private int totalQuestions;
    private double percentage;


    public Student(
            String email,
            String username,
            String password) {

        super(
            email,
            username,
            password
        );

        score = 0;
        totalQuestions = 0;
        percentage = 0;
    }


    // ========================================================
    // TAKE QUIZ
    // ========================================================
    public void takeQuiz(
            String title,
            ArrayList<Question> questions,
            Scanner scanner) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        if (questions.isEmpty()) {

            System.out.println(
                "\nThere are no questions available."
            );

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "              " +
            title.toUpperCase()
        );

        System.out.println(
            "=========================================="
        );


        score = 0;


        for (int i = 0;
             i < questions.size();
             i++) {

            Question question =
                questions.get(i);


            System.out.println(
                "\nQuestion " + (i + 1) + ":"
            );


            // POLYMORPHISM
            question.displayQuestion();


            String userAnswer;


            // =================================================
            // MULTIPLE CHOICE
            // =================================================
            if (question instanceof MultipleChoice) {

                while (true) {

                    System.out.print(
                        "\nYour answer (A/B/C/D): "
                    );

                    userAnswer =
                        scanner.nextLine()
                               .trim()
                               .toUpperCase();


                    if (userAnswer.equals("A")
                            || userAnswer.equals("B")
                            || userAnswer.equals("C")
                            || userAnswer.equals("D")) {

                        break;
                    }


                    System.out.println(
                        "Invalid answer. " +
                        "Please enter A, B, C, or D."
                    );
                }
            }


            // =================================================
            // TRUE / FALSE
            // =================================================
            else if (question instanceof TrueFalse) {

                while (true) {

                    System.out.print(
                        "\nYour answer (A/B): "
                    );

                    userAnswer =
                        scanner.nextLine()
                               .trim()
                               .toUpperCase();


                    if (userAnswer.equals("A")) {

                        userAnswer = "True";
                        break;

                    } else if (userAnswer.equals("B")) {

                        userAnswer = "False";
                        break;

                    } else {

                        System.out.println(
                            "Invalid answer. " +
                            "Please enter A for True " +
                            "or B for False."
                        );
                    }
                }
            }


            // =================================================
            // IDENTIFICATION
            // =================================================
            else {

                System.out.print(
                    "\nYour answer: "
                );

                userAnswer =
                    scanner.nextLine().trim();
            }


            // =================================================
            // CHECK ANSWER
            // =================================================

            // POLYMORPHISM
            if (question.checkAnswer(userAnswer)) {

                System.out.println("Correct!");

                score++;

            } else {

                System.out.println("Incorrect.");

                System.out.println(
                    "Correct answer: " +
                    question.getCorrectAnswer()
                );
            }
        }


        totalQuestions =
            questions.size();


        percentage =
            ((double) score / totalQuestions)
            * 100;


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "              QUIZ RESULTS"
        );

        System.out.println(
            "=========================================="
        );

        System.out.println(
            "Student: " + getUsername()
        );

        System.out.println(
            "Score: " +
            score +
            "/" +
            totalQuestions
        );

        System.out.printf(
            "Percentage: %.1f%%%n",
            percentage
        );


        if (percentage == 100) {

            System.out.println(
                "Perfect score! Excellent work!"
            );

        } else if (percentage >= 80) {

            System.out.println(
                "Great job!"
            );

        } else if (percentage >= 60) {

            System.out.println(
                "Good effort! Keep practicing."
            );

        } else {

            System.out.println(
                "Keep studying and try again!"
            );
        }


        System.out.println(
            "=========================================="
        );
    }


    // ========================================================
    // VIEW PROGRESS
    // ========================================================
    public void viewProgress() {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "           STUDENT PROGRESS"
        );

        System.out.println(
            "=========================================="
        );

        System.out.println(
            "Student: " + getUsername()
        );

        System.out.println(
            "Latest Score: " +
            score +
            "/" +
            totalQuestions
        );

        System.out.printf(
            "Percentage: %.1f%%%n",
            percentage
        );

        System.out.println(
            "=========================================="
        );
    }


    public int getScore() {
        return score;
    }


    public int getTotalQuestions() {
        return totalQuestions;
    }


    public double getPercentage() {
        return percentage;
    }
}
