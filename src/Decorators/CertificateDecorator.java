package Decorators;

import Fasade.StudentPortalFacade;


public class CertificateDecorator extends decorator {
    public CertificateDecorator(Courses wrapped){
        super(wrapped);
    }
    @Override
    public int mainContent() {
        if(wrapped.isFinished()){
            System.out.println("Student " + StudentPortalFacade.name + " " + StudentPortalFacade.lastName + " Congratulations! U finished the course !");
            System.out.println("Certificate of " + " " + nameOftheCourse());
            System.out.println("Amount of points" + " " + GaminificationDecorator.total);
        }
        else {
            System.out.println("Complete the cource first");
        }
        return GaminificationDecorator.total;
    }
}
