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
public class AppView extends JFrame{
  
    
    public AppView(String Title) {
     
        setTitle(Title);
        setSize(400,400);
    }

    
    void Execute() {
       //view will show now
        setVisible(true);
    }

    void attach(AppMagazineController aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
