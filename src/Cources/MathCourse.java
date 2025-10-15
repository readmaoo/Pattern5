package Cources;
import Decorators.Courses;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.Scanner;
public class MathCourse implements Courses {
    private boolean completed = false;
    private static final Scanner IN = new Scanner(System.in);
    @Override
    public String nameOftheCourse() { return "Math Course"; }
    @Override
    public int mainContent() {
        int quizPoints = 0;
        try (InputStream is = getClass().getResourceAsStream("/math.json")) {
            if (is == null) {
                System.out.println("Content is not found: /math.json");
                return 0;
            }
            ObjectMapper om = new ObjectMapper();
            JsonNode root = om.readTree(is);
            System.out.println( nameOftheCourse() );
            System.out.println("Title: " + root.path("title").asText());
            System.out.println();
            for (JsonNode topic : root.path("topics")) {
                System.out.println("Topic: " + topic.path("title").asText());
                System.out.println("Main Rules:");
                for (JsonNode b : topic.path("basics")) {
                    System.out.println(" • " + b.asText());
                }
                JsonNode q = topic.path("quiz").get(0);
                if (q != null && !q.isNull()) {
                    System.out.println("Mini quiz:");
                    System.out.println("Question: " + q.path("q").asText());
                    JsonNode opts = q.path("options");
                    for (int i = 0; i < opts.size(); i++) {
                        System.out.println("     [" + i + "] " + opts.get(i).asText());
                    }
                    int correct = q.path("answerIndex").asInt();
                    int user = readIndex(opts.size());
                    if (user == correct) {
                        System.out.println("Correct u get +10 points");
                        quizPoints += 10;
                    } else {
                        System.out.println("Wrong. Right answer:" + correct + opts.get(correct).asText());
                    }
                }
                System.out.println();
            }
            completed = true;
        } catch (Exception e) {
            System.out.println("error Math: " + e.getMessage());
        }
        return quizPoints;
    }
    private int readIndex(int optionsCount) {
        while (true) {
            System.out.print("Your answer (index): ");
            String s = IN.nextLine().trim();
            try {
                int idx = Integer.parseInt(s);
                if (idx >= 0 && idx < optionsCount) return idx;
            } catch (NumberFormatException ignored) {}
            System.out.println("Please enter a number from 0 to " + (optionsCount - 1));
        }
    }
    @Override
    public boolean isFinished(){ return completed; }
}
