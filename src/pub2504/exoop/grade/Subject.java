package pub2504.exoop.grade;

public class Subject {
	
    private String name;
    private GradePolicy gradePolicy;

    public Subject(String name, GradePolicy gradePolicy) {
        this.name = name;
        this.gradePolicy = gradePolicy;
    }

    public String getName() {
        return name;
    }

    public GradePolicy getGradePolicy() {
        return gradePolicy;
    }
    
}