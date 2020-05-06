<%@page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script  src = "js/jquery-3.5.0.mim.js" type="text/javascript"></script>
<script  src="Components/doctor.js"></script>
</head>
<body>
	<div class "containers">
	<div class="row">
	<div class ="col6">
	<h1>Doctor Management</h1>
	<form id="Doctor" name="formdoctor" methods="post" action="doctor.jsp">
	<input id="did" name="Doctorid" type="text" class="form-control form-control-sm">
	<br>Doctor ID:
	<input id="firsatname" name="Doctorfirstname" type="text" class="form-control form-control-sm">
	<br>Doctor First Name:
	<input id="lastname" name="Doctorlastname" type="text" class="form-control form-control-sm">
	<br>Doctor Last Name:
	<input id="gender" name="Doctorgender" type="text" class="form-control form-control-sm">
	<br>Doctor Gender:
	<input id="mobilenumber" name="Doctormobilenumber" type="text" class="form-control form-control-sm">
	<br>Doctor Mobile Number:
	<input id="address" name="Doctoraddress" type="text" class="form-control form-control-sm">
	<br>Doctor Address:
	<input id="workplace" name="Doctorworkplace" type="text" class="form-control form-control-sm">
	<br>Doctor Work Place:
	<input id="degree" name="Doctordegree" type="text" class="form-control form-contro-sm">
	<br>Doctor Degree:
	
	<input id="btnsave" name="btnsave" type="button" value="Save" class="btn-btn-primary">
	<input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success">
	
	out.print(session.getAttribute("statusMsg"));
	
	
	</div>
	<div id="alertError" class=""alert alert-danger">
	</div>
	<br>
	<div id ="divDoctorGrid>
	<%
	Doctor Doc = new Doctor();
	out.print(Doc.readdocdetails());
	%>
	</div>
	</div></div>
	<%
	//save==============
	if(request.getParameter("DfirstName") != null){
		Doctor Doc = new Doctor();
		String stsMsg = "";
		
		//insert=================================================
				if(request.getParameter("hidDoctorIDSave") == ""){
					stsMsg = Doc.insertdocdetails
							request.getParameter("DfirstName"),
							request.getParameter("DlastName"),
							request.getParameter("Dgender"),
							request.getParameter("Dmobilenumber"),
							request.getParameter("Daddress"),
							request.getParameter("Dworkplace"),
							request.getParameter("Ddegree"));
							
				}
		else//Update=============={
				stsMsg = Doc.updatedocdetails(request.getParameter("hidDoctorIDSave"),
						request.getParameter("DfirstName"),
						request.getParameter("DlastName"),
						request.getParameter("Dgender"),
						request.getParameter("Dmobilenumber"),
						request.getParameter("Daddress"),
						request.getParameter("Dworkplace"),
						request.getParameter("Ddegree"));
		
	}
		session.setAttribute("statusMsg", stsMsg);
		
	}
	//Delete==========================
			if(request.getParameter("hidDoctorIDelete") !=null)
			{
				Doctor Doc = new Doctor();
				String stsMsg = Doc.deletedocdetails(request.getParameter("hidDoctorIDDelete"));
				session.setAttribute("statusMsg", stsMsg);
			}
	%>
</body>
</html>