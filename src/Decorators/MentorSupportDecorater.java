package Decorators;

public class MentorSupportDecorater extends decorator {
    public MentorSupportDecorater(Courses wrapped) { super(wrapped); }
    @Override
    public int mainContent() {
        System.out.println("You have a mentor who will help you with materials.");
        System.out.println("If you have questions, call him. You have everyday check-ins.");
        int points = wrapped.mainContent();
        if (wrapped.isFinished()) {
            System.out.println("Mentor done with u");
        }
        return points;
    }
}
