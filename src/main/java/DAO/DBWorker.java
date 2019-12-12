package DAO;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private static final String GRAPHDB_SERVER = "http://localhost:7200/";
    private static final String REPOSITORY_ID = "oop_project";
    private static final String PREFIX = "http://oop/";
    private static final String PROPERTY_PREFIX = "<http://oop/properties/>";
    private static final String RELATIONSHIP_PREFIX = "<http://oop/relationships/>";
    private RepositoryConnection connection; 
    private Repository repository;
    
    public DBWorker()
    {
    	this.repository = new HTTPRepository(
    		      GRAPHDB_SERVER, REPOSITORY_ID);
    	repository.initialize();
    	this.connection = repository.getConnection();
    }
	
//	public String makeInsertRelationshipQuery(ArrayList<String> S, ArrayList<String>  P, ArrayList<String>  O) {
//		StringBuilder res = new StringBuilder("PREFIX :<" + PREFIX + ">" + "insert data {");
//		for (int i = 0; i<S.size(); ++i)
//		{
//			res.append(S.get(i));
//			res.append(" ");
//			res.append(P.get(i));
//			res.append(" ");
//			res.append(O.get(i));
//			res.append(".\n");
//		}
//		res.append("}");
//		return res.toString();
//	}
    
    public void addModel(Model model)
    {
    	this.connection.add(model);
    	
    }
    
    public void writeToFile(Model model, File file)
    {
    	try {
	    	FileOutputStream out = new FileOutputStream(file);
	    	Rio.write(model, out, RDFFormat.TURTLE);
    	} catch (Exception ex)
    	{
    		System.out.println(ex.getStackTrace().toString());
    	}
    }
    
    public Model readFromFile(File file)
    {
    	Model model = null;
    	try {
    		FileInputStream in = new FileInputStream(file);
    		model = Rio.parse(in, "", RDFFormat.TURTLE);
    		
    	} catch (Exception ex)
    	{
    		System.out.println(ex.getStackTrace().toString());
    	}
    	return model;
    }
	
//	public String makeSimpleSelectQuery(String S, String O, String P, 
//								String typeS, String typeO, boolean mask[]) {
//		String k = "";
//		if(mask[0]==true && mask[1]==false && mask[2]==false) {
//			k= "select * where{ "+S+" ?y ?z.}";
//			
//		}else if(mask[0]==true && mask[1]==true && mask[2]==false) {
//			k= "select * where{ "+S+" "+P+" ?z. }";
//			
//		}else if(mask[0]==false && mask[1]==true && mask[2]==false) {
//			k= "select * where{ ?x "+P+" ?z. }";
//			
//		}else if(mask[0]==true && mask[1]==false && mask[2]==true) {
//			k= "select * where{ "+S+" ?y"+O+".}";
//			
//		}else if(mask[0]==false && mask[1]==true && mask[2]==true) {
//			k= "select * where{ ?x "+P+" " + O+". }";
//			
//		}else if(mask[0]==false && mask[1]==false && mask[2]==true) {
//			k= "select * where{ ?x ?y"+O+".}";
//			
//		}else if(mask[0]==false && mask[1]==false && mask[2]==false) {
//			k= "select * where{?x ?y ?z}";
//			
//		}
//		return k;
//	}
	
	public  TupleQueryResult executeQuery(String query) {
		TupleQueryResult res = null;
		this.connection.begin();

			TupleQuery tupleQuery = this.connection
				      .prepareTupleQuery(QueryLanguage.SPARQL, query);
		    try {
		      res = tupleQuery.evaluate();
		      while (res.hasNext()) {
		          BindingSet bindingSet = res.next();

		          String name = bindingSet.getValue("x").stringValue();
		          System.out.println(name);
		      }
		    }catch (QueryEvaluationException qee) {  
		    	System.out.println(qee.getStackTrace().toString());
	        } finally {
	          res.close();
	        }    
		    this.connection.close();
		return res;
	}
	
	public String convertToString(TupleQueryResult tqr)
	{
		String res = "";
		BindingSet bindingSet;
		while (tqr.hasNext()) {
	          bindingSet = tqr.next();
	          for (String s: bindingSet.getBindingNames())
	          {
	        	  res += s + " " + bindingSet.getValue(s) + "\n";
	          }
	      }
		return res;
	}
	
}