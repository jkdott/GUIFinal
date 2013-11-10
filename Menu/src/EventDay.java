
import java.util.ArrayList;
public class EventDay {
        private Reservations theGoodLittleBoys;
        private ArrayList<Dish> theStuff;
        private String ohCaptainMyCaptain;
        private String date;
        
        public EventDay(String leader, String date){
                this.date = date;
                ohCaptainMyCaptain = leader;
                theStuff = dishGen();
                theGoodLittleBoys = reservationControl();
                reserve(leader, true);
        }

        private ArrayList<Dish> dishGen() {
                ArrayList<Dish> temp = new ArrayList<Dish>();
                Input output = new Input();
                boolean control;
                output.showInformation("Please enter your main dish");
                temp.add(new Dish());
                control = another();
                while(control){
                        temp.add(new Dish());
                        control = another();
                }
                return temp;
        }

        private Reservations reservationControl() {
                Dish main = theStuff.get(0);
                int scale = main.getNumberServed();
                scale *=3;
                //this can be changed if there is a specific limit
                if(scale>20)
                        return new Reservations(20);
                return new Reservations(scale);
        }
        private boolean another(){
                boolean isYes;
                Input output = new Input();
                isYes = output.getBoolean("Add a side?");;
                if(isYes){
                        return true;
                } 
                return false;
        }
        public boolean reserve(String name, boolean hasPaid){
                theGoodLittleBoys.add(name, hasPaid);
                return true;
        }
        public void displayShoppingList(){
                for(Dish stuff: theStuff){
                        stuff.shoppingList();
                }
        }

        public String getOhCaptainMyCaptain() {
                return ohCaptainMyCaptain;
        }

        public void setOhCaptainMyCaptain(String ohCaptainMyCaptain) {
                this.ohCaptainMyCaptain = ohCaptainMyCaptain;
        }

        public Reservations getTheGoodLittleBoys() {
                return theGoodLittleBoys;
        }

        public ArrayList<Dish> getTheStuff() {
                return theStuff;
        }
        public String getDate() {
                return date;
        }
}