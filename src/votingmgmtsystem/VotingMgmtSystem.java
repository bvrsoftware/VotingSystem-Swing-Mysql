/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingmgmtsystem;

/**
 *
 * @author ADMIN
 */
public class VotingMgmtSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         final Welcome w=new Welcome(); 
        w.setVisible(true);
        for (int i = 0; i <= 100; i++) 
        {
            final int percent = i;
            try 
            {
               java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() 
                    {
                        w.updateBar(percent);
                    }
                });
                java.lang.Thread.sleep(100);
             } 
             catch (InterruptedException e) 
             {
                 
             }
        }
    }
    
}
