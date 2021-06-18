package com.pancredit.service;

import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.pancredit.application.Application;

public class Service {
	private static Service instance;

	private final String fileName = "resources/data.json";

	private ConcurrentMap<String, Application> applications = new ConcurrentHashMap<String, Application>();

	private AtomicInteger mapKey = new AtomicInteger();

	public static Service getInstance() {

		if (instance == null) {
			synchronized (Service.class) {
				if (instance == null) {
					instance = new Service();
					instance.populate();
				}
			}
		}

		return instance;
	}

	private Service() {
	}

	public ArrayList<Application> getApplications() {

		ArrayList<Application> resultList = new ArrayList<Application>();
		for (Application app : this.applications.values()) {
			resultList.add(app);
		}

		return resultList;
	}

	public boolean addApplication(Application application) {
		
		if (applications.containsKey(application.getId())) {
			return false;
		}
		
		applications.put(application.getId(), application);
		return true;
	}
	public boolean updateApplication(Application application) {
		
		if (!applications.containsKey(application.getId())) {
			return false;
		}
		
		applications.put(application.getId(), application);
		return true;
	}
	public boolean deleteApplication(String id) {
		
		if (applications.containsKey(id)) {
			return false;
		}
		
		applications.remove(id);
		return true;
	}

	@SuppressWarnings("unchecked")
	private void populate() {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		ClassLoader loader = this.getClass().getClassLoader();

		try (FileReader reader = new FileReader(loader.getResource(fileName).getFile())) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray jsonArray = (JSONArray) obj;
			
			jsonArray.forEach(item -> {
			    JSONObject json = (JSONObject) item;
			    Application app = new Application(json);
			    applications.put(app.getId(),app);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ArrayList<Application> appList = Service.getInstance().getApplications();
		appList.forEach(app -> System.out.println((Application) app));

	}
}
