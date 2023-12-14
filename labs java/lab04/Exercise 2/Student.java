public class Student extends Person {
    protected int id;
    public Student(){}
    public Student(String name, int id){
        super(name);
        this.id = id;
    }
    public String toString(){
        return "Student: name = " + getName() + ", id = " + id;
    }
}

class TestStudent{
    public static void main(String[] args){
        Student s = new Student("Bob", 111);
        System.out.println (s);
    }
}