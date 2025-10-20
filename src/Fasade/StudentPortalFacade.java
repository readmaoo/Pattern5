package Fasade;

import Builder.Builder;
import Cources.MathCourse;
import Cources.ProgrammCourse;
import Decorators.Courses;

import java.util.Scanner;
public class StudentPortalFacade {
    private static final Scanner IN = new Scanner(System.in);
    public static int course;
    public static String name;
    public static String lastName;
    private Courses selected;
    public boolean enrollIntheCourse() {
        System.out.println("Welcome to the My course platform");
        System.out.println("Please write a course name (Math/Program) and press Enter:");
        String choice = IN.nextLine();
        if(course == 1 && choice.equalsIgnoreCase("Program")) {
            System.out.println("u are not allowed.It will be allowed in second course");
            return false;
        }
        if(course == 2 && choice.equalsIgnoreCase("Math")) {
            System.out.println("u are not allowed,This course already passed");
            return false;
        }
        if ("Math".equalsIgnoreCase(choice)) {
            selected = new MathCourse();
        } else if ("Program".equalsIgnoreCase(choice) || "Programm".equalsIgnoreCase(choice)) {
            selected = new ProgrammCourse();
        } else {
            System.out.println("Unknown course: " + choice);
            return false;
        }
        System.out.println("You successfully chose " + selected.nameOftheCourse());
        return true;
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

