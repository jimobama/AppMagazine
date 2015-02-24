/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

/**
 *
 * @author Obaro
 */
class StoryController extends IController {

    MainStoryView view ;
    AppMagazineController controller;
    StoryController (IController parent)
    {
        view = new MainStoryView();
        controller= (AppMagazineController)(parent);
        this.model = new  StoryModel();
    }
    
    private void saveStory()
    {
        Story story = view.GetStory();
         if(story.validate())
         {
              ModelJournist journist= new  ModelJournist();
              if(journist.IsExist(story.Journist()))
              {                  
                StoryModel  amodel= ( StoryModel )this.model;

                if(amodel.IsStoryExist(story))
                {
                    this.view.ShowMessage("This story already exist",0);
                }else
                {
                    amodel.SaveStory(story);
                    this.view.ShowMessage("Your Story as be successfully added we woll contact you soon",1);
                }
              }else
              {
                this.view.setVisible(false);
                this.controller.xhsRegister();
               
              }
         }
    }
  
    public void Execute()     
    {
    }
    
}
