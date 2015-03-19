/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import helps.ColorCode;
import helps.Console;

/**
 *
 * @author Obaro
 */
class JournalistView extends IView{

    private   Journalist j;
    private final String  Title;
    
    JournalistController controller;
    JournalistView(String title) {
      j= new Journalist ();
      Title=title;
    }

    @Override
    void Execute() {
       this._start();
    }

   
    Journalist GetJournist() {
      return this.j;
    }

    private void _start() {
        Console.WriteLn(ColorCode.BLUE+"---------"+Title+"-----------"+ColorCode.BLACK);      
          
        this.j.setEmail(Console.askString("Enter your email address ? "));
        this.j.setFirstname(Console.askString("Enter your firstname ?"));
        this.j.setLastname(Console.askString("Enter your lastname ?"));
        this.j.setAddress(Console.askString("Enter your current address ?"));
        this.j.setPhonenumber(Console.askString("Enter your mobile number ? "));
        
        this.j= this.validated();
        
    }
    //Attach the observer to the subject
    @Override
    public void attach(IController observer) {
       controller= (JournalistController)observer;
    }

    private Journalist validated() {
        
        Console.WriteLn("Do you want to continue the registration [y/n]? ");
        char c= Console.askChar("Enter choice : ");
         if(c =='Y' || c == 'y')
         {       
            if(!this.j.validate())
            {
                this.ShowMessage(ColorCode.RED+j.Error+ColorCode.BLACK,0);
              switch(this.j.CODE)    
              {
                  case Journalist.EMAIL:
                  {
                   this.j.setEmail(Console.askString("Enter your email address again ? "));
                   break;
                  }
                  case Journalist.ADDRESS:
                  {
                      this.j.setAddress(Console.askString("Enter your current address again ?"));
                      break;
                  }
                  case Journalist.FIRSTNAME:
                  {
                    this.j.setFirstname(Console.askString("Enter your firstname again ?"));
                    break;
                  }
                  case Journalist.LASTNAME:
                  {
                      this.j.setLastname(Console.askString("Enter your lastname again ?"));
                      break;
                  }
                  case Journalist.PHONENUMBER:
                  {
                      this.j.setPhonenumber(Console.askString("Enter your mobile number again ? "));  
                  }
                  default:
                      break;
              }
              
              this.j=  validated();
            }
         }
        return this.j;
    }
    
    //As the user to enter to 
    String askUserName() {
      
        String email= Console.askString(ColorCode.WHITE+"Enter your email address ? "+ColorCode.BLACK);
        return email;
    }
}
