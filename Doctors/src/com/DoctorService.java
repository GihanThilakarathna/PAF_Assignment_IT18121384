package com;



import javax.swing.text.Document;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Doctor;


@Path("/Appoint")

public class DoctorService {
	Doctor Doc = new Doctor();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)	 
	public String readItems()
	{
		return  Doc.readdocdetails();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDcotors(@FormParam("DfirstName") String DfirstName,
	 @FormParam("DlastName") String DlastName,
	 @FormParam("Didnum") String Didnum,
	 @FormParam("Dgender") String Dgender,
	 @FormParam("Dmobilenumber") String DmobileNumber,
	 @FormParam("Daddress") String Daddress,
	 @FormParam("Dworkplace") String Dworkplace,
	 @FormParam("Ddegree") String Ddegree)
	
	{
		 String output = Doc.insertdocdetails(DfirstName, DlastName,Didnum, Dgender, DmobileNumber, Daddress, Dworkplace, Ddegree);
		return output;
		}
	
	
		
	@DELETE
	
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String Did)
	{
	//Convert the input string to an XML document
	 Document doc = (Document) Jsoup.parse(Did, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String did = ((Element) doc).select("did").text();
	 String output = ((Doctor) doc).deletedocdetails(Did);
	return output;
	}
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctors(String docdata) {
		
		JsonObject  Doc = new JsonParser().parse(docdata).getAsJsonObject();
		
		String Did = Doc.get("Did").getAsString();
		 String DfirstName = Doc.get("DfirstName").getAsString();
		 String DlastName = Doc.get("DlastName").getAsString();
		 String Didnum = Doc.get("Didnum").getAsString();
		 String Dgender = Doc.get("Dgender").getAsString();
		 String Dmobilenumber = Doc.get("Dmobilenumber").getAsString();
		 String Daddress = Doc.get("Daddress").getAsString();
		 String Dworkplace = Doc.get("Dworkplace").getAsString();
		 String Ddegree = Doc.get("Ddegree").getAsString();
		 
		 String output = Doc.updatedocdetails(Did, DfirstName, DlastName,Didnum, Dgender, Dmobilenumber, Daddress, Dworkplace, Ddegree);
		 return output;
	}
	 
	
			 
	
}
