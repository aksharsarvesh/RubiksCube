/**Written by: Akshar Sarvesh
*Slot.java
*Stores data for a single piece on the cube
*3 types-corner, edge, and center, so 3 constructors
*Necessary for the cube
*
*/

package RubiksCube;

import java.util.Arrays;

//This class will store data on all three pieces.
public class Slot {
	private int[] data;
	private int O;
	int[] coordinates;
	private boolean solved = false;
	public Slot(int[] d, int O, int[] coordinates){
		data = d;
		this.O=O;
		this.coordinates = coordinates;
	}
	public Slot(Slot s){
		data = s.getColor();
		coordinates= s.getCoordinates();
	}
	
	public Slot(int first,int second, int third, int O,int co1, int co2, int co3){
		data= new int[3];
		data[0]=first;
		data[1]=second;
		data[2]=third;
		this.O=O;
		coordinates = new int[3];
		coordinates[0]=co1;
		coordinates[1]=co2;
		coordinates[2]=co3;
	}
	public Slot(int first, int second, int O,int co1, int co2, int co3){
		data=new int[2];
		data[0]=first;
		data[1]=second;
		this.O=O;
		coordinates = new int[3];
		coordinates[0]=co1;
		coordinates[1]=co2;
		coordinates[2]=co3;
	}
	public Slot(int color, int O,int co1, int co2, int co3){
		data = new int[1];
		data[0]=color;
		this.O=O;
		coordinates = new int[3];
		coordinates[0]=co1;
		coordinates[1]=co2;
		coordinates[2]=co3;
	}
	//Return the color represented
	public int[]getColor(){
		return data;
	}
	public void setColor(int[] colors){
		data= colors;
	}
	//return the orientation
	public int getOrientation(){
		return O;
	}
	public void setOrientation(int O){
		this.O = O;
	}
	//only for the solving process
	public int[] getCoordinates() {
		
		return coordinates;
	}
	public void setCoordinates(int c, int r, int l) {
		coordinates[0] = c;
		coordinates[1]=r;
		coordinates[2] = l;
		
	}
	public String toString(){
		return Arrays.toString(data)+" "+Arrays.toString(coordinates);
	}
	public void solved(){
		solved = true;
	}
	public boolean isSolved(){
		return solved;
	}
}
