import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button for user choice of the hard difficulty level
 * 
 * @Matthew Webster
 * @09-Apr-2017 
 */
public class HardButton extends Button
{
    HardButton(){
        hardButtonOff(); 
    }

    /**
     * Act - do whatever the HardButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }       

    /**
     * This method contains what happens
     * when the button is turned on
     */
    public void hardButtonOn()
    {
        currentWorld.buttonState = true;
    }

    /**
     * This method contains what happens
     * when the button is off
     */
    public void hardButtonOff()
    {
        difficulty = "Hard";
        buttonImage = new GreenfootImage(difficulty, diffucltyButtonSize, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        currentWorld.buttonState = false;
    }

    /**
     * This method toggles the button.
     */
    public void buttonToggle()
    {
        if (currentWorld.buttonState){
            hardButtonOff();
        }
        else{
            hardButtonOn();
        }
    }
}
