import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class toge2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class toge3 extends Actor
{
    private int main_timecount = 100;
    private int timecount = 115;
    /**
     * Act - do whatever the toge2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     timecount--;
        if( timecount == 0 ){
            main_timecount--;
            timecount=timecount+115;
        }
       
        int i = 0;
            i = main_timecount % 2;
        if( i == 0 ){
        setRotation(90);
        move(1);
        }
        if( i == 1 ){
        setRotation(90);
        move(-1);          
        }// Add your action code here.
    }    
}
