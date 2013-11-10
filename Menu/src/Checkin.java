

public class Checkin {
	//name contains an email address for easy contact and to avoid duplicates
	private String name;
	private boolean hasPaid;
	public Checkin(String name, boolean hasPaid){
		this.name = name;
		this.hasPaid = hasPaid;
	}
	public boolean pay(){
		hasPaid = true;
		return hasPaid;
	}
	public String getName() {
		return name;
	}
	public boolean isPaid() {
		return hasPaid;
	}
	public String toString(){
		if(hasPaid==true)
			return ("The user " + name + " has paid");
		else
			return("The user " + name + " has NOT paid");
	}
}
