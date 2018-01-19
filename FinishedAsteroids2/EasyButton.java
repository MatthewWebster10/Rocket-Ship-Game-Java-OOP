import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button for user choice of the easy difficulty level
 * 
 * @Matthew Webster
 * @09-Apr-2017 
 */
public class EasyButton extends Button
{
    public EasyButton(){
        easyButtonOff();
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }    

    /**
     * This method contains what happens
     * when the button is turned on
     */
    public void easyButtonOn()
    {        
        currentWorld.buttonState = true;
    }

    /**
     * This method contains what happens
     * when the button is off
     */
    public void easyButtonOff()
    {
        difficulty = "Easy";
        buttonImage = new GreenfootImage(difficulty, diffucltyButtonSize, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        currentWorld.buttonState = false;
    }

    /**
     * This method toggles the button on or off
     * based on conditions
     */
    public void buttonToggle()
    {
        if (currentWorld.buttonState){
            easyButtonOff();
        }
        else{
            easyButtonOn();
        }
    }
}
