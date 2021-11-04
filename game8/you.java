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
    private boolean onGround = true; //ジャンプ処理、地上
    private int gravity;
    
    public void act()
    {
       gravity--;
       setLocation(getX(), getY() - gravity);
    }
    
    public void move() 
    {
        int x = getX(); 
        int y = getY();
        gravity--;
        setLocation(getX(), getY() - gravity);
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
        if( onGround && Greenfoot.isKeyDown( "spase" ) ){
            setLocation( x,y+3 );
            gravity = 1; // this will make the character jump
        }
    
    } 
}
