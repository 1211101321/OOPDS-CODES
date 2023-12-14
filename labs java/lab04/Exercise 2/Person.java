public class Person{
    private String name;
    public Person(){}
    public Person(String name) {
        this.name = name;
    }
    public String toString(){
        return "Person: name = " + name;
    }
    public String getName(){
        return name;
    }
}

class TestPerson{
    public static void main(String[] args){
        Person p = new Person("Ali");
        System.out.println (p);
    }
}