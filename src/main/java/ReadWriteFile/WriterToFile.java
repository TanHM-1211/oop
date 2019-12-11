/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWriteFile;
import initializer.Subject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author BQ
 */
public class WriterToFile {
    public WriterToFile(){
        
    }

    public void Write(String subjectLabel, String objectLabel, String subject, String object, String relation) {
        try {
            File f = new File("data/" + subject + relation + object);
            FileWriter fw = new FileWriter(f);
            
            fw.write(subjectLabel + " " + relation + " " + objectLabel);
            
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
}