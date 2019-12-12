package main;
import java.util.List;
import generate.data.GenerateObjects;

import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.mapdb.DB;

import DAO.*;


public class Main {

	public static void main(String args[])
	{
		SimpleQuery sq = new SimpleQuery();
		String q = sq.getDescriptionOfPerson("a");
		System.out.println(q);
		DBWorker worker = new DBWorker();
		System.out.println(worker.convertToString(worker.executeQuery(q)));
		GenerateObjects genO = new GenerateObjects();
		ModelBuilder builder = new ModelBuilder();
		genO.generatePerson(builder, 100000);
		worker.addModel(builder.build());
	}
}
