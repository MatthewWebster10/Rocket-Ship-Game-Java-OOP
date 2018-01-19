import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button for user choice to reset the game
 * 
 * @Matthew Webster 
 * @09-Apr-2017 
 */
public class ResetButton extends Button
{
    //Global Variable
    String reset = "Reset";
    //checking if the button is on or not
    boolean resetButtonState;
    ResetButton(){
        resetButtonOff();
    }

    /**
     * Act - do whatever the resetButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }    

    /**
     * This method contains what happens
     * when the button is turned on
     */
    public void resetButtonOn()
    {
        //resets the world
        resetButtonState = true;
        Greenfoot.setWorld(new Space());
    }

    /**
     * This method contains what happens
     * when the button is off
     */
    public void resetButtonOff()
    {
        buttonImage = new GreenfootImage(reset, 40, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        resetButtonState = false;
    }

    /**
     * This method toggles the button on or off
     * based on conditions
     */
    public void buttonToggle()
    {
        if (resetButtonState){
            resetButtonOff();
        }
        else{
            resetButtonOn();
        }
    }
}
