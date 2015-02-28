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
    
    StoryModel()
    {
        stories = new ArrayList<>();
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
         }
    }

  ArrayList<Story> getAllStories(String email) {
       ArrayList <Story> temArry;
      temArry =  this.loadAllStories(email);
       return temArry;
    }

    private ArrayList<Story> loadAllStories(String email) {
       return this.stories;
    }
}
