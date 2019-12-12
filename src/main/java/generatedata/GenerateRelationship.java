package generatedata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.*;

public class GenerateRelationship {
	private ArrayList<Person> people;
	private ArrayList<Event> events;
	private ArrayList<Organization> organizations;
	private ArrayList<Agreement> agreements;
	private ArrayList<Location> locations;
	private ArrayList<Country> countries;
	private List<String> rela;
	
	public GenerateRelationship()
	{
		rela = Arrays.asList(new String[] {"meet", "organize", "hasAgreementWith", "participate", "takePlaceIn", "bolster", "oppose", "deliver"});
	}
	
//	public String exec(int num, int batch_size)
//	{
//		
//	}
}
