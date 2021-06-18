package com.pancredit.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pancredit.application.Application;

import junit.extensions.TestSetup;

public class TestService {

	@Test
	public void testGetApplications() {
		Service service = Service.getInstance();
		ArrayList<Application> appList = service.getApplications();
		assertTrue(appList != null && appList.size() > 0); 
		//fail("Not yet implemented");
		//assert(true);
	}


}
