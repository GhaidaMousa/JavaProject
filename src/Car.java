
import java.io.Serializable;
public abstract class Car implements Payabel , Serializable {

   protected String plateNo;
   protected double pricePerDay;
   protected String model;
   protected String  color;
   protected boolean available;
   protected Customer cr;
   
   public Car ( String plate, double price, String model, String  color){
       plateNo=plate;  
       pricePerDay=price;
       this.model=model;
       this.color=color;
       available=true;
       cr = null;
   } 
   
   public void setCustomer( Customer c){
       cr = c;
   }
   
   public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double price) {
        pricePerDay = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() { 
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Customer getCustomer() {
        return cr;
    }
    
    public String toString(){ // if statement?
        return "plate number: " +plateNo+ " price Per Day: " +pricePerDay+ " model: " +model+
         " color: " +color+  " available: " +available+ "\nCustomer: " + cr.toString() + "\n";
    }
    
}

    