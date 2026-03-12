public class LowGradeException extends Exception {

    private String studentName;
    private double average;

    public LowGradeException(String studentName, double average) {
        super("Low grade detected for " + studentName + " | Average: " + average);
        this.studentName = studentName;
        this.average = average;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getAverage() {
        return average;
    }
}