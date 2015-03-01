/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import javax.swing.JFrame;

/**
 *
 * @author Obaro
 */
public class AppView extends IView{
  
    private AppMagazineController controller;
    public AppView(String Title) {
     
       
    }
  
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

  
    
}
