package kodlamaio.humanResourcesProject.core.utilities.results;

public class ErrorResult extends Result{

    public ErrorResult(String message) {
        super(message, false);
    }

    public ErrorResult(){
        super(false);
    }

}
