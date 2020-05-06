$(document).ready(function() {
	if($("#alertSuccess").text().trim() == ""){
		$("#alertError").hide();
		
	}
	$("#alertError").hide();
		
	
});

//Save============================================
$(document).on("Click", "#btnSave",function(event)
		{
		$("#alertSuccess").text("");
		$("#alertSuccess").hide("");
		$("#alertError").text("");
		$("#alertError").hide("");
		
		
		var status = validateDoctorForm();
		if(status != true){
			$("#alertError").text(status);
			$("#alertError").show();
			return;
		}
		
		//if valid=================================
		var type = ($("hiddoctoridSave").val() == "") ? "POST" : "PUT";
		$.ajax(
				{
					url : "DoctorAPI",
					type :type,
					data : $("#formDoctor").serialize(),
					dataType :"text",
					complete : function(response.responseText, status);
						
					}
				});
		
		$("#formDoctor").submit();
		});

function  onDoctorSaveComplete(response, status) {
	if(status == "success"){
		var resultSet = JSON.parse(response);
		if(resultSet.status.trim()== "success"){
			$("#alertSuccess").text("Succesfully saved.");
			$("alertSuccess".show();
			$("#divDoctorGrid").html(resultSet.data);
		}else if(resultSet.status.trim()== "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	}else if(status == "error"){
		$("#alertError").text("Error while saving");
		$("#alertError").show();
	}else {
		$("#alertError").text(" Unknown error while saving");
		$("#alertError").show();
	}
	$("#hiddoctoridSave").val("");
	$("#formItem")[0].reset();
		
}

//Update=============================================
$(document).on("Click", "#btnUpdate",function(event)
		{
	$("#hidDoctorSave").val($this).closest("tr").find('#hidDoctorUpdate').val());
	$("#DoctorId").val($this).closest("tr").find('td:eg(0)').text());
	$("#Firstname").val($this).closest("tr").find('td:eg(1)').text());
	$("#Lastname").val($this).closest("tr").find('td:eg(2)').text());
	$("#gender").val($this).closest("tr").find('td:eg(3)').text());
	$("#mobilenumber").val($this).closest("tr").find('td:eg(4)').text());
	$("#address").val($this).closest("tr").find('td:eg(5)').text());
	$("#workplace").val($this).closest("tr").find('td:eg(6)').text());
	$("#degree").val($this).closest("tr").find('td:eg(7)').text());
	
	
		});
		
//Remove=============================================
		$(document).on("click", ".btnRemove", function(event)
				{
			$.ajax(
					{
				url :"DoctorAPI",
				type : "Delete",
				data : "itemID= " + $(this).data("did"),
				datatype :"text",
				complete : function(response,status)
				{
				onDoctorDeleteComplete(response,responseText, status);	
				}
			});
		});
				
		function onDoctorDeleteComplete(response, status)
		{
			if(status == "success")
				{
				var resultSet = JSON.parse(reponse);
				if(resultSet.status.trim() == "success")
					{
					$("#alertSuccess").text("Successfully deleted.");
					$("#alertsuccess").show();
					
					$("#divDoctorGrid").html(resultSet.data);
					}else if(resultSet.status.trim() == "error")
						{
						$("#alertError").text(resultSet.data);
						$("alertError").show();
						}
				
				}else if(status == "error")
					{
					$("#alertError").text("Error while deleting");
					$("alertError").show();
					}else
						{
						$("#alertError").text("Unknown error while deleting");
						$("alertError").show();
						}
		}
		
		
function validateDoctorForm() {
	if("$doctorid").val().trim()==""){
		return "Insert Doctor Id";
	}
	
	if("$doctorfirstname").val().trim()==""){
		return "Insert Doctor FirstName";
	}
	if("$doctorlastname").val().trim()==""){
		return "Insert Doctor LastName";
	}
	if("$gender").val().trim()==""){
		return "Insert Doctor Gender";
	}
	if("$mobilenumber").val().trim()==""){
		return "Insert Doctor Mobile Number";
	}
	if("$address").val().trim()==""){
		return "Insert DoctorAddress";
	}
	if("$workplace").val().trim()==""){
		return "Insert Doctor Workplace";
	}
	if("$degree").val().trim()==""){
		return "Insert Degree";
	}
	
	return true;
}
		