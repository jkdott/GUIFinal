import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class OpeningScreenAndDriver {
	private static EventDay myDay ;//= setDay();

	/*private static setDay(){
		
	}_*/
	public static void main(String[] args) throws IOException{
		boolean cont;
		Input take = new Input();
		BufferedImage img = ImageIO.read(new File("logo.jpg"));
			
		ImageIcon icon = new ImageIcon(img);
		Object[] options = {"Set a Meal/Create an Event-Day","View Upcoming Meals","View Shopping List", "Cancel"};
		cont = true;
		while(cont){
			int response = JOptionPane.showOptionDialog(null,
					"Welcome to the Holy Ghost Cooking Club JavaApp.  What would you like to do?",
					"Welcome",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon,
					options,
					options[0]
					);
			if(response == 0){
				String leader = take.getString("Who will lead this EventDay?");
				String date = take.getString("What is the date? (ddmmyyyy)");
				myDay = new EventDay(leader, date);
			} else if(response == 1){
				
			} else if(response == 2){
				myDay.displayShoppingList();
				
			} else if (response == (options.length - 1)){
				cont = false;
			}
		}
	}
}