/*
The controller : is designed to observer more than one subjects that will be able to called its observer methods 
 */
package appmagazine;

abstract class  IController {
  
    protected IModel model;   
   public abstract void Execute();
}
