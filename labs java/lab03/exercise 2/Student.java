import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private ArrayList<Course> courses = new ArrayList<Course>(); 

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void dropCourse(Course course) {
        courses.remove(course);
    }

    public String toString() {
        return id + "\t" + name + "\t" + courses;
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student(111, "ali");
        System.out.println(s1.toString());

        s1.addCourse(new Course("tcp1101", "wong"));
        s1.addCourse(new Course("tma1101", "lim"));
        System.out.println(s1);
    }
}