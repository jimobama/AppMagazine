/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import helps.Validator;
import java.util.Date;

import java.io.Serializable;

/**
 *
 * @author Obaro
 */
public class Story implements java.io.Serializable {
    static int CODE;
     public static final int   EMAIL=0;
     public static final int TITLE=1;
     public static final int PERSONTO=2;
     public static final int CONTENT=3;
    
     private String title;

     
  
    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getJournistId() {
        return journistId;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return _date;
    }

    public String getToperson() {
        return toperson;
    }
     private String  id;
     private String journistId;
     private String content;
     private Date   _date;
     private String toperson;
     public  String Error;
     
   public   Story()
     {      
         title="";
         id="";
         journistId="";
         content="";
         _date= new Date();
         Error="";
        this.id=String.valueOf(Validator.uniqueNumber());
     }
     
     void set(String atitle, String aid, String ajournistId,String acontent)
     {
         title=atitle;
         id=aid;
         journistId=ajournistId;
         content=acontent;
        _date= new Date();
     }
     
     String Journist()
     {
         return this.journistId;
     }

    public void SetTitle(String title) {
        this.title=title;
      }

    public void SetEmail(String email) {
        this.journistId=email;
        }

    public void SeTToPerson(String toPerson) {
         this.toperson = toPerson;
        }

    public void SetContext(String content) {
        this.content=content;
     }
  public boolean equals(Story obj) {
        return ((this.id == obj.id) || (this.title.equalsIgnoreCase(obj.title)));
    }
    boolean validate() {
         boolean okay=false;
         
         if(!Validator.isMatch("^[a-zA-Z_]+[a-zA-Z0-9\\.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,4}$", this.journistId.trim()))
         {
             Error="Enter a valid journist's email address";
             CODE =EMAIL;
         }
         else if(!Validator.isMatch("[a-zA-Z0-9\\.\\-_ ]+$", title.trim()))
         {
              Error="Enter a valid story title !!!";
              CODE =TITLE;
         }
         else if ("".equals(content.trim()))
         {
             Error="Invalid story context or filename to download the story context from!";
             CODE =CONTENT;
         }
        else
         {
             okay=true;
         }
        
        return okay;
      }
     
     
     
     
}
