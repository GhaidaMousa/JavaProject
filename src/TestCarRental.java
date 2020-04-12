import java.io.*;
public class TestCarRental {
public static void main(String[] args) throws Exception {

        CarRental agency = new CarRental(100);

        agency.addCar(new Economy("ABC-1234", 150, "Camry", "White"));
        agency.addCar(new Economy("XYZ-5678", 90, "Accent", "Blue"));
        agency.addCar(new VIP("TTM-5544", 320, "BMW", "Black", new Driver(1, "Waleed")));
        agency.addCar(new VIP("EEAA9966", 370, "Mercedes", "Black", new Driver(2, "Sara")));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cars.dat"));

        oos.writeInt(agency.getNumOfCars());
        oos.writeObject(agency.getCarlist());

        oos.close();

        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cars.dat"));

        int numOfCars = ois.readInt();
        System.out.println("Total Cars: " + numOfCars);
        Car[] cars = (Car[]) ois.readObject();

        for (int i = 0; i < numOfCars; i++) {
            Car car = cars[i];
            System.out.println(car);

        }
    }

}

