import java.util.Arrays;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "name = " + name;
    }

    public int compareTo(Person p) {
        return name.compareTo(p.name);

        // if (name.compareTo(p.name) > 0) {
        //     return 1;
        // } else if (name.compareTo(p.name) == 0) {
        //     return 0;
        // } else {
        //     return -1;
        // }

    }
}

class TestPerson {
    public static void main(String[] args) {
        Person[] persons = { new Person("Bob"),
                new Person("Cat"),
                new Person("Ali") };

        Arrays.sort(persons);
        System.out.println(persons);

    }

}