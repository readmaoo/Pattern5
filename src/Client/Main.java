package Client;
import Fasade.StudentPortalFacade;
import java.util.Scanner;
import static Fasade.StudentPortalFacade.course;
public class Main {
    public static void main(String[] args) {
        StudentPortalFacade portal = new StudentPortalFacade();
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello,enter u'r Name Please");
        StudentPortalFacade.name = sc.nextLine();
        System.out.println("Hello,enter u'r Last name Please");
        StudentPortalFacade.lastName = sc.nextLine();
        System.out.println("Hello,Write on which Cource do u learning?");
        course = sc.nextInt();
        sc.nextLine();
        switch(course){
            case 1, 2 ->{
                while (true) {
                    System.out.println("\n Main Menu ");
                    System.out.println("1. Start education");
                    System.out.println("2. Receive a certificate");
                    System.out.println("3. Educate with mentor");
                    System.out.println("4. Demo Math+Mentor+Certification");
                    System.out.println("5. Demo Programming + Gaiminification ");
                    System.out.println("0. Exit");
                    System.out.print("Choose: ");
                    String raw = sc.nextLine().trim();
                    int opt;
                    try {
                        opt = Integer.parseInt(raw);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter 0 to 3");
                        continue;
                    }
                    switch (opt) {
                        case 1, 5 -> {
                            boolean enrolled = portal.enrollIntheCourse();
                            if (!enrolled) {
                                return;
                            }
                            portal.startLearning();
                        }
                        case 2 -> portal.completeCourse();
                        case 3 -> portal.help();
                        case 4 -> {
                            portal.enrollIntheCourse();
                            portal.help();
                            portal.completeCourse();
                        }
                        case 0 -> {
                            System.out.println("Bye!");
                            return;
                        }
                        default -> System.out.println("Please enter 0 to 3");
                    }
                }
            }
            case 3 -> System.out.println("Bye! u are not allowed");
        }
    }
}
