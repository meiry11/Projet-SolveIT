package fr.or.exo11;

import java.util.Objects;

public class Teacher extends Person{
    private String subject;

    public Teacher() {
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void Explain(){
        System.out.println("Explanation Begins");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }

   @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
