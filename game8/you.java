import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class you extends Actor
{
    private boolean movingleft = false; // 画像が右向きの場合は false をセット
    private int vSpeed = 0; //current vertical speed
    private int acceleration = 2;

    private boolean jumping = false;

    public void act()
    {
        checkKeys();
        checkFall();
        onGround();
    }

    public void checkKeys()
    {
        int x = getX(); 
        int y = getY();

        if( Greenfoot.isKeyDown( "left" ) ){
            //左
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
            setLocation( x-5,y );
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            //右
            if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
            setLocation( x+5,y );
        }
        if (Greenfoot.isKeyDown("up") && jumping == false){
            //上
            setLocation( x,y-2 ); 
            jump();
        }

        if( Greenfoot.isKeyDown( "left" ) && Greenfoot.isKeyDown("up") && jumping == false){
            //左と上
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
            setLocation( x-5,y-2 );
            jump();
        }
        if( Greenfoot.isKeyDown( "right" ) && Greenfoot.isKeyDown("up") && jumping == false){
            //右と上
            if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
            setLocation( x+5,y-2 );
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
        Actor unter = getOneObjectAtOffset( 0, getImage().getHeight()/2, MyWorld.class );
        return unter != null;
    }

    public void jump(){
        vSpeed = -8;
        jumping = true;
        //fall();
    }

    public void fall(){
        setLocation( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
        jumping = false;

    }
}
