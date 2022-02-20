import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Client> list = FileManager.getList();
        // list.add(new Client("viral.patel218@gmail.com", "viral@viral123"));
        // FileManager.saveList(list);
        new GUI(list);

    }
}

class GUI {
    GUI(ArrayList<Client> list) {

        if (list.size() == 0) 
        {
            JFrame f1 = new JFrame("Robin-Hood Stock Broker");
            // f1.getContentPane().setBackground(new Color(200 ,200,200));
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f1.setIconImage(new ImageIcon("circle.jpg").getImage());

            // background image
            f1.setContentPane(new JLabel(new ImageIcon("Untitled-1.jpg")));

            // labels
            JLabel l1 = new JLabel("Create Account");
            JLabel l2 = new JLabel("Email : ");
            JLabel l3 = new JLabel("passward : ");

            l1.setFont(new Font("Raleway", Font.BOLD, 20));
            l2.setFont(new Font("Raleway", Font.BOLD, 15));
            l3.setFont(new Font("Raleway", Font.BOLD, 15));

            l1.setBounds(500, 150, 200, 30);
            l2.setBounds(470, 220, 100, 30);
            l3.setBounds(470, 270, 100, 30);

            f1.add(l1);
            f1.add(l2);
            f1.add(l3);

            // Text Field
            JTextField tf1 = new JTextField("");
            JTextField tf2 = new JTextField("");

            tf1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
            tf2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

            tf1.setBounds(580, 220, 100, 30);
            tf2.setBounds(580, 270, 100, 30);

            tf1.setVisible(true);
            tf2.setVisible(true);

            f1.add(tf1);
            f1.add(tf2);

            // button
            JButton b = new JButton("Create");
            b.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
            b.setBackground(new Color(152, 100, 255));
            b.setBounds(500, 350, 170, 30);
            b.setVisible(true);
            f1.add(b);

            // frame setting
            f1.setSize(1200, 600);
            f1.setLayout(null);
            f1.setVisible(true);
            f1.setResizable(false);

        } 
        else 
        {
            JFrame f2 = new JFrame("Robin-Hood Stock Broker");
            // f2.getContentPane().setBackground(new Color(200 ,200,200));
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setIconImage(new ImageIcon("circle.jpg").getImage());

            // background image
            f2.setContentPane(new JLabel(new ImageIcon("Untitled-1.jpg")));

            // labels
            JLabel l1 = new JLabel("Login");
            JLabel l2 = new JLabel("Email : ");
            JLabel l3 = new JLabel("passward : ");
            JLabel l4 = new JLabel("or");

            l1.setFont(new Font("Raleway", Font.BOLD, 20));
            l2.setFont(new Font("Raleway", Font.BOLD, 15));
            l3.setFont(new Font("Raleway", Font.BOLD, 15));
            l4.setFont(new Font("Raleway", Font.BOLD, 10));

            l1.setBounds(550, 150, 100, 30);
            l2.setBounds(470, 220, 100, 30);
            l3.setBounds(470, 270, 100, 30);
            l4.setBounds(580, 380, 100, 30);

            f2.add(l1);
            f2.add(l2);
            f2.add(l3);
            f2.add(l4);

            // Text Field
            JTextField tf1 = new JTextField("");
            JTextField tf2 = new JTextField("");

            tf1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
            tf2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

            tf1.setBounds(580, 220, 100, 30);
            tf2.setBounds(580, 270, 100, 30);

            tf1.setVisible(true);
            tf2.setVisible(true);

            f2.add(tf1);
            f2.add(tf2);

            // button
            JButton b1 = new JButton("Login");
            JButton b2 = new JButton("Create new account");

            b1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
            b2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

            b1.setBackground(new Color(152, 100, 255));
            b2.setBackground(new Color(152, 100, 255));

            b1.setBounds(500, 350, 170, 30);
            b2.setBounds(500, 410, 170, 30);

            b1.setVisible(true);
            b2.setVisible(true);

            f2.add(b1);
            f2.add(b2);

            // frame setting
            f2.setSize(1200, 600);
            f2.setLayout(null);
            f2.setVisible(true);
            f2.setResizable(false);
        }
    }
}

class Client implements Serializable {

    String email_address;
    String passward;

    Client(String email_address, String passward) {
        this.email_address = email_address;
        this.passward = passward;
    }
}

class FileManager {

    static ArrayList<Client> getList() throws Exception {

        File file_checker = new File("DATA.txt");

        if (file_checker.exists()) {
            System.out.println("File already exists");
        } else {
            file_checker.createNewFile();

            ArrayList<Client> DATA = new ArrayList<>();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_checker));
            oos.writeObject(DATA);
            oos.close();

            System.out.println("File created");

        }

        ArrayList<Client> DATA;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.txt"));
        DATA = (ArrayList<Client>) ois.readObject();
        ois.close();

        return DATA;
    }

    static void saveList(ArrayList<Client> DATA) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DATA.txt"));
        oos.writeObject(DATA);
        oos.close();
    }

}