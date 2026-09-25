import java.util.ArrayList;
import java.util.Scanner;

public class Tutor extends User{
    public Tutor(
            String email,
            String username,
            String password) {

        super(
            email,
            username,
            password
        );
    }


    // ========================================================
    // CREATE MULTIPLE CHOICE QUESTION
    // ========================================================
    private MultipleChoice createMultipleChoice(
            Scanner scanner) {

        System.out.println(
            "\n------------------------------------------"
        );

        System.out.println(
            "CREATE MULTIPLE CHOICE QUESTION"
        );

        System.out.println(
            "------------------------------------------"
        );


        System.out.print(
            "Enter your question: "
        );

        String question =
            scanner.nextLine().trim();


        String[] choices =
            new String[4];


        for (int i = 0; i < 4; i++) {

            char letter =
                (char) ('A' + i);


            System.out.print(
                "Enter choice " +
                letter +
                ": "
            );


            choices[i] =
                scanner.nextLine().trim();
        }


        String correctAnswer;


        while (true) {

            System.out.print(
                "Enter the correct answer (A/B/C/D): "
            );


            correctAnswer =
                scanner.nextLine()
                       .trim()
                       .toUpperCase();


            if (correctAnswer.equals("A")
                    || correctAnswer.equals("B")
                    || correctAnswer.equals("C")
                    || correctAnswer.equals("D")) {

                break;
            }


            System.out.println(
                "Invalid choice. " +
                "Please enter A, B, C, or D."
            );
        }


        System.out.print(
            "Enter topic: "
        );

        String topic =
            scanner.nextLine().trim();


        System.out.print(
            "Enter difficulty: "
        );

        String difficulty =
            scanner.nextLine().trim();


        return new MultipleChoice(
            question,
            correctAnswer,
            topic,
            difficulty,
            choices
        );
    }


    // ========================================================
    // CREATE TRUE / FALSE QUESTION
    // ========================================================
    private TrueFalse createTrueFalse(
            Scanner scanner) {

        System.out.println(
            "\n------------------------------------------"
        );

        System.out.println(
            "CREATE TRUE / FALSE QUESTION"
        );

        System.out.println(
            "------------------------------------------"
        );


        System.out.print(
            "Enter your question: "
        );

        String question =
            scanner.nextLine().trim();


        String correctAnswer;


        while (true) {

            System.out.print(
                "Enter the correct answer (A=True / B=False): "
            );


            String answer =
                scanner.nextLine()
                       .trim()
                       .toUpperCase();


            if (answer.equals("A")) {

                correctAnswer = "True";
                break;

            } else if (answer.equals("B")) {

                correctAnswer = "False";
                break;

            } else {

                System.out.println(
                    "Invalid answer. " +
                    "Please enter A or B."
                );
            }
        }


        System.out.print(
            "Enter topic: "
        );

        String topic =
            scanner.nextLine().trim();


        System.out.print(
            "Enter difficulty: "
        );

        String difficulty =
            scanner.nextLine().trim();


        return new TrueFalse(
            question,
            correctAnswer,
            topic,
            difficulty
        );
    }


    // ========================================================
    // CREATE IDENTIFICATION QUESTION
    // ========================================================
    private Identification createIdentification(
            Scanner scanner) {

        System.out.println(
            "\n------------------------------------------"
        );

        System.out.println(
            "CREATE IDENTIFICATION QUESTION"
        );

        System.out.println(
            "------------------------------------------"
        );


        System.out.print(
            "Enter your question: "
        );

        String question =
            scanner.nextLine().trim();


        System.out.print(
            "Enter the correct answer: "
        );

        String correctAnswer =
            scanner.nextLine().trim();


        System.out.print(
            "Enter topic: "
        );

        String topic =
            scanner.nextLine().trim();


        System.out.print(
            "Enter difficulty: "
        );

        String difficulty =
            scanner.nextLine().trim();


        return new Identification(
            question,
            correctAnswer,
            topic,
            difficulty
        );
    }


    // ========================================================
    // CREATE QUESTION
    // ========================================================
    public Question createQuestion(
            Scanner scanner) {

        while (true) {

            System.out.println(
                "\n=========================================="
            );

            System.out.println(
                "             CHOOSE QUESTION TYPE"
            );

            System.out.println(
                "=========================================="
            );

            System.out.println(
                "1. Multiple Choice"
            );

            System.out.println(
                "2. True or False"
            );

            System.out.println(
                "3. Identification"
            );

            System.out.println(
                "=========================================="
            );


            System.out.print(
                "Choose question type: "
            );


            String choice =
                scanner.nextLine()
                       .trim();


            if (choice.equals("1")) {

                return createMultipleChoice(
                    scanner
                );

            } else if (choice.equals("2")) {

                return createTrueFalse(
                    scanner
                );

            } else if (choice.equals("3")) {

                return createIdentification(
                    scanner
                );

            } else {

                System.out.println(
                    "\nInvalid option. " +
                    "Please choose 1, 2, or 3."
                );
            }
        }
    }


    // ========================================================
    // CREATE QUIZ
    // ========================================================
    public void createQuiz(
            Scanner scanner,
            ArrayList<Question> questions) {

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
            "             CREATE YOUR QUIZ"
        );

        System.out.println(
            "=========================================="
        );


        System.out.print(
            "Enter your quiz title: "
        );


        String title =
            scanner.nextLine().trim();


        if (title.isEmpty()) {

            System.out.println(
                "Quiz title cannot be empty."
            );

            return;
        }


        QuizData.setTitle(title);


        while (true) {

            Question question =
                createQuestion(scanner);


            questions.add(question);


            System.out.println(
                "\nQuestion added successfully!"
            );


            String addMore;


            while (true) {

                System.out.print(
                    "\nAdd another question? (Y/N): "
                );


                addMore =
                    scanner.nextLine()
                           .trim()
                           .toUpperCase();


                if (addMore.equals("Y")
                        || addMore.equals("N")) {

                    break;
                }


                System.out.println(
                    "Please enter Y or N."
                );
            }


            if (addMore.equals("N")) {

                break;
            }
        }


        System.out.println(
            "\nYour quiz has been created successfully!"
        );
    }


    // ========================================================
    // VIEW QUIZ
    // ========================================================
    public void displayQuiz(
            String title,
            ArrayList<Question> questions) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        if (questions.isEmpty()) {

            System.out.println(
                "\nNo questions have been created."
            );

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "             " +
            title.toUpperCase()
        );

        System.out.println(
            "=========================================="
        );


        for (int i = 0;
             i < questions.size();
             i++) {

            Question question =
                questions.get(i);


            System.out.print(
                "\n" + (i + 1) + ". "
            );


            question.displayQuestion();


            System.out.println(
                "Topic: " +
                question.getTopic()
            );


            System.out.println(
                "Difficulty: " +
                question.getDifficulty()
            );
        }
    }


    // ========================================================
    // CREATE LESSON
    // ========================================================
    public void createLesson(
            Scanner scanner,
            ArrayList<Lesson> lessons) {

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
            "              CREATE LESSON"
        );

        System.out.println(
            "=========================================="
        );


        int week;


        while (true) {

            System.out.print(
                "Pick the week (1-20): "
            );


            try {

                week =
                    Integer.parseInt(
                        scanner.nextLine()
                    );


                if (week >= 1 && week <= 20) {

                    break;
                }


                System.out.println(
                    "Please enter a week from 1 to 20."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid number."
                );
            }
        }


        System.out.print(
            "Enter lesson topic: "
        );

        String topic =
            scanner.nextLine().trim();


        System.out.print(
            "Enter lesson title: "
        );

        String title =
            scanner.nextLine().trim();


        System.out.print(
            "Enter a short description: "
        );

        String description =
            scanner.nextLine().trim();


        Lesson lesson =
            new Lesson(
                week,
                topic,
                title,
                description
            );


        lessons.add(lesson);


        System.out.println(
            "\nLesson created successfully!"
        );
    }


    // ========================================================
    // VIEW LESSONS
    // ========================================================
    public void viewLessons(
            ArrayList<Lesson> lessons) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        if (lessons.isEmpty()) {

            System.out.println(
                "\nNo lessons have been created."
            );

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "              LESSONS"
        );

        System.out.println(
            "=========================================="
        );


        for (Lesson lesson : lessons) {

            lesson.displayLesson();
        }
    }


    // ========================================================
    // VIEW STUDENT PROGRESS
    // ========================================================
    public void viewStudentProgress(
            Student student) {

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
            "         STUDENT PROGRESS"
        );

        System.out.println(
            "=========================================="
        );


        System.out.println(
            "Student: " +
            student.getUsername()
        );


        System.out.println(
            "Latest Score: " +
            student.getScore() +
            "/" +
            student.getTotalQuestions()
        );


        System.out.printf(
            "Percentage: %.1f%%%n",
            student.getPercentage()
        );


        System.out.println(
            "=========================================="
        );
    }
}
