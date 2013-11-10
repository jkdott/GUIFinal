import javax.swing.*;
import java.util.*;
public class Output {

	public Output(){}
	
	public boolean printStringArray(ArrayList<String> list, String title){
		String message = "";
		for(int i = 0; i<list.size(); i++){
			String temp = list.get(i);
			message = message + ("Ingredient " + (i+1) + ": " + temp + "\n");
		}
		JOptionPane.showMessageDialog(null, message, title, 1);
		return true;
	}
	
	public boolean printProcedure(String dishName, String procedure){
		String title = ("Follow these instructions for " + dishName);
		String message = "Procedure: \n";
		String total = message + procedure;
		
		JOptionPane.showMessageDialog(null, total, title, 1);
		return true;
	}
	}


