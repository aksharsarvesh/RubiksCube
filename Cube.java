package RubiksCube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import apcs.Window;
public class Cube {
	static Slot[][][] cube;
	/** VERY IMPORTANT
	 * THE STRING YOU ENTER INTO THE SCANNER RIGHT BELOW THIS
	 * IS WHAT THE CUBE WILL DO. MAKE SURE YOU HAVE SPACES
	 * I couldn't get the file to work, but you can still
	 * copy paste into it
	 */
	static Scanner s = new Scanner("D2 R2 B2 L2 B' R2 U2 B L2 D U' L' R' U L D' R' F D2");
	static ArrayList<Slot> corners = new ArrayList<Slot>();
	static ArrayList<Slot> edges = new ArrayList<Slot>();
	static ArrayList<Slot> centers = new ArrayList<Slot>();
	static ArrayList<Slot> piecesOfInterest = new ArrayList<Slot>();
	public static void main(String[] args) {
		//Make the window
		Window.size(1200, 900);
		
		
		//Initialize a 3x3x3 cube
		 cube = new Slot[3][3][3];
		//Start with a solved cube
		start();
		draw();
		//Uprime();
		//draw();
		//D();
		//draw();
		System.out.println("Scramble:");
		scramble();
		System.out.println();
		draw();
		Window.wait(3.5);
		System.out.println("Solution:");
		solve();
		draw();
		
	}
	private static void solve() {
		cross();
		System.out.println();
		Window.wait(2);
		bottomCorners();
		System.out.println();
		Window.wait(2);
		middleEdges();
		System.out.println();
		Window.wait(2);
		topCross();
		System.out.println();
		Window.wait(2);
		topFace();
		System.out.println();
		Window.wait(2);
		topEdges();
		System.out.println();
		Window.wait(2);
		topCorners();
		System.out.println();
		Window.wait(2);
		
	}
	private static void topCorners() {
		// TODO Auto-generated method stub
		
	}
	private static void topEdges() {
		// TODO Auto-generated method stub
		
	}
	private static void topFace() {
		// TODO Auto-generated method stub
		
	}
	private static void topCross() {
		// TODO Auto-generated method stub
		
	}
	private static void middleEdges() {
		// TODO Auto-generated method stub
		
	}
	private static void bottomCorners() {
		Slot piece;
		//Goes through all the corner
		//Finds four corners
		for(int a = 0; a<4;a++){
			int face = 0;
			int face2=0;
			//Stops itself once it hits a useful corners
			boolean keepGoing = true;
			for(int j = 0;j<corners.size();j++){
				if(keepGoing){
					Slot s = corners.get(j);
					for(int i =0;i< s.getColor().length;i++){
						//finds the corners with white
						//makes sure it's not already solved
						if(s.getCoordinates()[0]==0&&(s.getColor()[1]==cube[1][1][s.getCoordinates()[2]].getColor()[0])&&(s.getColor()[2]==cube[1][s.getCoordinates()[1]][1].getColor()[0])){
							s.solved();
						}
						if(s.getColor()[i]==6&&!s.isSolved()){
							keepGoing = false;
							
							
							//Start the corner in the yellow face-then there are only two different cases
						
								
								
							//White face
							if(s.getCoordinates()[0]==0){
								//Left face
								if(s.getCoordinates()[1]==0){
									//Front face
									if(s.getCoordinates()[2]==0){
										L();
										D();
										Lprime();
										Dprime();
										face = 2;
										face2=4;
										System.out.print("L D L' D' ");
									}
									//back face
									if(s.getCoordinates()[2]==2){
										Lprime();
										Dprime();
										L();
										D();
										face = 2;
										face2 = 5;
										System.out.print("L' D' L D ");
									}
								}
								//right face
								if(s.getCoordinates()[1]==2){
									//Front face
									if(s.getCoordinates()[2]==0){
										Rprime();
										Dprime();
										R();
										D();
										face = 1;
										face2 = 4;
										System.out.print("R' D' R D ");
									}
									//back face
									if(s.getCoordinates()[2]==2){
										R();
										D();
										Rprime();
										Dprime();
										
										face = 1;
										face2=5;
										System.out.print("R D R' D' ");
									}
								}
								//Now, any white corners in the white face are now in the yellow face
								
							}
								
							int Orientation = 0;
							
							if(s.getColor()[0]==6){
								
								Orientation = 0;
							}
							else if(s.getColor()[1] == 6){
								
								Orientation=1;
							}
							else if(s.getColor()[2] == 6){
								Orientation =2;
							}
							int color1 = s.getColor()[(Orientation+1)%3];
							int color2 = s.getColor()[(Orientation+2)%3];
							
							
							
							
							
							
								
								
							//NOTE: The only way to do this is to hard code it, because the pieces don't reload their positions enough	
							//This is, if the centers directly above the current corner has the same color as the pieces second color and third color
							if(face ==0){
								//this means it started and ended in the bottom layer, so face was never assigned
								//L face
								
								if(s.getCoordinates()[1]==0){
									face = 2;
									if(s.getCoordinates()[2]==0){
										face2 = 4;
									}
									else if(s.getCoordinates()[2]==2){
										face2 = 5;
									}
									
								}
								//R face
								else if(s.getCoordinates()[1]==2){
									face =1;
									if(s.getCoordinates()[2]==0){
										face2 = 4;
									}
									else if(s.getCoordinates()[2]==2){
										face2 = 5;
									}
									
									face = 1;
								}
								
								
							}
							
							
							for(int x = 0;x<4;x++){
								//either the first non white color has the color of the front/back or the color of the left/right
								
								if((color1==face&&color2==face2)||color1==face2&&color2==face){
									//already in correct spot, just stay there
								}
								else{
									
									Orientation=(3-Orientation)%3;
									
									D();
									System.out.print("D ");
									//front left
									if(face==2){
										if(face2==4){
											face = 1;
											
										}
										//back left
										else if(face2==5){
											face2 = 4;
											
										}
									}
									
									
							
									else if(face==1){
										//front right
										if(face2==4){
											face2 = 5;
											
										}
										//back right
										else if(face2==5){
											face = 2;
											
										}
									}
									
										
									
									
								}
							}
							
							
							//After finding the correct face:
							
							if(face == 2){
								//Left
								if(face2==4){
									//Front
									L();
									D();
									Lprime();
									Dprime();
									System.out.print("L D L' D' ");
								}
								if(face2 ==5){
									//back
									Lprime();
									Dprime();
									L();
									D();
									System.out.print("L' D' L D ");
								}
							}
							if(face == 1){
								if(face2==4){
									Rprime();
									Dprime();
									R();
									D();
									System.out.print("R' D' R D ");
								}
								if(face2 ==5){
									R();
									D();
									Rprime();
									Dprime();
									System.out.print("R D R' D' ");
								}
							}
							
							//Although painful, this is the easiest way to switch the 0th index and the 2nd
							Orientation = (((3-(Orientation-1)))+1)%3;
							for(int x = 0;x<5;x++){
								
								if(Orientation ==0){
									//we already know it's in the correct place
									s.solved();
								}
								if(!s.isSolved()){
									Orientation = (Orientation+1)%3;
									if(face == 2){
										if(face2==4){
											L();
											D();
											Lprime();
											Dprime();
											System.out.print("L D L' D' ");
											L();
											D();
											Lprime();
											Dprime();
											System.out.print("L D L' D' ");
										}
										if(face2 ==5){
											Lprime();
											Dprime();
											L();
											D();
											System.out.print("L' D' L D ");
											Lprime();
											Dprime();
											L();
											D();
											System.out.print("L' D' L D ");
										}
									}
									if(face == 1){
										if(face2==4){
											Rprime();
											Dprime();
											R();
											D();
											System.out.print("R' D' R D ");
											Rprime();
											Dprime();
											R();
											D();
											System.out.print("R' D' R D ");
										}
										if(face2 ==5){
											R();
											D();
											Rprime();
											Dprime();
											System.out.print("R D R' D' ");
											R();
											D();
											Rprime();
											Dprime();
											System.out.print("R D R' D' ");
										}
									}
								}
								
							}
							//now the bottom corners should be solved
						
							
							
						
						}
					}
				}
			}
		}
	}
	private static void cross() {
		Slot piece;
		//Goes through all the edges
		//Finds four edges
		for(int a = 0; a<4;a++){
			int face = 0;
			//Stops itself once it hits a useful edge
			boolean keepGoing = true;
			for(int j = 0;j<edges.size();j++){
				if(keepGoing){
					Slot s = edges.get(j);
					for(int i =0;i< s.getColor().length;i++){
						//finds the edges with white
						//makes sure it's not already solved
						if(s.getCoordinates()[0]==0&&(s.getColor()[1]==cube[1][s.getCoordinates()[1]][s.getCoordinates()[2]].getColor()[0])){
							s.solved();
						}
						if(s.getColor()[i]==6&&!s.isSolved()){
							keepGoing = false;
							//now it shouldn't try solving it again
							s.solved();
							//Start the s in the yellow face-then there are only two different cases
						
								//in all of the ss of Interest, it finds 3 possibilities: its in the
								//white face, in the middle layer, or in the yellow face
								
								//This is if it's in the white face
								if(s.getCoordinates()[0]==0){
									//Now turn it up to the yellow face-first find the other coordinates
									//If its on the L face
									if(s.getCoordinates()[1]==0){
										L2();
										face = 2;
										System.out.print("L2 ");
									}
									//R face
									else if(s.getCoordinates()[1]==2){
										R2();
										face = 1;
										System.out.print("R2 ");
									}
									//F or B?
									else if(s.getCoordinates()[1]==1){
										//F face
										if(s.getCoordinates()[2]==0){
											F2();
											face = 4;
											System.out.print("F2 ");
										}
										//B face
										else if(s.getCoordinates()[2]==2){
											B2();
											face = 5;
											System.out.print("B2 ");
										}
									}
									//Now, any white edges in the white face are now in the yellow face
								}
								//Middle Layer?
								if(s.getCoordinates()[0]==1){
									//L face
									if(s.getCoordinates()[1]==0){
										//F/L edge
										if(s.getCoordinates()[2]==0){
											L();
											Dprime();
											Lprime();
											D();
											face = 2;
											System.out.print("L D' L' D ");
										}
										//B/L face
										else if(s.getCoordinates()[2]==2){
											Lprime();
											Dprime();
											L();
											D();
											face = 2;
											System.out.print("L' D' L D ");
										}
									}
									//R face
									else if(s.getCoordinates()[1]==2){
										//F/R edge
										if(s.getCoordinates()[2]==0){
											Rprime();
											Dprime();
											R();
											D();
											face = 1;
											System.out.print("R' D' R D ");
										}
										else if(s.getCoordinates()[2]==2){
											R();
											Dprime();
											Rprime();
											D();
											face = 1;
											System.out.print("R D' R' D ");
										}
									}
								}
								//Now any edge if the edge was in the middle layer it is now in the yellow face.
								//Now, find orientation, then find the correct secondary face (red, orange, green, or blue), then insert the edge!
								int Orientation = 0;
								if(s.getColor()[0]==6){
									Orientation = 1;
								}
								else if(s.getColor()[1] == 6){
									Orientation=0;
								}
								
								
								//NOTE: The only way to do this is to hard code it, because the pieces don't reload their positions enough	
								//This is, if the center directly above the current edge has the same color as the pieces second color
								if(face ==0){
									//this means it started and ended in the bottom layer, so face was never assigned
									//L face
									
									if(s.getCoordinates()[1]==0){
										face = 2;
									}
									//R face
									else if(s.getCoordinates()[1]==2){
										
										face = 1;
									}
									//F or B face
									else if(s.getCoordinates()[1]==1){
										if(s.getCoordinates()[2]==0){
											face = 4;
										}
										else if(s.getCoordinates()[2]==2){
											face = 5;
										}
									}
								}
								
								if(face ==1){
									if(s.getColor()[Orientation]==1){
										//already in correct spot, just stay there
									}
									else if(s.getColor()[Orientation]==4){
										
										Dprime();
										System.out.print("D' ");
										
									}
									else if(s.getColor()[Orientation]==2){
										D2();
										System.out.print("D2 ");
									}
									else if(s.getColor()[Orientation]==5){
										D();
										System.out.print("D ");
									}
								}
								else if(face ==4){
									if(s.getColor()[Orientation]==1){
										D();
										System.out.print("D ");
										
									}
									else if(s.getColor()[Orientation]==4){
										//correct spot
									}
									else if(s.getColor()[Orientation]==2){
										Dprime();
										System.out.print("D' ");
									}
									else if(s.getColor()[Orientation]==5){
										D2();
										System.out.print("D2 ");
									}
								}
								else if(face ==2){
									if(s.getColor()[Orientation]==1){
										D2();
										System.out.print("D2 ");
									}
									else if(s.getColor()[Orientation]==4){
										D();
										System.out.print("D ");
										
									}
									else if(s.getColor()[Orientation]==2){
										//correct spot
									}
									else if(s.getColor()[Orientation]==5){
										Dprime();
										System.out.print("D' ");
										
									}
								}
								else if(face ==5){
									if(s.getColor()[Orientation]==1){
										Dprime();
										System.out.print("D' ");
									}
									else if(s.getColor()[Orientation]==4){
										D2();
										System.out.print("D2 ");
									}
									else if(s.getColor()[Orientation]==2){
										D();
										System.out.print("D ");
										
										
									}
									else if(s.getColor()[Orientation]==5){
										//correct spot
									}
								}
								//After finding the correct face:
								
								//because it's essentially the same thing, I will copy/paste the code from before:
								//L face
								if(s.getColor()[Orientation]==2){
									//if the secondary color is NOT on the yellow face
									if(Orientation==1){
										L2();
										System.out.print("L2 ");
									}
									//but if it is...
									else if(Orientation == 0){
										//quick trigger to get the s in the correct way
										Lprime();
										Uprime();
										F();
										U();
										System.out.print("L' U' F U ");
									}
								}
								//R face
								else if(s.getColor()[Orientation]==1){
									if(Orientation==1){
										R2();
										System.out.print("R2 ");
									}
									else if(Orientation ==0){
										R();
										U();
										Fprime();
										Uprime();
										System.out.print("R U F' U' ");
									}
								}
							
								else if(s.getColor()[Orientation]==4){
									//F face
									if(Orientation==1){
										F2();
										System.out.print("F2 ");
									}
									else if(Orientation ==0){
										Fprime();
										Uprime();
										R();
										U();
										System.out.print("F' U' R U ");
									}
								}
									//B face
								else if(s.getColor()[Orientation]==5){
									if(Orientation==1){
										B2();
										System.out.print("B2 ");
									}
									else if(Orientation ==0){
										Bprime();
										Uprime();
										L();
										U();
										System.out.print("B' U' L U ");
									}
								}
							
								
								//At this point, theoretically the cross should be done *crossing fingers
							
						}
					}
				}
			}
		}
		
		
	}
	private static void scramble() {
		String move = "";
		while(s.hasNext()){
			move = s.next();
			switch(move){
				case "R":
					R();
					break;
				case "R'":
					Rprime();
					break;
				case "R2":
					R2();
					break;
				case "L":
					L();
					break;
				case "L'":
					Lprime();
					break;
				case "L2":
					L2();
					break;
				case "F":
					F();
					break;
				case "F'":
					Fprime();
					break;
				case "F2":
					F2();
					break;
				case "B":
					B();
					break;
				case "B'":
					Bprime();
					break;
				case "B2":
					B2();
					break;
				case "U":
					U();
					break;
				case "U'":
					Uprime();
					break;
				case "U2":
					U2();
					break;
				case "D":
					D();
					break;
				case "D'":
					Dprime();
					break;
				case "D2":
					D2();
					break;
				default:
					System.err.println("Invalid Scramble - "+move);
			}
			System.out.print(move+" ");
		}
		System.out.println();
		
	}
	private static void D() {
		//Yeah, I get it. I'm lazy
		Dprime();
		Dprime();
		Dprime();
		
	}
	private static void D2(){
		Dprime();
		Dprime();
		
	}
	private static void Dprime() {
		Slot tempCor = new Slot(cube[2][0][0]);
		Slot tempEdge = new Slot(cube[2][0][1]);
		cube[2][0][0] = new Slot(swap(cube[2][2][0].getColor(),1,2),0,cube[2][0][0].getCoordinates());
		cube[2][2][0] = new Slot(swap(cube[2][2][2].getColor(),1,2),0,cube[2][2][0].getCoordinates());
		cube[2][2][2] = new Slot(swap(cube[2][0][2].getColor(),1,2),0,cube[2][2][2].getCoordinates());
		cube[2][0][2] = new Slot(swap(tempCor.getColor(),1,2),0,cube[2][0][2].getCoordinates());
		cube[2][0][2].setOrientation(0);
		cube[2][0][1] = new Slot(cube[2][1][0].getColor(),0,cube[2][0][1].getCoordinates());
		cube[2][1][0] = new Slot(cube[2][2][1].getColor(),0,cube[2][1][0].getCoordinates());
		cube[2][2][1] = new Slot(cube[2][1][2].getColor(),0,cube[2][2][1].getCoordinates());
		cube[2][1][2] = new Slot(tempEdge.getColor(),0,cube[2][1][2].getCoordinates());
		
		draw();
		refreshList();
		
	}
	
	private static void Uprime() {
		U();
		U();
		U();
		
	}
	private static void U2() {
		U();
		U();
		
	}
	private static void U() {
		
		Slot tempCor = new Slot(cube[0][0][0]);
		Slot tempEdge = new Slot(cube[0][0][1]);
		cube[0][0][0] = new Slot(swap(cube[0][2][0].getColor(),1,2),0,cube[0][0][0].getCoordinates());
		cube[0][2][0] = new Slot(swap(cube[0][2][2].getColor(),1,2),0,cube[0][2][0].getCoordinates());
		cube[0][2][2] = new Slot(swap(cube[0][0][2].getColor(),1,2),0,cube[0][2][2].getCoordinates());
		cube[0][0][2] = new Slot(swap(tempCor.getColor(),1,2),0,cube[0][0][2].getCoordinates());
		cube[0][0][2].setOrientation(0);
		cube[0][0][1] = new Slot(cube[0][1][0].getColor(),0,cube[0][0][1].getCoordinates());
		cube[0][1][0] = new Slot(cube[0][2][1].getColor(),0,cube[0][1][0].getCoordinates());
		cube[0][2][1] = new Slot(cube[0][1][2].getColor(),0,cube[0][2][1].getCoordinates());
		cube[0][1][2] = new Slot(tempEdge.getColor(),0,cube[0][1][2].getCoordinates());
		
		draw();
		refreshList();
	}
	
	private static void Bprime() {
		B();B();B();
		
	}
	private static void B2() {
		B();
		B();
		
	}
	private static void B() {
		Slot tempCor = new Slot(cube[0][0][2]);
		Slot tempEdge = new Slot(cube[0][1][2]);
		tempCor.setOrientation(cube[0][0][2].getOrientation());
		tempEdge.setOrientation(cube[0][1][2].getOrientation());
		//All of these need their coordinates for the solving process
		cube[0][0][2] = new Slot(swap(cube[0][2][2].getColor(),0,2),0,cube[0][0][2].getCoordinates());
		cube[0][2][2] = new Slot(swap(cube[2][2][2].getColor(),0,2),0,cube[0][2][2].getCoordinates());
		cube[2][2][2] = new Slot(swap(cube[2][0][2].getColor(),0,2),0, cube[2][2][2].getCoordinates());
		cube[2][0][2] = new Slot(swap(tempCor.getColor(),0,2),0,cube[2][0][2].getCoordinates());
		
		cube[0][1][2] = new Slot(swap(cube[1][2][2].getColor(),0,1),0,cube[0][1][2].getCoordinates());
		cube[1][2][2] = new Slot(swap(cube[2][1][2].getColor(),0,1),0,cube[1][2][2].getCoordinates());
		cube[2][1][2] = new Slot(swap(cube[1][0][2].getColor(),0,1),0,cube[2][1][2].getCoordinates());
		cube[1][0][2] = new Slot(swap(tempEdge.getColor(),0,1),0,cube[1][0][2].getCoordinates());
		draw();
		refreshList();
		
	}
	private static void F() {
		Fprime();Fprime();Fprime();
		
	}
	private static void F2() {
		F();
		F();
		
	}
	private static void Fprime() {
		Slot tempCor = new Slot(cube[0][0][0]);
		Slot tempEdge = new Slot(cube[0][1][0]);
		tempCor.setOrientation(cube[0][0][0].getOrientation());
		tempEdge.setOrientation(cube[0][1][0].getOrientation());
		cube[0][0][0] = new Slot(swap(cube[0][2][0].getColor(),0,2),0,cube[0][0][0].getCoordinates());
		cube[0][2][0] = new Slot(swap(cube[2][2][0].getColor(),0,2),0,cube[0][2][0].getCoordinates());
		cube[2][2][0] = new Slot(swap(cube[2][0][0].getColor(),0,2),0,cube[2][2][0].getCoordinates());
		cube[2][0][0] = new Slot(swap(tempCor.getColor(),0,2),0,cube[2][0][0].getCoordinates());
		
		cube[0][1][0] = new Slot(swap(cube[1][2][0].getColor(),0,1),0,cube[0][1][0].getCoordinates());
		cube[1][2][0] = new Slot(swap(cube[2][1][0].getColor(),0,1),0,cube[1][2][0].getCoordinates());
		cube[2][1][0] = new Slot(swap(cube[1][0][0].getColor(),0,1),0,cube[2][1][0].getCoordinates());
		cube[1][0][0] = new Slot(swap(tempEdge.getColor(),0,1),0,cube[1][0][0].getCoordinates());
		draw();
		refreshList();
		
	}
	private static void Lprime() {
		L();L();L();
		
	}
	private static void L2() {
		L();
		L();
		
	}
	private static void L() {
		Slot tempCor = new Slot(cube[0][0][0]);
		Slot tempEdge = new Slot(cube[1][0][0]);
		tempCor.setOrientation(cube[0][0][0].getOrientation());
		tempEdge.setOrientation(cube[1][0][0].getOrientation());
		cube[0][0][0] = new Slot(swap(cube[0][0][2].getColor(),0,1),0,cube[0][0][0].getCoordinates());
		cube[0][0][2] = new Slot(swap(cube[2][0][2].getColor(),0,1),0,cube[0][0][2].getCoordinates());
		cube[2][0][2] = new Slot(swap(cube[2][0][0].getColor(),0,1),0,cube[2][0][2].getCoordinates());
		cube[2][0][0] = new Slot(swap(tempCor.getColor(),0,1),0,cube[2][0][0].getCoordinates());
		
		cube[1][0][0] = new Slot((cube[0][0][1].getColor()),0,cube[1][0][0].getCoordinates());
		cube[0][0][1] = new Slot((cube[1][0][2].getColor()),0,cube[0][0][1].getCoordinates());
		cube[1][0][2] = new Slot(cube[2][0][1].getColor(),0,cube[1][0][2].getCoordinates());
		cube[2][0][1] = new Slot(tempEdge.getColor(),0,cube[2][0][1].getCoordinates());
		draw();
		refreshList();
	}
	private static void R() {
		Rprime();Rprime();Rprime();
		
	}
	private static void R2() {
		Rprime();
		Rprime();
	
	}
	private static void Rprime() {
		Slot tempCor = new Slot(cube[0][2][0]);
		Slot tempEdge = new Slot(cube[1][2][0]);
		tempCor.setOrientation(cube[0][2][0].getOrientation());
		tempEdge.setOrientation(cube[1][2][0].getOrientation());
		cube[0][2][0] = new Slot(swap(cube[0][2][2].getColor(),0,1),0,cube[0][2][0].getCoordinates());
		cube[0][2][2] = new Slot(swap(cube[2][2][2].getColor(),0,1),0,cube[0][2][2].getCoordinates());
		cube[2][2][2] = new Slot(swap(cube[2][2][0].getColor(),0,1),0,cube[2][2][2].getCoordinates());
		cube[2][2][0] = new Slot(swap(tempCor.getColor(),0,1),0,cube[2][2][0].getCoordinates());
		cube[0][2][0].setOrientation(0);
		cube[1][2][0] = new Slot((cube[0][2][1].getColor()),0,cube[1][2][0].getCoordinates());
		cube[0][2][1] = new Slot((cube[1][2][2].getColor()),0,cube[0][2][1].getCoordinates());
		cube[1][2][2] = new Slot(cube[2][2][1].getColor(),0,cube[1][2][2].getCoordinates());
		cube[2][2][1] = new Slot(tempEdge.getColor(),0,cube[2][2][1].getCoordinates());
		
		draw();
		refreshList();
	}
	private static void draw() {
		
		//This way we know at least one of the coordinate values for each slot
		//therefore, it is much easier to convert 3D models into 2D drawings
		drawTop();//assured that c = 0
		drawBottom();//assured that c = 2
		drawFront();//assured that l = 0
		drawBack();//assured that l = 2
		drawLeft();//assured that r=0
		drawRight();//assured that r = 2
		Window.frame(10);
		
		
	}
	/**Both left and right faces are ALWAYS last in priority
	 * So, for the Up and Down faces, we can just go with the orientation index
	 * but for left and right, we can go with 
	 * (orientation+s.getColor().length-1)%s.getColor().length
	 * to go either back one in the array to get the color from orientation,
	 * or to go +2 for corners or +1 for edges.
	 */
	private static void drawLeft() {
		int x = 45;
		int y = 335;
		Slot s;
		for(int c = 0; c<3;c++){
			for(int l = 0;l<3;l++){
				s = cube[c][0][l];
				//Because of the math behind it, these if statements are monstrosities.
				//To future me or to other coders I may show this to, basically it goes to the orientation index, 
				//and travels forward in the
				//array by the array's length -1 to get to the value
				//which is last in priority
				//we know right and left are last, so these are always last and never in priority, except for centers.
				//Just to protect from out of bounds exceptions, we use modulus of the array's length to wrap back around
				//for example, {6,4,1} where 4 is the orientation, that means 6 is on the left or right side,
				//we go forward by two, which is out of bounds but wraps back around to index = 0, value = 6
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==1){
					Window.out.color("Red");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==2){
					Window.out.color("Orange");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==3){
					Window.out.color("Yellow");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==4){
					Window.out.color("Green");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==5){
					Window.out.color("Blue");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==6){
					Window.out.color("White");
				}
				
				Window.out.square(x+95*(2-l), y+95*c, 90);
				//while in the up and down face, l is used in the y value, here it is the x
				//because of how the cube unfolds. If you imagine it in you mind, you will see why depth
				//becomes the determinant of x
			}
		}
		
	}
	private static void drawRight() {
		//Assured that r = 2
		int x = 645;
		int y = 335;
		Slot s;
		for(int c = 0; c<3;c++){
			for(int l = 2;l>=0;l--){
				s = cube[c][2][l];
				//Because of the math behind it, these if statements are monstrosities.
				//To future me or to other coders I may show this to, basically it goes to the orientation index, 
				//and travels forward in the
				//array by the array's length -1 to get to the value
				//which is last in priority
				//we know right and left are last, so these are always last and never in priority, except for centers.
				//Just to protect from out of bounds exceptions, we use modulus of the array's length to wrap back around
				//for example, {6,4,1} where 4 is the orientation, that means 6 is on the left or right side,
				//we go forward by two, which is out of bounds but wraps back around to index = 0, value = 6
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==1){
					Window.out.color("Red");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==2){
					Window.out.color("Orange");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==3){
					Window.out.color("Yellow");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==4){
					Window.out.color("Green");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==5){
					Window.out.color("Blue");
				}
				if(s.getColor()[(s.getOrientation()+s.getColor().length-1)%s.getColor().length]==6){
					Window.out.color("White");
				}
				
				Window.out.square(x+95*l, y+95*c, 90);
				//while in the up and down face, l is used in the y value, here it is the x
				//because of how the cube unfolds. If you imagine it in you mind, you will see why depth
				//becomes the determinant of x
			}
		}
	}
	private static void drawBack() {
		int x = 945;
		int y = 335;
		Slot s;
		//Top Row of Back face
		for(int r = 0; r<3;r++){
			s = cube[0][r][2];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[(s.getOrientation()+1)%3]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==6){
				Window.out.color("White");
			}	
			
			Window.out.square(x+95*(2-r), y, 90);
		}
		//Middle Layer of Back face
		for(int r = 0; r<3;r++){
			s = cube[1][r][2];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[s.getOrientation()]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[s.getOrientation()]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[s.getOrientation()]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[s.getOrientation()]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[s.getOrientation()]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[s.getOrientation()]==6){
				Window.out.color("White");
			}	
			
			Window.out.square(x+95*(2-r), y+95, 90);
		}
		//Bottom layer of Back face
		for(int r = 0; r<3;r++){
			s = cube[2][r][2];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[(s.getOrientation()+1)%3]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==6){
				Window.out.color("White");
			}	
			Window.out.square(x+95*(2-r), y+95*2, 90);
		}
		
	}
	private static void drawFront() {
		int x = 345;
		int y = 335;
		Slot s;
		//Top Row of Front face
		for(int r = 0; r<3;r++){
			s = cube[0][r][0];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[(s.getOrientation()+1)%3]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==6){
				Window.out.color("White");
			}	
			
			Window.out.square(x+95*r, y, 90);
		}
		//Middle Layer of Front face
		for(int r = 0; r<3;r++){
			s = cube[1][r][0];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[s.getOrientation()]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[s.getOrientation()]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[s.getOrientation()]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[s.getOrientation()]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[s.getOrientation()]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[s.getOrientation()]==6){
				Window.out.color("White");
			}	
			
			Window.out.square(x+95*r, y+95, 90);
		}
		//Bottom layer of front face
		for(int r = 0; r<3;r++){
			s = cube[2][r][0];
			//No switch case because I'm bad at them, and they have a high risk of 
			//screwing with everything. So, just a bunch of if statements
			if(s.getColor()[(s.getOrientation()+1)%3]==1){
				Window.out.color("Red");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==2){
				Window.out.color("Orange");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==3){
				Window.out.color("Yellow");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==4){
				Window.out.color("Green");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==5){
				Window.out.color("Blue");
			}
			if(s.getColor()[(s.getOrientation()+1)%3]==6){
				Window.out.color("White");
			}	
			Window.out.square(x+95*r, y+95*2, 90);
		}
			
	}
	private static void drawBottom() {
		int x = 345;
		int y = 620;
		Slot s;
		for(int r = 0; r<3;r++){
			for(int l = 2;l>=0;l--){
				s = cube[2][r][l];
				//No switch case because I'm bad at them, and they have a high risk of 
				//screwing with everything. So, just a bunch of if statements
				if(s.getColor()[s.getOrientation()]==1){
					Window.out.color("Red");
				}
				if(s.getColor()[s.getOrientation()]==2){
					Window.out.color("Orange");
				}
				if(s.getColor()[s.getOrientation()]==3){
					Window.out.color("Yellow");
				}
				if(s.getColor()[s.getOrientation()]==4){
					Window.out.color("Green");
				}
				if(s.getColor()[s.getOrientation()]==5){
					Window.out.color("Blue");
				}
				if(s.getColor()[s.getOrientation()]==6){
					Window.out.color("White");
				}
				
				Window.out.square(x+95*r, y+95*l, 90);
			}
		}
		
	}
	private static void drawTop() {
		int x = 345;
		int y = 50;
		Slot s;
		for(int r = 0; r<3;r++){
			for(int l = 2;l>=0;l--){
				s = cube[0][r][l];
				//No switch case because I'm bad at them, and they have a high risk of 
				//screwing with everything. So, just a bunch of if statements
				if(s.getColor()[s.getOrientation()]==1){
					Window.out.color("Red");
				}
				if(s.getColor()[s.getOrientation()]==2){
					Window.out.color("Orange");
				}
				if(s.getColor()[s.getOrientation()]==3){
					Window.out.color("Yellow");
				}
				if(s.getColor()[s.getOrientation()]==4){
					Window.out.color("Green");
				}
				if(s.getColor()[s.getOrientation()]==5){
					Window.out.color("Blue");
				}
				if(s.getColor()[s.getOrientation()]==6){
					Window.out.color("White");
				}
				
				Window.out.square(x+95*r, y+95*(2-l), 90);
			}
		}
		
	}
	//Start the cube in a solved position, ready to be scrambled
	private static void start() {
		//Easiest way is to hard code it
		//First Layers, then rows, then columns
		//Set the temporary value then make a new slot object with that value/piece
		
		//When choosing an orientation, priority to Top/Bottom color, 
		//and for edges in the middle layer,
		//Choose Front/Back color
		/** 1 = red
		 * 2 = orange
		 * 3 = yellow
		 * 4=green
		 * 5=blue
		 * 6=white
		 */
		//Front Top Left Corner
		int[] tempCor = {6,4,1};
		cube[0][0][0] = new Slot(6,4,2,0,0,0,0);
		corners.add(cube[0][0][0]);
		//Top Left Edge
		int[] tempEdge = {6,1};
		cube[0][0][1] = new Slot(6,2,0,0,0,1);
		edges.add(cube[0][0][1]);
		//Back Top Left Corner
		tempCor[1]= 5;
		cube[0][0][2] = new Slot(6,5,2,0,0,0,2);
		corners.add(cube[0][0][2]);
		//Front Top Edge
		tempEdge[1] = 4;
		cube[0][1][0] = new Slot(6,4,0,0,1,0);
		edges.add(cube[0][1][0]);
		//Top Center
		int[] tempCent = {6};
		cube[0][1][1] = new Slot(6,0,0,1,1);
		centers.add(cube[0][1][1]);
		//Back Top Edge
		tempEdge[1] = 5;
		cube[0][1][2] = new Slot(6,5,0,0,1,2);
		edges.add(cube[0][1][2]);
		//Front Top Right corner
		tempCor[1]= 4;
		tempCor[2]=2;
		cube[0][2][0] = new Slot(6,4,1,0,0,2,0);
		corners.add(cube[0][2][0]);
		//Top Right Edge
		tempEdge[1] = 2;
		cube[0][2][1] = new Slot(6,1,0,0,2,1);
		edges.add(cube[0][2][1]);
		//Back Top Right Corner
		tempCor[1]= 5;
		cube[0][2][2] = new Slot(6,5,1,0,0,2,2);
		corners.add(cube[0][2][2]);
		
		//At this point the Top layer, or the white side, is complete
		
		//Front Left Edge
		tempEdge[0] = 4;
		tempEdge[1]=1;//Because this is a middle layer edge, the new orientation and 
		//variable naming has priority toward the front(green) face
		cube[1][0][0] = new Slot(4,2,0,1,0,0);
		edges.add(cube[1][0][0]);
		//Left Center 
		tempCent[0]=1;
		cube[1][0][1] = new Slot(2,0,1,0,1);//The only piece other than right center
		//that has only a right or left color-orientation just states its one color
		centers.add(cube[1][0][1]);
		//Back Left Edge
		tempEdge[0] = 5;
		cube[1][0][2] = new Slot(5,2,0,1,0,2);
		edges.add(cube[1][0][2]);
		//Front Center
		tempCent[0]=4;
		cube[1][1][0] = new Slot(4,0,1,1,0);
		centers.add(cube[1][1][0]);
		//Core
		//Nothing Here!
		
		//Back Center
		tempCent[0]=5;
		cube[1][1][2] = new Slot(5,0,1,1,2);
		centers.add(cube[1][1][2]);
		//Front Right Edge
		tempEdge[0] = 4;
		tempEdge[1]=2;
		cube[1][2][0] = new Slot(4,1,0,1,2,0);
		edges.add(cube[1][2][0]);
		//Right Center
		tempCent[0]=2;
		cube[1][2][1] = new Slot(1,0,1,2,1);
		centers.add(cube[1][2][1]);
		//Back Right Edge
		tempEdge[0] = 5;
		cube[1][2][2] = new Slot(5,1,0,1,2,2);
		edges.add(cube[1][2][2]);
		
		//Now the Middle Layer is complete
		
		//Front Bottom Left Corner
		tempCor[0]= 3;
		tempCor[1]= 4;
		tempCor[2]= 1;
		cube[2][0][0] = new Slot(3,4,2,0,2,0,0);
		corners.add(cube[2][0][0]);
		//Bottom Left Edge
		tempEdge[0] = 3;
		tempEdge[1]=1;
		cube[2][0][1] = new Slot(3,2,0,2,0,1);
		edges.add(cube[2][0][1]);
		//Back Bottom Left Corner
		tempCor[1]= 5;
		cube[2][0][2] = new Slot(3,5,2,0,2,0,2);
		corners.add(cube[2][0][2]);
		//Bottom Front Edge
		tempEdge[1]=5;
		cube[2][1][0] = new Slot(3,4,0,2,1,0);
		edges.add(cube[2][1][0]);
		//Bottom Center
		tempCent[0]=3;
		cube[2][1][1] = new Slot(3,0,2,1,1);
		centers.add(cube[2][1][1]);
		//Bottom Back Edge
		tempEdge[1]=4;
		cube[2][1][2] = new Slot(3,5,0,2,1,2);
		edges.add(cube[2][1][2]);
		//Front Bottom Right Corner
		tempCor[1]= 5;
		tempCor[2]= 2;
		cube[2][2][0] = new Slot(3,4,1,0,2,2,0);
		corners.add(cube[2][2][0]);
		//Bottom Right Edge
		tempEdge[1]=2;
		cube[2][2][1] = new Slot(3,1,0,2,2,1);
		edges.add(cube[2][2][1]);
		//Back Bottom Right Corner
		tempCor[1]= 5;
		cube[2][2][2] = new Slot(3,5,1,0,2,2,2);
		corners.add(cube[2][2][2]);
		//Finally, the cube is intialized to the solved position!
	}
	//after every turn, this allows the lists to have all of the current corners and edges, but centers can't change, so no need to reload that
	private static void refreshList() {
		//clear all the corners
		while(!corners.isEmpty()){
			corners.remove(0);
		}
		//clear all the edges
		while(!edges.isEmpty()){
			edges.remove(0);
		}
		//Cycle through all the positions
		for(int c = 0; c<3;c++){
			for(int r = 0; r<3;r++){
				for(int l = 0; l<3;l++){
					//If all three coordinates are an extreme, it's a corner
					if((r==0||r==2)&&(c==0||c==2)&&(l==0||l==2)){
						corners.add(cube[c][r][l]);
					}
					//else if two are extremes and one is 1, it's an edge
					if(((r==0||r==2)&&(c==0||c==2)&&(l ==1))||((r==1)&&(c==0||c==2)&&(l==0||l==2))||((r==0||r==2)&&(c==1)&&(l==0||l==2))){
						edges.add(cube[c][r][l]);
					}
				}
			}
		}
		
	}
	
	
	private static int[] swap(int[] data, int i, int j) {
		int x = data[i];
		data[i]=data[j];
		data[j]=x;
		return data;
		
	}

}