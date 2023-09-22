package Homework;

public class Students {
    private String studentName;
    private int studentNumber;
    private double studentGrade;

    public Students(String studentName, int studentNumber, double studentGrade) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.studentGrade = studentGrade;
    }


    public String getStudentName() {
        return studentName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getStudentGrade() {
        return studentGrade;
    }
}
