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
import java.sql.*;
import javax.swing.*;

public class VerifyAdhar extends JFrame {
    JButton button,back;
    JLabel label,lblAno,lblApath,lblid;
    JComboBox cmbid;
    JTextField txtadhar_no,txtadharpath,txtid;
    
     Connection con;
    PreparedStatement pt;
    ResultSet rs;
    Statement st;

    public VerifyAdhar(){
    super("Verify Registration from database in java");
    
   button = new JButton("Verify");
    button.setBounds(30,300,100,40);
    
    back = new JButton("Back");
     back.setBounds(570,310,100,20);
    
    lblAno = new JLabel("Adhar_No.");
    lblAno.setBounds(340,310,100,20);
    
    txtadhar_no = new JTextField();
    txtadhar_no.setBounds(400,310,100,20);
   // back.setBounds(490,310,100,20);
     txtadhar_no.setSize(150, 20);
    cmbid = new JComboBox();
    cmbid.setBounds(230,310,100,20);
    lblid = new JLabel("Select ID.");
    lblid.setBounds(150,310,100,20);
    
    label = new JLabel();
   label.setBounds(10,10,670,250);
    
    add(button);
    add(label);
    add(cmbid);
    add(txtadhar_no);
    add(lblAno);
    add(lblid);
    add(back);
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingSystem", "root", "");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println("Error in Connection plz Check :" + e);
        }
         try{
             String U="Unverify";
             pt=con.prepareStatement("select Id from adharverify Where Verify='"+U+"' order by Id ");
           rs=pt.executeQuery();
             while(rs.next())
           {
             String id;
              id=rs.getString("Id");
             cmbid.addItem(id);
             
         }
         }
         catch(Exception e){}
    
    cmbid.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from adharverify where ID = '"+(String)cmbid.getSelectedItem()+"'");
                if(rs.next()){
                    byte[] img = rs.getBytes(3);
                    String no=rs.getString(2);
                    txtadhar_no.setText(no);

                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    label.setIcon(newImage);
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }
    });
     back.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            new MainForm().setVisible(true);
        }
    });
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            int id=Integer.parseInt((String)cmbid.getSelectedItem());
            String adhar=txtadhar_no.getText();
            try{
                        pt = con.prepareStatement("update condidateregistration set RStatus=? where Id='"+id+"'and Adhar='"+adhar+"'");
                        pt.setString(1, "Registed");
                        pt.executeUpdate();
                        pt = con.prepareStatement("update voterregistration set RStatus=? where Id='"+id+"'and Adhar='"+adhar+"'");
                        pt.setString(1, "Registed");
                        pt.executeUpdate();
                        pt = con.prepareStatement("update adharverify set Verify=? where Id='"+id+"'");
                        pt.setString(1, "Verify");
                        pt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Verify successfully");
            }catch(Exception ex){
                ex.printStackTrace();
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
        new VerifyAdhar();
    }
   }
