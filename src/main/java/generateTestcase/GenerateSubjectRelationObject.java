/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateTestcase;

import ReadWriteFile.ReaderFromFile;
import ReadWriteFile.WriterToFile;
import model.Subject;

import java.util.Objects;
import java.io.FileWriter;
/**
 *
 * @author BQ
 */
public class GenerateSubjectRelationObject {
    private Subject[] subjects;
    private Object[] objects;
    
    public GenerateSubjectRelationObject(String subject, String object, String relation) {
        ReaderFromFile readerFromFile = new ReaderFromFile();
        readerFromFile.Read(subjects, (model.SimpleObject[]) objects, subject, object);
        
        int numSubjects = subjects.length;
        int numObjects = objects.length;
        
        for(int i = 0; i < numSubjects; i++)
        for(int j = 0; j < numObjects; j++) {
            WritertoFile writerToFile =  new WritertoFile();
            writerToFile.Write(subjects[i], objects[j], subject, object, relation);
        }
    }
}
