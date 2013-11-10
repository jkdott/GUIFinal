import javax.swing.*;
public class Input {
	public Input(){}
	
	public boolean showInformation(String message){
		JOptionPane.showMessageDialog(null, message);
		return true;
	}
	
	public int shoppingOrProcedure(){
		Object[] options = {"Display the Procedure",
                "Display the Shopping List"};
		int n = JOptionPane.showOptionDialog(null, //default frame
				"Would you like to view the Procedure or the Shopping List?", //question
				"Viewing Options", //title				
				JOptionPane.YES_NO_OPTION, //type of options
				JOptionPane.QUESTION_MESSAGE, //type of message
				null, 
				options, //options one
				options[1]);//and two
		System.out.println(n);
		return n;
	}
	
	public String getString(String message){
		String inputValue = JOptionPane.showInputDialog(message);
		return inputValue;
	}
	
	public int getInt(String message){
		int inputVal = Integer.parseInt(JOptionPane.showInputDialog(message));
		return inputVal;
	}
	
	public double getDouble(String message){
		double inputVal = Double.parseDouble(JOptionPane.showInputDialog(message));
		return inputVal;
	}
	
	public boolean getBoolean(String message){
		int response = JOptionPane.showConfirmDialog(null, message);
		boolean isYes; 
		if(response == 0){
			isYes = true;
		} else {
			isYes = false;
		}
		
		return isYes;
		
	}
}
