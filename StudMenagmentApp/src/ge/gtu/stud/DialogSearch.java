package ge.gtu.stud;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialogSearch extends JDialog {
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JButton jButtonSearch = new JButton();
  

  JPanel jPanel5 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  FlowLayout flowLayout1 = new FlowLayout();
  FlowLayout flowLayout2 = new FlowLayout();
  FlowLayout flowLayout3 = new FlowLayout();
  FlowLayout flowLayout4 = new FlowLayout();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField jTextFieldName = new JTextField();
  JTextField jTextFieldSurname = new JTextField();
  JTextField jTextFieldAge = new JTextField();
  JTextField jTextFieldGroup = new JTextField();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel9 = new JPanel();
  JPanel jPanel10 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable jTable1 = new JTable();
  
 
  
  JTextField jTextFieldName1 = new JTextField();
  JLabel jLabel6 = new JLabel();
  FlowLayout flowLayout5 = new FlowLayout();
  JPanel jPanel11 = new JPanel();
  JTextField jTextFieldGroup1 = new JTextField();
  JLabel jLabel7 = new JLabel();
  FlowLayout flowLayout6 = new FlowLayout();
  JTextField jTextFieldSurname1 = new JTextField();
  JPanel jPanel12 = new JPanel();
  FlowLayout flowLayout7 = new FlowLayout();
  JLabel jLabel8 = new JLabel();
  JPanel jPanel13 = new JPanel();
  JTextField jTextFieldAge1 = new JTextField();
  FlowLayout flowLayout8 = new FlowLayout();
  JPanel jPanel14 = new JPanel();
  JLabel jLabel9 = new JLabel();
  ListSelectionModel selectionModel=jTable1.getSelectionModel();
    Connection con = null;
  public DialogSearch(Frame frame, String title, Connection con,boolean modal) {
    super(frame, title, modal);
    try {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.con = con;
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }


  public DialogSearch(Connection con) {
      this(new Frame(), "DialogInsertGroup", con, false);
  }
  DefaultTableModel tableModel=null;
  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setMinimumSize(new Dimension(10, 10));
    jPanel1.setPreferredSize(new Dimension(10, 180));
    jPanel1.setRequestFocusEnabled(true);
    jPanel1.setLayout(borderLayout2);
    jButtonSearch.setText("Search");
    jButtonSearch.addActionListener(new DialogSearch_jButtonSearch_actionAdapter(this));
    BoxLayout verticalFlowLayout1 = new BoxLayout(jPanel3,BoxLayout.PAGE_AXIS);
    jPanel3.setLayout(verticalFlowLayout1);
    jPanel5.setLayout(flowLayout1);
    jPanel6.setLayout(flowLayout2);
    jPanel7.setLayout(flowLayout3);
    jPanel8.setLayout(flowLayout4);
    jLabel2.setText("Name");
    jLabel3.setText("Surname");
    jLabel4.setText("Age");
    jLabel5.setToolTipText("");
    jLabel5.setText("Group");
    jTextFieldName.setToolTipText("");
    jTextFieldName.setText("");
    jTextFieldName.setColumns(15);

    jTextFieldSurname.setText("");
    jTextFieldSurname.setColumns(20);
    jTextFieldGroup.setText("");
    jTextFieldGroup.setColumns(12);
    jTextFieldAge.setText("");
    jTextFieldAge.setColumns(30);
    jPanel2.setLayout(borderLayout3);
    jPanel9.setLayout(borderLayout4);
    BoxLayout verticalFlowLayout2 = new BoxLayout(jPanel10,BoxLayout.PAGE_AXIS);
    jPanel10.setLayout(verticalFlowLayout2);
    jTextFieldName1.setColumns(15);
    jTextFieldName1.setText("");
    jTextFieldName1.setToolTipText("");
    jLabel6.setText("Age");
    jPanel11.setLayout(flowLayout8);
    jTextFieldGroup1.setText("");
    jTextFieldGroup1.setColumns(12);
    jLabel7.setText("Surname");

    jTextFieldSurname1.setText("");
    jTextFieldSurname1.setColumns(15);
    jPanel12.setLayout(flowLayout7);
    jLabel8.setText("Name");
    jPanel13.setLayout(flowLayout6);
    jTextFieldAge1.setText("");
    jTextFieldAge1.setColumns(15);
    jPanel14.setLayout(flowLayout5);
    jLabel9.setToolTipText("");
    jLabel9.setText("Group");
    flowLayout7.setAlignment(FlowLayout.LEFT);
    flowLayout8.setAlignment(FlowLayout.LEFT);
    flowLayout6.setAlignment(FlowLayout.LEFT);
    flowLayout5.setAlignment(FlowLayout.LEFT);
    borderLayout4.setHgap(10);

        jTable1.setRowSelectionAllowed(true);
        selectionModel.addListSelectionListener(new
                DialogSearch_selectionModel_listSelectionAdapter(this));
        getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.CENTER);
    jPanel1.add(jPanel4,  BorderLayout.SOUTH);
    jPanel4.add(jButtonSearch, null);
    panel1.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel9, BorderLayout.CENTER);
    jPanel9.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jTable1, null);
    jPanel2.add(jPanel10,  BorderLayout.EAST);
    jPanel11.add(jLabel9, null);
    jPanel11.add(jTextFieldGroup1, null);
    jPanel10.add(jPanel12, null);
    jPanel12.add(jLabel6, null);
    jPanel12.add(jTextFieldAge1, null);
    jPanel10.add(jPanel13, null);
    jPanel13.add(jLabel7, null);
    jPanel13.add(jTextFieldSurname1, null);
    jPanel10.add(jPanel14, null);
    jPanel14.add(jLabel8, null);
    jPanel14.add(jTextFieldName1, null);
    jPanel10.add(jPanel11, null);
    jPanel3.add(jPanel5, null);
    jPanel5.add(jLabel2, null);
    jPanel5.add(jTextFieldName, null);
    jPanel3.add(jPanel6, null);
    jPanel6.add(jLabel3, null);
    jPanel6.add(jTextFieldSurname, null);
    jPanel3.add(jPanel7, null);
    jPanel7.add(jLabel4, null);
    jPanel7.add(jTextFieldAge, null);
    jPanel3.add(jPanel8, null);
    jPanel8.add(jLabel5, null);
    jPanel8.add(jTextFieldGroup, null);
    String[] colName={"Name","Surname","Age","GroupNum"};
    tableModel=new DefaultTableModel(colName,0 );
    jTable1.setModel(tableModel);
  }

  Vector<String> vec= null;
  
  void jButtonSearch_actionPerformed(ActionEvent e)
  {
   try
    {

     String fname = (jTextFieldName.getText().equals(""))?"":"st.FName like '"+jTextFieldName.getText()+"%'";

     String sname = (jTextFieldSurname.getText().equals(""))?"":"st.LName like '"+jTextFieldSurname.getText()+"%'";

      String age = (jTextFieldAge.getText().equals(""))?"":"st.Age = '"+jTextFieldAge.getText()+"' ";

      String grnum=(jTextFieldGroup.getText().equals(""))?"":"gr.Num like '"+jTextFieldGroup.getText()+"%'";
      StringBuilder sb = new  StringBuilder("") ;
      if ( !fname.isEmpty() ) sb.append(fname);
      if ( !sname.isEmpty()) {if(sb.toString().isEmpty()) sb.append(sname); else  sb.append(" and "+sname); }
      if ( !age.isEmpty()) {if(sb.toString().isEmpty()) sb.append(age); else  sb.append(" and "+age); }
      if ( !grnum.isEmpty()) {if(sb.toString().isEmpty()) sb.append(grnum); else  sb.append(" and "+grnum); }
      String flt = sb.toString();
      String filter = ( !flt.isEmpty())? " where "+ flt: "";
      List<LStudent> lst = DAO.findLStudentFromDB(con,  filter);


      int n= tableModel.getRowCount();

      //jTable1.clearSelection();
      for (int i = 0; i < n; i++) {
    	  	
    	  try {
			tableModel.removeRow(0);
		} catch (Exception e2) {
			// TODO: handle exception
			int j = 1; j+=1;
		}
      }
    
      for ( LStudent st : lst )
      {
    	  vec= new Vector<String>();  
        vec.add(st.fName);
        vec.add(st.lName);
        vec.add(""+st.age);
        vec.add(st.num);
        tableModel.addRow(vec);
        
      }
      
      jTable1.revalidate();
      repaint();
    }
    catch (Exception ex) {

    }


  }

    public void selectionModel_valueChanged(ListSelectionEvent e)
    {
        int i= jTable1.getSelectedRow();
        if (i == -1) return;
        jTextFieldName1.setText((String)tableModel.getValueAt(i,0));
        jTextFieldSurname1.setText((String)tableModel.getValueAt(i,1));
        jTextFieldAge1.setText((String)tableModel.getValueAt(i,2));
        jTextFieldGroup1.setText((String)tableModel.getValueAt(i,3));
        
        jTable1.clearSelection();
        jTable1.revalidate();
        repaint();

    }
}


class DialogSearch_selectionModel_listSelectionAdapter implements
        ListSelectionListener {
    private DialogSearch adaptee;
    DialogSearch_selectionModel_listSelectionAdapter(DialogSearch adaptee) {
        this.adaptee = adaptee;
    }

    public void valueChanged(ListSelectionEvent e) {
        adaptee.selectionModel_valueChanged(e);
    }
}


class DialogSearch_jButtonSearch_actionAdapter implements java.awt.event.ActionListener {
  DialogSearch adaptee;

  DialogSearch_jButtonSearch_actionAdapter(DialogSearch adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButtonSearch_actionPerformed(e);
  }
}
