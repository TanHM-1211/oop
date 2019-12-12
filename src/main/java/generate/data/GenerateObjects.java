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
                		System.out.println(cnt);
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
            location_reader = new BufferedReader(new FileReader("data/vietnamese-namedb/girl.txt"));
            String des;
            while((des = location_reader.readLine()) != null) 
            {
            	locations.set(cnt, new Location(cnt, des, ""));
            	cnt++;
        		if (cnt >= num)
        		{
        			this.util.addLocation(builder, locations);
        			location_reader.close();
        		}
            }
            this.util.addLocation(builder, locations);
			location_reader.close();
        } catch (IOException ex1) {
            System.out.println("Error: "+ex1);
        }
        return locations ;
	}
	
	
}
