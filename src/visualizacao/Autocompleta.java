/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Autocompleta.java
 *
 * Created on 11/05/2010, 22:04:06
 */

package visualizacao;

import controle.ClienteCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Célio
 */
public class Autocompleta extends javax.swing.JFrame {

     JComboBox combo = null;
    String digit;
    List<String> v = null;
    ClienteCRUD cc = new ClienteCRUD();
    /** Creates new form Autocompleta */
    public Autocompleta() {
        initComponents();

         combo = new JComboBox();
         combo.setEditable(true);
         combo.setSelectedItem("");

         combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter()
      {
          public void keyReleased(KeyEvent e)
        {
              if (e.getKeyCode() != 38 )
              {
                  digit = combo.getEditor().getItem().toString();
                    try {
                        v = cc.pesq(digit);
                    } catch (SQLException ex) {
                        Logger.getLogger(Autocompleta.class.getName()).log(Level.SEVERE, null, ex);
                    }


                combo.removeAllItems();
                boolean showPopup = false;

                for (int i = 0; i < v.size(); i++)
                {
                    // if (v.get(i).indexOf(digit) != -1) {
                         combo.addItem(v.get(i));
                         showPopup = true;
                     } //}
                combo.getEditor().setItem(new String(digit));
                //JTextField textField = (JTextField) e.getSource();
                //textField.setCaretPosition(textField.getDocument().getLength());
                combo.hidePopup();
                if (showPopup)
                {
                    combo.showPopup();
                }

                }
          }
      });

    combo.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            if (combo.getSelectedIndex() == -1)
            { //WHY selection do not work without this line !!!
                combo.setSelectedItem(combo.getItemAt(0));
            }
        }
    });

            combo.setBounds(20, 20, 150, 20);
            this.getContentPane().add(combo);

            this.setVisible(true);

}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 60, 50, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(60, 180, 270, 20);

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(60, 130, 220, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        // TODO add your handling code here:
        

    }//GEN-LAST:event_jComboBox1KeyReleased




    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
  public void run() {
                new Autocompleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
