/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import appmagazine.AppMagazineController;
import appmagazine.AppModel;


public class AppMagazine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AppMagazineController  controller= new AppMagazineController(new AppModel());
        controller.Execute();
    }
    
}
