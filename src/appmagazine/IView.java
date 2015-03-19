/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

//External libraries that we used during year one 
import helps.ColorCode;
import helps.Console;



/**
 *
 * @author Obaro
 */
abstract class IView extends Console{

    void attach(IController observer) {
        
    }

   abstract void Execute();
   
    void ShowMessage(String msg, int i) {
       
        switch(i)
        {
            case 0:
                Console.WriteLn(ColorCode.RED+msg+ColorCode.BLACK);
                break;
            default:
                 Console.WriteLn(ColorCode.BLACK+msg+ColorCode.BLACK);
                break;
        }
    }

    
}
