/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

/**
 *
The Main App model
 */
public class AppModel extends IModel {
private AppMagazineController controller;
    public AppModel() {
    }

    @Override
    void attach(IController observer) {
        this.controller=(AppMagazineController)observer;
    }
    
}
