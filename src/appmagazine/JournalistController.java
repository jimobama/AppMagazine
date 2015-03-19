/*
This is the Journalist class controller that enable one to add , remove and delete journalist details from db
 */
package appmagazine;

/**
 *
 * @author Obaro
 */
class JournalistController extends IController{
 static JournalistController instance=null;
    static JournalistController GetInstance(AppMagazineController aThis) {
       if(instance ==null)
           instance= new JournalistController(aThis);
       return instance;
    }
  private AppMagazineController controller;
  private JournalistView view;
    
    JournalistController(IController parent)
    {
        controller=(AppMagazineController)parent;
        view= new JournalistView("New Account");
        this.model= new ModelJournalist();
        view.attach(this);
        this.model.attach(this);
    }
    //Inherit class from the Icontroller to show the view
    @Override
    public void Execute() {
       this.view.Execute();
       this.SubmitForm();
    }
    
    //This submit the form to the database 
    private void SubmitForm()
    {
        //Get the journist information from the controller's view 
        Journalist journist= this.view.GetJournist();
        if(journist.validate())
        {
            //type cast the model back to the Journalist model
          ModelJournalist  aModel =( ModelJournalist)model;
          //Check if the email of the journalist already exists
          if(aModel.IsExist(journist.getEmail()))
          {
              this.view.ShowMessage("This email provided has been already registered",0);              
          }
          else
          {
              //Save it to the file
              aModel.SaveJournist(journist);
              //Show the message to the users
              this.view.ShowMessage("Your information has be successfully recorded",1);
              this.controller.xhsCallStroy();                
             
          }
        }
    }

    //This check if the journalist email exist
    boolean IsExist(String journistId) {
      
         ModelJournalist amodel= ( ModelJournalist)model;
         if(amodel.IsExist(journistId))
         {
             return true;
         }
         return false;
    }

    // The method verifiy the user journalis information by asking the view to input its email address
    boolean verify() {
        
      String email= this.view.askUserName();
      return IsExist(email);
    }

    String getUsername() {
       return this.view.askUserName();
    }
    
}
