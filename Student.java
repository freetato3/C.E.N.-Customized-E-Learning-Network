import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    private int score;
    private int totalQuestions;
    private double percentage;
    private ArrayList<String> weakTopics;


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
        weakTopics = new ArrayList<>();
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
        weakTopics.clear();


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

                // Remember the topic so lessons can be recommended
                String wrongTopic =
                    question.getTopic().trim();

                boolean alreadyListed = false;

                for (String t : weakTopics) {

                    if (t.equalsIgnoreCase(wrongTopic)) {

                        alreadyListed = true;
                    }
                }

                if (!alreadyListed) {

                    weakTopics.add(wrongTopic);
                }

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


    // ========================================================
    // RECOMMEND LESSONS
    // ========================================================
    public void recommendLessons(
            ArrayList<Lesson> lessons) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        if (totalQuestions == 0) {

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "         RECOMMENDED LESSONS"
        );

        System.out.println(
            "=========================================="
        );


        if (weakTopics.isEmpty()) {

            System.out.println(
                "No weak topics found. " +
                "You answered everything correctly!"
            );

            return;
        }


        boolean found = false;


        for (Lesson lesson : lessons) {

            for (String topic : weakTopics) {

                if (lesson.getTopic().trim()
                        .equalsIgnoreCase(topic)) {

                    lesson.displayLesson();

                    found = true;

                    break;
                }
            }
        }


        if (!found) {

            System.out.println(
                "You missed questions on: " +
                String.join(", ", weakTopics)
            );

            System.out.println(
                "No matching lessons are available yet."
            );
        }
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


    public ArrayList<String> getWeakTopics() {
        return new ArrayList<>(weakTopics);
    }
}