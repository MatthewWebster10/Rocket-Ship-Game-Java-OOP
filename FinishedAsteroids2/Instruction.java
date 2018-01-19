import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the game instructions
 * 
 * @Matthew Webster
 * @05-Mar-2017
 */
public class Instruction extends Actor
{
    //Global Variable
    Space currentWorld;
    Instruction(){
        currentWorld = (Space) getWorld();
        resize();       
    }

    /**
     * Act - do whatever the Instruction wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if game starts remove instructions
        //otherwise have the instructions on the screen
        currentWorld = (Space) getWorld();
        if (currentWorld.buttonState){
            currentWorld.removeObject(this);

        }
        else{

        }

    }   

    /**
     * The instruction page is too small.
     * so this method fixes the size to take over the screen
     */
    public void resize()
    {
        GreenfootImage currentImage = getImage();
        currentImage.scale(1280, 720);
        setImage(currentImage);
    }
}
