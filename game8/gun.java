
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gun extends Actor
{
    /**
     * Act - do whatever the gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        Actor actor = getOneIntersectingObject( you.class );
        if(actor && ! movingleft ){
            setRotation(0);
            move(5);
        }  
        if(actor && movingleft ){
            setRotation(0);
            move(-5);
        }

        ////enemi-gun//atari///////    
        actor = getOneIntersectingObject( enemi.class );
        if( actor != null ){
            getWorld().removeObject( actor ); 
        }
        actor = getOneIntersectingObject( enemi2.class );
        if( actor != null ){
            getWorld().removeObject( actor ); 
        }
        actor = getOneIntersectingObject( enemi3.class );
        if( actor != null ){
            getWorld().removeObject( actor ); 
        }
        actor = getOneIntersectingObject( enemi4.class );
        if( actor != null ){
            getWorld().removeObject( actor ); 
        }

    }
}
