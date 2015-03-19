/*
The controller to the story model and view that provided interface methods to manipulate the stories in the data file
 */
package appmagazine;

import java.util.ArrayList;

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
        this.view.attach(this);
        this.model.attach(this);
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
                this.view.reset();
                this.controller.xhsRegister();
               
              }
         }
    }
  
        @Override
    public void Execute()     
    {
        this.view.Execute();
    }

    void xhsCallMenu() {
   
      this.controller.Execute();
     }

    void xhsAddStory(Story story) {
      
        if(this.controller.xhsIsUserExist(story.getJournistId()))
        {
         if(story.validate())
         {
            StoryModel  amodel=(StoryModel) (this.model);
             if(amodel.IsStoryExist(story))
             {
                 this.view.ShowMessage("The story Title already exist if you don't mind  or you can reflame it", 0);
                 amodel.SaveStory(story);
                 this.xhsDisplayStoryTable();
                 
             }
            else
             {
                amodel.SaveStory(story); 
                this.view.ShowMessage("The story is been successfully added ",1);
             }
         }
        }
      else
        {
            this.controller.xhsRegister();
        }
    }

    void xhsDisplayStoryTable() {
        StoryModel amodel = (StoryModel)model;
        ArrayList<Story> stories = null;
        String email = controller.xhsAskUsername();
        stories = amodel.getAllStories(email);
        this.view.displayStories(stories);
       
        
    }
    
}
