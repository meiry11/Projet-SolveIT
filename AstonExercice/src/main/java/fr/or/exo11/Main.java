package fr.or.exo11;

public class Main {
    public static void main(String[] args) {
        Person personne1 = new Person();
        Student student1 = new Student();
        Teacher teacher = new Teacher();
        Teacher teacher1 = new Teacher();

        personne1.sayHello();
        System.out.println();

        student1.setAge(15);
        student1.sayHello();
        student1.goToClass();
        student1.displayAge();
        System.out.println(student1.getClass().getSuperclass());

        teacher.setAge(40);teacher1.setAge(40);
        teacher.sayHello();
        System.out.println("My age is "+teacher.getAge());
        teacher.Explain();

        System.out.println(teacher.hashCode());
        System.out.println(teacher1.hashCode());


    }
}
