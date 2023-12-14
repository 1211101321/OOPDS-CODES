//WithoutPolymorphism.java
public class WithoutPolymorphism {
    public static void main(String []args){
        Person person = new Person("Ali");
        System.out.println(person);

        Student student = new Student("Bob",111);
        System.out.println(student);

        Staff staff = new Staff("Cat",3000);
        System.out.println(staff);

        Lecturer lecturer = new Lecturer("Danny",4000, new Subject("TCP1201", "OOPDS"));
        System.out.println(lecturer);
    }
}
