package com.pranav.beginner.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pranav.beginner.model.LocationStats;

@Service

public class CoronaVirusDataServices {
	
	private static String VIRUS_DATA = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	private List<LocationStats> allStats = new ArrayList<>();
	@PostConstruct
	@Scheduled(cron="* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
	    List<LocationStats> newStats = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				                         .uri(URI.create(VIRUS_DATA))
				                         .build();
		
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		
		for(CSVRecord record : records) {
			LocationStats locationStat =  new LocationStats();
			
			String provstate = record.get("Province/State");
			String countrRegion = record.get("Country/Region");
			String latitude = record.get("Lat");
			String longitude = record.get("Long");
			int latestTotalCases = Integer.parseInt(record.get(record.size() - 1));
			int diffFromPrevDay = latestTotalCases -  Integer.parseInt(record.get(record.size() - 2));
			
			locationStat.setState(provstate);;
			locationStat.setCountry(countrRegion);
			locationStat.setLatitude(latitude);
			locationStat.setLongitude(longitude);
			locationStat.setLatestTotalCases(latestTotalCases);
			locationStat.setDiffFromPrevDay(diffFromPrevDay);
			
			newStats.add(locationStat);
		}
		
		this.allStats = newStats;
		
	}
	public List<LocationStats> getAllStats() {
		return allStats;
	}

}
