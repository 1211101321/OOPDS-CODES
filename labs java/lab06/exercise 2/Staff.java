import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class Staff implements Comparable<Staff> {
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

    public int compareTo(Staff s) {
        if (getPaid() > s.getPaid()) {
            return 1;
        } else if (getPaid() == s.getPaid()) {
            return 0;
        } else {
            return -1;
        }

    }
}

class Manager extends Staff {
    protected double allowance;

    public Manager() {
    }

    public Manager(String name, double salary, double allowance) {
        super(name, salary);
        this.allowance = allowance;
    }

    public double getPaid() {
        return getSalary() + allowance;
    }

    public String toString() {
        return "Manager: name = " + getName() + ", Salary = " + getSalary() + ", Allowance = " + allowance + ", Paid = "
                + getPaid();
    }

    public int compareTo(Manager m) {
        if (getPaid() > m.getPaid()) {
            return 1;
        } else if (getPaid() == m.getPaid()) {
            return 0;
        } else {
            return -1;
        }

    }
}

class Technician extends Staff {
    protected double overtimepay;

    public Technician() {
    }

    public Technician(String name, double salary, double overtimepay) {
        super(name, salary);
        this.overtimepay = overtimepay;
    }

    public double getPaid() {
        return getSalary() + overtimepay;
    }

    public String toString() {
        return "Technician: name = " + getName() + ", Salary = " + getSalary() + ", Over Time pay = " + overtimepay
                + ", Paid = " + getPaid();
    }

    public int compareTo(Technician t) {
        if (getPaid() > t.getPaid()) {
            return 1;
        } else if (getPaid() == t.getPaid()) {
            return 0;
        } else {
            return -1;
        }

    }

}

class Exercise2 {
    public static void main(String[] args) {
        Staff[] staffArray = { new Technician("Ali", 2000, 1200),
                new Manager("Siti", 4000, 1800),
                new Technician("Abu", 3000, 2000) };
        // 1. Add code to sort and and print staffArray.

        System.out.println("Before sorting array");

        for (Staff s : staffArray) { // for each loop
            System.out.println(s);
        }

        Arrays.sort(staffArray);
        System.out.println("After sorting array");

        for (Staff s : staffArray) { // for each loop
            System.out.println(s);
        }

        // Create an ArrayList from staffArray.
        ArrayList<Staff> staffList = new ArrayList<>(Arrays.asList(staffArray));

        // 2. Add code to sort and print staffList.

        System.out.println("Before sorting list");

        for (Staff s : staffList) { // for each loop
            System.out.println(s);
        }

        Collections.sort(staffList,Collections.reverseOrder(null)); // for a reverse result
        System.out.println("After sorting list");

        for (Staff s : staffList) { // for each loop
            System.out.println(s);
        }




    }
}