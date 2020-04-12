import java.io.*;
public class CarRental {
    
    private int numOfCars;
    private Car [] carList;
    
    public CarRental(int size){
        carList= new Car [size];
        numOfCars=0;
    }
    
    public boolean addCar(Car c){
        if(numOfCars>=carList.length)
            return false;
        for(int i=0; i<numOfCars; i++){
            if(carList[i].getPlateNo().toLowerCase().equals(c.getPlateNo().toLowerCase()))
            return false;  
        }
        carList[numOfCars++]= c;
        return true; 
    }
    
    public void saveToFile() throws FileNotFoundException, IOException {
 
          File f= new File("cars.dat");
          FileOutputStream fo = new FileOutputStream(f);
          ObjectOutputStream oo= new ObjectOutputStream(fo);
          
          for(int i=0; i<numOfCars; i++)
              oo.writeObject(carList[i]);
          oo.writeInt(numOfCars);
          oo.close();
    }
    
    public void loadFromFile()throws FileNotFoundException, IOException, ClassNotFoundException {
          File f= new File("cars.dat");
          FileInputStream fi = new FileInputStream(f);
          ObjectInputStream oi= new ObjectInputStream(fi);
          
          numOfCars = oi.readInt();
          carList= (Car[])oi.readObject();
          
          oi.close();   
    }
    
    public String rentCar(String plateNo, Customer c, int numOfDay){
        String str= null;
        for(int i=0; i<numOfCars; i++){
          if(carList[i].getPlateNo().toLowerCase().equals(plateNo.toLowerCase())){
              if(carList[i].isAvailable()){
                  carList[i].setCustomer(c);
                  carList[i].setAvailable(false);
                  str= carList[i].printBill(numOfDay);
              }
          }
        }
        return str;
    }
    
    public boolean returnCar(String plateNo){
         for(int i=0; i<numOfCars; i++){
          if(carList[i].getPlateNo().toLowerCase().equals(plateNo.toLowerCase())){
              if(!carList[i].isAvailable()){
                  carList[i].setAvailable(true);
                  carList[i].setCustomer(null);
                  return true;
                 } 
              }       
          }
         return false;
    }
        
    
    public VIP[] SearchAvailableVIP(){
       int num=0;
       for(int i=0; i<numOfCars;i++){
           if(carList[i] instanceof VIP ){
               if(carList[i].isAvailable())
                   num++;
            }
       }
       if(num== 0)
           return null;
       VIP[] car= new VIP[num];
       int j=0;
       for(int i=0; i<10 ;i++){
           if(carList[i] instanceof VIP ){
               if(carList[i].isAvailable())
                   car[j++]= (VIP) carList[i];
           }
       }
       return car;  
    }
    
    public Economy[] searchAvailableEconomy(){
        int num=0;
       for(int i=0; i<numOfCars; i++){
           if(carList[i] instanceof Economy ){
               if(carList[i].isAvailable())
                   num++;
            }
       }
       if(num== 0)
           return null;
       Economy[] car= new Economy[num];
       int j=0;
       for(int i=0; i<10 ;i++){
           if(carList[i] instanceof Economy ){
               if(carList[i].isAvailable())
                   car[j++]= (Economy) carList[i];
           }
       }
       return car;  
    }
    
    public Car getCar(String PN){
        Car find= null;
        for (int i = 0; i < numOfCars; i++){
            if(carList[i].getPlateNo().toLowerCase().equals(PN.toLowerCase())){
                find= carList[i];
            }   
        }
        return find;
    }
    public Car[] getCarlist() {
        return carList;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

     
    
}
