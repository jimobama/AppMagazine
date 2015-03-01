/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Obaro
 */
class Database {

    private String filename;
    private  boolean _save;
    Database(String FileName) {
       filename=FileName;
    }
    
    boolean IsSave()
    {
       
        return _save;
    }
    void SaveObject(Object journalists) {
       _save=false;
        File file = new File(this.filename);
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      try {
                FileOutputStream fop = new FileOutputStream(file);
            try {
                ObjectOutputStream out = new ObjectOutputStream(fop);
                 out.writeObject(journalists);
                 out.close();               
                 fop.close();
                 _save=true;
                } catch (IOException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
             
              
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       
    }
    
    
    Object  GetObject()
    {
        File file = new File(this.filename);
        Object objectStream=null;
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         try {
                FileInputStream fop = new FileInputStream(file);
            try {
                 ObjectInputStream in = new ObjectInputStream(fop);
                 objectStream  =(Object)  in.readObject();
                 in.close();               
                 fop.close();
              
                } catch (IOException ex) {
                    //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
             
              
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        return objectStream;
    }
    
}
