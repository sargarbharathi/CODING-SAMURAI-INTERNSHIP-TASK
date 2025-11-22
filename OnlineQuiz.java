import java.util.*;

class Question {
    String question;
    String[] options;
    int correctIndex;

    Question(String question, String[] options, int correctIndex) {
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
    }
}

public class OnlineQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        ArrayList<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Which language is used for Android Development?",
                new String[]{"Java", "HTML", "Python", "C#"}, 0));

        quiz.add(new Question("Which data structure uses FIFO?",
                new String[]{"Stack", "Queue", "Tree", "Graph"}, 1));

        quiz.add(new Question("Which keyword is used to create an object in Java?",
                new String[]{"class", "new", "object", "create"}, 1));

        int score = 0;
        int qNo = 1;

       
        System.out.println("===== Online Quiz Application =====");

        for (Question q : quiz) {
            System.out.println("\nQ" + qNo + ": " + q.question);

            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i + 1) + ") " + q.options[i]);
            }

            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (userAnswer - 1 == q.correctIndex) {
                System.out.println("✔ Correct!");
                score++;
            } else {
                System.out.println("✘ Wrong! Correct answer: " + q.options[q.correctIndex]);
            }

            qNo++;
        }

       
        System.out.println("\n===== Quiz Completed =====");
        System.out.println("Your Score: " + score + "/" + quiz.size());
    }
}
