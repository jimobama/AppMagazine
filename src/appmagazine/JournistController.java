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
class JournistController extends IController{
 static JournistController instance=null;
    static JournistController GetInstance(AppMagazineController aThis) {
       if(instance ==null)
           instance= new JournistController(aThis);
       return instance;
    }
  private AppMagazineController controller;
  private JournistView view;
    
    JournistController(IController parent)
    {
        controller=(AppMagazineController)parent;
        view= new JournistView("New Account");
    }
    @Override
    public void Execute() {
       
        this.view.setVisible(true);
    }
    
    private void SubmitForm()
    {
        Journist journist= this.view.GetJournist();
        if(journist.validate())
        {
          ModelJournist  aModel =( ModelJournist)model;
          if(aModel.IsExist(journist.getEmail()))
          {
              this.view.ShowMessage("This email provided has been already registered",0);              
          }
          else
          {
              aModel.SaveJournist(journist);
              this.view.ShowMessage("Your information has be successfully recorded");
              
              if(this.controller.xhsCallFromStory)
              {
                  this.view.dispose();
                  this.controller.xhsCallFromStory=false;
                  this.controller.xhsCallStroy();
                  
              }
          }
        }
    }
    
}
