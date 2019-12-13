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
	
    public String getDateOfBirthOfPerson(String labelOfPerson) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where \n{ ?y person:hasLabel \""+labelOfPerson+"\". ?y person:hasDate_of_birth ?x ";
    	k+=".}"; return k;
    }
    
    public String getDescriptionOfPerson(String labelOfPerson) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where { ?y person:hasLabel \""+labelOfPerson+"\". ?y person:hasDescription ?x .}";
    	return k;
    }
    
    public String getDateOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasDate ?x.}";
    	return k;
    }
    
    public String getDescriptionOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasDescription ?x. }";
    	return k;
    }
    
    public String getLocationOfEvent(String labelOfEvent) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y event:hasLabel \""+labelOfEvent+" \". ?y event:hasLocation ?x.}";
    	return k;
    }

    public String getDescriptionOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasDescription ?x. }";
    	return k;
    }
    
    public String getDateOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasDate ?x. }";
    	return k;
    }
    
    public String getLocationOfAgreement(String labelOfAgreement) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y agreement:hasLabel \""+labelOfAgreement+" \". ?y agreement:hasLocation ?x. }";
    	return k;
    }
    
    public String getDescriptionOfCountry(String labelOfCountry) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y country:hasLabel \""+labelOfCountry+" \". ?y country:hasDescription ?x. }";
    	return k;
    }
    
    public String getDescriptionOfLocation(String labelOfLocation) {
    	String k = String.valueOf(PREFIX);
    	k+="select ?x where { ?y location:hasLabel \""+labelOfLocation+" \". ?y location:hasDescription ?x. }";
    	return k;
    }
    
    public String getLocationOfOrganization(String labelOfOrganization) {
    	String k= String.valueOf(PREFIX);
    	k+="select ?x where { ?y organization:hasLabel \""+labelOfOrganization+" \". ?y organization:hasLocation ?x. }";
    	return k;
    }
    
    //truy van don gian cac quan he, biet thong tin cua Subject, tim Object
   
//meet 
    public String getPersonMeetPerson(String labelOfSub) { //tìm person gặp person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where{ ?s person:hasLable \""+labelOfSub+"\". person:?sperson:meet ?o . ?o person:hasLabel ?z .}";
    	return k;
    } 
//organize
    public String getEventOrganizeByPerson(String labelOfSub) { //tìm organization tổ chức bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:organize ?o . ?o event:hasLabel ?z .}";
    	return k;
    } 
    // câu này tìm tất cả những gì mà người tên "label" tổ chức ra
    
    public String getEventOrganizeByOrganization(String labelOfSub) { // tìm Event tổ chức bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s organization:hasLabel \""+labelOfSub+"\". ?s organization:organize ?o. ?o event:hasLabel ?z . }";
    	return k;
    }
//hasAgreementWith
    public String getCountryHasAgreementWithCountry(String labelOfSub) { //Tìm country được kí hiệp ước với country  
    	String k = String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:hasAgreementWith ?o . ?o country:hasLabel ?z . }";
    	return k;
    }
//participate
    public String getOrganizationParticipateByPerson(String labelOfSub) {//tìm organization được tham gia bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:participate ?o . ?o organization:hasLabel ?z .}";
    	return k;
    }
    
    public String getOrganizationParticipateByOrganization(String labelOfSub) {//tìm organization được tham gia bởi organization
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s organization:hasLabel \""+labelOfSub+"\". ?s organization:participate ?o . ?o organization:hasLabel ?z .}";
    	return k;
    }
    
    public String getEventParticipateByPerson(String labelOfSub) {//tìm event đươc tham gia bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:participate ?o . ?o event:hasLabel ?z .}";
    	return k;
    }
    
    public String getEventParticipateByOrganization(String labelOfSub) {//tìm event đươc tham gia bởi organization
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s organization:hasLabel \""+labelOfSub+"\". ?s organization:participate ?o . ?o event:hasLabel ?z .}";
    	return k;
    }
    
    public String getAgreementParticipateByPerson(String labelOfSub) {//tìm agreement đươc tham gia bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:participate ?o . ?o agreement:hasLabel ?z .}";
    	return k;
    }
    
    public String getAgreementParticipateByOrganization(String labelOfSub) {//tìm agreement đươc tham gia bởi organization
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s organization:hasLabel \""+labelOfSub+"\". ?s organization:participate ?o . ?o agreement:hasLabel ?z .}";
    	return k;
    }
//takePlaceIn
    public String getLocationTakePlaceInByEvent(String labelOfSub) {//tìm location được Event tổ chức tại
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s event:hasLabel \""+labelOfSub+"\". ?s event:takePlaceIn ?o . ?o location:hasLabel ?z }";
    	return k;
    }
    
    public String getCountryTakePlaceInByEvent(String labelOfSub) {//tìm country được Event tổ chức tại
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s event:hasLabel \""+labelOfSub+"\". ?s event:takePlaceIn ?o . ?o country:hasLabel ?z }";
    	return k;
    }
//bolster
    public String getCountryBolsterByPerson(String labelOfSub) {//tìm country được person ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:bolster ?o . ?o country:hasLabel ?z}";
    	return k;
    }
    
    public String getAgreementBolsterByPerson(String labelOfSub) {//tìm agreement được person ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:bolster ?o . ?o agreement:hasLabel ?z}";
    	return k;
    }
    
    public String getEventBolsterByPerson(String labelOfSub) {//tìm event được person ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:bolster ?o . ?o event:hasLabel ?z}";
    	return k;
    }
    
    public String getCountryBolsterByCountry(String labelOfSub) {//tìm country bị country ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:bolster ?o . ?o country:hasLabel ?z}";
    	return k;
    }
    
    public String getAgreementBolsterByCountry(String labelOfSub) {//tìm agreement bị country ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:bolster ?o . ?o agreement:hasLabel ?z}";
    	return k;
    }
    
    public String getEventBolsterByCountry(String labelOfSub) {//tìm event bị country ủng hộ
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:bolster ?o . ?o event:hasLabel ?z}";
    	return k;
    }
    
//oppose
    public String getCountryOpposeByPerson(String labelOfSub) {//tìm country bị phản đối bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:oppose ?o . ?o country:hasLabel ?z}";
    	return k;
    }
    
    public String getAgreementOpposeByPerson(String labelOfSub) {//tìm agreement bị phản đối bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:oppose ?o . ?o agreement:hasLabel ?z}";
    	return k;
    }
    
    public String getEventOpposeByPerson(String labelOfSub) {//tìm event bị phản đối bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:oppose ?o . ?o event:hasLabel ?z}";
    	return k;
    }
    
    public String getCountryOpposeByCountry(String labelOfSub) {//tìm country bị phản đối bởi country
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:oppose ?o . ?o country:hasLabel ?z}";
    	return k;
    }
    
    public String getAgreementOpposeByCountry(String labelOfSub) {///tìm agreement bị phản đối bởi country
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:oppose ?o . ?o agreement:hasLabel ?z}";
    	return k;
    }
    
    public String getEventOpposeByCountry(String labelOfSub) {//tìm event bị phản đối bởi country
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:oppose ?o . ?o event:hasLabel ?z}";
    	return k;
    }
//deliverSpeechAt
    public String getEventDeliverSpeechByPerson(String labelOfSub) {//tìm event được person phát biểu tại
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:deliverSpeechAt ?o . ?o event:hasLabel ?z}";
    	return k;
    }
//hasTensionWith
    public String getCountryHasTensionWithCountry(String labelOfSub) {//tìm country căng thẳng vs country có tên labelOfSub
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:hasTensionWith ?o . ?o country:hasLabel ?z }";
    	return k;
    }
//cancel
    public String getEventCancelByPerson(String labelOfSub) {//tìm event bị hủy bỏ bởi person
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s person:hasLabel \""+labelOfSub+"\". ?s person:cancel ?o . ?o event:hasLabel ?z }";
    	return k;
    }
//negotiateWith
    public String getCountryNegotiateWithCountry(String labelOfSub) {//tìm country đàm phán với country vó tên labelOfSub
    	String k= String.valueOf(PREFIX);
    	k+="select ?o where { ?s country:hasLabel \""+labelOfSub+"\". ?s country:negotiateWith ?o . ?o country:hasLabel ?z}";
    	return k;
    }
}