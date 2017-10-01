package funnyengine.util;
import java.awt.Color;
import java.awt.Graphics;
import funnyengine.core.GameObject;



public class Box extends GameObject {
	
	
	public Box(int x,int y,int w,int h,int id) {
		this.x=x;this.y=y;width=w;height=h;this.id=id;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	
		
}
