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
        static StoryController instance=null;   
    static StoryController GetInstance(AppMagazineController aThis) {
       
        if(instance==null)
        {
            instance= new StoryController(aThis);
        }
        return instance;
    }

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
              ModelJournalist journist= new  ModelJournalist();
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
