/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmagazine;

import view.StoryView;

/**
 *
 * @author Obaro
 */
class MainStoryView extends IView {
 
    private StoryView storyview;
    public MainStoryView() {
        storyview= new StoryView();
        this.setContentPane(storyview);
        
    }

 
    void Execute() {
        this.pack();
        this.setVisible(true);
    }

    Story GetStory()
    {
      Story story;
        story = this.storyview.GetStory();
      
       
      return story;
    }

    void ShowMessage(String this_story_already_exist, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
