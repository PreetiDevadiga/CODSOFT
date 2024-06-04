import java.util.Scanner;

public class StudentGradeCalculator {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting number of subjects from user
        System.out.print(ANSI_GREEN + "Enter the number of subjects: " + ANSI_RESET);
        int numSubjects = scanner.nextInt();

        // Initialize the variables
        double totalMarks = 0.0;

        // Getting marks for each subject
  
        System.out.println(ANSI_GREEN + "Enter marks obtained (out of 100) for each subject:" + ANSI_RESET);
        for (int i = 1; i <= numSubjects; i++) {
            double marks;
            do {
                System.out.print(ANSI_YELLOW + "Subject " + i + ": " + ANSI_RESET);
                marks = scanner.nextDouble();
                if (marks < 0 || marks > 100) {
                    System.out.println(ANSI_RED + "Invalid marks! Please enter a value between 0 and 100." + ANSI_RESET);
                }
            } while (marks < 0 || marks > 100); 
            totalMarks += marks;}

        // Calculate average percentage
        double averagePercentage = (totalMarks / (numSubjects*100)) * 100;

       
        String grade;
        if (averagePercentage >= 90) {
            grade =ANSI_GREEN + "A (Excellent)";
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            grade = ANSI_GREEN +"B (Very Good)";
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            grade = ANSI_GREEN + "C (Good)";
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            grade = ANSI_GREEN + "D (Average)";
        } else if (averagePercentage >= 50 && averagePercentage < 60) {
            grade = ANSI_GREEN + "E (Below Average)";
        } else if (averagePercentage >= 45 && averagePercentage < 50) {
            grade = ANSI_GREEN + "Paas";
        } else {
            grade = ANSI_RED + "F (Fail)"  + ANSI_RESET;
        }

        // Displaying the results
        System.out.println(ANSI_GREEN + "\n** Results **");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade + ANSI_RESET);

        scanner.close();
    }
}