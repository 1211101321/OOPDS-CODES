//Subject.java
public class Subject {
    private String code;
    private String name;
    public Subject (String code, String name){
        this.code = code;
        this.name = name;
    }
    public String toString(){
        return code +" "+ name;
    }
}

class TestSubject{
    public static void main(String[]args){
        Subject s = new Subject("TCP1201", "OOPDS");
        System.out.println(s);
    }
}