public class Economy extends Car {

   public Economy ( String plate, double price, String model, String color){
       super(plate,price,model,color);
   }
   
   public String printBill( int days) {
       double Tprice = pricePerDay * days ; 
       if( days > 7 )
         Tprice = Tprice - ( Tprice * 0.2 ); 
         
       String bill = "Bill: \n " +"\"Economy Car\n\""+super.toString() + "Total price: "+Tprice; 
      
      return bill ; 
    }


}

        

