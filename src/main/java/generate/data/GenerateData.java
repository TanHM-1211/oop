package generate.data;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;

import model.Agreement;
import model.Country;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;

public class GenerateData {
	private GenerateObjects geno = new GenerateObjects();
	private GenerateRelationship genr = new GenerateRelationship();
	
	private ArrayList<Person> people;
	private ArrayList<Event> events;
	private ArrayList<Organization> organizations;
	private ArrayList<Agreement> agreements;
	private ArrayList<Location> locations;
	private ArrayList<Country> countries;
	private List<String> rela;
	
	public GenerateData() {
		
	}
	
	public void generateObjects(ModelBuilder builder, int num)
	{	
		int numloc = Math.min(num/20, 1086);
		int numcty = Math.min(num/20, 1900);
		this.locations = geno.generateLocation(builder, numloc);
		this.countries = geno.generateCountry(builder, numcty);
		
		int numagr = Math.min(num/6, numloc*9);
		this.agreements = geno.generateAgreement(builder, this.locations, numagr);
		int numevt = Math.min(num/6, numloc*1000);
		this.events = geno.generateEvent(builder, this.locations, numevt);
		int numorg = Math.min(num/6, numloc*200);
		this.organizations = geno.generateOrganization(builder, locations, numorg);
		
		num -= (numloc + numcty + numagr + numevt + numorg);
		this.people = geno.generatePerson(builder, num);
	}
	
	public void generateRelationships(Model model, int num)
	{
		genr.genPerPer(model, people, people, num/7);
		genr.genPerCty(model, people, countries, num/7);
		genr.genPerCty1(model, people, countries, num/7);
		genr.genPerArg(model, people, agreements, num/7);
		genr.genPerOrg(model, people, organizations, num/7);
		genr.genPerEvent(model, people, events, num/7);
		genr.genCtyCty(model, countries, countries, num/7);
	}
	
	
}
