package prob2A;

public class Student {

    private GradeReport grade;
    private String name;

    public Student(String name){
        this.name = name;
        this.grade = new GradeReport(this);
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{ \n" +
                "  name: \"%s\",\n" +
                "  grade: %s,\n" +
                "}", this.name, this.grade);
    }
}
