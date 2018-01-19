import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Over Screen
 * 
 * @Matthew Webster 
 * @14-Apr-2017
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);

        //reset button
        addObject(new ResetButton(), 75, 690);
    }

    public void act()
    {
        //reset button mechanism
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //searching for the button and the mouse
        if (mouse != null){
            Actor currentActor = mouse.getActor();
            if (currentActor != null){
                if (currentActor.getClass() == ResetButton.class){
                    ResetButton currentButton = (ResetButton) currentActor;
                    int mouseClickCount = mouse.getClickCount();
                    if (mouseClickCount == 1){
                        //reset the game
                        currentButton.buttonToggle();
                    }

                }

            }
        }
    }
}
