import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class you extends Actor
{
    private boolean movingleft = false; // 画像が右向きの場合は false をセット
    //private boolean onGround = true; //actor on ground? Starting on ground
    private int vSpeed = 0; //current vertical speed
    private int acceleration = 2;
    
    public void act()
    {
        checkKeys();
        checkFall();
    }
    public void checkKeys()
    {
        int x = getX(); 
        int y = getY();
          
        if( Greenfoot.isKeyDown( "left" ) ){
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
            setLocation( x-5,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
            setLocation( x+5,y );
        }
        if (Greenfoot.isKeyDown("up") /*&& onGround()*/){
            setLocation( x,y-2 );
            jump();
        }
    
    } 
    public void checkFall(){
        if(onGround()){
        }
        else{ 
            fall();
        }     
    }
    public boolean onGround(){
        Actor unter = getOneObjectAtOffset( 0, 30, MyWorld.class );
        return unter != null;
    }
    public void jump(){
        vSpeed = -2;
        fall();
    }
     
    public void fall(){
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
}
