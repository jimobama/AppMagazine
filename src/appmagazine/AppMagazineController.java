
/*This is the application main controller ;
This controller contains other sub-controller of the rest classes
like StoryController and the JournalistController.


*/
package appmagazine;


public class AppMagazineController extends IController{

    private StoryController storyController ;
    private JournalistController journistController;
    private AppView view;
    boolean xhsCallFromStory;
    
    //The parameterised controller
    public AppMagazineController(AppModel aModel,AppView aview)
    {
        //set the view  and model of the controller 
        this.view = aview;
        this.model=aModel;
        // The view attach its observer 
        this.view.attach(this);
        //The method attached its observer
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
            this.view.ShowMessage("There is no account with the current email ; please register the account", 0);
            this.view.promptForRegistration();
            
           }
         }

    boolean xhsIsUserExist(String journistId) {
      
      return this.journistController.IsExist(journistId);
    }

    String xhsAskUsername() {
       return this.journistController.getUsername();
    }
    
}
