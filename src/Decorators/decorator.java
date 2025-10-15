package Decorators;

public abstract class decorator implements Courses {
    protected final Courses wrapped;
    public decorator(Courses wrapped){
        this.wrapped = wrapped;
    }
    @Override
    public String nameOftheCourse(){return wrapped.nameOftheCourse(); }
    @Override
    public boolean isFinished(){ return wrapped.isFinished(); }
}
