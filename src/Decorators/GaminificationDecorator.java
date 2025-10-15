package Decorators;

public class GaminificationDecorator extends decorator {
    public GaminificationDecorator(Courses wrapped){ super(wrapped); }
    public static int total;
    @Override
    public int mainContent() {
        int quizPoints = wrapped.mainContent();
        int bonus = wrapped.isFinished() ? 70 : 0;
        total = quizPoints + bonus;
        System.out.println("Quiz points: " + quizPoints + "/30");
        if (bonus > 0) System.out.println("Course completion bonus: +70");
        System.out.println("Total points: " + total + "/100");
        return total;
    }
}
