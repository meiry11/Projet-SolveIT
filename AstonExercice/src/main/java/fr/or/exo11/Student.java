package fr.or.exo11;

public class Student extends Person{
    public void goToClass(){
        System.out.println("I'm going to class");
    }

    public void displayAge(){
        System.out.println("My age is "+getAge());
    }


}
