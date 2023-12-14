class Person {
    private String name;

    /*
     * public Person(String name){
     * this.name = name;
     * }
     */

    public String greet() {
        return "I'm a Person";
    }
}

class Student extends Person {
    public String greet() {
        return "I'm a Student";
    }

}

public class Polymorphism {
    public static void main(String[] args) {
        Person p1 = new Person(); // no polymorphism
        Person p2 = new Student();// polymorphism , upcasting
        process(p1);
        process(p2);
    }

    public static void process(Person p) {
        System.out.println("Processing " + p.greet());
    }
}