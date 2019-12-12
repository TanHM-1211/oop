package generatedata;

import model.*;
import model.Object;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;

public class generateIRI {
	private static final String PERSON = "<http://oop/person/>";
	private static final String ORGANIZATION = "<http://oop/organization/>";
	private static final String AGREEMENT = "<http://oop/agreement/>";
	private static final String COUNTRY = "<http://oop/country/>";
	private static final String EVENT = "<http://oop/event/>";
	private static final String LOCATION = "<http://oop/location/>";
	private ValueFactory valueFactory = SimpleValueFactory.getInstance();
//	private ArrayList<String> labels = new ArrayList<String>(
//			Arrays.asList(new String[] {"hasId", "hasLabel", "hasDescription"}));
	
	public generateIRI() {

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
	
	public void addSimpleNode(ModelBuilder builder, ArrayList<Object> objs, String prefix, String type)
	{
		for (Object obj: objs)
		{
			builder.setNamespace("pref", prefix).subject("pref:"+type+obj.getId())
				.add("pref:hasId", obj.getId())
				.add("pref:hasLabel", obj.getLabel())
				.add("pref:hasDescription", obj.getDescription());
		}
	}
	
	public void addPersonNode(ModelBuilder builder, ArrayList<Person> people)
	{
		for (Person obj: people)
		{
			builder.setNamespace("pref", PERSON).subject("pref:person"+obj.getId())
				.add("pref:hasDate_of_birth", obj.getDate_of_birth());
		}
	}
	
	public void addOrganizationNode(ModelBuilder builder, ArrayList<Organization> orgs)
	{
		for (Organization obj: orgs)
		{
			builder.setNamespace("pref", ORGANIZATION).setNamespace("loc", LOCATION)
				.subject("pref:organization"+obj.getId())
				.add("loc:hasLocation", );
		}
	}
}
