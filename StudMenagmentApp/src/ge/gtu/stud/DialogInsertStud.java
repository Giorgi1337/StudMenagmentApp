package ge.gtu.stud;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;


import java.sql.*;
import java.awt.event.*;
import java.util.List;

public class DialogInsertStud extends JDialog {
    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jButtonClose = new JButton();
    JButton jButtonSave = new JButton();
    
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    JPanel jPanel6 = new JPanel();
    FlowLayout flowLayout2 = new FlowLayout();
    FlowLayout flowLayout3 = new FlowLayout();
    FlowLayout flowLayout4 = new FlowLayout();
    FlowLayout flowLayout5 = new FlowLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTextFieldName = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextFieldSurname = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jTextFieldAge = new JTextField();
    JLabel jLabel4 = new JLabel();
    JComboBox jComboBoxGroupNum = new JComboBox();
    Connection con = null;

    public DialogInsertStud(Frame owner, String title, Connection con,boolean modal) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.con=con;
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public DialogInsertStud(Connection con) {
        this(new Frame(), "DialogInsertStud", con, false);
    }

    private void jbInit() throws Exception {
        panel1.setLayout(borderLayout1);
        jPanel2.setLayout(flowLayout1);
        jButtonClose.setText("Close");
    jButtonClose.addActionListener(new DialogInsertStud_jButtonClose_actionAdapter(this));
        jButtonSave.setText("Save");
    jButtonSave.addActionListener(new DialogInsertStud_jButtonSave_actionAdapter(this));
    BoxLayout verticalFlowLayout1 = new BoxLayout(jPanel1,BoxLayout.PAGE_AXIS);
    	jPanel1.setLayout(verticalFlowLayout1);
        jPanel3.setLayout(flowLayout2);
        jPanel4.setLayout(flowLayout3);
        jPanel5.setLayout(flowLayout4);
        jPanel6.setLayout(flowLayout5);
        jLabel1.setText("სახელი");
        jTextFieldName.setText("");
        jTextFieldName.setColumns(15);
        jLabel2.setText("გვარი");
        jTextFieldSurname.setText("");
        jTextFieldSurname.setColumns(20);
        jLabel3.setText("ასაკი");
        jTextFieldAge.setText("");
        jTextFieldAge.setColumns(10);
        jLabel4.setText("ჯგუფის ნომერი ");
        jComboBoxGroupNum.addActionListener(new
                DialogInsertStud_jComboBoxGroupNum_actionAdapter(this));
        getContentPane().add(panel1);
        panel1.add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.add(jPanel3);
        jPanel3.add(jLabel1);
        jPanel3.add(jTextFieldName);
        jPanel1.add(jPanel4);
        jPanel4.add(jLabel2);
        jPanel4.add(jTextFieldSurname);
        jPanel1.add(jPanel5);
        jPanel5.add(jLabel3);
        jPanel5.add(jTextFieldAge);
        jPanel1.add(jPanel6);
        jPanel6.add(jLabel4);
        jPanel6.add(jComboBoxGroupNum);
        panel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jButtonSave);
        jPanel2.add(jButtonClose);
        fillGroupCombo();
    }

    int selectedGroupId= -1;

    void fillGroupCombo()
    {
      try {
            List<Groupe> grNums = DAO.getGroupsFromDB(con);
            for ( Groupe gr : grNums) {
                jComboBoxGroupNum.addItem(gr);
            }

      }
      catch (Exception ex)
      {
         JOptionPane.showMessageDialog(this,"Data Read Error","Error",JOptionPane.ERROR_MESSAGE);
      }

    }

    public void jComboBoxGroupNum_actionPerformed(ActionEvent e) {
        selectedGroupId = ((Groupe)jComboBoxGroupNum.getSelectedItem()).getId();
    }

  void jButtonSave_actionPerformed(ActionEvent e)
  {
    String fname = jTextFieldName.getText();
    String lname = jTextFieldSurname.getText();
    int age = Integer.parseInt(jTextFieldAge.getText());
    Student st = new Student(0,fname,lname, 20);
    // verifivation of student

    // insert into TStudent
      Groupe gr = (Groupe) (jComboBoxGroupNum.getSelectedItem());

      DAO.insertStudentToDB(con,st,gr);
      JOptionPane.showMessageDialog(this,"მონაცემთა ბაზასთან ჩაწერის ოპერაცია წარმატებით დასრულდა","Student Dialog Status"
              ,JOptionPane.INFORMATION_MESSAGE);
    // insert into TStudGroup

  }

  void jButtonClose_actionPerformed(ActionEvent e) {
      this.dispose();
  }
}


class DialogInsertStud_jComboBoxGroupNum_actionAdapter implements
        ActionListener {
    private DialogInsertStud adaptee;
    DialogInsertStud_jComboBoxGroupNum_actionAdapter(DialogInsertStud adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jComboBoxGroupNum_actionPerformed(e);
    }
}

class DialogInsertStud_jButtonSave_actionAdapter implements java.awt.event.ActionListener {
  DialogInsertStud adaptee;

  DialogInsertStud_jButtonSave_actionAdapter(DialogInsertStud adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonSave_actionPerformed(e);
  }
}

class DialogInsertStud_jButtonClose_actionAdapter implements java.awt.event.ActionListener {
  DialogInsertStud adaptee;

  DialogInsertStud_jButtonClose_actionAdapter(DialogInsertStud adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonClose_actionPerformed(e);
  }
}
