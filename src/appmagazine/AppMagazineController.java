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
    private JournalistController journistController;
    private AppView view;
    boolean xhsCallFromStory;
    public AppMagazineController(AppModel aModel,AppView aview)
    {
        //set the view  and model of the controller 
        this.view = aview;
        this.model=aModel;
        this.view.attach(this);
        this.model.attach(this);
        storyController= StoryController.GetInstance(this);
        journistController=JournalistController.GetInstance(this);
    }
    
   
    @Override
    public void Execute()
    {
         
      this.view.Execute();
      
    }

  

    void xhsRegister() {
        
         this.journistController.Execute();
       }  

    void xhsCallStroy() {
           if(this.journistController.verify())
           {
            this.storyController.Execute();
           }
           else
           {
            xhsRegister();       
           }
         }

    boolean xhsIsUserExist(String journistId) {
      
      return this.journistController.IsExist(journistId);
    }

    String xhsAskUsername() {
       return this.journistController.getUsername();
    }
    
}
