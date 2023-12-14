public abstract class Staff {
    private String name;
    private double salary;

    public Staff() {

    }

    protected Staff(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double getPaid();
}

class Manager extends Staff {
    protected double allowance;

    public Manager() {}
    

    public Manager(String name, double salary, double allowance) {
        super(name, salary);
        this.allowance = allowance;
    }

    public double getPaid() {
        return getSalary() + allowance;
    }

    public String toString(){
        return "Manager: name = "+getName()+", Salary = "+getSalary()+", Allowance = "+allowance+", Paid = "+getPaid();
    }
}

class Technician extends Staff {
    protected double overtimepay;

    public Technician() {}
    

    public Technician(String name, double salary, double overtimepay) {
        super(name, salary);
        this.overtimepay = overtimepay;
    }

    public double getPaid(){
        return getSalary() + overtimepay;
    }

    public String toString(){
        return "Technician: name = "+getName()+", Salary = "+getSalary()+", Over Time pay = "+overtimepay+", Paid = "+getPaid();
    }

}


class Exercise1{
    public static void main(String[]args){
        //cangt make an object from Staff class because it is an abstract
        Staff m = new Manager("Siti", 4000, 1500);
        System.out.println(m);
        Staff t = new Technician("Abu", 2000, 1200);
        System.out.println(t);



        
    }
}