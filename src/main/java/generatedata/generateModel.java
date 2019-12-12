package generatedata;

import model.*;
import model.SimpleObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;

public class generateModel {
	private static final String PERSON = "http://oop/person/";
	private static final String ORGANIZATION = "http://oop/organization/";
	private static final String AGREEMENT = "http://oop/agreement/";
	private static final String COUNTRY = "http://oop/country/";
	private static final String EVENT = "http://oop/event/";
	private static final String LOCATION = "http://oop/location/";
	private ValueFactory valueFactory = SimpleValueFactory.getInstance();
//	private ArrayList<String> labels = new ArrayList<String>(
//			Arrays.asList(new String[] {"hasId", "hasLabel", "hasDescription"}));
	
	public generateModel() {

	}
	
//	public void addSimpleInfo(Model model, ArrayList<Object> objs, String prefix, String type)
//	{
//		IRI s, p;
//		Literal o;
//		for (Object obj: objs)
//		{
//			s = valueFactory.createIRI(prefix, type + obj.getId());
//			
//			p = valueFactory.createIRI(prefix, "/hasId");
//			o = valueFactory.createLiteral(obj.getId());
//			model.add(s, p, o);
//			
//			p = valueFactory.createIRI(prefix, "/hasLabel");
//			o = valueFactory.createLiteral(obj.getLabel());
//			model.add(s, p, o);
//			
//			p = valueFactory.createIRI(prefix, "/hasDescription");
//			o = valueFactory.createLiteral(obj.getDescription());
//			model.add(s, p, o);
//		}
//	}
//	
//	public void addPersonInfo(Model model, ArrayList<Person> people) {
//		IRI s, p;
//		Literal o;
//		for (Person obj: people)
//		{
//			s = valueFactory.createIRI(PERSON, "/person" + obj.getId());
//			p = valueFactory.createIRI(PERSON, "/hasDateOfBirth");
//			o = valueFactory.createLiteral(obj.getDate_of_birth());
//			model.add(s, p, o);		
//		}
//	}
//	
//	public void addEventInfo(Model model, ArrayList<Event> events) {
//		IRI s, p;
//		Literal o;
//		for (Event obj: events)
//		{
//			s = valueFactory.createIRI(EVENT, "/event" + obj.getId());
//			p = valueFactory.createIRI(EVENT, "/takePlaceOn");
//			o = valueFactory.createLiteral(obj.getDate());
//			model.add(s, p, o);		
//		}
//	}
//	
//	public void addAgreementInfo(Model model, ArrayList<Agreement> agreements) {
//		IRI s, p;
//		Literal o;
//		for (Agreement obj: agreements)
//		{
//			s = valueFactory.createIRI(AGREEMENT, "/event" + obj.getId());
//			p = valueFactory.createIRI(AGREEMENT, "/takePlaceOn");
//			o = valueFactory.createLiteral(obj.getDate());
//			model.add(s, p, o);		
//		}
//	}
	
	public void addSimple(ModelBuilder builder, SimpleObject obj, String prefix, String type)
	{
			builder.setNamespace("pref", prefix).subject("pref:"+type+obj.getId())
				.add("pref:hasId", obj.getId())
				.add("pref:hasLabel", obj.getLabel())
				.add("pref:hasDescription", obj.getDescription());
		
	}
	
	public void addPerson(ModelBuilder builder, ArrayList<Person> people)
	{
		for (Person obj: people)
		{
			this.addSimple(builder, obj, PERSON, "person");
			builder.setNamespace("pref", PERSON).subject("pref:person"+obj.getId())
				.add("pref:hasDate_of_birth", obj.getDate_of_birth());
		}
	}
	
	public void addOrganization(ModelBuilder builder, ArrayList<Organization> orgs)
	{
		for (Organization obj: orgs)
		{
			this.addSimple(builder, obj, ORGANIZATION, "organization");
			builder.setNamespace("pref", ORGANIZATION)
				.subject("pref:organization"+obj.getId())
				.add("pref:hasLocation ", "<" + LOCATION + "/location"+obj.getLocation().getId() + ">");
		}
	}
	
	public void addAgreement(ModelBuilder builder, ArrayList<Agreement> agrs)
	{
		for (Agreement obj: agrs)
		{
			this.addSimple(builder, obj, AGREEMENT, "agreement");
			builder.setNamespace("pref", AGREEMENT).subject("pref:agreement"+obj.getId())
				.add("pref:takePlaceOn", obj.getDate());
		}
	}
	
	public void addEvent(ModelBuilder builder, ArrayList<Event> events)
	{
		for (Event obj: events)
		{
			this.addSimple(builder, obj, EVENT, "event");
			builder.setNamespace("pref", EVENT)
				.subject("pref:event"+obj.getId())
				.add("pref:takePlaceOn", obj.getDate())
				.add("pref:hasLocation ", "<" + LOCATION + "/location"+obj.getLocation().getId() + ">");		
		}
	}
	
	public void addLocation(ModelBuilder builder, ArrayList<Location> locations)
	{
		for (Location obj: locations)
		{
			this.addSimple(builder, obj, LOCATION, "location");
		}
	}
	
	public void addCountry(ModelBuilder builder, ArrayList<Country> countries)
	{
		for (Country obj: countries)
		{
			this.addSimple(builder, obj, COUNTRY, "country");
		}
	}
	
}
