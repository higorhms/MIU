package prog122source.employeeinfo;

public class OverdrawnAccountException extends Exception{
    public OverdrawnAccountException(String message) {
        super(message);
    }
}
