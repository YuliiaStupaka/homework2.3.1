package homework231;
public class FullGroupException extends Exception{
    @Override
    public String getMessage(){
        return "Cannot add student because the group is full.";
    }
}
