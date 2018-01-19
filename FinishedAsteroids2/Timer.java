import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Image details of the Game Timer
 * 
 * @Matthew Webster 
 * @05-Mar-2017
 */
public class Timer extends Actor
{
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if statement needed because world is not initialized when
        //the act method is activated
        if (getWorld()!= null){
            Space currentWorld = (Space) getWorld();
            //Timer text
            String time = "Timer: "+ (currentWorld.gameTime)/60+"/"+currentWorld.restrictedTime/60+"s";
            setImage(new GreenfootImage(time, 50, Color.WHITE, Color.BLACK));
        }

    }    
}
