
/*This is the application main controller ;
This controller contains other sub-controller of the rest classes
like StoryController and the JournalistController.


*/
package appmagazine;


//The main controller extends the Interface cintroller IController 
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
        //Create instance of the rest controller 
        storyController= StoryController.GetInstance(this);
        journistController=JournalistController.GetInstance(this);
    }
    
   
    //This method will return the main view of the main controller
    @Override
    public void Execute()
    {   
        //call the view to display
      this.view.Execute();
      
    }

  
// The method will call the journist controller to  request for new journalist registration
    void xhsRegister() {
        
        //call the journalist controller
         this.journistController.Execute();
       }  
//This will start the Story Controller for the user to be able to add and delete stories
    void xhsCallStroy() {
           if(this.journistController.verify())
           {
            this.storyController.Execute();
           }
           else
           {
               //This is will return error message to the user and ask them to register new account
            this.view.ShowMessage("There is no account with the current email ; please register the account", 0);
            this.view.promptForRegistration();
            
           }
         }

    //This method check if user already exist or not
    boolean xhsIsUserExist(String journistId) {
      
      return this.journistController.IsExist(journistId);
    }
// The method will ask the user to enter its username name  by calling the journist controller
    String xhsAskUsername() {
       return this.journistController.getUsername();
    }
    
}
