public class Lecturer extends Staff {
    protected Subject subject;
    public Lecturer(){}
    public Lecturer(String name, double salary, Subject subject){
        super(name, salary); // invoke Staff overloaded constructor
        this.subject = subject;
    }
    public String toString(){
        return "Lecturer: name = " + getName() + ", salary = " + getSalary() + ", subject = " + subject;
    }
}

class TestLecturer{
    public static void main(String[] args){
        Lecturer l = new Lecturer("Danny", 4000, new Subject("TCP1201", "OOPDS"));
        System.out.println (l);
    }
}