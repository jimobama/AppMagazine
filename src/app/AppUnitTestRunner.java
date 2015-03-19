/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
//Import the test runner class
import helps.Console;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 *
 * @author Obaro
 */
public class AppUnitTestRunner {
    
    
    
    public static void main(String arg[])
     {
         //Create the Junit Runner class to test the given classes
         Result result = JUnitCore.runClasses( AppUnitTest.class);
         
         //Check if there is any error in any of the method tested
         for(Failure f:result.getFailures())
         {
             Console.WriteLn(f.getTrace());
         }
         
         Console.WriteLn("Success :"+ result.wasSuccessful());
     }
    
}
