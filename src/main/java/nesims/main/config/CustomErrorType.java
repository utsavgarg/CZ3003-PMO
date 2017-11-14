package nesims.main.config;

//Configuration class file to have custom error messages when doing a HTTP request call.
public class CustomErrorType {

	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}