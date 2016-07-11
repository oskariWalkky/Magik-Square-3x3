import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WriteDriver {
	private String sql;
	private static String whichTable1 = "";
	private ConnectingDriver connDri = new ConnectingDriver();

	//Constructor called and info passed in
	WriteDriver(int[] array, int sum, int ranNum) {

		//Format the array into a String to pass to the database
		String arrayString = stringArrayFormatter(array);
		int ohShitWD = array[8];

		try {
			//Make a connection, then pass the data to the db
			Connection myConn = DriverManager.getConnection(connDri.getUrl(), connDri.getUser(), connDri.getPas());
			
			Statement myStat = myConn.createStatement();
			
			sql = "INSERT INTO "+ whichTable1 + " (id, array, sum, oh_shit, run_number, date_entered)"
					+ " VALUES (NULL, " + "'" + arrayString + "', " + sum + ", " + ohShitWD + ", " + ranNum
					+ ", NOW())";
			
			myStat.executeUpdate(sql);
			System.out.println("Valid Array Injected!");
			
			myConn.close();//TODO Do you need to close? Is it automatic?

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(arrayString);
			System.out.println(sql);
		}
	}
	
	//TOOL: Array to String Formatter
	private String stringArrayFormatter(int[] array){
		String ts = "";		
		for(int i = 0; i < array.length; i++){
			ts = ts + String.format("%4d", array[i]);
		}		
		return ts;
	}

	//TOOL: The user has chosen which table to write to (Magik3.java)
	public static void setWhichTable(String whichTable) {
		whichTable1 = whichTable;
	}
}
