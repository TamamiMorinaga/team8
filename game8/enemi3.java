import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemi2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemi3 extends Actor
{
     private int main_timecount = 100;
    private int timecount = 115;
    private boolean movingleft = true;
    /**
     * Act - do whatever the enemi2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
                // Add your action code here.
                timecount--;
        if( timecount == 0 ){
            main_timecount--;
            timecount=timecount+115;
        }
       
        int i = 0;
            i = main_timecount % 2;
        if( i == 0 ){
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
        setRotation(0);
        move(1);
        }
        if( i == 1 ){
        setRotation(0);
        move(-1);
        if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
           
        }
    
    
       /* setRotation(180);
        move(15);*/
    }    
}
