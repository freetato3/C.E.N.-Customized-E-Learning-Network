public class Lesson {
    private int week;
    private String topic;
    private String title;
    private String description;


    public Lesson(
            int week,
            String topic,
            String title,
            String description) {

        this.week = week;
        this.topic = topic;
        this.title = title;
        this.description = description;
    }


    public int getWeek() {
        return week;
    }


    public String getTopic() {
        return topic;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public void setWeek(int week) {
        this.week = week;
    }


    public void setTopic(String topic) {
        this.topic = topic;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void displayLesson() {

        System.out.println(
            "\n------------------------------------------"
        );

        System.out.println("Week: " + week);

        System.out.println("Topic: " + topic);

        System.out.println("Title: " + title);

        System.out.println(
            "Description: " + description
        );

        System.out.println(
            "------------------------------------------"
        );
    }
}
