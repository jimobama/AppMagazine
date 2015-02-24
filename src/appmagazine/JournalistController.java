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
    }
    @Override
    public void Execute() {
       
        this.view.setVisible(true);
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
