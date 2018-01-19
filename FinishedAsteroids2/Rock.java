import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the rock jpg
 * in the Space world.
 * 
 * @Matthew Webster
 * @05-Mar-2017
 */
public class Rock extends Mover
{
    //Global Variables
    int currentSize = 100;
    int smallSize = 12;//3 hits to the asteroid to collect rock sample
    //Variable used throughout the program for counting amount of rocks destroyed
    public static int rocksDestroyed = 0;
    //world variable and checking if a rock is completely destroyed
    boolean rockChecker = false;
    Space currentWorld; 
    /**
     * Gives different speeds and turn angle for the different rocks.
     */
    public Rock()
    {
        speed = Math.random()*maxSpeed;//1-10
        angle = Math.random()*360;//0 degrees - 360 degrees

        move( (int)speed);
        turn( (int)angle);
        sizeImage();
    }

    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        moveSteadily();
        currentWorld = (Space) getWorld();

        Actor bullet;
        bullet = getOneIntersectingObject(Bullet.class);
        //resizes rock after hit from a bullet

        if (bullet != null){
            currentWorld = (Space) getWorld();
            scaleSize(0.5);
            sizeImage();
            //changes speed and direction
            momentumCollision();

            int updatedSize = currentSize;
            currentWorld.removeObject(bullet);
            //if rock isn't completely destroyed we make a similiar
            //rock to the one that was damaged for shattering effect
            if (!rockIsGone()){
                Rock currentRock = new Rock();
                currentRock.secondHalf(updatedSize);//finishing making shattered piece
                currentWorld.addObject(currentRock, getX(), getY());
            }
        }

        //counts rocks destroyed
        if(rockIsGone()){
            rocksDestroyed++;
            rockChecker = false; 
        }
        //deals with destroying of the rocket
        if(currentSize >= 50 && currentWorld.getTime() > 120){
            rocketCrash(); 
        }
        else{

        }

    }    

    /**
     * This method reduces the size of the rock 
     * when it is hit by a bullet
     */
    private void sizeImage()
    {
        if (currentSize <= smallSize){
            currentWorld.removeObject(this);
            rockChecker = true;
        }
        GreenfootImage currentRock = getImage();
        currentRock.scale(currentSize, currentSize);
        setImage(currentRock);

    }

    /**
     * dealing with the rate of decrease in the rocks(asteroids)
     */
    public void scaleSize(double scaleFactor)
    {
        currentSize = Math.round ( (int) (currentSize*scaleFactor));
    }

    /**
     * returns boolean statement which determines whether or not a 
     * asteroid is there or not. 
     */
    public boolean rockIsGone()
    {
        return rockChecker;
    }

    /**
     * My shattering object algorithm reduces the size, but keeps the first object that was hit
     * and makes a new object with the same size
     * This method makes that new rock 
     */
    public void secondHalf(int updatedSize)
    {
        //very similiar to the change change sizeImage() method
        //but focuses on the new rock made
        currentSize = updatedSize;
        GreenfootImage currentRock = getImage();
        currentRock.scale(currentSize, currentSize);
        setImage(currentRock);
    }

    /**
     * Changes direction and speed of a rock
     * that was hit by a laser bullet
     */
    public void momentumCollision()
    {
        speed = Math.random()*maxSpeed;//1-10
        angle = Math.random()*360;//0 degrees - 360 degrees

        move( (int)speed);
        turn( (int)angle);
    }

    /**
     * Deals with the destroying of the rocket
     */
    public void rocketCrash()
    {
        Actor Rocket = getOneIntersectingObject(Rocket.class);
        //if the rocket connects with a big enough rock
        //the rocket is destroyed and gameOver
        if (Rocket != null)
        {
            currentWorld.removeObject(Rocket);
            Greenfoot.setWorld(new GameOver());
        }

    }

}
