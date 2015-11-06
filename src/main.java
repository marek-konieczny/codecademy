import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.MetaEventListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.xml.stream.events.Comment;

public class main {



	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {

		long startTime = System.nanoTime();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://10.1.1.30:3306/forumapm_msmrd01", "developer",
				"QzKHfnVaUzJDTxbM");
		Statement stmt = conn.createStatement();

		// CUSTOM QUERY
		// --------------------------------------------------------------------
		//
		//
		//
		// String query =
		// "select date_time,longitude,latitude from marvis_data where `date_time`>'2015-10-30 01:00:00' and `date_time`<'2015-10-30 23:00:00' and sn =80 order by id_marvis desc;";
		// String query
		// ="SELECT * FROM `marvis_data` WHERE `date_time`>='2015-10-23 06:00:00' and `date_time`<='2015-10-23 08:00:00';";
		String query = "SELECT * FROM `marvis_data` WHERE `sn`=80 and date(`date_time`)='2015-11-05' ORDER BY `date_time` DESC;";
		// String query
		// ="SELECT * FROM `marvis_data` WHERE `date_time`>='2015-11-01 01:00:00';";
		// ---------------------------------------------------------------------------------
		ResultSet rs1 = stmt.executeQuery(query);

		try {
			File file = new File("out.kml");
			if (file.delete()) {
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ----------------------------------------------------------------------------------------------------
		FileWriter fw = new FileWriter("out.kml");
		// Adding header to file
		fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		fw.write("\n");
		fw.write("<kml xmlns=\"http://earth.google.com/kml/2.1\">");
		fw.write("\n");
		fw.write("<Document>");
		fw.write("\n");
		fw.write("<Style id=\"waypoint_n\">");
		fw.write("\n");
		fw.write("<IconStyle>");
		fw.write("\n");
		fw.write("<Icon>");
		fw.write("\n");
		fw.write("<href>http://maps.google.com/mapfiles/kml/pal4/icon62.png</href>");
		fw.write("\n");
		fw.write("</Icon>");
		fw.write("\n");
		fw.write("</IconStyle>");
		fw.write("\n");
		fw.write("</Style>");
		fw.write("\n");

		// write all records to file
		while (rs1.next()) {
			// if(rs1.next()) {
			String datetime = rs1.getString("date_time");

			Float latitude = rs1.getFloat("latitude");
			Float longitude = rs1.getFloat("longitude");
			fw.write("<Placemark>");
			fw.write("\n");
			fw.write("<description>");
			fw.write("\n");
			fw.write(datetime);
			fw.write("\n");
			fw.write("</description>");
			fw.write("\n");
			fw.write("<styleUrl>#waypoint_n</styleUrl>");
			fw.write("\n");
			fw.write("<Point>");
			fw.write("\n");
			fw.write("<coordinates>" + longitude + "," + latitude
					+ "</coordinates>");
			fw.write("\n");
			fw.write(" </Point>");
			fw.write("\n");
			fw.write("</Placemark>");
			fw.write("\n");
			// fw.write("<Document>");
		}
		fw.write("</Document>");
		fw.write("\n");
		fw.write("</kml>");
		fw.close();
		System.out.println("done");

		//System.out.println(mixStart("aix"));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.print("Execution time total in milliseconds: ");
		System.out.println(duration / 1000000);

	}
}
