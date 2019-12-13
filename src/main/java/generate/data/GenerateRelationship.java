package generate.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import model.*;

public class GenerateRelationship {
	private static final String PERSON = "http://oop/person/";
	private static final String ORGANIZATION = "http://oop/organization/";
	private static final String AGREEMENT = "http://oop/agreement/";
	private static final String COUNTRY = "http://oop/country/";
	private static final String EVENT = "http://oop/event/";
	private static final String LOCATION = "http://oop/location/";

    private static final String PREFIX = "http://oop/";
	private ArrayList<Person> people;
	private ArrayList<Event> events;
	private ArrayList<Organization> organizations;
	private ArrayList<Agreement> agreements;
	private ArrayList<Location> locations;
	private ArrayList<Country> countries;
	private List<String> rela;
	private ValueFactory vf = SimpleValueFactory.getInstance();
	
	
	public GenerateRelationship() {
		rela = Arrays.asList(new String[] {"meet", "organize", "hasAgreementWith", "participate", "takePlaceIn", 
				"bolster", "oppose", "deliverASpeechAt", "hasTensionWith", "cancel", "negotiateWith"});
	}



	public void exec(RepositoryConnection connection, int num, int batch_size)
	{
		ArrayList<Statement> people = new ArrayList<Statement>(Arrays.asList(new Statement[batch_size]));
		Model model = (new ModelBuilder()).build();
	}
	
	public void genRela(Model model, ArrayList<Integer> id1s, ArrayList<Integer> id2s,
			String prefix1, String prefix2, String type1, String type2, String relationship, int num)
	{	
		ArrayList<Statement> res = new ArrayList<Statement>();
		IRI p = vf.createIRI(prefix1, relationship);
		int cnt = 0;
		for (int id1: id1s)
		{
			Resource s = vf.createIRI(prefix1, type1 + id1);
			for (int id2: id2s)
			{
				Value o = vf.createIRI(prefix2, type2 + id2);
				res.add(vf.createStatement(s, p, o));
				cnt++;
				if (cnt >= num) 
				{
					model.addAll(res);
					return;
				}
			}
		}
		model.addAll(res);
		return;
	}
	
	public void genPerPer(Model model, ArrayList<Person> objects1, ArrayList<Person> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Person obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, PERSON, "person", "person", "meet", num);
	}
	
	public void genPerEvent(Model model, ArrayList<Person> objects1, ArrayList<Event> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Event obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, EVENT, "person", "event", "organize", num);
	}
	
//	public void genCtyCty(Model model, ArrayList<Person> objects1, ArrayList<Person> objects2, int num)
//	{
//		ArrayList<Integer> id1s = new ArrayList<Integer>();
//		ArrayList<Integer> id2s = new ArrayList<Integer>();
//		for (Person obj: objects1) id1s.add(obj.getId());
//		for (Person obj: objects2) id2s.add(obj.getId());
//		this.genRela(model, id1s, id2s, PERSON, PERSON, "person", "person", "meet", num);
//	}
	
	public void genPerOrg(Model model, ArrayList<Person> objects1, ArrayList<Organization> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Organization obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, ORGANIZATION, "person", "organization", "participate", num);
	}
	
	public void genPerCty(Model model, ArrayList<Person> objects1, ArrayList<Country> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Country obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, COUNTRY, "person", "country", "bolster", num);
	}
	
	public void genPerCty1(Model model, ArrayList<Person> objects1, ArrayList<Country> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Country obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, COUNTRY, "person", "country", "oppose", num);
	}
	
	public void genCtyCty(Model model, ArrayList<Country> objects1, ArrayList<Country> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Country obj: objects1) id1s.add(obj.getId());
		for (Country obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, COUNTRY, COUNTRY, "country", "country", "hasTensionWith", num);
	}
	
	public void genPerArg(Model model, ArrayList<Person> objects1, ArrayList<Agreement> objects2, int num)
	{
		ArrayList<Integer> id1s = new ArrayList<Integer>();
		ArrayList<Integer> id2s = new ArrayList<Integer>();
		for (Person obj: objects1) id1s.add(obj.getId());
		for (Agreement obj: objects2) id2s.add(obj.getId());
		this.genRela(model, id1s, id2s, PERSON, AGREEMENT, "person", "agreement", "cancel", num);
	}
	
//	public String exec(int num, int batch_size)
//	{
//		
//	}
}
