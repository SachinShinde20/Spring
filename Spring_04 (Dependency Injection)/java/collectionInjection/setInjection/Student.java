package collectionInjection.setInjection;

import java.util.Set;

public class Student {
    int id;
    Set<String> courses;

    public Student(){
        super();
    }

    public Student(int id, Set<String> courses) {
        this.id = id;
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public Set<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", courses=" + courses +
                '}';
    }
}
