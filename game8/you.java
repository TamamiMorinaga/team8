import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class you here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class you extends Actor
{
    final int speed_jump = 5;
    final int speed_gravity = 5;
    final int speed_lr = 5;
    final int height_jump = 90;
    final int offset_x = 20;
    final int offset_y = 10;
        
    int jumping = 0;
    boolean up_pressed = false;
    private boolean movingleft = false;
    
    public void act()
    {
       //getImage().scale( 25, 25 );
        
        int x = getX();
        int y = getY();
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        int dx = 0;
        int dy = 0;        
        boolean grounded = false;

        // 接地判定
        if( jumping == 0 ){
            Actor block = getOneObjectAtOffset(-offset_x,h/2,brock.class);
            if( block == null ) block = getOneObjectAtOffset(offset_x,h/2,brock.class);
            if( block != null ) grounded = true;
        }
        
        // キー入力
        if( Greenfoot.isKeyDown( "left" ) ){
            dx = -speed_lr;
            if( ! movingleft ){
                movingleft = true;
                getImage().mirrorHorizontally();
            }
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            dx = speed_lr;
            if( movingleft ){
                movingleft = false;
                getImage().mirrorHorizontally();
            }
        }
        /*if( Greenfoot.isKeyDown( "space" ) ){
            getWorld().addObject( new gun(), getX(), getY() );
            if( ! movingleft ){
                movingleft = true;
                move(5);
            }
            if( movingleft ){
                movingleft = false;
                 move(-5);
            }
        }*/
        if( Greenfoot.isKeyDown( "up" ) ){
            if( !up_pressed ){
                up_pressed = true;
                if( grounded ) jumping = height_jump/speed_jump;
            }
        }
        else up_pressed = false;            

        // 上下移動
        if( jumping > 0 ){
            dy = -speed_jump;
            --jumping;
        }
        else if( !grounded ){
            dy = speed_gravity;
        }

        // ブロックとの衝突判定
        if( dy < 0 ){
            /*Actor block = getOneObjectAtOffset(-offset_x,-h/2+dy,brock.class);
            if( block == null ) block = getOneObjectAtOffset(offset_x,-h/2+dy,brock.class);
            if( block == null ) block = getOneObjectAtOffset(0,-h/2+dy,brock.class);*/
            Actor block = getOneObjectAtOffset(0,-h/2+dy,brock.class);
            //if( block == null ) block = getOneObjectAtOffset(offset_x,-h/2+dy,brock.class);
            //if( block == null ) block = getOneObjectAtOffset(-offset_x,-h/2+dy,brock.class);
            if( block != null ){
                int by = block.getY();
                int bh = block.getImage().getHeight();
                dy = (by+bh/2)-(y-h/2);
                jumping = 0;
            }
        }
        if( dy > 0 ){
            Actor block = getOneObjectAtOffset(-offset_x,h/2+dy,brock.class);
            if( block == null ) block = getOneObjectAtOffset(offset_x,h/2+dy,brock.class);
            if( block != null ){   
                int by = block.getY();
                int bh = block.getImage().getHeight();
                dy = (by-bh/2)-(y+h/2);
            } 
        } 
        if( dx < 0 ){
            Actor block = getOneObjectAtOffset(-w/2+dx,-offset_y+dy,brock.class);
            if( block == null ) block = getOneObjectAtOffset(-w/2+dx,offset_y+dy,brock.class);
            if( block != null ){
                int bx = block.getX();
                int bw = block.getImage().getWidth();
                dx = (bx+bw/2)-(x-w/2);
            }
        }
        if( dx > 0 ){
            Actor block = getOneObjectAtOffset(w/2+dx,-offset_y+dy,brock.class);
            if( block == null ) block = getOneObjectAtOffset(w/2+dx,offset_y+dy,brock.class);
            if( block != null ){
                int bx = block.getX();
                int bw = block.getImage().getWidth();
                dx = (bx-bw/2)-(x+w/2);
            }
        }
        
        setLocation( x+dx, y+dy );
        Actor actor = getOneIntersectingObject( toge.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        }   
        actor = getOneIntersectingObject( toge2.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        /*getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );*/
    }  
     actor = getOneIntersectingObject( enemi.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        /*getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );*/
    }  
    actor = getOneIntersectingObject( enemi2.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        /*getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );*/
    }  
    actor = getOneIntersectingObject( enemi3.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        /*getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );*/
    }  
    actor = getOneIntersectingObject( enemi4.class );
        if( actor != null ){
            getWorld().showText( "GAMEOVER", 400,200 );
            Greenfoot.stop();
        /*getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );*/
    }  
}
}
