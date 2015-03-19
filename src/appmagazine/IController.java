/*

This is the observer object that must be implemented by every controller to be able to observer the operations inside 
its subjects
 */
package appmagazine;

abstract class  IController {
  
    protected IModel model;   
   public abstract void Execute();
}
