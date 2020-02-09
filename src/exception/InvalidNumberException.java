package exception;

public class InvalidNumberException extends RuntimeException{

	public InvalidNumberException(){
		super("Invalid int. Please check the API for more info.");
	} 
	
	public InvalidNumberException(String message){
		super(message);
	}

	public InvalidNumberException(String message, Throwable error){
		super(message, error);
	}
	
}
