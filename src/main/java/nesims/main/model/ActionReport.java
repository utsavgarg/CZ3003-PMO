package nesims.main.model;

//Model class to store values of the Action report sent to CMO
public class ActionReport {
	private String content;
	private String sender;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
}