public class WithPolymorphism {
    public static void main(String[] args){
        Person[] persons = {new Person("Ali"),

                            new Student("Bob", 111),

                            new Staff("Cat", 3000),

                            new Lecturer("Danny", 4000, new Subject("TCP1201", "OOPDS"))};

        for(Person person: persons){
            System.out.println (person);
        }

        for (Person person: persons){
            process(person);
        }
    }
    public static void process(Person p){
        System.out.println("Processing " + p);
    }
}