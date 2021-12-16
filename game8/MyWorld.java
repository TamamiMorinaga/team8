
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.TextLabel;
import greenfoot.WorldVisitor;
import greenfoot.util.GraphicsUtilities;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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
    
    class TextLabelEx extends TextLabel
    {
        boolean enable;
        int xpos;
        int ypos;
        int size;
        boolean bold;
        greenfoot.Color gfcolor;
        java.awt.Color color;
        String text;
        String[] lines;
        private GraphicsUtilities.MultiLineStringDimensions dimensions = null;
        
        @Override
        public int getX(){ return xpos;}
        
        @Override
        public int getY(){ return ypos;}
        
        @Override
        public String getText(){ return text;}     
        
        public TextLabelEx(String _text, int _xpos, int _ypos, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            super("", 0, 0 );
            lines = new String[1];
            xpos = _xpos;
            ypos = _ypos;
            reset( _text, _size, _bold, _gfcolor );
        }
        
        public void reset( String _text, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            if( text == _text && size == _size && bold == _bold && gfcolor == _gfcolor ) return;
            text = _text;
            size = _size;
            bold = _bold;
            gfcolor = _gfcolor;
            lines[0] = text;
            dimensions = null;
            
            if( text.length() == 0 ) enable = false;
            else enable = true;
        }

        @Override
        public void draw(Graphics2D g, int cellsize)
        {
            if( !enable ) return;
            if(dimensions == null) {
                dimensions = GraphicsUtilities.getMultiLineStringDimensions(lines, bold ? java.awt.Font.BOLD : java.awt.Font.PLAIN, size);
                color = new java.awt.Color( gfcolor.getRed(), gfcolor.getGreen(), gfcolor.getBlue(), gfcolor.getAlpha() );
            }
                
            int ydraw = ypos * cellsize - dimensions.getHeight() / 2 + cellsize / 2;
            int xdraw = xpos * cellsize - dimensions.getWidth() / 2 + cellsize / 2;
            g.translate(xdraw, ydraw);
            GraphicsUtilities.drawOutlinedText(g, dimensions, color, java.awt.Color.BLACK);
            g.translate(-xdraw, -ydraw);
        }
    }
    public void showTextEx(String text, int x, int y, int size, boolean bold, greenfoot.Color color )
    {
        for( TextLabel label : WorldVisitor.getTextLabels(this) ){
            if( label.getX() == x && label.getY() == y ){
                if( label instanceof TextLabelEx ){
                    ((TextLabelEx)label).reset(text, size, bold, color);
                    return;                    
                }
            }
        }
        WorldVisitor.getTextLabels(this).add(new TextLabelEx( text, x, y, size, bold, color ) );
        
        //showText( "labels: "+WorldVisitor.getTextLabels(this).size(), 80, 20 );
    }
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    GreenfootSound bgm = null;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1040, 680, 1);
        bgm = new GreenfootSound( "19.mp3" );
        //super(700, 500, 1);
                int map[][] = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {0,8,0,0,0,0,0,0,5,4,5,6,5,4,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,7,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,3,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,6,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,7,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1},
                {1,3,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,2,2,1,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1},
                
            };
        for(int y = 0; y < 22; y++){
            for(int x = 0; x < 34; x++){
                if(map[y][x]==1){
                    addObject( new brock(), 25+(x*30), 25+(y*30));
                }
                if(map[y][x]==2){
                    addObject( new toge(), 25+(x*30), 25+(y*30));
                }
                if(map[y][x]==3){
                    addObject( new toge2(), 25+(x*30), 25+(y*30));
                }
                if(map[y][x]==4){
                    addObject( new enemi(), 25+(x*30), 31+(y*30));
                }
                if(map[y][x]==5){
                    addObject( new enemi2(), 25+(x*30), 31+(y*30));
                }
                if(map[y][x]==6){
                    addObject( new enemi3(), 25+(x*30), 31+(y*30));
                }

                if(map[y][x]==7){
                    addObject( new toge3(), 25+(x*30), 25+(y*30));
                }
                if(map[y][x]==8){
                    addObject( new takara(), 25+(x*30), 22+(y*30));
                }

            }
        }
        /*int i;
        int j;
        for(i = 0; i < 20; i++ ){
         j = i * 30 + 15;
         addObject( new brock(), j, 385 );
       
        }
        for(i = 0; i < 19; i++ ){
         j = i * 30 + 15;
         addObject( new brock(), j, 285 );
       
        }
        for(i = 1; i < 20; i++ ){
         j = i * 30 + 15;
         addObject( new brock(), j, 185 );
       
        }
        for(i = 0; i < 19; i++ ){
         j = i * 30 + 15;
         addObject( new brock(), j, 85 );
       
        }
    
    addObject( new enemi(), 150, 361 );
    addObject( new enemi3(), 400, 261 );
    addObject( new enemi2(), 250, 161 );
    addObject( new enemi4(), 50, 61 );
    addObject( new toge(), 200, 215 );
    addObject( new toge(), 25, 115 );
    addObject( new toge(), 175, 115 );
    addObject( new toge(), 255, 115 );
    addObject( new toge(), 475, 115 );
    addObject( new toge(), 505, 115 );
    addObject( new toge(), 505, 115 );
    addObject( new toge2(), 315, 115 );*/

    addObject( new you(), 55, 625 );  
    }
    
    public void act(){
        bgm.playLoop();
        timecount--;
        if( timecount == 0 ){
            main_timecount--;
            timecount=timecount+70;
        }
        showText( ""+main_timecount, 25, 20 );
        if( main_timecount == 0 ){
            showTextEx( "GAME OVER", 300, 200, 64, false, greenfoot.Color.RED);
            Greenfoot.stop();
            bgm.stop();
        }
    }
}
