import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradebookProcessor {

    public static void main(String[] args) {
        try (
            Scanner fileReader = new Scanner(new File("students.txt"));
            PrintWriter reportWriter = new PrintWriter("grades_report.txt")
        ) {

            System.out.println("=== Lehman Gradebook Processor ===");
            System.out.println("Reading students.txt...\n");

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }
                
                String[] parts = line.split(" ");
                String name = parts[0];
             
                try {
                    int score1 = Integer.parseInt(parts[1]);
                    int score2 = Integer.parseInt(parts[2]);
                    int score3 = Integer.parseInt(parts[3]);
                    double average = (score1 + score2 + score3) / 3.0;
                    double roundedAverage = Math.round(average * 100.0) / 100.0;

                    if (roundedAverage < 60.0) {
                        throw new LowGradeException(name, roundedAverage);
                    }

                    String reportLine = "Student: " + name + " | Average: " + roundedAverage;
                    reportWriter.println(reportLine);

                    System.out.println("Processed: " + reportLine);

                } catch (NumberFormatException e) {
                    System.out.println("WARNING: Skipping " + name +
                        " — invalid score data found. (" + e.getMessage() + ")");

                } catch (LowGradeException e) {
                    String warningLine = "Student: " + e.getStudentName() +
                        " | Average: " + e.getAverage() + " *** WARNING: Low Grade ***";
                    reportWriter.println(warningLine);
                    System.out.println("LOW GRADE FLAG: " + warningLine);

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("WARNING: Skipping line — not enough data: \"" + line + "\"");
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Could not open a required file.");
            System.out.println("Details: " + e.getMessage());

        } finally {
            System.out.println("\nProcessing Complete.");
        }

    }

}