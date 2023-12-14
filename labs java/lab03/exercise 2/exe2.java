import java.util.ArrayList;

public class exe2{
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Student> students = new ArrayList<Student>();

        printCourses(courses);
        printStudents(students);

        System.out.println("Sample output 2: After creating 3 courses and 2 students");
        courses.add(new Course("TCP1101", "Tan"));
        courses.add(new Course("TMA1301", "Tin"));
        courses.add(new Course("TMA1201", "Tun"));
        students.add(new Student(111, "Ali"));
        students.add(new Student(222, "Bob"));
        printCourses(courses);
        printStudents(students);

        System.out.println("Sample output 3: After Ali added 3 courses and Bob added 1 course");
        students.get(0).addCourse(courses.get(0));
        students.get(0).addCourse(courses.get(1));
        students.get(0).addCourse(courses.get(2));
        students.get(1).addCourse(courses.get(1));
        printCourses(courses);
        printStudents(students);

        System.out.println("Sample output 4: After Ali dropped 1 course");
        students.get(0).dropCourse(courses.get(0));
        printCourses(courses);
        printStudents(students);
    }

    public static void printCourses(ArrayList<Course> courses) {
        System.out.println("All courses");
        System.out.println("No\tCode/Teacher");
        if (courses.size() == 0)
            System.out.println("-");
        else {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ".\t" + courses.get(i).toString());
            }
        }
    }

    public static void printStudents(ArrayList<Student> students) {
        System.out.println("All students");
        System.out.println("No\tID\tName\tCourses");
        if (students.size() == 0)
            System.out.println("-");
        else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ".\t" + students.get(i).toString());
            }
        }
    }



    public static void printCourses(ArrayList<Course> courses) {
        System.out.println("All courses");
        System.out.println("No\tCode/Teacher");
        if (courses.size() == 0)
            System.out.println("-");
        else {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ".\t" + courses.get(i).toString());
            }
        }
    }

    public static void printStudents(ArrayList<Student> students) {
        System.out.println("All students");
        System.out.println("No\tID\tName\tCourses");
        if (students.size() == 0)
            System.out.println("-");
        else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ".\t" + students.get(i).toString());
            }
        }
    }
}