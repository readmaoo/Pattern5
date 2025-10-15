package Fasade;

import Builder.Builder;
import Cources.MathCourse;
import Cources.ProgrammCourse;
import Decorators.CertificateDecorator;
import Decorators.Courses;
import Decorators.GaminificationDecorator;
import Decorators.MentorSupportDecorater;
import java.util.Scanner;
public class StudentPortalFacade {
    private static final Scanner IN = new Scanner(System.in); // НЕ закрываем
    private Courses selected;
    public void enrollIntheCourse() {
        System.out.println("Welcome to the My course platform");
        System.out.println("Please write a course name (Math/Program) and press Enter:");
        String choice = IN.nextLine();
        if ("Math".equalsIgnoreCase(choice)) {
            selected = new MathCourse();
        } else if ("Program".equalsIgnoreCase(choice) || "Programm".equalsIgnoreCase(choice)) {
            selected = new ProgrammCourse();
        } else {
            System.out.println("Unknown course: " + choice);
            return;
        }
        System.out.println("You successfully chose " + selected.nameOftheCourse());
    }
    public void startLearning() {
        if (selected == null) {
            System.out.println("Enroll first");
            return;
        }
        var pipeline = new Builder(selected)
                .withGamification()
                .build();
        pipeline.mainContent();
    }
    public void help() {
        if (selected == null) {
            System.out.println("Enroll first");
            return;
        }
        var pipeline = new Builder(selected)
                .withMentor()
                .withGamification()
                .build();
        pipeline.mainContent();
    }
    public void completeCourse() {
        if (selected == null) {
            System.out.println("Enroll first");
            return;
        }
        var pipeline = new Builder(selected)
                .withCertificate()
                .build();
        pipeline.mainContent();
    }
}

