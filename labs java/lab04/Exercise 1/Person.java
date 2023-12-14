//Person.java
public class Person {
    protected String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person: name = " + name;
    }
}

class TestPerson {
    public static void main(String[] args) {
        Person p = new Person("Ali");
        System.out.println(p);
    }
}