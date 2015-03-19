/*
 A model is designed to be the observer subject and the Icontroller the observer object

A Model observer is designed to observer by only one controller and same to the view 

 */
package appmagazine;


abstract class IModel {

   abstract void attach(IController observer);
    
}
