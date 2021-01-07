/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingmgmtsystem;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class VoterRegistration extends javax.swing.JFrame {

     private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Connection con;
    PreparedStatement pt;
    ResultSet rs;
    Statement st;

    public VoterRegistration() {
        initComponents();
        setconnection();
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        java.util.Date dateobj = new java.util.Date();
        lbldate.setText(df.format(dateobj));
        next();
    }

    public void setconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VotingSystem", "root", "");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println("Error in Connection plz Check :" + e);
        }
    }

    public void clear() {
        txtid.setText("");
        txtname.setText("");
        txtage.setText("");
        txtadd.setText("");
        txtnum.setText("");
        cmbstate.setSelectedItem(0);
        buttonGroup1.clearSelection();
        txtemail.setText("");
        txtpass.setText("");
        txtCpass.setText("");
        txtadhar.setText("");
    }
    public void next()
    {
       int i=0;
        try
        {
            rs=st.executeQuery("Select ID from voterregistration order by ID desc");
            rs.next();
            i=rs.getInt(1);
            i=i+1;
            txtid.setText(i+ "");
        }
        catch(Exception e)
        {
            txtid.setText("1100");
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        msgbox = new javax.swing.JOptionPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        rdomale = new javax.swing.JRadioButton();
        rdofemale = new javax.swing.JRadioButton();
        btnsubmit = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtCpass = new javax.swing.JPasswordField();
        btnexit = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        txtcountry = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtadhar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtadd = new javax.swing.JTextArea();
        cmbstate = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VOTING SYSTEM");

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Voter ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Gender :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Age :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contect No. :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("State :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Country :");

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnameFocusLost(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        txtage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtageFocusLost(evt);
            }
        });
        txtage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtageKeyPressed(evt);
            }
        });

        txtnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnumFocusLost(evt);
            }
        });
        txtnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumKeyPressed(evt);
            }
        });

        buttonGroup1.add(rdomale);
        rdomale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdomale.setText("Male");
        rdomale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rdofemale);
        rdofemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdofemale.setText("Female");
        rdofemale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnsubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsubmit.setText("Submit");
        btnsubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        btncancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Developed by sanjeev kumar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Password:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Confrom password :");

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpass.setText("jPasswordField2");
        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassMouseClicked(evt);
            }
        });
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassFocusLost(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        txtCpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCpass.setText("jPasswordField2");
        txtCpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCpassMouseClicked(evt);
            }
        });
        txtCpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpassActionPerformed(evt);
            }
        });
        txtCpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpassKeyPressed(evt);
            }
        });

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnnext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnext.setText("Next");
        btnnext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        txtcountry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcountry.setText("India");
        txtcountry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("E-Mail:");

        txtemail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Adhar Card:");

        txtadhar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtadhar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtadhar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtadharFocusLost(evt);
            }
        });
        txtadhar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtadharKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Address:");

        txtadd.setColumns(20);
        txtadd.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtadd.setRows(5);
        txtadd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtaddFocusLost(evt);
            }
        });
        txtadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtadd);

        cmbstate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbstate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select State", "Uttar pradesh", "Madhaya pradesh", "Rajasthan", "Uttarakhand", "Tamil Nadu", "Kerla", "Kolkatta", "Chandigarh", " " }));
        cmbstate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(55, 55, 55)
                                .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(jLabel12))
                            .addComponent(jLabel11)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(29, 29, 29)))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtid)
                                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbstate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtnum, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(112, 112, 112))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rdomale)
                                        .addGap(125, 125, 125)))
                                .addComponent(rdofemale)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtadhar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpass, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtadhar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbstate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtcountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel15)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdomale)
                    .addComponent(rdofemale))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/votingmgmtsystem/tmu3.gif"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel13.setText("VOTING SYSTEM");

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Voter Registration");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        lblback.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblback.setForeground(new java.awt.Color(102, 102, 255));
        lblback.setText("Back...");
        lblback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(lblback)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblback))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        if(!txtid.getText().equals("") && !txtname.getText().equals("") && !txtadd.getText().equals("") &&!txtadhar.getText().equals("")&& !cmbstate.getSelectedItem().equals("Select State") && ! txtage.getText().equals("") && ! txtnum.getText().equals("") && ! txtcountry.getText().equals("")&& !txtemail.getText().equals("")&&!buttonGroup1.getSelection().equals(buttonGroup1.isSelected(null)))
             {
            String str=txtemail.getText();
            int l=str.indexOf('@');
            int ds=str.indexOf('.');
             if(l==-1 || ds==-1)
             {
                     msgbox.showMessageDialog(null,"Plz....enter valid email(@ and . symbol must)");
                     txtemail.setText("");
                     txtemail.requestFocus();
                     
            }
          else {
            int id = Integer.parseInt(txtid.getText());
            String name, num, st, co, ge, adhar,add, age,pass,cpass,email,date;
            pass=txtpass.getText();
            cpass=txtCpass.getText();
            num = txtnum.getText();
            age = txtage.getText();
            name = txtname.getText();
            st =(String) cmbstate.getSelectedItem();
            if(cmbstate.getSelectedItem().equals("Select State"))
            {
                 msgbox.showMessageDialog(this,"Select any One State","Failure",2,null);
            }
            add = txtadd.getText();
            co =txtcountry.getText();
            adhar=txtadhar.getText();
            email=txtemail.getText();
            date=lbldate.getText();
            ge = " ";
            if (rdomale.isSelected() == true) {
                ge = "Male";
            }
            if (rdofemale.isSelected() == true) {
                ge = "Female";
            }
             if(pass.equals(cpass)==false)
             {
                msgbox.showMessageDialog(this,"password missMatch","Failure",2,null);
             }
        else {
                 
                try {
                   pt = con.prepareStatement("insert into voterregistration values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pt.setInt(1, id);
                    pt.setString(2, name);
                    pt.setString(3, age);
                    pt.setString(4, ge);
                    pt.setString(5, add);
                    pt.setString(6, st);
                    pt.setString(7, co);
                    pt.setString(8, num);
                    pt.setString(9, adhar);
                    pt.setString(10, email);
                    pt.setString(11, pass);
                    pt.setString(12, "LogOut");
                    pt.setString(13, "Unregisted");
                    pt.executeUpdate();
                    pt = con.prepareStatement("insert into history values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pt.setInt(1, id);
                    pt.setString(2, name);
                    pt.setString(3, age);
                    pt.setString(4, ge);
                    pt.setString(5, add);
                    pt.setString(6, st);
                    pt.setString(7, co);
                    pt.setString(8, num);
                    pt.setString(9, adhar);
                    pt.setString(10, "");
                    pt.setString(11, email);
                    pt.setString(12, pass);
                    pt.setString(13, date);
                    pt.setString(14, "new Entry");
                    pt.executeUpdate();
                    msgbox.showMessageDialog(this, "detail saved  successfully", "Save", 1, null);
                    new UploadVoter().setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    msgbox.showMessageDialog(this, "This detail is already exist", "Unsave", 2, null);
                }}}}
              else
             {
                   msgbox.showMessageDialog(null,"Please ensure that all field are compulsory");   
             }

    }//GEN-LAST:event_btnsubmitActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
       txtpass.setText("");
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtCpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpassActionPerformed
        txtCpass.setText("");
    }//GEN-LAST:event_txtCpassActionPerformed

    private void txtnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyChar()>=evt.VK_0  && evt.getKeyChar()<=evt.VK_9 || evt.getKeyCode()==evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_ENTER)
        {  
        }
        else
        {
            msgbox.showMessageDialog(null,"Enter only digit");
            txtnum.setText("");
            txtnum.requestFocus();
        }
    }//GEN-LAST:event_txtnumKeyPressed

    private void txtpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseClicked
        // TODO add your handling code here:
        txtpass.setText("");
    }//GEN-LAST:event_txtpassMouseClicked

    private void txtCpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpassMouseClicked
        // TODO add your handling code here:
        txtCpass.setText("");
    }//GEN-LAST:event_txtCpassMouseClicked

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
          if(!txtid.getText().equals("") && !txtname.getText().equals("") && !txtadd.getText().equals("") &&!txtadhar.getText().equals("")&& !cmbstate.getSelectedItem().equals("Select State") && ! txtage.getText().equals("") && ! txtnum.getText().equals("") && ! txtcountry.getText().equals("")&& !txtemail.getText().equals("")&&!buttonGroup1.getSelection().equals(buttonGroup1.isSelected(null)))
             {
            String str=txtemail.getText();
            int l=str.indexOf('@');
            int ds=str.indexOf('.');
             if(l==-1 || ds==-1)
             {
                     msgbox.showMessageDialog(null,"Plz....enter valid email(@ and . symbol must)");
                     txtemail.setText("");
                     txtemail.requestFocus();
                     
            }
          else {
            int id = Integer.parseInt(txtid.getText());
            String name, num, st, co, ge, adhar,add, age,pass,cpass,email,date;
            pass=txtpass.getText();
            cpass=txtCpass.getText();
            num = txtnum.getText();
            age = txtage.getText();
            name = txtname.getText();
            st = (String)cmbstate.getSelectedItem();
            add = txtadd.getText();
            co =txtcountry.getText();
            adhar=txtadhar.getText();
            email=txtemail.getText();
            date=lbldate.getText();
            ge = " ";
            if (rdomale.isSelected() == true) {
                ge = "Male";
            }
            if (rdofemale.isSelected() == true) {
                ge = "Female";
            }
             if(pass.equals(cpass)==false)
             {
                msgbox.showMessageDialog(this,"password missMatch","Failure",2,null);
             }
        else {
                 
                try {
                    pt = con.prepareStatement("insert into voterregistration values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pt.setInt(1, id);
                    pt.setString(2, name);
                    pt.setString(3, age);
                    pt.setString(4, ge);
                    pt.setString(5, add);
                    pt.setString(6, st);
                    pt.setString(7, co);
                    pt.setString(8, num);
                    pt.setString(9, adhar);
                    pt.setString(10, email);
                    pt.setString(11, pass);
                    pt.setString(12, "LogOut");
                     pt.setString(13, "Unregisted");
                    pt.executeUpdate();
                    pt = con.prepareStatement("insert into history values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pt.setInt(1, id);
                    pt.setString(2, name);
                    pt.setString(3, age);
                    pt.setString(4, ge);
                    pt.setString(5, add);
                    pt.setString(6, st);
                    pt.setString(7, co);
                    pt.setString(8, num);
                    pt.setString(9, adhar);
                    pt.setString(10, "");
                    pt.setString(11, email);
                    pt.setString(12, pass);
                    pt.setString(13, date);
                    pt.setString(14, "new Entry");
                    pt.executeUpdate();
                 
                    msgbox.showMessageDialog(this, "detail saved  successfully", "Save", 1, null);
                   clear();
                   next();
                } catch (Exception ex) {
                    msgbox.showMessageDialog(this, "This detail is already exist", "Unsave", 2, null);
                }}}}
              else
             {
                   msgbox.showMessageDialog(null,"Please ensure that all field are compulsory");   
             }
    }//GEN-LAST:event_btnnextActionPerformed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode()==evt.VK_ENTER) {
            txtpass.requestFocus();
        }
    }//GEN-LAST:event_txtpassKeyPressed

    private void txtCpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpassKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode()==evt.VK_ENTER) {
            txtCpass.requestFocus();
        }
    }//GEN-LAST:event_txtCpassKeyPressed

    private void txtnumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnumFocusLost
        // TODO add your handling code here:
         int len=txtnum.getText().length();
        
        if (len>0)
        {
            if(len<10 || len>11)
            {
                msgbox.showMessageDialog(null,"Enter proper number only 10 digit");
                txtnum.setText("");
                txtnum.requestFocus();    
            }    
        }
    }//GEN-LAST:event_txtnumFocusLost

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
         int ascii=evt.getKeyCode();
     
        if(ascii>=65 && ascii<=90 || ascii==16 || ascii==8 || ascii==20 || ascii==32)
        {
            
            
        }
        else
        {
            msgbox.showMessageDialog(null,"Enter only character");
            txtname.setText("");
            txtname.requestFocus();
        }
    }//GEN-LAST:event_txtnameKeyPressed

    private void txtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusLost
        // TODO add your handling code here:
        String s1,s2,s3,s;
     
      s=txtname.getText();
      s1=s.substring(0,1);
     
      s2=s1.toUpperCase();
      s3=s.substring(1);
      s=s2+s3;
      txtname.setText(s);
    }//GEN-LAST:event_txtnameFocusLost

    private void txtageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtageKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()>=evt.VK_0  && evt.getKeyChar()<=evt.VK_9 || evt.getKeyCode()==evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_ENTER)
        {
        }
        else
        {
            msgbox.showMessageDialog(null,"Enter only digit");
            txtage.setText("");
            txtage.requestFocus();
        }
    }//GEN-LAST:event_txtageKeyPressed

    private void txtageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtageFocusLost
        // TODO add your handling code here:
        int len=Integer.parseInt(txtage.getText());

        if(len<18 || len>1000)
        {
            msgbox.showMessageDialog(null,"Your Age greater then 18");
            txtage.setText("");
            txtage.requestFocus();
        }
    }//GEN-LAST:event_txtageFocusLost

    private void txtadharFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtadharFocusLost
        // TODO add your handling code here:
         int len=txtadhar.getText().length();
        
        if (len>0)
        {
            if(len<12 || len>13)
            {
                msgbox.showMessageDialog(null,"Valid Enter only 12 digit");
                txtadhar.setText("");
                txtadhar.requestFocus();    
            }    
        }
    }//GEN-LAST:event_txtadharFocusLost

    private void txtadharKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadharKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyChar()>=evt.VK_0  && evt.getKeyChar()<=evt.VK_9 || evt.getKeyCode()==evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_ENTER)
        {  
        }
        else
        {
            msgbox.showMessageDialog(null,"Enter only digit");
            txtadhar.setText("");
            txtadhar.requestFocus();
        }
    }//GEN-LAST:event_txtadharKeyPressed

    private void txtaddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaddFocusLost
        // TODO add your handling code here:
         String s1,s2,s3,s;
     
      s=txtadd.getText();
      s1=s.substring(0,1);
     
      s2=s1.toUpperCase();
      s3=s.substring(1);
      s=s2+s3;
      txtadd.setText(s);
    }//GEN-LAST:event_txtaddFocusLost

    private void txtaddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddKeyPressed
        // TODO add your handling code here:
        int ascii=evt.getKeyCode();
     
        if(ascii>=65 && ascii<=90 || ascii==16 || ascii==8 || ascii==20 || ascii==32)
        {
            
            
        }
        else
        {
            msgbox.showMessageDialog(null,"Enter only character");
            txtname.setText("");
            txtname.requestFocus();
        }
    }//GEN-LAST:event_txtaddKeyPressed

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        // TODO add your handling code here:
        String email=txtemail.getText();
    Pattern p = Pattern.compile(EMAIL_PATTERN);
    Matcher m = p.matcher(email);
    boolean matchFound = m.matches();
        
        if(!matchFound)
            msgbox.showMessageDialog(null,"Wrong Format of Email");

    }//GEN-LAST:event_txtemailFocusLost

    private void lblbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbackMouseClicked
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblbackMouseClicked

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
        // TODO add your handling code here:
          int len=txtnum.getText().length();
        
        if (len>0)
        {
            if(len<8 || len>15)
            {
                msgbox.showMessageDialog(null,"Enter proper number only 8-15 digit");
                txtnum.setText("");
                txtnum.requestFocus();    
            }    
        }
    }//GEN-LAST:event_txtpassFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VoterRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoterRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoterRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoterRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoterRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnsubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbstate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblback;
    private javax.swing.JLabel lbldate;
    private javax.swing.JOptionPane msgbox;
    private javax.swing.JRadioButton rdofemale;
    private javax.swing.JRadioButton rdomale;
    private javax.swing.JPasswordField txtCpass;
    private javax.swing.JTextArea txtadd;
    private javax.swing.JTextField txtadhar;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcountry;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables

}
