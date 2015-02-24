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
  
    private JFrame window;
    public AppView(String Title) {
        window= new JFrame(Title);
        window.setContentPane(this);
    }

    @Override
    void Execute() {
       //view will show now
        this.window.setVisible(true);
    }
    
}
