package DAO;

import java.util.ArrayList;

public class MultiConditionQuery {
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
	public ArrayList<String> AdvanceQuery(){
		ArrayList<String> listAdvanceQuery = new ArrayList<String>();
		//Đưa ra các sự kiện diễn ra tại Nguyễn Đình Chiểu vào 2008 hoặc 2010 tổ chức bởi vinamilk
			String Query1 = "PREFIX "+
					"SELECT ?s WHERE{\n" + 
						"?s event:hasLabel \"Nguyễn Đình Chiểu\". \n"+
						"?x organization:organize ?s. \n"+
						"?x organization:hasLabel \"Vinamilk\". \n"+
						"?s event:hasDate ?t. \n"+
						"FILTER (year(?t)=2008 || year(?t)=2010) \n" +  
					"}\n" + 
					"ORDER BY ?s";
		//Đưa ra các quốc gia được ủng hộ bởi người có tên là Bảo Bình
			String Query2= "PREFIX"+
					"SELECT ?o WHERE{/n"+
						"?s country:hasLabel ?o. \n"+
						"?p person:bolster ?s. \n"+
						"?s person:hasLabel \"Bảo Bình\". \n"+
					"}\n";
		//Đưa ra người lớn tuổi nhất phát biểu tại Event "hội Lim" vào năm 2016
			String Query3 = "PREFIX"+
					"SELECT ?o WHERE{ \n"+
						"?s person:hasLabel ?o.\n "+
						"?s person:deliverSpeechAt ?e.\n"+
						"?e event:hasLabel \"hội Lim\". \n"+
						"?e event:hasDate ?n. \n"+
						"FILTER (year(?n)=2016)} \n";
		//tìm những người trong tên có chữ "Đường" tham gia kí kết hiệp ước "Brexit"
			String Query4 = "PREFIX"+
					"SELECT ?o WHERE{ \n"+
						"?s person:hasLabel ?o. \n"+
						"?s person:participate ? ?a.\n"+
						"?a agreement:hasLabel \"Brexit\".\n"+
						"FILETER (regex(?o,\"Đường\"))}";
			listAdvanceQuery.add(Query1);
			listAdvanceQuery.add(Query2);
			listAdvanceQuery.add(Query3);
			listAdvanceQuery.add(Query4);
			return listAdvanceQuery;
	}
	
}
