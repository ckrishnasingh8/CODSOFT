import java.util.Scanner; // Import the Scanner class to read user input

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.println("---------------------------------------");

        // Step 1: Get the number of subjects
        int numberOfSubjects;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numberOfSubjects = scanner.nextInt();
                if (numberOfSubjects > 0) {
                    break; // Exit loop if valid positive integer
                } else {
                    System.out.println("Please enter a positive number of subjects.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input
            }
        }

        int totalMarks = 0; // Initialize total marks

        // Step 2: Take marks obtained in each subject
        System.out.println("\nEnter marks obtained in each subject (out of 100):");
        for (int i = 1; i <= numberOfSubjects; i++) {
            int marks;
            while (true) {
                System.out.print("Enter marks for Subject " + i + ": ");
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        totalMarks += marks; // Add marks to total
                        break; // Exit loop if valid marks (0-100)
                    } else {
                        System.out.println("Marks must be between 0 and 100. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Consume the invalid input
                }
            }
        }

        // Step 3: Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Step 4: Grade Calculation
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Step 5: Display Results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage); // Format to 2 decimal places
        System.out.println("Grade: " + grade);
        System.out.println("----------------");

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
