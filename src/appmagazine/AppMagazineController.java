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
public class AppMagazineController extends IController{

    private StoryController storyController ;
    private JournistController journistController;
    private AppView view;
    boolean xhsCallFromStory;
    public AppMagazineController(AppModel aModel)
    {
        //set the view  and model of the controller 
        this.view = new AppView("Application");
        this.model=aModel;
        this.view.attach(this);
        this.model.attach(this);
        storyController= StoryController.GetInstance(this);
        journistController=JournistController.GetInstance(this);
    }
    
    
    @Override
    public void Execute()
    {
         if(this.Allow())
         {
             this.view.Execute();
         }
    }

    private boolean Allow() {
      return true;
    }

    void xhsRegister() {
        
         this.journistController.Execute();
       }

    void xhsCallStroy() {
           this.storyController.Execute();
         }
    
}
