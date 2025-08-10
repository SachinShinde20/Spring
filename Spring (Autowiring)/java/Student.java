import java.util.List;

public class Student {
    int id;
    List<String> subjects;
    Project project;

    public Student() {
        super();
    }

    public Student(List<String> subjects, Project projects) {
        this.subjects = subjects;
        this.project = projects;
    }

    public Student(int id, List<String> subjects, Project projects) {
        this.id = id;
        this.subjects = subjects;
        this.project = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project projects) {
        this.project = projects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", subjects=" + subjects +
                ", projects=" + project +
                '}';
    }
}
