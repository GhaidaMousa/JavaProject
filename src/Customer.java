import java.io.*;
public class Customer implements Serializable {
    private int id ;
    private String name;
    private long phone;
    
    public Customer(int i, String n, long p ){
        id= i;
        name= n;
        phone= p;
    }
    
    public String toString(){
        return"Customer information   ID:" +id+ " Name: "+name+" Phone: "+phone+"\n";
    }
    
    
    
}
