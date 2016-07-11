// Easy to access and modify url, user, and pas - used in other classes 
public class ConnectingDriver {

	//Change to your specific location
	private String url = "jdbc:mysql://192.168.15.12/3x3";
	private String user = "user";
	// TODO How can you avoid storing the pas bellow?
	private String pas = "****************";

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPas() {
		return pas;
	}

}
