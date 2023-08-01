package ge.gtu.stud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.*;

public class DialogInsGroup extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  FlowLayout flowLayout1 = new FlowLayout();
  JButton jButtonSave = new JButton();
  JButton jButtonClose = new JButton();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  FlowLayout flowLayout2 = new FlowLayout();
  FlowLayout flowLayout3 = new FlowLayout();
  JLabel jLabel1 = new JLabel();
  JTextField jTextFieldNum = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField jTextFieldSpec = new JTextField();
  Connection con=null;
  public DialogInsGroup(Frame frame, String title, Connection con, boolean modal) {
    super(frame, title, modal);
    this.con = con;
    try {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogInsGroup(Connection con) {
    this(new Frame(), "DialogInsertGroup", con, false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel2.setLayout(flowLayout1);
    jButtonSave.setActionCommand("jButtonSave");
    jButtonSave.setText("Save");
    jButtonClose.setMinimumSize(new Dimension(71, 23));
    jButtonClose.setToolTipText("");
    jButtonClose.setText("jClose");
    jButtonClose.addActionListener(new DialogInsGroup_jButtonClose_actionAdapter(this));
    jButtonSave.addActionListener(new DialogInsGroup_jButtonSave_actionAdapter(this));
    jPanel1.setLayout(gridLayout1);
    gridLayout1.setRows(2);
    jPanel3.setLayout(flowLayout2);
    jPanel4.setLayout(flowLayout3);
    jLabel1.setText("Number");
    jLabel2.setText("Speciality");
    jTextFieldSpec.setText("");
    jTextFieldSpec.setColumns(20);
    jTextFieldNum.setText("");
    jTextFieldNum.setColumns(12);
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.CENTER);
    jPanel3.add(jLabel1, null);
    jPanel3.add(jTextFieldNum, null);
    jPanel1.add(jPanel3, null);
    jPanel1.add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(jTextFieldSpec, null);
    panel1.add(jPanel2,  BorderLayout.SOUTH);
    jPanel2.add(jButtonSave, null);
    jPanel2.add(jButtonClose, null);
  }
  void jButtonSave_actionPerformed(ActionEvent e)
  {
    String num = jTextFieldNum.getText();
    String spec = jTextFieldSpec.getText();

    Groupe gr = new Groupe(spec,num, 0);
    // verifivation


    //
    try {
      DAO.insertGroupToDB(con,gr);
      JOptionPane.showMessageDialog(this,"მონაცემთა ბაზასთან ჩაწერის ოპერაცია წარმატებით დასრულდა","Group Dialog Status"
              ,JOptionPane.INFORMATION_MESSAGE);
      // insert into TStudGroup
    } catch (Exception e1) {
      JOptionPane.showMessageDialog(this,"შეცდომა: მონაცემთა ბაზასთან ჩაწერის ოპერაცია წარუმატებლად დასრულდა","Group Dialog Status"
              ,JOptionPane.ERROR_MESSAGE);
      // insert into TStudGroup
    }


  }

  void jButtonClose_actionPerformed(ActionEvent e) {
     this.dispose();
  }
}
class DialogInsGroup_jButtonSave_actionAdapter implements java.awt.event.ActionListener {
  DialogInsGroup adaptee;

  DialogInsGroup_jButtonSave_actionAdapter(DialogInsGroup adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonSave_actionPerformed(e);
  }
}

class DialogInsGroup_jButtonClose_actionAdapter implements java.awt.event.ActionListener {
  DialogInsGroup adaptee;

  DialogInsGroup_jButtonClose_actionAdapter(DialogInsGroup adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonClose_actionPerformed(e);
  }
}