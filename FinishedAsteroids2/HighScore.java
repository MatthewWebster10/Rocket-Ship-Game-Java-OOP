import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Deals with the display of the High score
 * 
 * @Matthew Webster
 * @14-Apr-2017
 */
public class HighScore extends Actor
{
    //Global Variables
    GreenfootImage highScoreDisplay;
    Space currentWorld;
    HighScore(){
    }

    /**
     * Act - do whatever the HighScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();

        if ((currentWorld.getTime()) == 1)
        {
            //display high score based on difficulty
            //and if it is less than required time to complete the game
            if (Score.easyScore < (currentWorld.restrictedTime)/60 && currentWorld.easyMode)
            {
                highScoreDisplay = new GreenfootImage("Easy High score: "+Score.easyScore+"s", 30, Color.WHITE, Color.BLACK);
                setImage(highScoreDisplay);

            }
            if (Score.mediumScore < currentWorld.restrictedTime/60 && currentWorld.mediumMode)
            {
                highScoreDisplay = new GreenfootImage("Medium High score: "+Score.mediumScore+"s", 30, Color.WHITE, Color.BLACK);
                setImage(highScoreDisplay);
            }
            if (Score.hardScore < currentWorld.restrictedTime/60 && currentWorld.hardMode)
            {
                highScoreDisplay = new GreenfootImage("Hard High score: "+Score.hardScore+"s", 30, Color.WHITE, Color.BLACK);
                setImage(highScoreDisplay);
            }

        }
    }    
}
