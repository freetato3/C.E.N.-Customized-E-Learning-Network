import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    public Admin(
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
    // MANAGE USERS
    // ========================================================
    public void manageUsers(
            Scanner scanner,
            Student student,
            Tutor tutor) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        while (true) {

            System.out.println(
                "\n=========================================="
            );

            System.out.println(
                "              MANAGE USERS"
            );

            System.out.println(
                "=========================================="
            );

            System.out.println(
                "1. Manage Student"
            );

            System.out.println(
                "2. Manage Tutor"
            );

            System.out.println(
                "3. Back"
            );


            System.out.print(
                "\nChoose an account: "
            );


            String choice =
                scanner.nextLine();


            User selectedUser = null;


            if (choice.equals("1")) {

                selectedUser = student;

            } else if (choice.equals("2")) {

                selectedUser = tutor;

            } else if (choice.equals("3")) {

                return;

            } else {

                System.out.println(
                    "Invalid option."
                );

                continue;
            }


            // ==============================================
            // CHOOSE WHAT TO MANAGE
            // ==============================================

            while (true) {

                System.out.println(
                    "\nSelected account: " +
                    (selectedUser instanceof Student
                        ? "Student"
                        : "Tutor")
                );


                System.out.println(
                    "1. Change Username"
                );

                System.out.println(
                    "2. Change Password"
                );

                System.out.println(
                    "3. Back"
                );


                System.out.print(
                    "\nChoose what to manage: "
                );


                String manageChoice =
                    scanner.nextLine();


                if (manageChoice.equals("1")) {

                    System.out.println(
                        "\nCurrent username: " +
                        selectedUser.getUsername()
                    );


                    System.out.print(
                        "Enter new username: "
                    );


                    String newUsername =
                        scanner.nextLine().trim();


                    if (newUsername.isEmpty()) {

                        System.out.println(
                            "Username cannot be empty."
                        );

                    } else {

                        selectedUser.setUsername(
                            newUsername
                        );


                        System.out.println(
                            "\nUsername successfully changed!"
                        );


                        System.out.println(
                            "New username: " +
                            selectedUser.getUsername()
                        );
                    }


                } else if (
                    manageChoice.equals("2")
                ) {

                    System.out.println(
                        "\nCurrent password: " +
                        selectedUser.getPassword()
                    );


                    System.out.print(
                        "Enter new password: "
                    );


                    String newPassword =
                        scanner.nextLine().trim();


                    if (newPassword.isEmpty()) {

                        System.out.println(
                            "Password cannot be empty."
                        );

                    } else {

                        selectedUser.setPassword(
                            newPassword
                        );


                        System.out.println(
                            "\nPassword successfully changed!"
                        );


                        System.out.println(
                            "New password: " +
                            selectedUser.getPassword()
                        );
                    }


                } else if (
                    manageChoice.equals("3")
                ) {

                    break;

                } else {

                    System.out.println(
                        "Invalid option."
                    );
                }
            }
        }
    }


    // ========================================================
    // MANAGE SUBJECTS / LESSONS
    // ========================================================
    public void manageSubjects(
            Scanner scanner,
            ArrayList<Lesson> lessons) {

        if (!isLoggedIn()) {

            System.out.println(
                "\nPlease login first."
            );

            return;
        }


        while (true) {

            System.out.println(
                "\n=========================================="
            );

            System.out.println(
                "          MANAGE SUBJECTS / LESSONS"
            );

            System.out.println(
                "=========================================="
            );

            System.out.println(
                "1. View Lessons"
            );

            System.out.println(
                "2. Edit Lesson"
            );

            System.out.println(
                "3. Delete Lesson"
            );

            System.out.println(
                "4. Back"
            );


            System.out.print(
                "\nChoose an option: "
            );


            String choice =
                scanner.nextLine();


            if (choice.equals("1")) {

                viewLessons(lessons);

            } else if (choice.equals("2")) {

                editLesson(
                    scanner,
                    lessons
                );

            } else if (choice.equals("3")) {

                deleteLesson(
                    scanner,
                    lessons
                );

            } else if (choice.equals("4")) {

                return;

            } else {

                System.out.println(
                    "Invalid option."
                );
            }
        }
    }


    // ========================================================
    // VIEW LESSONS
    // ========================================================
    private void viewLessons(
            ArrayList<Lesson> lessons) {

        if (lessons.isEmpty()) {

            System.out.println(
                "\nNo lessons available."
            );

            return;
        }


        System.out.println(
            "\n=========================================="
        );

        System.out.println(
            "             ALL LESSONS"
        );

        System.out.println(
            "=========================================="
        );


        for (int i = 0;
             i < lessons.size();
             i++) {

            System.out.println(
                "\nLesson #" + (i + 1)
            );


            lessons.get(i).displayLesson();
        }
    }


    // ========================================================
    // EDIT LESSON
    // ========================================================
    private void editLesson(
            Scanner scanner,
            ArrayList<Lesson> lessons) {

        if (lessons.isEmpty()) {

            System.out.println(
                "\nNo lessons available to edit."
            );

            return;
        }


        viewLessons(lessons);


        int number;


        while (true) {

            System.out.print(
                "\nEnter lesson number to edit: "
            );


            try {

                number =
                    Integer.parseInt(
                        scanner.nextLine()
                    );


                if (number >= 1
                        && number <= lessons.size()) {

                    break;
                }


                System.out.println(
                    "Invalid lesson number."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid number."
                );
            }
        }


        Lesson lesson =
            lessons.get(number - 1);


        System.out.println(
            "\nWhat would you like to change?"
        );


        System.out.println("1. Week");
        System.out.println("2. Topic");
        System.out.println("3. Title");
        System.out.println("4. Description");
        System.out.println("5. Everything");


        System.out.print(
            "\nChoose an option: "
        );


        String choice =
            scanner.nextLine();


        if (choice.equals("1")) {

            System.out.println(
                "Current week: " +
                lesson.getWeek()
            );


            int week;

            while (true) {

                System.out.print(
                    "Enter new week (1-20): "
                );

                try {

                    week =
                        Integer.parseInt(
                            scanner.nextLine()
                        );


                    if (week >= 1 && week <= 20) {

                        lesson.setWeek(week);
                        break;
                    }

                    System.out.println(
                        "Week must be between 1 and 20."
                    );

                } catch (NumberFormatException e) {

                    System.out.println(
                        "Please enter a valid number."
                    );
                }
            }


        } else if (choice.equals("2")) {

            System.out.println(
                "Current topic: " +
                lesson.getTopic()
            );


            System.out.print(
                "Enter new topic: "
            );


            lesson.setTopic(
                scanner.nextLine()
            );


        } else if (choice.equals("3")) {

            System.out.println(
                "Current title: " +
                lesson.getTitle()
            );


            System.out.print(
                "Enter new title: "
            );


            lesson.setTitle(
                scanner.nextLine()
            );


        } else if (choice.equals("4")) {

            System.out.println(
                "Current description: " +
                lesson.getDescription()
            );


            System.out.print(
                "Enter new description: "
            );


            lesson.setDescription(
                scanner.nextLine()
            );


        } else if (choice.equals("5")) {

            System.out.println(
                "Current week: " +
                lesson.getWeek()
            );


            int week;

            while (true) {

                System.out.print(
                    "Enter new week (1-20): "
                );

                try {

                    week =
                        Integer.parseInt(
                            scanner.nextLine()
                        );


                    if (week >= 1 && week <= 20) {

                        lesson.setWeek(week);
                        break;
                    }

                    System.out.println(
                        "Week must be between 1 and 20."
                    );

                } catch (NumberFormatException e) {

                    System.out.println(
                        "Please enter a valid number."
                    );
                }
            }


            System.out.println(
                "Current topic: " +
                lesson.getTopic()
            );


            System.out.print(
                "Enter new topic: "
            );


            lesson.setTopic(
                scanner.nextLine()
            );


            System.out.println(
                "Current title: " +
                lesson.getTitle()
            );


            System.out.print(
                "Enter new title: "
            );


            lesson.setTitle(
                scanner.nextLine()
            );


            System.out.println(
                "Current description: " +
                lesson.getDescription()
            );


            System.out.print(
                "Enter new description: "
            );


            lesson.setDescription(
                scanner.nextLine()
            );


        } else {

            System.out.println(
                "Invalid option."
            );

            return;
        }


        System.out.println(
            "\nLesson successfully updated!"
        );
    }


    // ========================================================
    // DELETE LESSON
    // ========================================================
    private void deleteLesson(
            Scanner scanner,
            ArrayList<Lesson> lessons) {

        if (lessons.isEmpty()) {

            System.out.println(
                "\nNo lessons available to delete."
            );

            return;
        }


        viewLessons(lessons);


        System.out.print(
            "\nEnter lesson number to delete: "
        );


        int number;


        try {

            number =
                Integer.parseInt(
                    scanner.nextLine()
                );

        } catch (NumberFormatException e) {

            System.out.println(
                "Invalid number."
            );

            return;
        }


        if (number < 1
                || number > lessons.size()) {

            System.out.println(
                "Invalid lesson number."
            );

            return;
        }


        Lesson removed =
            lessons.remove(number - 1);


        System.out.println(
            "\nLesson \"" +
            removed.getTitle() +
            "\" has been deleted."
        );
    }
}


// ============================================================
// QUIZ DATA
// ============================================================
class QuizData {

    private static String title = "";


    public static void setTitle(
            String newTitle) {

        title = newTitle;
    }


    public static String getTitle() {

        return title;
    }
}
