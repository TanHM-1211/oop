package generate.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.rdf4j.model.util.ModelBuilder;

import java.util.concurrent.ThreadLocalRandom;
import model.*;

public class GenerateObjects {
//	private int num;
//	private ArrayList<Person> people;
//	private ArrayList<Event> events;
//	private ArrayList<Organization> organizations;
//	private ArrayList<Agreement> agreements;
//	private ArrayList<Location> locations;
//	private ArrayList<Country> countries;
	private Utils util;
	private Calendar cal;

	public  GenerateObjects() {
		util = new Utils();
		cal = Calendar.getInstance();
		cal.clear();
	}
	public Date getRandomDate()
	{
	    cal.set(Calendar.YEAR, ThreadLocalRandom.current().nextInt(1950, 2019));
	    cal.set(Calendar.MONTH, ThreadLocalRandom.current().nextInt(0, 12));
	    cal.set(Calendar.DATE, ThreadLocalRandom.current().nextInt(1, 29));

		return cal.getTime();
	}
	
//	public void generatePerson(ModelBuilder builder, int num, int batch_size)
//	{
//		ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(new Person[batch_size]));
////		System.out.println(people.size());
//		int cnt = 0;
//		try{
//            BufferedReader first_name_reader, last_name_reader, description_reader;
//            first_name_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/girl.txt"));
//            last_name_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/ho.txt"));
//            description_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/description.txt"));
//            String first_name, last_name, description;
//            while((last_name = last_name_reader.readLine()) != null){
//                while((first_name = first_name_reader.readLine()) != null)
//                {
//                	while((description = description_reader.readLine()) != null)
//                	{
//                		people.set(cnt%batch_size, new Person(cnt, last_name + first_name, description, getRandomDate()));
//                		cnt++;
//                		System.out.println(cnt);
//                		if (cnt%batch_size == 0)
//                		{
//                			this.util.addPerson(builder, people);
//                		}
//                		else if (cnt > num)
//                		{
//                			first_name_reader.close();
//                            last_name_reader.close();
//                            description_reader.close();
//                            return;
//                		}
//                	}
//                }
//            }
//            first_name_reader.close();
//            last_name_reader.close();
//            description_reader.close();
//        } catch (IOException ex1) {
//            System.out.println("Error: "+ex1);
//        }
//        return;
//	}
	
	public ArrayList<Person> generatePerson(ModelBuilder builder, int num)
	{
		ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(new Person[num]));
		int cnt = 0;
		try{
            BufferedReader first_name_reader, last_name_reader, description_reader;
            first_name_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/girl.txt"));
            last_name_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/ho.txt"));
            description_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/description.txt"));
            String first_namei, last_namei, descriptioni;
            ArrayList<String> first_names = new ArrayList<String>();
            ArrayList<String> last_names = new ArrayList<String>();
            ArrayList<String> descriptions = new ArrayList<String>();
             
            while((last_namei = last_name_reader.readLine()) != null) last_names.add(last_namei);
            while((first_namei = first_name_reader.readLine()) != null) first_names.add(first_namei);
            while((descriptioni = description_reader.readLine()) != null) descriptions.add(descriptioni);
            for (String last_name: last_names)
            	for (String first_name: first_names)
            		for (String description: descriptions)
                	{
                		people.set(cnt, new Person(cnt, last_name + " " + first_name, description, getRandomDate()));
                		cnt++;
                		if (cnt >= num)
                		{
                			this.util.addPerson(builder, people);
                			first_name_reader.close();
                            last_name_reader.close();
                            description_reader.close();
                            return people;
                		}
                	}    
            
            this.util.addPerson(builder, people);
            first_name_reader.close();
            last_name_reader.close();
            description_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return people ;
	}
	
	public ArrayList<Location> generateLocation(ModelBuilder builder, int num)
	{
		ArrayList<Location> locations = new ArrayList<Location>(Arrays.asList(new Location[num]));
		int cnt = 0;
		try{
            BufferedReader location_reader;
            location_reader = new BufferedReader(new FileReader("data/location/hanoi.txt"));
            String name;
            while((name = location_reader.readLine()) != null) 
            {
            	locations.set(cnt, new Location(cnt, name, ""));
            	cnt++;
        		if (cnt >= num)
        		{
        			this.util.addLocation(builder, locations);
        			location_reader.close();
        			return locations ;
        		}
            }
            this.util.addLocation(builder, locations);
			location_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return locations ;
	}
	
	public ArrayList<Event> generateEvent(ModelBuilder builder, ArrayList<Location> locations, int num)
	{
		ArrayList<Event> events = new ArrayList<Event>(Arrays.asList(new Event[num]));
		int cnt = 0;
		try{
            BufferedReader name_reader, description_reader;
            name_reader = new BufferedReader(new FileReader("data/event/festival.txt"));
            description_reader = new BufferedReader(new FileReader("data/event/description.txt"));
            String  namei, descriptioni;
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> descriptions = new ArrayList<String>();
             
            while((namei = name_reader.readLine()) != null) names.add(namei);
            while((descriptioni = description_reader.readLine()) != null) descriptions.add(descriptioni);
            for (Location location: locations)
            	for (String name: names)
            		for (String description: descriptions)
                	{
            			events.set(cnt, new Event(cnt, name, description, getRandomDate(), location));
                		cnt++;
                		if (cnt >= num)
                		{
                			this.util.addEvent(builder, events);
                			name_reader.close();
                            description_reader.close();
                            return events;
                		}
                	}    
            
            this.util.addEvent(builder, events);
			name_reader.close();
            description_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return events ;
	}
	
	public ArrayList<Organization> generateOrganization(ModelBuilder builder, ArrayList<Location> locations, int num)
	{
		ArrayList<Organization> organizations = new ArrayList<Organization>(Arrays.asList(new Organization[num]));
		int cnt = 0;
		try{
            BufferedReader organization_reader;
            organization_reader = new BufferedReader(new FileReader("data/organization/organizations.txt"));
            String name;
            while((name = organization_reader.readLine()) != null) 
            {
            	for (Location location: locations)
            	{
            		organizations.set(cnt, new Organization(cnt, name, "", location));
	            	cnt++;
	        		if (cnt >= num)
	        		{
	        			this.util.addOrganization(builder, organizations);
	        			organization_reader.close();
	        			return organizations ;
	        		}
            	}
            }
            this.util.addOrganization(builder, organizations);
			organization_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return organizations ;
	}
	
	public ArrayList<Agreement> generateAgreement(ModelBuilder builder, ArrayList<Location> locations, int num)
	{
		ArrayList<Agreement> agreements = new ArrayList<Agreement>(Arrays.asList(new Agreement[num]));
		int cnt = 0;
		try{
            BufferedReader name_reader, description_reader;
            name_reader = new BufferedReader(new FileReader("data/aggrement/aggrements.txt"));
            description_reader = new BufferedReader(new FileReader("data/aggrement/description.txt"));
            String  namei, descriptioni;
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> descriptions = new ArrayList<String>();
             
            while((namei = name_reader.readLine()) != null) names.add(namei);
            while((descriptioni = description_reader.readLine()) != null) descriptions.add(descriptioni);
            for (Location location: locations)
            	for (String name: names)
            		for (String description: descriptions)
                	{
            			agreements.set(cnt, new Agreement(cnt, name, description, getRandomDate(), location));
                		cnt++;
                		if (cnt >= num)
                		{
                			this.util.addAgreement(builder, agreements);
                			name_reader.close();
                            description_reader.close();
                            return agreements;
                		}
                	}    
            
            this.util.addAgreement(builder, agreements);
			name_reader.close();
            description_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return agreements ;
	}
	
	public ArrayList<Country> generateCountry(ModelBuilder builder, int num)
	{
		ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(new Country[num]));
		int cnt = 0;
		try{
            BufferedReader name_reader, description_reader;
            name_reader = new BufferedReader(new FileReader("data/country/countries.txt"));
            description_reader = new BufferedReader(new FileReader("data/country/description.txt"));
            String  namei, descriptioni;
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> descriptions = new ArrayList<String>();
             
            while((namei = name_reader.readLine()) != null) names.add(namei);
            while((descriptioni = description_reader.readLine()) != null) descriptions.add(descriptioni);
            	for (String name: names)
            		for (String description: descriptions)
                	{
            			countries.set(cnt, new Country(cnt, name, description));
                		cnt++;
                		if (cnt >= num)
                		{
                			this.util.addCountry(builder, countries);
                			name_reader.close();
                            description_reader.close();
                            return countries;
                		}
                	}    
            
            	this.util.addCountry(builder, countries);
    			name_reader.close();
                description_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return countries ;
	}
	
}
