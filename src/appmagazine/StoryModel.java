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
 *  The class is the story model that will added journalist story and edit the story and store the stories to an xml files
 */
class StoryModel extends IModel{
    
     ArrayList<Story> stories;
     StoryController controller;
      private Database db;
    StoryModel()
    {
      
        db= new Database("tbl_story.txt");
        this.stories= (ArrayList<Story>)this.db.GetObject();
        if(this.stories ==null)
        {
              stories = new ArrayList<Story>();
        }
    }

    @Override
    void attach(IController observer) {
     this.controller = ( StoryController)observer;
    }

    boolean IsStoryExist(Story story) {
       
     Iterator<Story>  iter=   this.stories.iterator();
     
      while(iter.hasNext())
      {
          Story temStory=  iter.next();
          if(temStory.equals(story))
          {
              return true;
          }
      }
      
      return false;
    }

    void SaveStory(Story story) {
       
         if(!this.IsStoryExist(story))
         {
             this.stories.add(story);
             this.db.SaveObject(stories);
            this.stories = (ArrayList<Story>)this.db.GetObject(); 
         }
    }

  ArrayList<Story> getAllStories(String email) {
       ArrayList <Story> temArry;
        temArry =  this.loadAllStories(email);
       return temArry;
    }

    private ArrayList<Story> loadAllStories(String email) {
       ArrayList<Story>  tem= new ArrayList<Story>();
       
       Iterator<Story> iter= this.stories.iterator();
       
       while(iter.hasNext())
       {
           Story story = iter.next();
           
           if(story.getJournistId().equalsIgnoreCase(email.trim()))
           {
               tem.add(story);
           }
       }
        
        
       return tem;
    }
}
