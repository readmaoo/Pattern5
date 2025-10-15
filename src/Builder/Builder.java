package Builder;
import Decorators.*;
public class Builder {
    private Courses base;
    private boolean mentor;
    private boolean gamification;
    private boolean certificate;
    public Builder(Courses base) { this.base = base; }
    public Builder withMentor() { this.mentor = true; return this; }
    public Builder withGamification() { this.gamification = true; return this; }
    public Builder withCertificate() { this.certificate = true; return this; }
    public Courses build() {
        Courses c = base;
        if (mentor)        c = new MentorSupportDecorater(c);
        if (gamification)  c = new GaminificationDecorator(c);
        if (certificate)   c = new CertificateDecorator(c);
        return c;
    }
}
