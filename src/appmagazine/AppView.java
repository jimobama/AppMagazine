/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import helps.ColorCode;
import helps.Console;
import javax.swing.JFrame;

/**
 *
The main controller view
 */
public class AppView extends IView{
  
    private AppMagazineController controller;
    public AppView(String Title) {
     
       
    }
  
    //This method display the menu on the console
    private char _menu()
    {
        char prompt;
        Console.WriteLn(ColorCode.BLUE+"[*************"+ColorCode.WHITE+" Main Menu "+ColorCode.BLUE+"***************]"+ColorCode.BLACK);
        Console.WriteLn("a). -  Add New Story");
        Console.WriteLn("e). -  Exit Application");
        
        prompt = Console.askChar("Enter option ? ");
       
        return prompt;
    }
    
    @Override
    void Execute() {
       char prompt = this._menu();
       if(prompt  == 'E')
       {
           Console.exit(0);
           System.exit(-1);
       }
      controller.xhsCallStroy();
      Execute();
       
    }

    void attach(IController parent) {
        controller =(AppMagazineController)parent;
    }

    void promptForRegistration() {
        char prompt= Console.askChar("Enter 'a' to create new account or any key to main menu again? ");
        if(prompt=='a' || prompt=='A')
        {
               controller.xhsRegister();    
        }
       else
        {
            controller.Execute();
        }
    }

  
    
}
