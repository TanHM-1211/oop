package main;
import java.util.ArrayList;
import java.util.List;
import generate.data.*;
import model.*;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.mapdb.DB;

import DAO.*;


public class Main {

	public static void main(String args[])
	{
		DBWorker worker = new DBWorker();
//		SimpleQuery sq = new SimpleQuery();
//		String q = sq.getDescriptionOfPerson("An An Bình");
//		System.out.println(q);
//		System.out.println(worker.convertToString(worker.executeQuery(q)));
		
		GenerateObjects genO = new GenerateObjects();
		GenerateRelationship genr = new GenerateRelationship();
		ModelBuilder builder = new ModelBuilder();
		
		ArrayList<Person> ps = genO.generatePerson(builder, 100);
//		genO.generateCountry(builder, 100);
//		ArrayList<Location> locations = genO.generateLocation(builder, 100); 
//		genO.generateOrganization(builder, locations, 100);
//		genO.generateEvent(builder, locations, 100);
//		genO.generateAgreement(builder, locations, 100);
		Model model = builder.build();
		genr.genPerPer(model, ps, ps, 100);
		worker.addModel(model);
	}
}
