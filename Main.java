import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
            new Scanner(System.in);


        // ====================================================
        // CREATE USERS
        // ====================================================

        Student student =
            new Student(
                "student@gmail.com",
                "student01",
                "student123"
            );


        Tutor tutor =
            new Tutor(
                "tutor@gmail.com",
                "tutor01",
                "tutor123"
            );


        Admin admin =
            new Admin(
                "admin@gmail.com",
                "admin01",
                "admin123"
            );


        // ====================================================
        // QUIZ STORAGE
        // ====================================================

        ArrayList<Question> questions =
            new ArrayList<>();


        // ====================================================
        // LESSON STORAGE
        // ====================================================

        ArrayList<Lesson> lessons =
            new ArrayList<>();


        // ====================================================
        // MAIN LOOP
        // ====================================================

        boolean running = true;


        while (running) {

            System.out.println(
                "\n=========================================="
            );

            System.out.println(
                "          ONLINE LEARNING SYSTEM"
            );

            System.out.println(
                "=========================================="
            );

            System.out.println(
                "1. Student Login"
            );

            System.out.println(
                "2. Tutor Login"
            );

            System.out.println(
                "3. Admin Login"
            );

            System.out.println(
                "4. Exit"
            );

            System.out.println(
                "=========================================="
            );


            System.out.print(
                "Enter your choice: "
            );


            String choice =
                scanner.nextLine();


            // =================================================
            // STUDENT LOGIN
            // =================================================

            if (choice.equals("1")) {

                System.out.println(
                    "\n===== STUDENT LOGIN ====="
                );


                System.out.print(
                    "Email: "
                );


                String email =
                    scanner.nextLine();


                System.out.print(
                    "Password: "
                );


                String password =
                    scanner.nextLine();


                if (student.login(
                        email,
                        password)) {

                    boolean studentRunning =
                        true;


                    while (studentRunning) {

                        System.out.println(
                            "\n===== STUDENT MENU ====="
                        );


                        System.out.println(
                            "1. Take Quiz"
                        );

                        System.out.println(
                            "2. View Progress"
                        );

                        System.out.println(
                            "3. View Lessons"
                        );

                        System.out.println(
                            "4. Logout"
                        );


                        System.out.print(
                            "\nEnter your choice: "
                        );


                        String studentChoice =
                            scanner.nextLine();


                        if (studentChoice.equals("1")) {

                            student.takeQuiz(
                                QuizData.getTitle(),
                                questions,
                                scanner
                            );


                        } else if (
                            studentChoice.equals("2")
                        ) {

                            student.viewProgress();


                        } else if (
                            studentChoice.equals("3")
                        ) {

                            System.out.println(
                                "\n=========================================="
                            );

                            System.out.println(
                                "              LESSONS"
                            );

                            System.out.println(
                                "=========================================="
                            );


                            if (lessons.isEmpty()) {

                                System.out.println(
                                    "No lessons available."
                                );

                            } else {

                                for (
                                    Lesson lesson :
                                    lessons
                                ) {

                                    lesson.displayLesson();
                                }
                            }


                        } else if (
                            studentChoice.equals("4")
                        ) {

                            student.logout();

                            studentRunning =
                                false;


                        } else {

                            System.out.println(
                                "Invalid option."
                            );
                        }
                    }
                }
            }


            // =================================================
            // TUTOR LOGIN
            // =================================================

            else if (choice.equals("2")) {

                System.out.println(
                    "\n===== TUTOR LOGIN ====="
                );


                System.out.print(
                    "Email: "
                );


                String email =
                    scanner.nextLine();


                System.out.print(
                    "Password: "
                );


                String password =
                    scanner.nextLine();


                if (tutor.login(
                        email,
                        password)) {

                    boolean tutorRunning =
                        true;


                    while (tutorRunning) {

                        System.out.println(
                            "\n===== TUTOR MENU ====="
                        );


                        System.out.println(
                            "1. Create Your Quiz"
                        );

                        System.out.println(
                            "2. View Your Quiz"
                        );

                        System.out.println(
                            "3. Create Lesson"
                        );

                        System.out.println(
                            "4. View Lessons"
                        );

                        System.out.println(
                            "5. View Student Progress"
                        );

                        System.out.println(
                            "6. Logout"
                        );


                        System.out.print(
                            "\nEnter your choice: "
                        );


                        String tutorChoice =
                            scanner.nextLine();


                        if (tutorChoice.equals("1")) {

                            tutor.createQuiz(
                                scanner,
                                questions
                            );


                        } else if (
                            tutorChoice.equals("2")
                        ) {

                            tutor.displayQuiz(
                                QuizData.getTitle(),
                                questions
                            );


                        } else if (
                            tutorChoice.equals("3")
                        ) {

                            tutor.createLesson(
                                scanner,
                                lessons
                            );


                        } else if (
                            tutorChoice.equals("4")
                        ) {

                            tutor.viewLessons(
                                lessons
                            );


                        } else if (
                            tutorChoice.equals("5")
                        ) {

                            tutor.viewStudentProgress(
                                student
                            );


                        } else if (
                            tutorChoice.equals("6")
                        ) {

                            tutor.logout();

                            tutorRunning =
                                false;


                        } else {

                            System.out.println(
                                "Invalid option."
                            );
                        }
                    }
                }
            }


            // =================================================
            // ADMIN LOGIN
            // =================================================

            else if (choice.equals("3")) {

                System.out.println(
                    "\n===== ADMIN LOGIN ====="
                );


                System.out.print(
                    "Email: "
                );


                String email =
                    scanner.nextLine();


                System.out.print(
                    "Password: "
                );


                String password =
                    scanner.nextLine();


                if (admin.login(
                        email,
                        password)) {

                    boolean adminRunning =
                        true;


                    while (adminRunning) {

                        System.out.println(
                            "\n===== ADMIN MENU ====="
                        );


                        System.out.println(
                            "1. Manage Users"
                        );

                        System.out.println(
                            "2. Manage Subjects"
                        );

                        System.out.println(
                            "3. Logout"
                        );


                        System.out.print(
                            "\nEnter your choice: "
                        );


                        String adminChoice =
                            scanner.nextLine();


                        if (adminChoice.equals("1")) {

                            admin.manageUsers(
                                scanner,
                                student,
                                tutor
                            );


                        } else if (
                            adminChoice.equals("2")
                        ) {

                            admin.manageSubjects(
                                scanner,
                                lessons
                            );


                        } else if (
                            adminChoice.equals("3")
                        ) {

                            admin.logout();

                            adminRunning =
                                false;


                        } else {

                            System.out.println(
                                "Invalid option."
                            );
                        }
                    }
                }
            }


            // =================================================
            // EXIT
            // =================================================

            else if (choice.equals("4")) {

                System.out.println(
                    "\nThank you for using the system!"
                );


                running = false;


            } else {

                System.out.println(
                    "\nInvalid option."
                );
            }
        }


        scanner.close();
    }
}
