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
    @Override
    public void Execute() {
       this.view.Execute();
       this.SubmitForm();
    }
    
    private void SubmitForm()
    {
        Journalist journist= this.view.GetJournist();
        if(journist.validate())
        {
          ModelJournalist  aModel =( ModelJournalist)model;
          if(aModel.IsExist(journist.getEmail()))
          {
              this.view.ShowMessage("This email provided has been already registered",0);              
          }
          else
          {
              aModel.SaveJournist(journist);
              this.view.ShowMessage("Your information has be successfully recorded",1);
              this.controller.xhsCallStroy();                
             
          }
        }
    }

    boolean IsExist(String journistId) {
      
         ModelJournalist amodel= ( ModelJournalist)model;
         if(amodel.IsExist(journistId))
         {
             return true;
         }
         return false;
    }

    boolean verify() {
        
      String email= this.view.askUserName();
      return IsExist(email);
    }

    String getUsername() {
       return this.view.askUserName();
    }
    
}
