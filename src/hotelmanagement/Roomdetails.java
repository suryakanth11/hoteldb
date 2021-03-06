/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Sony
 */
public class Roomdetails extends javax.swing.JFrame {
Connection con;
PreparedStatement ps;
ResultSet rs;
Statement st;
    /**
     * Creates new form Roomdetails
     */
    public Roomdetails() {
         try
{
    Class.forName("oracle.jdbc.OracleDriver");
    JOptionPane.showMessageDialog(this,"Driver Loaded Successfully");
        try
        {
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","msk11");
            JOptionPane.showMessageDialog(this, "Welcome! You are Connected to ORACLE DB Server");
        }
        catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this,"Server Not Loaded");
                }
}
        catch(Exception e1)
        {
            JOptionPane.showMessageDialog(this,"Drivers Not Loaded");
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        trno = new javax.swing.JTextField();
        trent = new javax.swing.JTextField();
        trtype = new javax.swing.JComboBox<>();
        Insert = new javax.swing.JButton();
        textrt = new javax.swing.JTextField();
        gomn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ROOMNO");

        jLabel2.setText("ROOMTYPE");

        jLabel3.setText("RENT");

        trno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trnoActionPerformed(evt);
            }
        });

        trtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deluxe", "SuperDeluxe", "Executive" }));

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        gomn.setText("GO TO MENU");
        gomn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gomnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert)
                        .addGap(52, 52, 52)
                        .addComponent(gomn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(trno)
                            .addComponent(trent)
                            .addComponent(trtype, 0, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textrt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(trno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(trtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(trent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert)
                    .addComponent(gomn))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
         String s="insert into room(roomno,roomtype,rent)values(?,?,?)";
         String itemText=(String)trtype.getSelectedItem();
         
        try{
            textrt.setText(itemText);
            ps=con.prepareStatement(s);
            ps.setString(1,trno.getText());
            ps.setString(2,textrt.getText());
           ps.setString(3,trent.getText());
            ps.execute();
          JOptionPane.showMessageDialog(this, "Record Inserted Sucessfully!");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
     clearData();
    
    }//GEN-LAST:event_InsertActionPerformed

    private void trnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trnoActionPerformed

    private void gomnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gomnActionPerformed
        // TODO add your handling code here:
        MENU ob1=new MENU();
        ob1.setVisible(true);
    }//GEN-LAST:event_gomnActionPerformed

    /**
     * @param args the command line arguments
     */
    private void clearData()
    {
         trno.setText("");
       textrt.setText("");
        trent.setText("");
        
        
    }
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
            java.util.logging.Logger.getLogger(Roomdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Roomdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Roomdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Roomdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Roomdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Insert;
    private javax.swing.JButton gomn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textrt;
    private javax.swing.JTextField trent;
    private javax.swing.JTextField trno;
    private javax.swing.JComboBox<String> trtype;
    // End of variables declaration//GEN-END:variables
}
