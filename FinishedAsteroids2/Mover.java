import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Has the foundation of all things
 * that move in the program's execution
 * @Matthew Webster
 * @05-Mar-2017
 */
public class Mover extends Actor
{
    //Global Vaariables
    double speed = 1.0;
    double angle = 0;
    double maxSpeed = 10.0; 
    public Mover()
    {

    }

    /**
     * Act - do whatever the Mover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveSteadily();
    }  

    /**
     * This function allows the mover to wrap around the wall when it goes through the wall.  
     */
    public void moveSteadily()
    {
        move( (int)speed);
        int x = getX(); 
        int y = getY(); 
        //if mover goes pass world borders, set a new location within the world
        //new position gives off the wrap around effect.
        if(x > (1280 + 50))
        {
            setLocation(1, y);
            return;
        }
        if (x < -50)
        {
            setLocation((1280 - 1), y); 
            return;
        } 
        if(y > (720 + 50))
        {
            setLocation(x, 1);
            return;
        }
        if (y < -50)
        {
            setLocation(x, (720 - 1)); 
            return;
        }
    } 

    /**
     * Rocket movement isn't constant at all times.
     * This method allows rocket to go wrap around the world while
     * not being given a constant movement. 
     */
    public void justThroughWall()
    {
        speed = 0;
        moveSteadily();
    }
}
