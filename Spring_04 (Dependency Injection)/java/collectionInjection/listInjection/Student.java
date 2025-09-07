package collectionInjection.listInjection;

import java.util.List;

public class Student {
    int id;
    List<String> courses;

    public Student(){
        super();
    }

    public Student(int id, List<String> courses) {
        this.id = id;
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public List<String> getCourses() {
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
