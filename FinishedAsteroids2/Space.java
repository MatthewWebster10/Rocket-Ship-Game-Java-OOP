import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world class for this program
 * This world is supposed to be Space where a rocket can be found
 * @Matthew Webster
 * @05-Mar-2017
 */
public class Space extends World
{
    //Global Variables
    int gameTime = 0;
    int howMany;//how many rocks
    int restrictedTime;//restricted time based on difficulty
    Actor timer;
    //difficulty check
    boolean easyMode = false;
    boolean mediumMode = false;
    boolean hardMode = false;
    //button state of all buttons except the reset button
    public static boolean buttonState = false;

    /**
     * Constructor for objects of class Space.
     */
    public Space()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        //buttons
        addObject(new EasyButton(), 925, 690);
        addObject(new MediumButton(), 1075, 690);
        addObject(new HardButton(), 1225, 690);

        //instructions
        addObject(new Instruction(), 640, 360);

        //resets static variables
        resetStaticVariable();
        //Initializing the Rocket
        Rocket Rocket = new Rocket();
        addObject(Rocket,100, 250);

        //sets paint order to avoid visual confusion
        setPaintOrder(Button.class, Instruction.class,Rocket.class, Rock.class, Score.class);

    }

    /**
     * This method is active throughout the course of execution
     * Increases game clock
     */
    public void act()
    {
        //game clock
        if (buttonState == true && !getObjects(Rock.class).isEmpty()){
            if (gameTime == 0){
                timer = new Timer();
                //Scoreboard is initialized
                Score scoreCount = new Score();
                addObject(scoreCount, 640, 690);
                addObject( new HighScore(), 1000, 50);
            }
            gameTime += 1;
            timer();
            if (getObjects(Timer.class).isEmpty()){//timer is initialized
                addObject(timer, 150, 100);
            }
        }
        //deals with the start button's mouse configurations
        MouseInfo mouse = Greenfoot.getMouseInfo();
        //searching for the button and the mouse
        if (mouse != null){
            Actor currentActor = mouse.getActor();
            if (currentActor != null){
                if (currentActor.getClass() == EasyButton.class){
                    EasyButton currentButton = (EasyButton) currentActor;
                    int mouseClickCount = mouse.getClickCount();
                    if (mouseClickCount == 1){
                        currentButton.buttonToggle();
                        removeObjects(getObjects(Button.class));

                        //initializing rocks based off difficulty
                        howMany = 2;
                        randomRocks(howMany);

                        //setting timer
                        restrictedTime = 40*60;//40 seconds
                        easyMode = true;
                    }
                    else{

                    }

                }
                if (currentActor.getClass() == MediumButton.class){
                    MediumButton currentButton = (MediumButton) currentActor;
                    int mouseClickCount = mouse.getClickCount();
                    if (mouseClickCount == 1){
                        currentButton.buttonToggle();
                        removeObjects(getObjects(Button.class));
                        //initializing rocks based off difficulty

                        howMany = 4;
                        randomRocks(howMany);
                        //setting timer 
                        restrictedTime = 40*60;//60 seconds
                        mediumMode = true;
                    }
                    else{

                    }
                }

                if (currentActor.getClass() == HardButton.class){
                    HardButton currentButton = (HardButton) currentActor;
                    int mouseClickCount = mouse.getClickCount();
                    if (mouseClickCount == 1){
                        currentButton.buttonToggle();
                        removeObjects(getObjects(Button.class));
                        //initializing rocks based off difficulty
                        howMany = 6;
                        randomRocks(howMany);
                        //setting Timer 
                        restrictedTime = 60*60;//60 seconds
                        hardMode = true;
                    }
                    else{

                    }
                }
            }
        }
        //add option to reset the game
        resetOption();
    }

    /**
     * This method returns gameTime.
     * Can be called anywhere if needed. 
     */
    public int getTime()
    {
        return gameTime;
    }

    /**
     * Deals with randomizing the position of the rocks
     * can be customized to populate the world with more rocks. 
     */
    public void randomRocks(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Rock SpaceRock = new Rock();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(SpaceRock, x, y);
        }
    }

    /**
     * In this program, static variables are needed for proper execution
     * In this method, it resets the static variables
     */
    private void resetStaticVariable()
    {
        Rock.rocksDestroyed = 0;
        buttonState = false;
    }

    /**
     * This method makes the reset button
     * and deals with its mouse clicking functionality
     */
    public void resetOption()
    {
        if (getTime() == 1 && getObjects(ResetButton.class).isEmpty())
        {
            addObject(new ResetButton(), 75, 690);
        }

        MouseInfo mouse = Greenfoot.getMouseInfo();
        //searching for the button and the mouse
        if (mouse != null){
            Actor currentActor = mouse.getActor();
            if (currentActor != null){
                if (currentActor.getClass() == ResetButton.class){
                    ResetButton currentButton = (ResetButton) currentActor;
                    int mouseClickCount = mouse.getClickCount();
                    if (mouseClickCount == 1){
                        currentButton.buttonToggle();
                    }

                }

            }
        }
    }

    /**
     * The timer for the game
     */
    public void timer()
    {
        //based off difficulty chosen by the user
        if (getTime() >= restrictedTime){
            //Game Over
            Greenfoot.setWorld(new GameOver());

        }
    }

}
