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
		SimpleQuery sq = new SimpleQuery();
		
		GenerateData gend = new GenerateData();
		ModelBuilder builder = new ModelBuilder();
		gend.generateObjects(builder, 100000);
		worker.addModel(builder.build());
		
		builder = new ModelBuilder();
		Model model = builder.build();
		gend.generateRelationships(model, 100000);
		worker.addModel(model);
	}
}
