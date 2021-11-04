import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int main_timecount = 100;
    private int timecount = 70;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject( new you(), 15, 385 );
    }
    
    public void act(){
        timecount--;
        if( timecount == 0 ){
            main_timecount--;
            timecount=timecount+70;
        }
        showText( ""+main_timecount, 50, 50 );
        if( main_timecount == 0 ){
            showText( "TIME OVER", 400, 200 );
            Greenfoot.stop();
        }
    }
}
