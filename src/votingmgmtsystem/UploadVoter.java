/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingmgmtsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.*;
import javax.swing.Icon;


public class UploadVoter extends JFrame {
    
     JButton button,bro ;
    JLabel label,lblAno,lblApath,lblid;
  //  JComboBox cmbid;
    JTextField txtadhar_no,txtadharpath,txtid;
    
    Connection con;
    PreparedStatement pt;
    ResultSet rs;
    Statement st;
    public UploadVoter()
    {
       super("Upload Adhar_Card");
    
    button = new JButton("UPLOAD");
    button.setBounds(30,300,100,40);
    bro = new JButton("Browser");
    bro.setBounds(590,310,100,20);
    
    lblAno = new JLabel("Adhar_No.");
    lblAno.setBounds(270,310,100,20);
    lblApath = new JLabel("Path.");
    lblApath.setBounds(450,310,100,20);
    txtadhar_no = new JTextField();
    txtadhar_no.setBounds(330,310,100,20);
    txtadharpath = new JTextField();
    txtadharpath.setBounds(490,310,100,20);
    txtid = new JTextField();
    txtid.setBounds(170,310,100,20);
    lblid = new JLabel("ID.");
    lblid.setBounds(150,310,100,20);
    
    label = new JLabel();
   label.setBounds(10,10,670,250);
    
    add(button);
    add(label);
    add(txtid);
    add(txtadhar_no);
    add(txtadharpath);
    add(lblAno);
    add(lblApath);
    add(bro);
    add(lblid);
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingSystem", "root", "");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println("Error in Connection plz Check :" + e);
        }
    
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
             int id = Integer.parseInt(txtid.getText());
             String Adhar_no;
             Adhar_no=txtadhar_no.getText();
             try{
                    pt = con.prepareStatement("insert into adharverify values(?,?,?,?)");
                    pt.setInt(1, id);
                    pt.setString(2, Adhar_no);
                    pt.setBytes(3, Adhar_card);
                    pt.setString(4,"Unverify");
                    pt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Upload Adhar Card");
                    new Login().setVisible(true);
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }
    });
     bro.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
         JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txtadharpath.setText(filename);
        
        try {
                 Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from Voterregistration where Adhar='"+txtadhar_no.getText()+"'");
                if(rs.next()){
                String id=rs.getString(1);
                txtid.setText(id);
                    
                }
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf;
            buf = new byte[10240];
            int length;
            for (length = 0; (length = fis.read(buf)) != -1;) {
                bos.write(buf, 0, length);
            }
            Adhar_card = bos.toByteArray();
      /*      ImageIcon image = new ImageIcon(in);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    label.setIcon(newImage);*/

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No Data");
        }
       }
    });
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.decode("#bdb76b"));
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);
    } 
     
    public static void main(String[] args){
        new UploadVoter();
    }
 Timer timer;
    private ImageIcon fomate = null;
    String filename = null;
    int s = 0;
    byte[] Adhar_card = null;
    }

