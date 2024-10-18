import java.util.Scanner;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Get the number of assignments
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        // Create arrays to store student information
        String[] studentNames = new String[numStudents];
        double[][] studentScores = new double[numStudents][numAssignments];
        double[] studentAverages = new double[numStudents];
        char[] studentGrades = new char[numStudents];

        // Get student information and calculate averages
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1));
            System.out.print("Name: ");
            studentNames[i] = scanner.next();

            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Score for assignment " + (j + 1) + ": ");
                studentScores[i][j] = scanner.nextDouble();
            }

            // Calculate average score
            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                sum += studentScores[i][j];
            }
            studentAverages[i] = sum / numAssignments;

            // Assign letter grade
            if (studentAverages[i] >= 90) {
                studentGrades[i] = 'A';
            } else if (studentAverages[i] >= 80) {
                studentGrades[i] = 'B';
            } else if (studentAverages[i] >= 70) {
                studentGrades[i] = 'C';
            } else if (studentAverages[i] >= 60) {
                studentGrades[i] = 'D';
            } else {
                studentGrades[i] = 'F';
            }
        }

        // Display student information
        System.out.println("\nStudent Information:");
        System.out.println("----------------------------------");
        System.out.println("Name\tAverage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames[i] + "\t" + studentAverages[i] + "\t" + studentGrades[i]);
        }

        // Bonus features (optional)
        // Calculate class average
        double classAverage = 0;
        for (int i = 0; i < numStudents; i++) {
            classAverage += studentAverages[i];
        }
        classAverage /= numStudents;
        System.out.println("\nClass Average: " + classAverage);

        // Identify highest and lowest scores
        double highestScore = studentScores[0][0];
        double lowestScore = studentScores[0][0];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numAssignments; j++) {
                if (studentScores[i][j] > highestScore) {
                    highestScore = studentScores[i][j];
                }
                if (studentScores[i][j] < lowestScore) {
                    lowestScore = studentScores[i][j];
                }
            }
        }
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);
    }
}