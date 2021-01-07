/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingmgmtsystem;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class VoterGrid extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pt;  
    ResultSet rs;
    Statement st;
    String U="Active";
    String [] cp=new String[]{"ID","Name","Age","Gender","Address","State","Country","Number","Adhar","Email","Password","Status"};
       DefaultTableModel dtmp=new DefaultTableModel(cp,0){
        @Override
        public boolean isCellEditable(int row,int column)
        {
           
                    return false;
           
        }
    };
   
       public VoterGrid() {
        initComponents();
     setconnection();
         DateFormat df=new SimpleDateFormat("dd/MM/YYYY");
         java.util.Date dateobj=new java.util.Date();
         lbldate.setText(df.format(dateobj));
         Status();
    }
    public void Status()
    {
         try{
            rs=st.executeQuery("select * from login where Status='"+U+"'");
           rs.next();
            lblid.setText(rs.getString(1));
        }catch(Exception ex){}
    }
    public void  setconnection()
    {
       try
        {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem","root","");
         st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         System.out.println("connected");
         rs=st.executeQuery("select * from voterregistration");
         fillgrid(rs);

        }
        catch(Exception e)
        {
            System.out.println("Error in Connection plz Check :" +e);
        }
    }
    public void fillgrid(ResultSet rs1)
    {
        votegrid();
        Object []ob=new Object[12];
        try
           {        
               while(rs1.next())
               {
                   
                   ob[0]=rs1.getString(1);
                   ob[1]=rs1.getString(2);
                   ob[2]=rs1.getString(3);
                   ob[3]=rs1.getString(4);
                   ob[4]=rs1.getString(5);
                   ob[5]=rs1.getString(6);
                   ob[6]=rs1.getString(7);
                   ob[7]=rs1.getString(8);
                   ob[8]=rs1.getString(9);
                   ob[9]=rs1.getString(10);
                   ob[10]=rs1.getString(11);
                   ob[11]=rs1.getString(12);
                   dtmp.addRow(ob);
                   votergrid.setModel(dtmp);
               }    
           }
           catch(Exception e)
           {
               e.printStackTrace(); 
           }
  }
        public void votegrid()
  {
      int rc=dtmp.getRowCount();
        for(int i=0;i<rc;i++)
        {
            dtmp.removeRow(0);
        }
  }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgbox = new javax.swing.JOptionPane();
        cmbsearch = new javax.swing.JComboBox();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        votergrid = new javax.swing.JTable();
        lbldate = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbldate1 = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VOTING SYSTEM");

        cmbsearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search With", "Id", "Name", "Number", "Address", "Age", "Gender", "Email", "State", " " }));
        cmbsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsearchActionPerformed(evt);
            }
        });

        txtsearch.setText("  Search");
        txtsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        votergrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(votergrid);

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/votingmgmtsystem/tmu3.gif"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setText("VOTING SYSTEM");

        lbldate1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbllogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllogout.setForeground(new java.awt.Color(0, 0, 255));
        lbllogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/votingmgmtsystem/exit.png"))); // NOI18N
        lbllogout.setText("LogOut");
        lbllogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoutMouseClicked(evt);
            }
        });

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 0, 51));
        lblid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Voter Detail");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(293, 293, 293)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbllogout)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(lbldate1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldate1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbllogout)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnback))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnback)
                            .addComponent(btnexit))
                        .addGap(1, 1, 1)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
         String un=lblid.getText();
        try{
            pt = con.prepareStatement("update login set Status=? where Username='"+un+"'");
            pt.setString(1, "LogOut");
            pt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void cmbsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsearchActionPerformed

    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        // TODO add your handling code here:
        String combo=(String)cmbsearch.getSelectedItem();
        if(combo.equals("Search With")==true)
        msgbox.showMessageDialog(this,"Please select search type ","Suggestion",3, null);
        else
        txtsearch.setText("");
    }//GEN-LAST:event_txtsearchMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String str,combo=(String)cmbsearch.getSelectedItem();
        str=txtsearch.getText();
        if(combo.equals("Id")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Id like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(combo.equals("Name")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Name like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
         if(combo.equals("Email")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Email like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(combo.equals("State")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where State like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
         if(combo.equals("Age")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Age like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(combo.equals("Address")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Address like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
         if(combo.equals("Number")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Number like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
         if(combo.equals("Gender")==true)
        {
            try{
                rs=st.executeQuery("select * from voterregistration where Gender like '%"+str+"%'");
                fillgrid(rs);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void lbllogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseClicked
        // TODO add your handling code here:
        String un=lblid.getText();
        try{
            pt = con.prepareStatement("update login set Status=? where Username='"+un+"'");
            pt.setString(1, "LogOut");
            pt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbllogoutMouseClicked

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
            java.util.logging.Logger.getLogger(VoterGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoterGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoterGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoterGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoterGrid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnexit;
    private javax.swing.JComboBox cmbsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate1;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JOptionPane msgbox;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTable votergrid;
    // End of variables declaration//GEN-END:variables
}
