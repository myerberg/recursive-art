/*
Tyler Myerberg
Created: 4.7.22
Updated: 4.12.22

Description: Creates a colorful recursive triangle structure.
Three recursive calls are used to build three smaller triangles from the previous triangle (half its size).
These new triangles are placed to the left, to the right, and below the larger one.
A second recursion method builds smaller triangles within the center when the value of count equals an odd number.
Three recursive calls place these new triangles to the left, to the right, and above the larger one.

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

//being RecursiveTriangles class with Canvas extension
public class RecursiveTriangles extends Canvas {
	
	//being main method
    public static void main(String[] args) {
    	
    	//creates JFrame instance for Recursive Triangles drawing
        JFrame frame = new JFrame("Recursive Triangles");
        
        //necessary close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instance of Canvas
        Canvas canvas = new RecursiveTriangles();
        
        //sets canvas size at 640 by 640
        canvas.setSize(640, 640);
        
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
    	System.out.println("Please enter an integer value for n, the number of levels for the triangle recursion.");

    	//sets count equal to user input		
    	count = input.nextInt();
    	
    	//sets color of background triangle to black
    	g.setColor(Color.black);
    	
    	//first x coordinate for background triangle
    	int x1_Initial = 1;
    	
    	//second x coordinate for background triangle
    	int x2_Initial = 320;
    	
    	//third x coordinate for background triangle
    	int x3_Initial = 640;
    	
    	//first y coordinate for background triangle
    	int y1_Initial = 1;
    	
    	//second y coordinate for background triangle
    	int y2_Initial = 640;
    	
    	//third y coordinate for background triangle
    	int y3_Initial = 1;
		
    	//integer array for x values of background triangle
        int [] x = {x1_Initial, x2_Initial, x3_Initial};
        
        //integer array for y values of background triangle
        int [] y = {y1_Initial, y2_Initial, y3_Initial};
        
        //draws background triangle using above integer arrays
        g.fillPolygon(x, y, 3);
        
        //sets base length of current triangle to largest x value
        int base = x3_Initial;
        
        //changes color to orange
        g.setColor(Color.orange);
    	
        //sends initial coordinates of first triangle to recursion method for manipulation, also sends count and base divided by 2
    	recursion(g, count, base/2, (x1_Initial + x3_Initial) / 2, (x1_Initial + x2_Initial) / 2, (x1_Initial + x3_Initial) / 2 + (x1_Initial + x2_Initial) / 2, y1_Initial, (y1_Initial + y2_Initial) / 2, (y1_Initial + y2_Initial) / 2);

        //sends initial coordinates of first triangle to recursion method for manipulation, also sends count and base divided by 2
       	recursion2(g, count, base/4, (x3_Initial/8) * 3, x2_Initial, x3_Initial - ((x3_Initial/8) * 3), y2_Initial / 4, y2_Initial / 2, y2_Initial / 4);
    	
    //closes paint method
    }
    
    //begins recursion method with manipulated parameters for new triangle coordinates (parameters are manipulated within the call to the method)
    public void recursion(Graphics g, int count, int base, int x1_Initial, int x2_Initial, int x3_Initial, int y1_Initial, int y2_Initial, int y3_Initial) {
    	
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
		    	
		    		//set color to gray
		    		g.setColor(Color.gray);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 3
		    	else if(count == 3) {
		    		
		    		//set color to white
		    		g.setColor(Color.white);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 4
		    	else if(count == 4) {
		    		
		    		//set color to red
		    		g.setColor(Color.red);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 5
		    	else if(count == 5) {
		    		
		    		//set color to cyan
		    		g.setColor(Color.cyan);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 6
		    	else if(count == 6) {
		    		
		    		//set color to blue
		    		g.setColor(Color.blue);
		    		
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

		    			//divides base by 2 before recursive calls
		    			base = base / 2;
    	
		    				//recursive call for triangle to the left with appropriate arithmetic to adjust x and y coordinates
		    				recursion(g, count, base, x1 - base, x2 - base/2, x3 - base - base/2, y1, ((y1 + y2) / 2), ((y1 + y2) / 2));
    	
		    				//recursive call for triangle to the right with appropriate arithmetic to adjust x and y coordinates
		    				recursion(g, count, base, (base) + x1, base + (base/2) + x2, (base/2) + x3, y1, ((y1 + y2) / 2), ((y1 + y2) / 2));

		    				//recursive call for triangle below with appropriate arithmetic to adjust x and y coordinates
		    				recursion(g, count, base, x1, (x1) - (base/2), (x1) + (base/2), base + ((y1 + y2) / 2), base + ((y2)), base + ((y2)));
		    				
		//closes if statement for count being above 1
    	}

    //closes recursion method
    }
    
    //begins recursion2 method with manipulated parameters for new triangle coordinates (parameters are manipulated within the call to the method)
    public void recursion2(Graphics g, int count, int base, int x1_Initial, int x2_Initial, int x3_Initial, int y1_Initial, int y2_Initial, int y3_Initial) {
    	
    	//continues the recursive call until count equals 1
    	if(count > 1) {
	    	
    		//if count is even
        	if(count % 2 == 0) {
        		
        		//do not draw any new triangles and lower count by 1
        		count--;
        	
        	//closes if statement
        	}
    		
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

        		//if count equals 3
		    	if(count == 3) {
		    	
		    		//set color to gray
		    		g.setColor(Color.gray);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 5
		    	else if(count == 5) {
		    		
		    		//set color to white
		    		g.setColor(Color.white);
		    	
		    	//closes if statement
		    	}
		    	
		    	//if count equals 7
		    	else if(count == 7) {
		    		
		    		//set color to red
		    		g.setColor(Color.red);
		    	
		    	//closes if statement
		    	}
		    		
		    		//integer array for x coordinates of new triangle
		    		int [] xTriangle = {x1, x2, x3};
        
		    		//integer array for y coordinates of new triangle
		    		int [] yTriangle = {y1, y2, y3};
    	
		    		//draws new triangle using above integer arrays
		    		g.fillPolygon(xTriangle, yTriangle, 3);
    	
		    			//decreases count by 2 before recursive calls
		    			count = count - 2;

		    			//divides base by 2 before recursive calls
		    			base = base / 2;
		    			
	    				//recursive call for triangle above with appropriate arithmetic to adjust x and y coordinates
	    				recursion2(g, count, base, (x1 + x2) / 2, x2, (x2 + x3) / 2, y1 - base, y2 - 2*base, y3 - base);
		    			
	    				//recursive call for triangle to the left with appropriate arithmetic to adjust x and y coordinates
	    				recursion2(g, count, base, x1 - base/2, x1, (x1 + x2) / 2, (y1 + y2) / 2, y2, (y1 + y2) / 2);
	
	    				//recursive call for triangle to the right with appropriate arithmetic to adjust x and y coordinates
	    				recursion2(g, count, base, (x2 + x3) / 2, x3, x3 + base/2, (y1 + y2) / 2, y2, (y1 + y2) / 2);
	    				
		//closes if statement for count being above 1
    	}

    //closes recursion2 method
    }
    
//closes class
}