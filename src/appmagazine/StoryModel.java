/*
The Model to the Story controller that handle data manipulation like saving to data file, delete story and retriving stories from data file
The model check if a story exists or not and report error to the controller that is later will be passsed to the Story view.
 */
package appmagazine;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *  The class is the story model that will added journalist story and edit the story and store the stories to an xml files
 */
public class StoryModel extends IModel{
    
     ArrayList<Story> stories;
     StoryController controller;
      private Database db;
 public   StoryModel()
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

    //test this method
  public  boolean IsStoryExist(Story story) {
       
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

 public   void SaveStory(Story story) {
       
         if(!this.IsStoryExist(story))
         {
             this.stories.add(story);
             this.db.SaveObject(stories);
            this.stories = (ArrayList<Story>)this.db.GetObject(); 
         }
    }

  public ArrayList<Story> getAllStories(String email) {
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
