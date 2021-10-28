import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class you here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class you extends Actor
{
    private boolean movingleft = false; // 画像が右向きの場合は false をセット
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        if( Greenfoot.isKeyDown( "left" ) ){
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
            setLocation( x-1,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
            setLocation( x+1,y );
        }
        if( Greenfoot.isKeyDown( "up" ) ){
            setLocation( x,y-1 );
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setLocation( x,y+1 );
        }
    } 
}
