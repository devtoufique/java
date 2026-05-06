import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter your answer (1-4): ");
        int userAnswer = sc.nextInt();

        if (userAnswer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Wrong!");
            return false;
        }
    }
}

public class DreamProject {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Question[] quiz = {
            new Question(
                "What is the capital of Bangladesh?",
                new String[]{"Dhaka", "Chittagong", "Khulna", "Rajshahi"},
                1
            ),
            new Question(
                "Which language is used in Java?",
                new String[]{"C", "Python", "Java", "HTML"},
                3
            ),
            new Question(
                "2 + 2 = ?",
                new String[]{"3", "4", "5", "6"},
                2
            )
        };

        int score = 0;

        System.out.println("=== Welcome to Quiz Game ===");

        for (int i = 0; i < quiz.length; i++) {
            if (quiz[i].askQuestion(sc)) {
                score++;
            }
        }

        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Your Score: " + score + "/" + quiz.length);

        if (score == quiz.length) {
            System.out.println("Excellent!");
        } else if (score >= 2) {
            System.out.println("Good job!");
        } else {
            System.out.println("Try again!");
        }

        sc.close();
    }
}