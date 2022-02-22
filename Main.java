import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Client> list = FileManager.getList();
        new GUI(list);

    }
}

class GUI {
    
    Client TempClient;
    ArrayList<Client> dataList;
    
    GUI(ArrayList<Client> dataList)
    {
        this.dataList = dataList;
        // TempClient = new Client("undefined","undefined");   
        TempClient = new Client();   

        if (dataList.size() == 0) 
        {
            frame1();
        } 
        else 
        {
            frame2();
        }
    }

    void frame1(){
        JFrame f1 = new JFrame("Robin-Hood Stock Broker");
        // f1.getContentPane().setBackground(new Color(200 ,200,200));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setIconImage(new ImageIcon("circle.jpg").getImage());

        // background image
        f1.setContentPane(new JLabel(new ImageIcon("Untitled-2.jpg")));

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
        // f1.setSize(1200, 600);
        f1.setBounds(180, 100, 1200, 600);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if ( tf1.getText().hashCode() == 0 || tf2.getText().hashCode() == 0 ){
                    System.out.println("Field can not be Empty");
                    JOptionPane.showMessageDialog(null, "Fields are empty!");
                }
                else{
                    TempClient.email_address = tf1.getText();
                    TempClient.passward = tf2.getText();
                    f1.setVisible(false);
                    frame3();
                }
            }
        });
    }

    void frame2(){
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
        f2.setBounds(180, 100, 1200, 600);
        f2.setLayout(null);
        f2.setVisible(true);
        f2.setResizable(false);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean flag = true;
                
                if(tf1.getText().hashCode() == 0 || tf2.getText().hashCode() ==0 ){
                    System.out.println("Field can not be Empty");
                    JOptionPane.showMessageDialog(null, "Fields are empty!");
                }
                else {
                    String entered_email_address = tf1.getText();
                    String entered_passward = tf2.getText();

                    for(int i=0; i<dataList.size(); i++){
                        String temp_email = dataList.get(i).email_address; 
                        String temp_passward = dataList.get(i).passward;

                        System.out.println(temp_email);
                        System.out.println(temp_passward);
                        
                        if(entered_email_address.equals(temp_email) && entered_passward.equals(temp_passward) ){
                            TempClient = dataList.get(i);
                            f2.setVisible(false);
                            frame5();
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        JOptionPane.showMessageDialog(null, "Email or Passward Wrong!!!");
                    }
                    
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
                frame1();
            }
        });


        

    }

    void frame3()
    {
        JFrame f1 = new JFrame("Robin-Hood Stock Broker");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setIconImage(new ImageIcon("circle.jpg").getImage());

        // background image
        f1.setContentPane(new JLabel(new ImageIcon("Untitled-1.jpg")));

        // labels
        JLabel l1 = new JLabel("Enter The Personal Details");
        JLabel l2 = new JLabel("First Name : ");
        JLabel l3 = new JLabel("Last Name : ");
        JLabel l4 = new JLabel("Age : ");
        JLabel l5 = new JLabel("Phone N0. : ");
        JLabel l6 = new JLabel("Gender : ");
        JLabel l7 = new JLabel("Address : ");
        JLabel l8 = new JLabel("State : ");

        

        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setFont(new Font("Raleway", Font.BOLD, 15));
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        l4.setFont(new Font("Raleway", Font.BOLD, 15));
        l5.setFont(new Font("Raleway", Font.BOLD, 15));
        l6.setFont(new Font("Raleway", Font.BOLD, 15));
        l7.setFont(new Font("Raleway", Font.BOLD, 15));
        l8.setFont(new Font("Raleway", Font.BOLD, 15));

        //            x    y    w    h
        l1.setBounds(450, 50, 300, 30); 
        l2.setBounds(300, 150, 100, 30);
        l3.setBounds(600, 150, 100, 30);
        l4.setBounds(300, 200, 100, 30);
        l5.setBounds(600, 200, 100, 30);
        l6.setBounds(300, 250, 100, 30);
        l7.setBounds(300, 300, 100, 30);
        l8.setBounds(600, 300, 100, 30);

        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(l8);

        // Text Field
        JTextField tf1 = new JTextField("");
        JTextField tf2 = new JTextField("");
        JTextField tf3 = new JTextField("");
        JTextField tf4 = new JTextField("");

        tf1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        tf2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        tf3.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        tf4.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

        tf1.setBounds(400, 150, 100, 30);
        tf2.setBounds(700, 150, 100, 30);
        tf3.setBounds(400, 200, 100, 30);
        tf4.setBounds(700, 200, 100, 30);

        tf1.setVisible(true);
        tf2.setVisible(true);
        tf3.setVisible(true);
        tf4.setVisible(true);

        f1.add(tf1);
        f1.add(tf2);
        f1.add(tf3);
        f1.add(tf4);

        // radio

        JRadioButton r1=new JRadioButton(" Male");    
        JRadioButton r2=new JRadioButton(" Female");

        // r1.setBackground(new Color(152, 100, 255));
        // r2.setBackground(new Color(152, 100, 255));

        r1.setBounds(400,250,100,30);    
        r2.setBounds(600,250,100,30);    
        
        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);bg.add(r2);

        f1.add(r1);
        f1.add(r2);   


        // text area
        // Border border = BorderFactory.createLineBorder(new Color(152, 100, 255), 1);
        JTextArea area =new JTextArea("");  
        area.setBounds(400, 300, 150,50);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	    area.setBorder(border);  
        area.setBorder(border);
        f1.add(area);  

        // list
        DefaultListModel<String> l = new DefaultListModel<>();  
        l.addElement("Gujarat");  
        l.addElement("Delhi");  
        l.addElement("Rajasthan");
        JList<String> list = new JList<>(l);  
        
        list.setBounds(700 ,300, 75,75);  
        
        list.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

        f1.add(list);  

        // button
        JButton b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        b.setBackground(new Color(152, 100, 255));
        b.setBounds(500, 420, 170, 30);
        b.setVisible(true);
        f1.add(b);

        // frame setting
        f1.setBounds(180, 100, 1200, 600);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // 

                if ( tf1.getText().hashCode() == 0 || tf2.getText().hashCode() == 0 
                  || tf3.getText().hashCode() == 0 || tf4.getText().hashCode() == 0
                  || !( r1.isSelected() || r1.isSelected()) || area.getText().hashCode()==0
                  || list.isSelectionEmpty() )
                {
                    System.out.println("Field can not be Empty");
                    JOptionPane.showMessageDialog(null, "Fields are empty!");
                }
                else{
                    TempClient.first_name = tf1.getText();
                    TempClient.last_name = tf2.getText();
                    TempClient.age = tf3.getText();
                    TempClient.phone_no = tf4.getText();

                    if(r1.isSelected()){
                        TempClient.gender = "male";
                    }
                    else{
                        TempClient.gender = "female";
                    }

                    TempClient.address = area.getText();

                    switch(list.getSelectedIndex()){
                        case 0:
                            TempClient.state = "Gujarat";
                            break;
                        case 1:
                            TempClient.state = "Delhi";
                            break;
                        case 2:
                            TempClient.state = "Rajasthan";
                            break;
                    }

                    f1.setVisible(false);
                    frame4();
                }
            }
        });

    }

    void frame4() {
        JFrame f1 = new JFrame("Robin-Hood Stock Broker");
        // f1.getContentPane().setBackground(new Color(200 ,200,200));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setIconImage(new ImageIcon("circle.jpg").getImage());

        // background image
        f1.setContentPane(new JLabel(new ImageIcon("Untitled-3.jpg")));

        // labels
        JLabel l1 = new JLabel("Bank Details");
        JLabel l2 = new JLabel("Account No : ");
        JLabel l3 = new JLabel("A/C type : ");
        JLabel l4 = new JLabel("Pan No : ");

        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setFont(new Font("Raleway", Font.BOLD, 15));
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        l4.setFont(new Font("Raleway", Font.BOLD, 15));

        l1.setBounds(520, 80, 150, 30);
        l2.setBounds(470, 150, 100, 30);
        l3.setBounds(470, 200, 100, 30);
        l4.setBounds(470, 250, 100, 30);

        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);

        // Text Field
        JTextField tf1 = new JTextField("");
        JTextField tf2 = new JTextField("");

        tf1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        tf2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

        tf1.setBounds(580, 150, 100, 30);
        tf2.setBounds(580, 250, 100, 30);

        tf1.setVisible(true);
        tf2.setVisible(true);

        f1.add(tf1);
        f1.add(tf2);

        // combo
        String languages[]={"Saving A/C","Current A/C"};        
        JComboBox cb = new JComboBox(languages);
        cb.setBackground(new Color(152, 100, 255));    
        cb.setBounds(580, 200,100,30);    
        f1.add(cb);

        // check box  
        JCheckBox checkBox1 = new JCheckBox("Accept term & condition");
        checkBox1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        checkBox1.setBackground(new Color(152, 100, 255));
        checkBox1.setBounds(500,300, 170,30);  
        f1.add(checkBox1);

        // button
        JButton b = new JButton("Confirm and Create");
        b.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        b.setBackground(new Color(152, 100, 255));
        b.setBounds(500, 350, 170, 30);
        b.setVisible(true);
        f1.add(b);

        // frame setting
        f1.setBounds(180, 100, 1200, 600);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if ( tf1.getText().hashCode() == 0 || tf2.getText().hashCode() == 0 || ! checkBox1.isSelected() ){
                    System.out.println("Field can not be Empty");
                    JOptionPane.showMessageDialog(null, "Fields are empty!");
                }
                else{
                    TempClient.account_no = tf1.getText();
                    TempClient.account_type = (String) cb.getSelectedItem();
                    TempClient.pan_no = tf2.getText();

                    dataList.add(TempClient);

                    try{
                        FileManager.saveList(dataList);
                    }
                    catch(Exception a){
                        System.out.println("Error occurred : " + e);
                    }


                    f1.setVisible(false);
                    frame5();
                }

            }
        });

    }

    void frame5(){
        
        JFrame f1 = new JFrame("Robin-Hood Stock Broker");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setIconImage(new ImageIcon("circle.jpg").getImage());
        
        // background image
        f1.setContentPane(new JLabel(new ImageIcon("border.jpg")));


        // label
        JLabel l1 = new JLabel("Explore");
        JLabel l2 = new JLabel("Dashboard");
        JLabel l3 = new JLabel("Nifty :");
        JLabel l4 = new JLabel("Sensex :");
        JLabel l5 = new JLabel("Bank-Nifty :");
        JLabel l6 = new JLabel("Nifty 500 :");

        // l1.setBackground(Color.GRAY);
        l1.setBackground(Color.BLUE);

        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setFont(new Font("Raleway", 5, 20));
        l3.setFont(new Font("Raleway", Font.BOLD, 15));
        l4.setFont(new Font("Raleway", Font.BOLD, 15));
        l5.setFont(new Font("Raleway", Font.BOLD, 15));
        l6.setFont(new Font("Raleway", Font.BOLD, 15));
        

        //            x    y    w   h
        l1.setBounds(100, 30, 100, 30);
        l2.setBounds(200, 30, 150, 30);
        l3.setBounds(100, 150, 100, 30);
        l4.setBounds(500, 150, 100, 30);
        l5.setBounds(100, 350, 100, 30);
        l6.setBounds(500, 350, 100, 30);

        // l1.setBackground(new Color(152, 100, 255));
        // Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        // l1.setBorder(border);

        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
   
        // image
        JLabel i1 = new JLabel(new ImageIcon("under_line.jpg"));
        JLabel i2 = new JLabel(new ImageIcon("candle.jpg"));
        JLabel i3 = new JLabel(new ImageIcon("candle_1.jpg"));
        JLabel i4 = new JLabel(new ImageIcon("candle_2.jpg"));
        JLabel i5 = new JLabel(new ImageIcon("candle.jpg"));

        i1.setBounds(90,80,1020,1);
        i2.setBounds(250,170,150,150);
        i3.setBounds(650,170,150,150);
        i4.setBounds(250,370,150,150);
        i5.setBounds(650,370,150,150);
        
        f1.add(i1);
        f1.add(i2);
        f1.add(i3);
        f1.add(i4);
        f1.add(i5);

        // Button
        JButton b1 = new JButton("Buy");
        JButton b2 = new JButton("Sell");
        JButton b3 = new JButton("Details");

        // b3.setBorder(BorderFactory.createEmptyBorder());
        // b3.setContentAreaFilled(false);

        // b3.setBorderPainted(false);
        // b3.setContentAreaFilled(false);
        // b3.setOpaque(true);

        b1.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        b2.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));
        b3.setFont(new Font("Raleway", Font.CENTER_BASELINE, 13));

        b1.setBackground(new Color(152, 100, 255));
        b2.setBackground(new Color(152, 100, 255));
        b3.setBackground(new Color(152, 100, 255));

        b1.setBounds(930, 400, 170, 30);
        b2.setBounds(930, 470, 170, 30);
        b3.setBounds(965, 30, 100, 30);

        b1.setVisible(true);
        b2.setVisible(true);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);

        
        f1.setBounds(180, 30, 1210, 635);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame6();
            }
        });

    }

    void frame6(){
        JFrame f=new JFrame();
        f.setIconImage(new ImageIcon("circle.jpg").getImage());
        
        
        JLabel l1=new JLabel("Your Information : ");    
        JLabel l2=new JLabel("");

        JLabel l3=new JLabel("Full Name : ");    
        JLabel l4=new JLabel(TempClient.first_name + " " + TempClient.last_name);    
        
        JLabel l5=new JLabel("Email : ");    
        JLabel l6=new JLabel(TempClient.email_address);    
        
        JLabel l7=new JLabel("Passward : ");    
        JLabel l8=new JLabel(TempClient.passward); 

        JLabel l9=new JLabel("Phone No. :");    
        JLabel l10=new JLabel(TempClient.phone_no);

        JLabel l11=new JLabel("Address :");    
        JLabel l12=new JLabel(TempClient.address);    
        
        JLabel l13=new JLabel("Account No.");    
        JLabel l14=new JLabel(TempClient.account_no);
        
        JLabel l15=new JLabel("Pan No.");    
        JLabel l16=new JLabel(TempClient.pan_no);

         // adding buttons to the frame  
         f.add(l1);     
         f.add(l2);     
         f.add(l3);     
         f.add(l4);     
         f.add(l5);     
         f.add(l6);     
         f.add(l7);     
         f.add(l8);     
         f.add(l9);     
         f.add(l10);     
         f.add(l11);     
         f.add(l12);     
         f.add(l13);     
         f.add(l14);     
         f.add(l15);     
         f.add(l16);     

        // setting grid layout of 3 rows and 3 columns    
        f.setLayout(new GridLayout(8,2));    
        f.setBounds(550, 100, 400, 500);   
        f.setVisible(true); 
    }

}

class Client implements Serializable {

    String email_address;
    String passward;
    String first_name;
    String last_name;
    String age;
    String phone_no;
    String gender;
    String address;
    String state;
    String account_no;
    String account_type;
    String pan_no;


    // Client(String email_address, String passward) {
    //     this.email_address = email_address;
    //     this.passward = passward;
    // }
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