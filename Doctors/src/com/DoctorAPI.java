package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Doctor;

import com.sun.jersey.api.model.Parameter;
import com.sun.research.ws.wadl.Doc;
import com.DoctorService;

/**
 * Servlet implementation class DoctorAPI
 */
@WebServlet("/DoctorAPI")
public class DoctorAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Doctor Doc = new Doctor(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = Doc.insertdocdetails(request.getParameter("DfirstName"),
				request.getParameter("DlastName"),
				request.getParameter("Didnum"),
				request.getParameter("Dgender"),
				request.getParameter("Dmobilenumber"),
				request.getParameter("Daddress"),
				request.getParameter("Dworkplace"),
				request.getParameter("Ddegree"));
		response.getWriter().write(output);
				
		
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = Doc.updatedocdetails(paras.get("hidDoctorIDSave").toString(),
				paras.get("DfirstName").toString(),
				paras.get("DlastName").toString(),
				paras.get("Didnum").toString(),
				paras.get("Dgender").toString(),
				paras.get("Dmobilenumber").toString(),
				paras.get("Daddress").toString(),
				paras.get("Dworkplace").toString(),
				paras.get("Ddegree").toString());
		
		response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = Doc.deletedocdetails(paras.get("Did").toString());
		response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String>map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(),"UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params =queryString.split("&");
			for(String param : params);
			{
				String param = null;
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
					
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

}
