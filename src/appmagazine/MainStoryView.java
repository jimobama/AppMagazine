/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;


import helps.ColorCode;
import helps.Console;
import java.util.ArrayList;
import java.util.Iterator;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

/**
The class is the view  of the StoryController , it handles every out putting and printing of views to the users
 */
class MainStoryView extends IView {
 
   
    private StoryController controller;
    public MainStoryView() {
      
        
    }
    
    @Override
    public void attach(IController parent)
    {
       controller = (StoryController) parent;
    }
 
    @Override
    void Execute() {
     char c=  this.menu();
    
     switch(c)
     {
         case 'A':
         case 'a':
         {
           
           Story  story=this.GetStory();
           this.controller.xhsAddStory(story);
           Execute();
            break;
         }
        case 'V':
         case 'v':
         {
             this.controller.xhsDisplayStoryTable();
             Execute();
             break;
         }
         default:
             controller.xhsCallMenu();
             break;
     }
     
    }
//The method prompt a user to enter story details and then return the story as an objects
    Story GetStory()
    {
     Story story= new Story();
     
     Console.WriteLn("|-------Enter Story Informations --------|\n");
     story.SetEmail(Console.askString("Journalist's Email > "));
     story.SetTitle(Console.askString("Story Title > "));
     story.SetContext(Console.askString("Enter the story context or the filename path > "));
     story.SeTToPerson(Console.askString("Who are you sending the story to: "));   
     story = this.validate(story);
     
      return story;
    }
    
    

   
    void reset() {
       
    }

    //The method check if the story is valid or not
    private Story validate(Story story)
    {
         char quit= Console.askChar(ColorCode.BLUE+"Do you want to continue with the story submission or leave this stage [y/n]? "+ColorCode.BLACK);
         if(quit =='y' || quit=='Y')
           {
            if(!story.validate())
             {
                Console.WriteLn(ColorCode.RED+story.Error+ColorCode.BLACK);
                switch( Story.CODE)
                {
                    case Story.EMAIL:
                    {
                       story.SetEmail(Console.askString("Journalist's Email > "));
                       break;
                    }
                    case Story.TITLE:
                    {
                       story.SetTitle(Console.askString("Story Title > "));
                       break;
                    }
                    case Story.PERSONTO:
                    {
                          story.SeTToPerson(Console.askString("Who are you sending the story to: "));
                       break;
                    }
                    case Story.CONTENT:
                    {
                       story.SetContext("Enter the story context or the filename path > ");
                       break;
                    }
                }

              story= validate(story);
             }
           }
         return story;
    }

    //The menu for the story operations
    private char menu()  {
       char prompt;
     
         Console.clear();
         Console.WriteLn(ColorCode.BLUE+"Do still want to continue with adding new story :"+ColorCode.BLACK);
         Console.WriteLn(" a - Yes Add New Story");
         Console.WriteLn(" v - View Previous Stories");
         Console.WriteLn(" b - Back to Main Menu");
         prompt= Console.askChar("Enter chioce ? ");       
       return prompt;
    }

    //The method display the list of all the story in a table form on the console.
    void displayStories(ArrayList<Story> stories) {
        Table t= new Table(6,BorderStyle.DESIGN_DOTS_WIDE,ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        CellStyle nstyle = new CellStyle(HorizontalAlign.center);
          CellStyle lstyle = new CellStyle(HorizontalAlign.left);
          CellStyle rstyle = new CellStyle(HorizontalAlign.right);
        t.setColumnWidth(0, 8, 14);
        t.setColumnWidth(1, 7, 16);
        t.setColumnWidth(2, 9, 16);
        
         t.addCell("S/N", nstyle);
         t.addCell("ID", nstyle);
         t.addCell("Title", nstyle);      
         t.addCell(" Journalist", nstyle);         
         t.addCell("Contact Person", nstyle);
            t.addCell("Date", nstyle);
         
        Iterator<Story> iter= stories.iterator();
        int counter=0;
       
        while(iter.hasNext())
        {
         counter++;
         Story story= iter.next();
         t.addCell(String.valueOf(counter), lstyle);
         t.addCell(story.getId(), lstyle);
         t.addCell(story.getTitle(), lstyle);        
         t.addCell(story.getJournistId(), lstyle);         
         t.addCell(story.getToperson(), lstyle);
          t.addCell(story.getDate().toString(), lstyle);
        }
        
         t.addCell("", nstyle);
         t.addCell("", nstyle);
         t.addCell("", nstyle);
         t.addCell("", nstyle);
         t.addCell("Total Stories = ", nstyle);         
         t.addCell(String.valueOf(counter), rstyle);
         Console.WriteLn(t.render());
    }

    

 

    
}
