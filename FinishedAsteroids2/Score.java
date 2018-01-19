import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class declares score image 
 * The score will be based on the amount of rocks destroyed
 * Also celebrates getting all rocks
 * @Matthew Webster 
 * @05-Mar-2017
 */
public class Score extends Actor
{   
    //Global Vairables
    //high scores
    public static int easyScore = 999;
    public static int mediumScore = 999;
    public static int hardScore = 999;
    Space currentWorld = (Space) getWorld();
    GreenfootImage scoreDisplay;
    /**
     * Deals with the score interpretation on the screen. 
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        if (!currentWorld.getObjects(Rock.class).isEmpty() && currentWorld.buttonState)
        {    //Tells you how many rocks destroyed so far 
            scoreDisplay = new GreenfootImage("Samples: "+ Rock.rocksDestroyed+ "/"+currentWorld.howMany*4 , 50, Color.WHITE, Color.BLACK);
            setImage(scoreDisplay);

        }

        if(currentWorld.getObjects(Rock.class).isEmpty() && currentWorld.buttonState)
        {    
            //Compliments driving skills
            scoreDisplay = new GreenfootImage("Nice Driving Skills " , 50, Color.WHITE, Color.BLACK);
            setImage(scoreDisplay);

            int playerTime = currentWorld.getTime()/60;

            //if the user beats his/her's high score a new high score is created
            if (currentWorld.easyMode && playerTime < easyScore)
            {
                easyScore = playerTime;
            }
            if (currentWorld.mediumMode && playerTime < mediumScore)
            {
                mediumScore = playerTime;
            }
            if (currentWorld.hardMode && playerTime < hardScore)
            {
                hardScore = playerTime;
            }
        }

    } 

}
