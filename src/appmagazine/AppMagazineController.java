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
public class AppMagazineController extends IController{

    public AppMagazineController(AppModel aModel,AppView aView)
    {
        //set the view  and model of the controller 
        this.view = aView;
        this.model=aModel;
        this.view.attach(this);
        this.model.attach(this);
    }
    
    
    @Override
    public void Execute()
    {
        System.out.println("Main View will launch");
    }
    
}
