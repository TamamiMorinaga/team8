import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class potato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class potato extends Actor
{
    /**
     * Act - do whatever the potato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( Greenfoot.isKeyDown( "up" ) ){
        setRotation(-90);
        move(1);
        }
        if( Greenfoot.isKeyDown( "left" ) ){
        setRotation(180);
        move(1);
        }
        if( Greenfoot.isKeyDown( "down" ) ){
        setRotation(90);
        move(1);
        }
        if( Greenfoot.isKeyDown( "right" ) ){
        setRotation(0);
        move(1);
        }  
    }
}
