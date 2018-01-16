import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

	String fileContents;
	ArrayList<String> SQLCommands = new ArrayList<String>();
	BufferedReader bufferReader;

	public Reader() {
		// TODO Auto-generated constructor stub
		try {
			JDBCConnection db = new JDBCConnection();//("mercurialminds","postgres","768S2rzb");
			bufferReader = new BufferedReader(new FileReader(new File("D:\\Bot libre\\db dumps\\2018-01-15\\mercurialmindssql\\mercurialminds.sql")));
			StringBuilder queryBuilder = new StringBuilder();
			while ((this.fileContents = this.bufferReader.readLine()) != null) {
				if (this.fileContents.trim().startsWith("--")) {
					continue;
				}
				
				if (this.fileContents.trim().toLowerCase().contains("create database")) {
					System.out.println(fileContents);
					continue;
				}
				
				if (this.fileContents.trim().equals("")) {
					continue;
				}
				
				if (this.fileContents.trim().endsWith(";")) {
					queryBuilder.append( " "+this.fileContents.trim()+ " ");
					db.runQuery(queryBuilder.toString());
					queryBuilder = new StringBuilder();
				}
				else {
					queryBuilder.append(this.fileContents.trim());
				}
				
				//SQLCommands.add(fileContents);
				
			}

			System.out.println("Total line = " + this.SQLCommands.size());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = new Reader();
	}

}
