import java.util.Scanner;
import java.util.Arrays;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();


        String[] studentNames = new String[numStudents];
        double[][] studentScores = new double[numStudents][numAssignments];


        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1));
            System.out.print("Name: ");
            studentNames[i] = scanner.next();

            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Score for assignment " + (j + 1) + ": ");
                studentScores[i][j] = scanner.nextDouble();
            }
        }

        // Calculate average scores and assign letter grades
        double[] studentAverages = new double[numStudents];
        char[] studentGrades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                sum += studentScores[i][j];
            }
            studentAverages[i] = sum / numAssignments;


            switch ((int) studentAverages[i] / 10) {
                case 9:
                case 10:
                    studentGrades[i] = 'A';
                    break;
                case 8:
                    studentGrades[i] = 'B';
                    break;
                case 7:
                    studentGrades[i] = 'C';
                    break;
                case 6:
                    studentGrades[i] = 'D';
                    break;
                default:
                    studentGrades[i] = 'F';
                    break;
            }
        }

        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (studentAverages[j] < studentAverages[j + 1]) {
                    // Swap elements in both names and averages arrays
                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                    double tempAverage = studentAverages[j];
                    studentAverages[j] = studentAverages[j + 1];
                    studentAverages[j + 1] = tempAverage;
                }
            }
        }

        // Display student information
        System.out.println("\nStudent Information:");
        System.out.println("----------------------------------");
        System.out.println("Name\tAverage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10s\t%.2f\t%s\n", studentNames[i], studentAverages[i], studentGrades[i]);
        }

        double highestAverage = studentAverages[0];
        double lowestAverage = studentAverages[0];
        for (int i = 1; i < numStudents; i++) {
            if (studentAverages[i] > highestAverage) {
                highestAverage = studentAverages[i];
            }
            if (studentAverages[i] < lowestAverage) {
                lowestAverage = studentAverages[i];
            }
        }

        System.out.println("\nHighest Average Score: " + highestAverage);
        System.out.println("Lowest Average Score: " + lowestAverage);
    }
}