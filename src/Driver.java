    import java.io.*;
public class Driver implements Serializable{

private int id ; 
private String name ; 

    public Driver (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return  "ID: " + id + " Name: " + name ;
    }


}


