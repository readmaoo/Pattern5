package Decorators;

import java.util.Scanner;

public class CertificateDecorator extends decorator {
    public CertificateDecorator(Courses wrapped){
        super(wrapped);
    }
    @Override
    public int mainContent() {
        if(wrapped.isFinished()){
            System.out.println("Enter u'r name");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Student " + name + " Congratulations! U finished the course !");
            System.out.println("Certificate of " + " " + nameOftheCourse());
            System.out.println("Amount of points" + " " + GaminificationDecorator.total);
        }
        else {
            System.out.println("Complete the cource first");
        }
        return GaminificationDecorator.total;
    }
}
