public class VIP extends Car {
    
    private Driver d;
    
    public VIP(String plate, double price, String model, String color, Driver d){
       super(plate,price,model,color);
       this.d=d;
   }
   
   public String printBill( int days) {
       double Tprice = pricePerDay * days ;
       for (int i=0; i<days; i++)
          Tprice+=100;
         
       String bill = "Bill: \n " +"\"VIP Car\n\""+super.toString() +"Driver: "+d.toString() +"\nTotal price: "+Tprice; 
      
      return bill ; 
    }
    
    public Driver getDriver() {
        return d;
    }
    
    //need toString()??
}

   
   
