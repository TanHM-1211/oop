package DAO;

import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import model.Person;

public class SimpleQuery {
    private static final String PERSON = "<http://oop/person/>";
	private static final String ORGANIZATION = "<http://oop/organization/>";
	private static final String AGREEMENT = "<http://oop/agreement/>";
	private static final String COUNTRY = "<http://oop/country/>";
	private static final String EVENT = "<http://oop/event/>";
	private static final String LOCATION = "<http://oop/location/>";
	private static final String PREFIX = "prefix person: <http://oop/person/> \n"
			+ "prefix organization: <http://oop/organization/> \n"
			+ "prefix agreement: <http://oop/agreement/> \n"
			+ "prefix country: <http://oop/country/> \n"
			+ "prefix event: <http://oop/event/> \n"
			+ "prefix location: <http://oop/location/>\n";
//	private static final String PERSONDOB = "<http://oop/person/hasDate_of_birth/>";
//	private static final String PERSONDESC = "<http://oop/person/hasDescription/>";
//	private static final String EVENTDATE = "<http://oop/event/hasDate/>";
//	//private ValueFactory valueFactory = SimpleValueFactory.getInstance();
//	
//	private static final String GRAPHDB_SERVER = "http://localhost:7200/";
//    private static final String REPOSITORY_ID = "oop_project";
//    private static final String PREFIX = "http://oop/";
//    private static final String PROPERTY_PREFIX = "<http://oop/properties/>";
//    private static final String RELATIONSHIP_PREFIX = "<http://oop/relationships/>";
//    private RepositoryConnection connection; 
//    private Repository repository;
	
	public SimpleQuery()
	{}
    
    public String getDateOfBirthOfPerson(String labelOfPerson) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where { ?y person:hasLabel \""+labelOfPerson+"\". ?y person:hasDate_of_birth ?x";
    	k+=".}"; return k;
    }
    
    public String getDescriptionOfPerson(String labelOfPerson) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where { ?y person:hasLabel \""+labelOfPerson+"\". ?y person:hasDescription ?x";
    	k+=".}"; return k;
    }
    
    public String getDateOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasDate ?x";
    	k+=".}"; return k;
    }
    
    public String getDescriptionOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasDescription ?x";
    	k+=".}"; return k;
    }
    
    public String getLocationOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasLocation ?x";
    	k+=".}"; return k;
    }

    public String getDescriptionOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasDescription ?x";
    	k+=".}"; return k;
    }
    
    public String getDateOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasDate ?x";
    	k+=".}"; return k;
    }
    
    public String getLocationOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasLocation ?x";
    	k+=".}"; return k;
    }
    
    public String getDescriptionOfCountry(String labelOfCountry) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y country:hasLabel \""+labelOfCountry+" \". ?y country:hasDescription ?x";
    	k+=".}"; return k;
    }
    
    public String getDescriptionOfLocation(String labelOfLocation) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where { ?y location:hasLabel \""+labelOfLocation+" \". ?y location:hasDescription ?x";
    	k+=".}"; return k;
    }
    
    public String getLocationOfOrganization(String labelOfOrganization) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y organization:hasLabel \""+labelOfOrganization+" \". ?y organization:hasLocation ?x";
    	k+=".}"; return k;
    }
    
    public String getPersonMeetPerson(String labelOfSub) { //find Person had met somebody else named "labelOfSub" (find Object);
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where{ ?s person:hasLable \""+labelOfSub+"\". person:?sperson:meet ?o";
    	k+=".}"; return k;
    }
    
    public String getEventOrganizeByPerson(String labelOfSub) { // find Events which hold by person named "labelOfPerson"
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:organize ?o }";
    	k+=".}"; return k;
    }
    public String getCountryAgreeCountry(String labelOfSub) { //find country which agree with other country named "labelOfSub"  
    	String k = String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:hasAgreementWith ?o }";
    	k+=".}"; return k;
    }
    
    public String getOrganizationParticipateByPerson(String labelOfSub) {//find Organization which had been participated by somebody named "labelOfSub"
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:participate ?o }";
    	k+=".}"; return k;
    }
    public String getLocationTakePlaceInByEvent(String labelOfSub) {//labelOfSub is name of location
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s location:hasLabel \""+labelOfSub+"\". ?s location:takePlaceIn ?o }";
    	k+=".}"; return k;
    }
    
    
}