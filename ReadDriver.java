import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadDriver {

	public ArrayList<String> tableList = new ArrayList<>();
	private int listNumberForTableList = 0;
	private ConnectingDriver connDri = new ConnectingDriver();

	public ReadDriver() {
		try {

			Connection myConn = DriverManager.getConnection(connDri.getUrl(), connDri.getUser(), connDri.getPas());

			Statement myStat = myConn.createStatement();

			ResultSet myRs = myStat.executeQuery("SELECT DISTINCT TABLE_NAME " +
				    "FROM INFORMATION_SCHEMA.COLUMNS " +
				    "WHERE COLUMN_NAME IN ('id', 'array', 'sum', 'oh_shit', 'run_number', 'date_entered')" +
				    "AND TABLE_SCHEMA='3x3';");

			while (myRs.next()) {

				tableList.add(myRs.getString("TABLE_NAME"));
				System.out.println((listNumberForTableList + 1) + " - " + tableList.get(listNumberForTableList));
				listNumberForTableList++;

			}
			
			myConn.close();//TODO Do you need to close? Is it automatic?

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
