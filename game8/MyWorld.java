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
        int i;
        int j;
        for(i = 0; i < 20; i++ ){
         j = i * 30 + 15;
    addObject( new brock(), j, 385 );
       
    }
     for(i = 0; i < 20; i++ ){
         j = i * 30 + 15;
    addObject( new brock(), j, 285 );
       
    }
     for(i = 0; i < 20; i++ ){
         j = i * 30 + 15;
    addObject( new brock(), j, 185 );
       
    }
     for(i = 0; i < 20; i++ ){
         j = i * 30 + 15;
    addObject( new brock(), j, 85 );
       
    }
    addObject( new you(), 15, 355 );
    addObject( new enemi(), 150, 361 );
    addObject( new enemi3(), 400, 261 );
    addObject( new enemi2(), 250, 161 );
    addObject( new enemi4(), 50, 61 );
                
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
