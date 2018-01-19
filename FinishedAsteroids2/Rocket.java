import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class deals with how the rocket will move
 * This includes user input. 
 * @Matthew Webster 
 * @05-Mar-2017
 */
public class Rocket extends Mover
{  
    //Global Variables
    //This set of variables are the mechanics of the rocket
    double speed = 1.0;
    double turnDegree = 2.0;
    double maxSpeed = 10;
    double maxTurnDegree = 6;
    double Turnaccel = 0.05;
    double accel = 0.3;
    //Variable used for current bullet
    Bullet currentBullet;
    //easy access world variable
    Space currentWorld; 
    //indicator of program's phases
    int  counter = 0;

    /**
     * Act - do whatever you want to do with rocket. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentWorld = (Space) getWorld();
        if (currentWorld.buttonState){//if game has started

            if (Greenfoot.isKeyDown("W")){//forward movement with user input
                if (speed < maxSpeed){
                    speed = speed + (speed*accel);//rate of change
                }
                counter = 1; //user input phase

                move( (int)speed);
            }

            if (Greenfoot.isKeyDown("D")){//clockwise turn with user input
                if (turnDegree < maxTurnDegree)
                {
                    turnDegree = turnDegree + (turnDegree*Turnaccel);//rate of change
                }
                turn( (int)turnDegree);   
            }
            if (Greenfoot.isKeyDown("A")){//anticlockwise turn with user input
                if (turnDegree < maxTurnDegree)
                {
                    turnDegree = turnDegree + (turnDegree*Turnaccel);//rate of change
                }
                turn( -(int)turnDegree);  
            }
            //shoot bullet
            if (Greenfoot.isKeyDown("space")){
                if (currentWorld.getObjects(Bullet.class).isEmpty()){
                    currentWorld.addObject( new Bullet(getRotation()), getX(), getY());

                }
            }
            //decceleration/inertia
            if (!Greenfoot.isKeyDown("W")){
                if (speed > 0.5){
                    //decceleration is a slower rate than acceleration
                    //makes sense for a spaceship
                    speed = speed - (speed*(Math.pow(accel,3.0)));
                    move( (int)speed);
                }
                else{
                    //prevent no movement when the player 
                    //has not used w for a few seconds
                    speed = 1.0;
                }

            }
            if (counter == 0)//automatic movement forward
            {
                move(5);//constant velocity
            }

            //just needs to go through world borders
            //no constant speed needed.
            justThroughWall();
        }  

    }    

}
