package ProductReactSpring.northwind.Core.utilties.results;

public class Result {
	
	private boolean success;
	
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String message) {
		this(success); // tek parametreli olanı çağırdı üstteki constructor
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	
	public String getMessage() {
		return this.message;
	}
	
	
	public void setSuccess(boolean success) {
		this.success = success;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	

}
