import java.util.*;

/** Used..............

    Single Inheritance
    Multiple inheritance
    Multi level
    Hierarchical Inheritance
    Access modifier
    Run Time Polymorphism (Override)
     */
abstract class Person{

    private String name;
    private int age;

    public Person(String name , int age){

        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public abstract void introduce();
}
//single inheritance
class Employee extends Person {
    private String position;
    private String company;

    public Employee(String name , int age , String position,String company){
        super(name,age);
        this.position=position;
        this.company=company;
    }
    public String getCompany(){
        return company;
    }
    public String getPosition(){
        return position;
    }

    @Override
    public void introduce(){
        System.out.println("Hi I'm "+getName()+" "+" I'm "+getAge()+" "+" Years old..");
    }
}


// For Multiple Inheritance
interface Task{
    public void assignTask(String task);
}

class Developer extends Employee implements Task{
    public Developer(String name,int age,String position ,String company){
        super(name,age,position,company);
    }
    @Override
    public void assignTask(String task){
        System.out.println("My task is "+ task);
    }
    @Override
    public  void introduce(){
        super.introduce();
        System.out.println("I'm  currently working on "+getCompany()+" as a "+getPosition()+" role.");
    }
}

class Manager extends Employee implements Task{
    public Manager(String name,int age,String position ,String company){
        super(name,age,position,company);
    }
    @Override
    public void assignTask(String task){
        System.out.println("My task is "+ task);
    }
    @Override
    public void introduce(){
        super.introduce();
        System.out.println("I'm  currently working on "+getCompany()+" as a "+getPosition()+" role.");
    }
}
public class Test{
    public static void main(String[] args) {
        Employee dev = new Developer("Gokulnath",22,"Developer","ZOHO");
        Developer sdev = new Developer("Jithin Murali",23,"Developer","ZOHO");
        Employee manager =new Manager("Nanish",22,"Manager","ZOHO");
        //DownCasting
        Task devtask = (Task) dev;
        // sdev.assignTask("BUILD A APPLICATION");
        dev.introduce();
        devtask.assignTask("Develop new App");
        
        System.out.println();
        sdev.introduce();
        System.out.println();
        manager.introduce();
    }
}
