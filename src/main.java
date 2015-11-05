import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.stream.events.Comment;

public class main {
	
	//Return true if the given non-negative number 
	//is a multiple of 3 or a multiple of 5. Use the % "mod" operator
	public boolean or35(int n) {
		if(n%5==0 ||  n%3==0)
		 return true;
		else return false;
	}
//-------------------------------------------------------------------------------------	
	//Given a string, take the first 2 chars and 
	//return the string with the 2 chars added at 
	//both the front and back, so "kitten" yields"kikittenki". 
	//If the string length is less than 2, use whatever chars are there. 

	//front22("kitten")  "kikittenki"
	//front22("Ha")  "HaHaHa"
	//front22("abc")  "ababcab"
	
	public String front22(String str) {
		if(str.length()<2)
			return str+str+str;
		else {
			String result;
			result=str.substring(0, 2) +str + str.substring(0, 2);
			return result;
		}
	}
//---------------------------------------------------------------------------------------

//Given a string, return true if the string starts with "hi" and false otherwise. 

//startHi("hi there")  true
//startHi("hi")  true
//startHi("hello hi")  false
	public boolean startHi(String str) {
		if(str.length()>1)
		return (str.substring(0, 2).equals("hi"));
		else return false; 
	}
//---------------------------------------------------------------------------------------

	//Given two temperatures, return true if one is less than 0 
	//and the other is greater than 100. 

	//icyHot(120, -1) true
	//icyHot(-1, 120)  true
	//icyHot(2, 120) false	
	
public boolean icyHot(int temp1, int temp2) {
	  return ((temp1<0&&temp2>100)||(temp1>100&&temp2<0));
}
//-------------------------------------------------------------------------------------
//Given 2 int values, return true if either of them is in the range 10..20 inclusive. 

//in1020(12, 99)  true
//in1020(21, 12)  true
//in1020(8, 99)  false

public boolean in1020(int a, int b) {
return (a<=20&&a>=10 || b<=20&&b>=10);	  
}
//-----------------------------------------------------------------------------------
//We'll say that a number is "teen" if 
//it is in the range 13..19 inclusive. 
//Given 3 int values, return true if 1 or more of them are teen. 

//hasTeen(13, 20, 10)  true
//hasTeen(20, 19, 10)  true
//hasTeen(20, 10, 13)  true
public boolean hasTeen(int a, int b, int c) {
	return((a>=13&&a<=19)||(b>=13&&b<=19)||(c>=13&&c<=19));
	  //return true;
}
//-----------------------------------------------------------------------------------

//We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
//Given 2 int values, return true if one or the other is teen, but not both. 

//loneTeen(13, 99)  true
//loneTeen(21, 19)  true
//loneTeen(13, 13)  false

public boolean loneTeen(int a, int b) {
	return(((a>=13&&a<=19)&&!(b>=13&&b<=19))||(!(a>=13&&a<=19)&&(b>=13&&b<=19)));
}
//------------------------------------------------------------------------------
//Given a string, if the string "del" appears starting at index 1
//, return a string where that "del" has been deleted. 
//Otherwise, return the string unchanged. 

//delDel("adelbc")  "abc"
//delDel("adelHello")  "aHello"
//delDel("adedbc")  "adedbc"
public String delDel(String str) {
	if(str.length()<4)
		return str;
	  else {
		  if(str.substring(1, 4).equals("del"))
			  return str.substring(0,1)+str.subSequence(4, str.length());
		  else return str;
		}
}
//---------------------------------------------------------------------------

//---------------------------------------------------------------------------
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
		//String query = "select date_time,longitude,latitude from marvis_data where `date_time`>'2015-10-30 01:00:00' and `date_time`<'2015-10-30 23:00:00' and sn =80 order by id_marvis desc;";
		String query ="SELECT * FROM `marvis_data` WHERE `date_time`>='2015-10-23 06:00:00' and `date_time`<='2015-10-23 08:00:00' limit 1;";
		//String query ="SELECT * FROM `marvis_data` WHERE `date_time`>='2015-11-01 01:00:00';";
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
		
		long endTime = System.nanoTime();
		 long duration = (endTime - startTime); 
		 System.out.print("Execution time total in milliseconds: ");
		System.out.println(duration/1000000);

	}
}
