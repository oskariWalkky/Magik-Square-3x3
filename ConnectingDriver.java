// Easy to access and modify url, user, and pas - used in other classes 
public class ConnectingDriver {

	private String url = "jdbc:mysql://192.168.10.53/3x3";
	private String user = "root";
	// TODO How can you avoid storing the pas bellow?
	private String pas = "Assholes";

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
