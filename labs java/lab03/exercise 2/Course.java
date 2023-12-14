public class Course{
    private String code;
    private String teacher;
    public Course(String code, String teacher) {
        this.code = code;
        this.teacher = teacher;
    }
    public String getCode() {
        return this.code;
    }
    public String toString() {
        return code + "/" + teacher;
    }
}

class TestCourse {
    public static void main(String[] args) {
        Course c1 = new Course("TCP1101", "Wong");
        System.out.println(c1.toString());
        System.out.println(c1); // auto invoke toString()
    }
}