package fr.pastekweb.tchat.model;

import javafx.geometry.Pos;

import java.awt.Point;
import java.util.Random;

/**
 * The client position in a Cartesian plan
 * 
 * @author Thomas TRIBOULT
 */
public class Position extends Point {
	/**
	 * 
	 */
	private static final long serialVersionUID = 818877188439997924L;

	/**
	 * Instantiate a new Position with its coordinate
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Position(int x, int y) {
		super(x, y);
	}

    /**
     * Instantiate a new Position with a point
     * @param p The point
     */
    public Position(Point p)
    {
        super(p);
    }
	
	/**
	 * A String representation of this coordinate
	 * 
	 * @return A String representing the x,y coordinates
	 */
	public String toString() {
		return x + ":" + y;
	}
	
	public static Position getRand(){
		Random r = new Random();
		
		return new Position(r.nextInt(50), r.nextInt(50));
	}
}
