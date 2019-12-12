package DAO;

import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import java.io.IOException;
import java.util.ArrayList;

public class RepositoryManager {
    private static final String GRAPHDB_SERVER = "http://localhost:7200/";
    private static final String REPOSITORY_ID = "oop_project";
    private static final String PREFIX = "http://oop/";
    private static final String PROPERTY_PREFIX = "<http://oop/properties/>";
    private RepositoryConnection connection; 
    private Repository repository;
    
    public void RepositoryManager()
    {
    	repository = new HTTPRepository(
    		      GRAPHDB_SERVER, REPOSITORY_ID);
    	repository.initialize();
    	connection = repository.getConnection();
    }
	
	public String makeSimpleInsertQuery(ArrayList<String> S, ArrayList<String>  P, ArrayList<String>  O) {
		StringBuilder res = new StringBuilder("PREFIX :<" + PREFIX + ">" + "insert data {");
		for (int i = 0; i<S.size(); ++i)
		{
			res.append(S.get(i));
			res.append(" ");
			res.append(P.get(i));
			res.append(" ");
			res.append(O.get(i));
			res.append(".\n");
		}
		res.append("}");
		return res.toString();
	}
	
	public String makeSimpleSelectQuery(String S, String O, String P, 
								String typeS, String typeO, boolean mask[]) {
		String k = "";
		if(mask[0]==true && mask[1]==false && mask[2]==false) {
			k= "select * where{ "+S+" ?y ?z.}";
			
		}else if(mask[0]==true && mask[1]==true && mask[2]==false) {
			k= "select * where{ "+S+" "+P+" ?z. }";
			
		}else if(mask[0]==false && mask[1]==true && mask[2]==false) {
			k= "select * where{ ?x "+P+" ?z. }";
			
		}else if(mask[0]==true && mask[1]==false && mask[2]==true) {
			k= "select * where{ "+S+" ?y"+O+".}";
			
		}else if(mask[0]==false && mask[1]==true && mask[2]==true) {
			k= "select * where{ ?x "+P+" " + O+". }";
			
		}else if(mask[0]==false && mask[1]==false && mask[2]==true) {
			k= "select * where{ ?x ?y"+O+".}";
			
		}else if(mask[0]==false && mask[1]==false && mask[2]==false) {
			k= "select * where{?x ?y ?z}";
			
		}
		return k;
	}
	public  TupleQueryResult executeQuery(String query , String type) {
		TupleQueryResult res = null;
		connection.begin();
		if (type == "insert")
		{
			Update updateOperation = this.connection.prepareUpdate(QueryLanguage.SPARQL, query);
			updateOperation.execute();
			try {
				this.connection.commit();
		    } catch (Exception e) {
		    	if (this.connection.isActive())
		    	  this.connection.rollback();
		    	System.out.println("Can not insert!");
		    }
		}
		else
		{
			TupleQuery tupleQuery = this.connection
				      .prepareTupleQuery(QueryLanguage.SPARQL, query);
		    try {
		      res = tupleQuery.evaluate();
		    }catch (QueryEvaluationException qee) {  
		    	System.out.println(qee.getStackTrace().toString());
	        } finally {
	          res.close();
	        }    
		}
		connection.close();
		return res;
	}
	
}