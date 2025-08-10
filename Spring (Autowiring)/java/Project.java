public class Project {
    String projectName;
    String tech;

    public Project() {
        super();
    }

    public Project(String projectName, String tech) {
        this.projectName = projectName;
        this.tech = tech;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
