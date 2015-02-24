/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import java.util.Date;

/**
 *
 * @author Obaro
 */
public class Story {
    
     private String title;
     private String  id;
     private String journistId;
     private String content;
     private Date   _date;
    private String toperson;
     
   public   Story()
     {
         title="";
         id="";
         journistId="";
         content="";
         _date= new Date();
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

    boolean validate() {
        
        return true;
      }
     
     
     
     
}
