/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateTestcase;

import ReadWriteFile.ReaderFromFile;
import generateTestcase.GenerateSubjectRelationObject;

/**
 *
 * @author BQ
 */
public class GenerateTestcase {
    
    public GenerateTestcase() {
        String[] subject = {};
        String[] object = {};
        String[] relation = {};
    
        ReaderFromFile readerFromFile = new ReaderFromFile();
        readerFromFile.ReadRelation(subject, object, relation);
    
        int num = subject.length;
        for(int i = 0; i < num; i ++)
        {
            GenerateSubjectRelationObject generatePersonVisitLocation = new GenerateSubjectRelationObject(subject[i], object[i], relation[i]);
        }
    }   
}   
