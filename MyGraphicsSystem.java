import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class MyGraphicsSystem extends LBUGraphics {

	public MyGraphicsSystem() {
        JFrame MainFrame = new JFrame();               
        MainFrame.setLayout(new FlowLayout());  
        MainFrame.add(this);                                    
        MainFrame.pack();                                            
        MainFrame.setVisible(true);
	}
	
    public void processCommand(String command)      //this method must be provided because LBUGraphics will call it when it's JTextField is used
    {
    	setBackground_Col(Color.CYAN);
    	
    	drawLine(Color.GREEN,0,30, 270, 120 );
    	
    	setStroke(15);
    	
    	System.out.println(getxPos());
    	System.out.println(getyPos());
    	// setxPos(50);
    	// setyPos(100);
    	
    	try {
    		
			String[] Split_cmd = command.split(" ");
			String First_cmd = Split_cmd[0];
			
			if (Split_cmd.length == 2) {
				int parameter = Integer.parseInt(Split_cmd[1]);
				
				switch(First_cmd) {
				
				case("turnleft"):
					turnLeft(parameter);
					break;
				case("turnright"):
					turnRight(parameter);
					break;
				case("forward"):
					forward(parameter);
					break;
				case("backward"):
					forward(parameter * -1);
					break;
				default:
					System.out.println("INVALID COMMAND!");
					break;
				}
			}
			else if (Split_cmd.length == 1) {
				switch(command) {
				
				case("about"):
					about();
					break;
				
				case("penup"):
					penUp();
					break;
				case("pendown"):
					penDown();
					break;
				case("black"): 
					setPenColour(Color.BLACK);
					break;
				case("green"):
					setPenColour(Color.GREEN);
					break;
				case("red"):
					setPenColour(Color.RED);
					break;
				case("white"):
					setPenColour(Color.WHITE);
					break;
				case("reset"):
					reset();
					break;
				case("clear"):
					clear();
					break;
				case("turnleft"):
					turnLeft();
					break;
				case("turnright"):
					turnRight();
					break;
				default:
					System.out.println("INVALID COMMAND!");
					break;
				}
			}
    	}
    	catch(NumberFormatException e) {
    		System.out.println("INVALID NUMERIC PARAMETER");
    	}
    }
    
}
