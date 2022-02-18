import java.io.*;
import java.util.*;



public class Main{
    public static void main(String[] args) throws Exception {

        ArrayList <Client> list = FileManager.getList();

        FileManager.saveList(list);

    }
}


class Client implements Serializable {

    String email_address;
    String passward;

    Client(String email_address, String passward){
        this.email_address = email_address;
        this.passward = passward;
    }
}

class FileManager{

    static ArrayList <Client> getList() throws Exception {

        File file_checker = new File("DATA.txt");

        if( file_checker.exists() ){
            System.out.println("File already exists");
        }
        else{
            file_checker.createNewFile();


            ArrayList <Client> DATA = new ArrayList<>();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_checker));
            oos.writeObject(DATA);
            oos.close();

            System.out.println("File created");

        }

        ArrayList <Client> DATA;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.txt"));
        DATA = (ArrayList <Client> ) ois.readObject();
        ois.close();

        return DATA;
    }

    static void saveList(ArrayList <Client> DATA) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DATA.txt"));
        oos.writeObject(DATA);
        oos.close();
    }

}