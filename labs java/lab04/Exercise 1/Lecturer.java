//Lecturer.java
public class Lecturer extends Staff { // superclass of lecturer is staff
    protected Subject subject;

    public Lecturer() {
    }

    public Lecturer(String name, double salary, Subject subject) {// lecturer will also have a name and salary thru
                                                                 // inheritance (SALARY FROM STAFF) (NAME FROM PERSON)
        super(name, salary);// invoke Staff overloaded constructor
        this.subject = subject;

    }

    public String toString() {
        return "Lecturer: name = " + name + ", salary = " + salary + ", subject= " + subject;
    }

}

class TestLecturer {
    public static void main(String[] args) {
        Lecturer l = new Lecturer("Danny", 4000, new Subject("TCP1201", "OOPDS"));
        System.out.println(l);
    }
}
