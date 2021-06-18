/*
 *  PANCREDIT SYSTEMS LTD
 *  (C) Copyright PanCredit Systems Ltd 2021
 *
 *  COPYRIGHT NOTICE
 *  ---------------------------------
 *  The contents of this file are protected by copyright. Any unauthorised
 *  copying, duplication of its contents are in breach of the copyright.
 *
 *  Last Checked In By: $Author$
 *  Date Checked In:    $Date$
 *  Name and Version:   $Id$
 *
 *  Log messages:       $Log$
 * 
 */
package com.pancredit.api;

//Import required java libraries
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.pancredit.application.Application;
import com.pancredit.service.Service;

//Extend HttpServlet class
public class ApiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String message;

	public void init() throws ServletException {
		message = "TODO";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In get");
		getApplications(request, response);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Put");
		boolean success = addApplication(request);
		if (!success) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setStatus(HttpServletResponse.SC_OK);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Post");
		boolean success = updateApplication(request);
		if (!success) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setStatus(HttpServletResponse.SC_OK);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = deleteApplication(request);
		if (!success) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setStatus(HttpServletResponse.SC_OK);

	}

	@SuppressWarnings("unchecked")
	private void getApplications(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ArrayList<Application> applicationList = Service.getInstance().getApplications();

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		for (Application app : applicationList) {
			jsonArray.add(app.toJsonObject());

		}
		out.print(jsonArray.toJSONString());

	}

	private JSONObject getJsonFromRequest(HttpServletRequest request) throws IOException, ServletException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			BufferedReader reader = request.getReader();
			jsonObject = (JSONObject) jsonParser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return jsonObject;

	}

	private boolean addApplication(HttpServletRequest request) throws IOException, ServletException {

		JSONObject jsonObject = getJsonFromRequest(request);
		return Service.getInstance().addApplication(new Application(jsonObject));

	}

	private boolean updateApplication(HttpServletRequest request) throws IOException, ServletException {

		JSONObject jsonObject = getJsonFromRequest(request);
		return Service.getInstance().updateApplication(new Application(jsonObject));

	}

	private boolean deleteApplication(HttpServletRequest request) throws IOException, ServletException {

		String id = request.getParameter("id");
		System.out.println(id);
		return Service.getInstance().deleteApplication(id);

	}

	public void destroy() {
		// do nothing.
	}

}
