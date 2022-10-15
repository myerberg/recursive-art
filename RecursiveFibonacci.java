/*
Tyler Myerberg
Created: 4.10.22
Updated: 4.12.22

Description: The Fibonacci sequence and golden ratio are mathematical mysteries built into the fundamentals of the universe.
Aesthetically, I wanted to capture the essence of the cosmos, with obelisk-like golden triangles reminiscent of 2001: A Space Odyssey juxtaposed against a black hole and twinkling stars.
At higher n values for the recursive call, the golden ratio known as phi is more accurately approximated by the ratios of consecutive Fibonacci terms, calculated using a for loop.
Phi is incorporated into the visual structure of the program, where the long sides of the golden triangles used are equal to phi times the base.

*/


//import Scanner
import java.util.Scanner;

//import Canvas
import java.awt.Canvas;

//import Color
import java.awt.Color;

//import Graphics
import java.awt.Graphics;

//import JFrame
import javax.swing.JFrame;

//being RecursiveFibonacci class with Canvas extension
public class RecursiveFibonacci extends Canvas {
	
	//being main method
    public static void main(String[] args) {
    	
    	//creates JFrame instance for Recursive Fibonacci drawing
        JFrame frame = new JFrame("Recursive Fibonacci");
        
        //necessary close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instance of Canvas
        Canvas canvas = new RecursiveFibonacci();
        
        //sets canvas size at 480 by 960
        canvas.setSize(480, 960);
        
        //adds canvas to frame
        frame.add(canvas);
        
        //pack method for frame
        frame.pack();
        
        //makes frame visible
        frame.setVisible(true);
    
    //closes main method
    }
    
    //begins paint method
    public void paint(Graphics g) {
    	
    	//instance of Scanner
    	Scanner input = new Scanner(System.in);
    	
    	//placeholder for count
    	int count = 0;
    	
    	//tells user to enter an n value
    	System.out.println("Please enter a positive integer value for n, representing the quantity of Fibonacci terms used for approximating the Golden Ratio.\nThe higher your value for n, the better the approximation of phi used for calculations within the recursion.");

    	//sets count equal to user input		
    	count = input.nextInt();
    	
    	//placeholder for phi
    	double phi = 1;
    	
    	//starting value for sum1
    	int sum1 = 0;
    	
    	//starting value for sum2
    	int sum2 = 1;
    	
    	//placeholder for sequence
    	int sequence = 0;
    	
    	//sets seqCount equal to count to allow for loop to run properly
    	int seqCount = count;
    	
    		//for loop to calculate phi approximation
	    	for(int i = 0; i < seqCount; i++) {
	    		
	    		//adds consecutive Fibonacci values to creates sequence value that will be used for phi calculation
	    		sequence = sum1 + sum2;

		    		//phi is represented by the ratio of the quantity of sum1 plus sum2 divided by sum2
		    		phi = ((double)sequence)/((double)sum2);

		    	//resets sum1 to equal sum2
	    		sum1 = sum2;
	    		
	    		//resets sum2 to equal sequence
	    		sum2 = sequence;

	    	//closes for loop	
	    	}
    	
	    //displays approximated phi value to user
    	System.out.println("Your phi value is approximated as: " + phi + ".");
    	
    	//sets color of background rectangle to a dark blue
    	//to find color values: https://www.rapidtables.com/web/color/RGB_Color.html
    	g.setColor(new Color(9, 0, 129, 255));
    	
    	//first x coordinate for initial golden triangle
    	double x1_Initial = 1;
    	
    	//second x coordinate for initial golden triangle
    	double x2_Initial = 240;
    	
    	//third x coordinate for initial golden triangle
    	double x3_Initial = 480;
    	
    	//first y coordinate for initial golden triangle
    	double y1_Initial = 1;
    	
    	//second y coordinate for initial golden triangle
    	double y2_Initial = phi*480;
		
    	//integer array for x values of background rectangle, using triangle coordinates that will be sent as parameters through the recursion
        int [] xRect = {(int)x1_Initial, (int)x3_Initial, (int)x3_Initial, (int)x1_Initial};
        
    	//integer array for x values of background rectangle, using triangle coordinates that will be sent as parameters through the recursion
        int [] yRect = {(int)y1_Initial, (int)y1_Initial, (int)y2_Initial, (int)y2_Initial};
        
        //draws background rectangle using above integer arrays
        g.fillPolygon(xRect, yRect, 4);
    	
    	//sets color of background oval to black
    	g.setColor(Color.black);
        
    	//creates background oval
        g.fillOval((int)x1_Initial, 3*((int)y2_Initial)/8, (int)x3_Initial, (int)x3_Initial);
    	
        //sends initial coordinates of first triangle to recursion method for manipulation, also sends count
    	recursion(g, phi, count, ((int)x1_Initial + (int)x3_Initial) / 2, ((int)x1_Initial + (int)x2_Initial) / 2, ((int)x1_Initial + (int)x3_Initial) / 2 + ((int)x1_Initial + (int)x2_Initial) / 2, (int)y1_Initial, ((int)y1_Initial + (int)y2_Initial) / 2, ((int)y1_Initial + (int)y2_Initial) / 2);
    
    //closes paint method
    }
    
    //begins recursion method with manipulated parameters for new triangle coordinates (parameters are manipulated within the call to the method)
    public void recursion(Graphics g, double phi, int count, int x1_Initial, int x2_Initial, int x3_Initial, int y1_Initial, int y2_Initial, int y3_Initial) {
    	
    	//continues the recursive call until count equals 1
    	if(count > 1) {
    		
        	//sets x1 to imported x1_Initial parameter
        	int x1 = x1_Initial;
        	
        	//sets x2 to imported x2_Initial parameter
        	int x2 = x2_Initial;
        	
        	//sets x3 to imported x3_Initial parameter
        	int x3 = x3_Initial;
        	
        	//sets y1 to imported y1_Initial parameter
        	int y1 = y1_Initial;
        	
        	//sets y2 to imported y2_Initial parameter
        	int y2 = y2_Initial;
        	
        	//sets y3 to imported y3_Initial parameter
        	int y3 = y3_Initial;

        		//if count equals 2
		    	if(count == 2) {
		    	
		    		//set color to white
		    		g.setColor(Color.white);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 3
		    	else if(count == 3) {
		    		
		    		//set color to black
		    		g.setColor(Color.black);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 4
		    	else if(count == 4) {
		    		
		    		//set color to a light blue
		    		g.setColor(new Color(159, 227, 255, 255));
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 5
		    	else if(count == 5) {
		    		
		    		//set color to a different shade of dark blue
		    		g.setColor(new Color(17, 31, 124, 255));
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 6
		    	else if(count == 6) {
		    		
		    		//set color to a medium blue
		    		g.setColor(new Color(36, 125, 242, 255));
		    		
		    	//closes if statement
		    	}
		    	
		    		//integer array for x coordinates of new triangle
		    		int [] xTriangle = {x1, x2, x3};
        
		    		//integer array for y coordinates of new triangle
		    		int [] yTriangle = {y1, y2, y3};
    	
		    		//draws new triangle using above integer arrays
		    		g.fillPolygon(xTriangle, yTriangle, 3);		    		
    	
		    			//decreases count by 1 before recursive calls
		    			count--;

		    				//creates golden triangles internally alternating 180 degrees
		    				recursion(g, phi, count, x1, (x1+x2)/2, (x1+x3)/2, y2, (int)((y1 + y2) / 2), (int)((y1 + y3) / 2));
		    				
		    				//sends golden triangles to the left (and slightly upward)
		    				recursion(g, phi, count, x1/2, (x1+x2)/4, (x1+x3)/4, y2/2, (int)((y1 + y2) / 4), (int)((y1 + y3) / 4));
		    				
		    				//sends golden triangles to the right (and slightly upward)
		    				recursion(g, phi, count, 480 - x1/2, 480 - (x1+x2)/4, 480 - (x1+x3)/4, y2/2, (int)((y1 + y2) / 4), (int)((y1 + y3) / 4));
		    				
		    				//alternates vertical position of golden triangles
		    				recursion(g, phi, count, x1, (x1+x2)/2, (x1+x3)/2, (int)(480*phi) - y2, (int)(480*phi) - (int)((y1 + y2) / 2), (int)(480*phi) - (int)((y1 + y3) / 2));
		    				
		//closes if statement for count being above 1
    	}

    //closes recursion method
    }
    
//closes class
}