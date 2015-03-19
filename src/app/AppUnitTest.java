
/*
The File contain the unit test methods for 5 important methods of the applications
The class will be implement with the unitAppRunner class
*/
package app;

import appmagazine.ModelJournalist;
import appmagazine.Story;
import appmagazine.StoryModel;
import org.junit.Test;
// use the import static to import a static field or class inside another class to avoid using the class its self
import static org.junit.Assert.assertEquals;

public class AppUnitTest {
    
    //Specific the annotation test to tell java runtime that the class is a test of another class
   @Test 
   public  void testStoryExists()
    {
        //expecting results
        boolean status =true;
        
        StoryModel  model;
        model = new StoryModel();
        
        //create a new story
         Story story = new Story();
         
        story.SetEmail("anicola00@gmail.com");
        story.SeTToPerson("Head Office");
        story.SetTitle("Three years boy attach university");
        story.SetContext("Its was yesterday a boy was given birth and become three to be uni that is aweson?");
        
        //we are expecting the result to be false since this story did not exist at the time of testing
        assertEquals(status,model.IsStoryExist(story));      
              
        
    }
    
   
   //Test on the Journalist method if Exists
   @Test
   public void TestJournalistModelIfExist()
   {
       
       boolean expectResult = false;
       
       ModelJournalist journalist = new ModelJournalist();
      
       //check if the method is working as expected
       assertEquals( expectResult ,journalist.IsExist("someone@yahoo.com"));
       
   }
   
   
   
}
