
//Makes reservations
import java.util.ArrayList;
public class Reservations {
	private ArrayList<Checkin> reserved;
	private ArrayList<Checkin> waitlist;
	private int space;
	public Reservations(int space){
		this.space = space;
		reserved = new ArrayList<Checkin>(space);
		waitlist = new ArrayList<Checkin>();
	}
	public boolean add(String name, boolean hasPaid){
		Input output = new Input();
		Checkin bigGuy = new Checkin(name, hasPaid);
		if(reserved.size()!=space){
			reserved.add(bigGuy);
			output.showInformation("Your reservation was succesful");
		}
		else{
			waitlist.add(bigGuy);
			output.showInformation("You have been put on the waitlist");
		}
		return true;
	}
	public boolean paid(String name){
		Checkin temp = new Checkin(name, true);
		for(int i = 0; i<reserved.size(); i++){
			if(temp.getName() == (reserved.get(i).getName())){
				reserved.set(i, temp);
				return true;
			}
		}
		return false;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public ArrayList<Checkin> getReserved() {
		return reserved;
	}
	public ArrayList<Checkin> getWaitlist() {
		return waitlist;
	}
	
}
