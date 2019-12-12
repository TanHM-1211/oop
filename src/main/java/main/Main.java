package main;
import java.util.List;

import org.mapdb.DB;

import DAO.*;


public class Main {
	public static void main(String args[])
	{
		SimpleQuery sq = new SimpleQuery();
		String q = sq.getDescriptionOfPerson("a");
		System.out.println(q);
		DBWorker worker = new DBWorker();
		worker.convert(worker.executeQuery(q));
	}
}
