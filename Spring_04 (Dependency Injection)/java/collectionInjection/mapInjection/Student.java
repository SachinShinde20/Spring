package collectionInjection.mapInjection;

import java.util.Map;

public class Student {
    int id;
    Map<String, Integer> courses;

    public Student(){
        super();
    }

    public Student(int id, Map<String, Integer> courses) {
        this.id = id;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Integer> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Integer> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", courses=" + courses +
                '}';
    }
}
