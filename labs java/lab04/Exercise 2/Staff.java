public class Staff extends Person {
    private double salary;
    public Staff() {}
    public Staff(String name, double salary){
        super(name); // invoke superclass constructor
        this.salary = salary;
    }
    public String toString(){
        return "Staff: name = " + getName() + ", salary = " + salary;
    }
    public double getSalary(){
        return salary;
    }
}

class TestStaff{
    public static void main(String[] args){
        Staff s = new Staff("Abu", 2000);
        System.out.println (s);
    }
}