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
abstract class IView extends Console{

    void attach(IController observer) {
        
    }

   abstract void Execute();
    
}
