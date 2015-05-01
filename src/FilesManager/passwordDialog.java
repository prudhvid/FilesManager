/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FilesManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Prudhvi
 */
public class passwordDialog extends javax.swing.JDialog {

    /**
     * Creates new form passwordDialog
     * @param parent
     * @param modal
     */
    LoginPreferences lp;
    public static boolean validCredentials;
    public passwordDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        validCredentials=false;
        lp=new LoginPreferences();
        if(lp.isUserPres())
        {
            signUpButton.setVisible(false);
            confirmBox.setVisible(false);
            confirmLabel.setVisible(false);
            
            passBox.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt)
                {
                    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        loginButtonActionPerformed(null);
                    }
                }
            });   
        }
        else{
            loginButton.setVisible(false);
            forgotButton.setVisible(false);
        }
        
        
        
        
        
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
        loginButton = new javax.swing.JButton();
        userBox = new javax.swing.JTextField();
        passBox = new javax.swing.JPasswordField();
        confirmLabel = new javax.swing.JLabel();
        confirmBox = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        forgotButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Password:");

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        userBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        passBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        confirmLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        confirmLabel.setText("     Confirm Password:");

        confirmBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        signUpButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        signUpButton.setText("Sign Up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        forgotButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forgotButton.setText("Forgot password");
        forgotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(confirmLabel)
                                .addGap(30, 30, 30)
                                .addComponent(confirmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(userBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(197, 197, 197))
                            .addComponent(passBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(68, 68, 68)
                        .addComponent(signUpButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(forgotButton)
                        .addGap(18, 18, 18)))
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(signUpButton))
                .addGap(28, 28, 28)
                .addComponent(forgotButton)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        String[] credentials = lp.getCredentials();
        String username=userBox.getText(),pasword=new String(passBox.getPassword());
        if(username.equals(credentials[0])&&pasword.equals(credentials[1]))
        {
            validCredentials=true;
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        if(! Arrays.equals(passBox.getPassword(), confirmBox.getPassword())){
            JOptionPane.showMessageDialog(this, "Please enter same password in both the fields");
            return;
        }
        if(userBox.getText().length()<4 || passBox.getPassword().length<4)
        {
            JOptionPane.showMessageDialog(this, "Minimum length is 4 for username and password");
            return;
        }
        lp.storeDetails(userBox.getText(), new String(passBox.getPassword()));
        JOptionPane.showMessageDialog(this, "successfully registered ");
        validCredentials=true;
        this.dispose();
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void forgotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotButtonActionPerformed
        // TODO add your handling code here:
        String username=userBox.getText(),pasword=new String(passBox.getPassword());
        if(username.length()==0||pasword.length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please enter your admin username and password to reset credentials");
            
        }
        else
        {
            String[] adminDetails = lp.getAdminDetails();
            if(username.equals(adminDetails[0])&&pasword.equals(adminDetails[1]))
            {
                lp.resetDetails();
                JOptionPane.showMessageDialog(this, "Your Credentials have successfully been reset\n Please restart the application");
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid admin details");
            }
        }
    }//GEN-LAST:event_forgotButtonActionPerformed

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
            java.util.logging.Logger.getLogger(passwordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passwordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passwordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passwordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                passwordDialog dialog = new passwordDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmBox;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JButton forgotButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passBox;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField userBox;
    // End of variables declaration//GEN-END:variables
}
