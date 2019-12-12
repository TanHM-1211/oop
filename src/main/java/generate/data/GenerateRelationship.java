package generate.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import model.*;

public class GenerateRelationship {
    private static final String PREFIX = "http://oop/";
	private ArrayList<Person> people;
	private ArrayList<Event> events;
	private ArrayList<Organization> organizations;
	private ArrayList<Agreement> agreements;
	private ArrayList<Location> locations;
	private ArrayList<Country> countries;
	private List<String> rela;
	
	
	
	public GenerateRelationship(ArrayList<Person> people, ArrayList<Event> events,
			ArrayList<Organization> organizations, ArrayList<Agreement> agreements, ArrayList<Location> locations,
			ArrayList<Country> countries) {
		this.people = people;
		this.events = events;
		this.organizations = organizations;
		this.agreements = agreements;
		this.locations = locations;
		this.countries = countries;
		rela = Arrays.asList(new String[] {"meet", "organize", "hasAgreementWith", "participate", "takePlaceIn", 
				"bolster", "oppose", "deliverASpeechAt", "hasTensionWith", "cancel", "negotiateWith"});
	}



	public void exec(RepositoryConnection connection, int num, int batch_size)
	{
		ArrayList<Statement> people = new ArrayList<Statement>(Arrays.asList(new Statement[batch_size]));
		Model model = (new ModelBuilder()).build();
	}
	
//	public String exec(int num, int batch_size)
//	{
//		
//	}
}
