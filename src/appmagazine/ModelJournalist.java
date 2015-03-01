/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Obaro
 */
class ModelJournalist extends IModel {
    
   private  ArrayList<Journalist> journalists;
   private  JournalistController controller;
   private String FileName="tbl_journist.txt";
   private Database db;
     ModelJournalist()
     {
        
         db   = new  Database(this.FileName);
         
         this.journalists = (ArrayList<Journalist>)db.GetObject();
         if( this.journalists==null)
               journalists=new ArrayList<>();
       
     }

    boolean IsExist(String email) {
       
        Iterator<Journalist> iter = this.journalists.iterator();
        
        while(iter.hasNext())
        {
            Journalist journalist= iter.next();
            if(journalist.getEmail().equalsIgnoreCase(email))
            {
                return true;
            }
        }
        
        return false;
        
    }

    @Override
    void attach(IController observer) {
      this.controller= (JournalistController)observer;
    }

    void SaveJournist(Journalist journist) {
        
        if(journist ==null)
            return ;
        
        if(journist.validate())
        {
            this.journalists.add(journist);
            this.db.SaveObject(this.journalists);
            this.journalists =(ArrayList<Journalist>)this.db.GetObject();
            
            
        }
        
    }

   
}
