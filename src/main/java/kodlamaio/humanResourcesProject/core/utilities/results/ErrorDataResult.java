package kodlamaio.humanResourcesProject.core.utilities.results;

public class ErrorDataResult<T> extends DataResult{

    public ErrorDataResult(T data, String message) {
        super(data, message, false);
    }

    public ErrorDataResult(T data){
        super(data,false);
    }

    public ErrorDataResult(String message){
        super(null,message,false);
    }

    public ErrorDataResult(){
        super(null,null,false);
    }

}
