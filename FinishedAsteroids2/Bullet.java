import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullet is made as a subclass of Rocket
 * @Matthew Webster
 * @05-Mar-2017
 */
public class Bullet extends Rocket
{
    //Global Variable
    Space currentWorld;
    int bulletLife = 60;// 1 seconds of life--> 1*60 
    int creationTime = -1;//temporary variable
    public Bullet(int direction)
    {
        turn( (int)direction);
        speed = maxSpeed*1.5;//same speed as the rocket
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Initializing constant movement
        move( (int)speed);
        currentWorld = (Space) getWorld();
        //Just needs to go through wall, moveSteadily() not needed.
        justThroughWall();

        Actor Rock = getOneIntersectingObject(Rock.class);
        if (creationTime == -1){//gets real creation time
            creationTime = currentWorld.getTime();
        }
        if (currentWorld.getTime() > bulletLife + creationTime){
            //destroy this object
            currentWorld.removeObject( this );//"this" refers to current bullet.
        }

    }    

}
