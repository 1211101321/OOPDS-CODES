//Staff.java
public class Staff extends Person {
    protected double salary;

    public Staff() {
    }

    public Staff(String name,double salary) {
        //this.name = name; //not generally the best because will only work for protected
        
        super(name); //remember this is to invoke superclass constructor
        this.salary = salary;
    }
    public String toString(){
        return "Staff : name = "+ name + ", salary = "+salary;
    }
}

class TestStaff{
    public static void main(String[]args){
        Staff s = new Staff("Abu",2000);
        System.out.println(s);
    }
}