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
abstract class  IController {
    protected IView view;
    protected IModel model;   
   public abstract void Execute();
}
