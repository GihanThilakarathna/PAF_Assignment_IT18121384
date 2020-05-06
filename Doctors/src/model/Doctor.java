package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Doctor {
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql,jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/doctors", "root", "");
			System.out.print("Sucessfully");
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			return con;
		}
		
		public String insertdocdetails(String firstname,String lastname,String idnum,  String gender, String mobilenumber,String address,String workplace,String degree) {
			String output = "";
			try {
				Connection con = connect();
				if(con == null) {
					return "Error while connecting to the database for inserting.";
				}
				String query = "insert into doctors('Did','DfirstName','DlastName','Didnum',Dgender','DmobileNumber','Daddress','Dworkplace','Ddegree')"+ " values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedState = con.prepareStatement(query);
				preparedState.setInt(1, 0);
				preparedState.setString(2,  firstname);
				preparedState.setString(3,  lastname);
				preparedState.setString(4,  idnum);
				preparedState.setString(5,  gender);
				preparedState.setString(6,  mobilenumber);
				preparedState.setString(7,  address);
				preparedState.setString(8,  workplace);
				preparedState.setString(9,  degree);
				
				
				preparedState.execute();
				con.close();
				output = " Inserted Succesfully";
			}catch (Exception e) {
				
			
			output = "Error  while connecting to the database for reading.";
			System.err.println(e.getMessage());
			
				
			}
		return output;
			
		}
		public String readdocdetails() 
		{
			String output ="";
			try {
				Connection con = connect();
				if(con == null) {
					return "Error  while connecting to the database for reading.";
				}
					output = "<table border=\"1\"><tr>did<th>FirstName</th><th> LastName </th><th>Idnum</th><th> Gender </th><th> Mobilenumber </th><th> Addresss </th><th> Workplace </th><th>Degree</th><th>Update</th><th>Remove</th></tr>";
					String query = "select * from doctors";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						String Did = Integer.toString(rs.getInt("Did"));
						String DfirstName = rs.getString("DfirstName");
						String DlasttName = rs.getString("DlastName");
						String Didnum = rs.getString("Didnum");
						String Dgender = rs.getString("Dgender");
						String DmobileNumber = rs.getString("Dmobilenumber");
						String Daddress= rs.getString("Daddress");
						String Dworkplace= rs.getString("Dworkplace");
						String Ddegree = rs.getString("Ddegree");
						
						output += "<tr><td><input id=\"hidDoctorIDUpdate\"name=\"hidDoctorIDUpdate\"type=\"hidden\" value=\"" + Did + "\">";
						
						
						output += "<tr><td>" + DfirstName + " </td>";
						output += "<tr><td>" + DlasttName + " </td>";
						output += "<tr><td>" + Didnum + " </td>";
						output += "<tr><td>" + Dgender + " </td>";
						output += "<tr><td>" + DmobileNumber + " </td>";
						output += "<tr><td>" + Daddress + " </td>";
						output += "<tr><td>" + Dworkplace + " </td>";
						output += "<tr><td>" + Ddegree + " </td>";
						
						output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
								 + "<input name=\"DID\" type=\"hidden\" value=\"" + Did
								 + "\">" + "</form></td></tr>";
						
						
						
					}
					
					con.close();
					output += "</table>";
					
					
				}
				catch (Exception e) 
				{
					output = "Error while reading the items.";
					System.err.println(e.getMessage());
				}
				return output;
			}
			
			public String updatedocdetails(String did,String firstName,String lastName, String idnum, String gender, String mobileNumber,String address,String workplace,String degree) {
				String output = "";
				try {
					Connection con = connect();
					if(con == null) {
						return "Error  while connecting to the database for reading.";
					}
					String query = "UPDATE doctors SET firstName=?,lastName=?,Didnum=?,gender=?,mobileNumber=?,address=?,workplace=?,degree=?WHERE did=?";
					PreparedStatement preparedState = con.prepareStatement(query);
					preparedState.setInt(1, 0);
					preparedState.setString(2,  firstName);
					preparedState.setString(3,  lastName);
					preparedState.setString(3,  idnum);
					preparedState.setString(4,  gender);
					preparedState.setString(5,  mobileNumber);
					preparedState.setString(6,  address);
					preparedState.setString(7,  workplace);
					preparedState.setString(8,  degree);
					
					
					preparedState.execute();
					con.close();
					output = "Succesfully update";
				}catch (Exception e) {
					
				
				output = "Error while updating the doctors.";
				System.err.println(e.getMessage());
				
					
				}
			return output;
		}
			public String deletedocdetails(String did) {
				
				String output = "";
				 try
				 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for deleting."; }
				 // create a prepared statement
				 String query = "delete from doctors where did=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(did));
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Deleted successfully";
				 }
				 catch (Exception e)
				 {
				 output = "Error while deleting the item.";
				 System.err.println(e.getMessage());
				 }
				 return output;
				 } 
			}
				
			
	
				
	

