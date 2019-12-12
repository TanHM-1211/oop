/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWriteFile;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Object;
import model.Subject;

/**
 *
 * @author BQ
 */
public class ReaderFromFile {

    public ReaderFromFile(){
    }

    public void ReadSubject(Subject[] subjects, String subject) {
        try{
            File f;
            f = new File("data/" + subject + ".txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br;
            br = new BufferedReader(fr);
        
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                subjects[++count] = new Subject(line);
            }
        
            fr.close();
            br.close();
        } catch (IOException ex1) {
            System.out.println("Loi doc file: "+ex1);
        }
        return;
    }

    public void ReadObject(Object[] objects, String object) {
        try {
            File f = new File("data/" + object + ".txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br;
            br = new BufferedReader(fr);
        
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                objects[count ++] = new Object(line);
            }
        
            fr.close();
            br.close();
        } catch (IOException ex2) {
            System.out.println("Loi doc file: " + ex2);
        }
        return;
    }
    
    public void Read(Subject[] subjects, Object[] objects, String subject, String object) {
        ReaderFromFile f = new ReaderFromFile();
        f.ReadSubject(subjects, subject);
        f.ReadObject(objects, object);
        return;
    }
    
    public void ReadRelation(String[] subject, String[] object, String[] relation) {
        try {
            File f = new File("data/Relation.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br;
            br = new BufferedReader(fr);
        
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                int i = 0;
                while(i < line.length() && line.charAt(i) != ' ') {
                    i ++;
                    subject[count] = subject[count] + line.charAt(i);
                }
                i ++;
                
                while(i < line.length() && line.charAt(i) != ' ') {
                    i ++;
                    object[count] = object[count] + line.charAt(i);
                }
                i ++;
                
                while(i < line.length() && line.charAt(i) != ' ') {
                    i ++;
                    relation[count] = relation[count] + line.charAt(i);
                }
                i ++;
            }
        
            fr.close();
            br.close();
        } catch (IOException ex2) {
            System.out.println("Loi doc file: " + ex2);
        }
    }
}
