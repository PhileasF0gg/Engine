package funnyengine.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Physics implements Runnable {

	boolean running=false;
	public static List<GameObject> gravity=new ArrayList<GameObject>();
	public static List<GameObject> physObjects=new ArrayList<GameObject>();
	List<GameObject> bounce=new ArrayList<GameObject>();
	List<GameObject> collision=new ArrayList<GameObject>();
	List<GameObject> levitation=new ArrayList<GameObject>();
	
	
	public Physics() {
		running=true;
		
	}
	
	public GameObject addGravitation(GameObject g) {
		System.out.println("Added Gravity");
		gravity.add(g);
		physObjects.add(g);
		System.out.println("to "+gravity);
		return g;
	}

	public List<GameObject> getPhysicObjects(){
		return physObjects;
	}
	
	
	@Override
	public void run() {

		System.out.println("Physics"+" "+gravity.size());
		for(GameObject g:gravity) {
			System.out.println("Fall");
			g.setPosition(g.getX(), g.getY()+1);
		}
			
	}
	
}
