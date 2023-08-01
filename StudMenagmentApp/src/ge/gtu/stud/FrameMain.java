package ge.gtu.stud;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FrameMain extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JMenuItem jMenuItemConnect = new JMenuItem();
    JMenuItem jMenuItemDiscon = new JMenuItem();
    Connection con;
    public FrameMain() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("Frame Title");
        jMenuFile.setText("DB");
        jMenuFileExit.setText("Exit");
        jMenuFileExit.addActionListener(new
                                        FrameMain_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("Help");
        jMenuHelpAbout.setText("About");
        jMenuHelpAbout.addActionListener(new
                                         FrameMain_jMenuHelpAbout_ActionAdapter(this));
        jMenuItemConnect.setText("Connect");
        jMenuItemConnect.addActionListener(new
                FrameMain_jMenuItemConnect_actionAdapter(this));
        jMenuItemDiscon.setEnabled(false);
        jMenuItemDiscon.setText("Disconnect");
        jMenuItemDiscon.addActionListener(new
                FrameMain_jMenuItemDiscon_actionAdapter(this));
        jMenuIOper.setText("Operation");
        jMenu1.setText("Insert");
    jMenuItemInsStud.setText("Student");
    jMenuItemInsStud.addActionListener(new FrameMain_jMenuItemInsStud_actionAdapter(this));
    jMenuItemInsGroup.setText("Group");
    jMenuItemInsGroup.addActionListener(new FrameMain_jMenuItemInsGroup_actionAdapter(this));
    jMenuItemSearch.setText("Search");
    jMenuItemSearch.addActionListener(new FrameMain_jMenuItemSearch_actionAdapter(this));
    jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenuIOper);
        jMenuFile.add(jMenuItemConnect);
        jMenuFile.add(jMenuItemDiscon);
        jMenuFile.add(jMenuFileExit);
        jMenuBar1.add(jMenuHelp);
        jMenuHelp.add(jMenuHelpAbout);
    jMenuIOper.add(jMenu1);
    jMenuIOper.add(jMenuItemSearch);
    jMenu1.add(jMenuItemInsGroup);
    jMenu1.add(jMenuItemInsStud);
        setJMenuBar(jMenuBar1);
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        FrameMain_AboutBox dlg = new FrameMain_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }
    public static Connection gCon= null;
    JMenu jMenuIOper = new JMenu();
  JMenu jMenu1 = new JMenu();
  JMenuItem jMenuItemInsGroup = new JMenuItem();
  JMenuItem jMenuItemInsStud = new JMenuItem();
  JMenuItem jMenuItemSearch = new JMenuItem();
    public void jMenuItemConnect_actionPerformed(ActionEvent e)
    {
        try
        {
            con = DAO.connectToDB();
            jMenuItemConnect.setEnabled(false);
            jMenuItemDiscon.setEnabled(true);
            JOptionPane.showMessageDialog(this,"მონაცემთა ბაზასთან მიერთება წარმატებით დასრულდა","Connection Status"
                    ,JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this,"Connection Error","Error",JOptionPane.ERROR_MESSAGE);

        }

    }

    public void jMenuItemDiscon_actionPerformed(ActionEvent e) {
        try {
          if (con !=null) con.close();
          jMenuItemConnect.setEnabled(true);
          jMenuItemDiscon.setEnabled(false);
        }
        catch (Exception ex) {

        }

    }

    public void jMenuItemInsGroup_actionPerformed(ActionEvent e)
    {
       DialogInsGroup dlg = new DialogInsGroup(this,"InsertGroup",con,true);
       dlg.setSize(400,300);
           dlg.show();
    }

  void jMenuItemInsStud_actionPerformed(ActionEvent e) {
          DialogInsertStud dlg = new DialogInsertStud(this,"InsertStudent",con,true);
           dlg.setSize(400,300);
           dlg.show();
  }

  void jMenuItemSearch_actionPerformed(ActionEvent e)
  {
    DialogSearch dlg =new DialogSearch(this,"Search",con,true);
    dlg.setSize(500,400);
    dlg.show();

  }
}


class FrameMain_jMenuItemDiscon_actionAdapter implements ActionListener {
    private FrameMain adaptee;
    FrameMain_jMenuItemDiscon_actionAdapter(FrameMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItemDiscon_actionPerformed(e);
    }
}


class FrameMain_jMenuItemConnect_actionAdapter implements ActionListener {
    private FrameMain adaptee;
    FrameMain_jMenuItemConnect_actionAdapter(FrameMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItemConnect_actionPerformed(e);
    }
}


class FrameMain_jMenuFileExit_ActionAdapter implements ActionListener {
    FrameMain adaptee;

    FrameMain_jMenuFileExit_ActionAdapter(FrameMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class FrameMain_jMenuHelpAbout_ActionAdapter implements ActionListener {
    FrameMain adaptee;

    FrameMain_jMenuHelpAbout_ActionAdapter(FrameMain adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}

class FrameMain_jMenuItemInsGroup_actionAdapter implements java.awt.event.ActionListener {
  FrameMain adaptee;

  FrameMain_jMenuItemInsGroup_actionAdapter(FrameMain adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemInsGroup_actionPerformed(e);
  }
}

class FrameMain_jMenuItemInsStud_actionAdapter implements java.awt.event.ActionListener {
  FrameMain adaptee;

  FrameMain_jMenuItemInsStud_actionAdapter(FrameMain adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemInsStud_actionPerformed(e);
  }
}

class FrameMain_jMenuItemSearch_actionAdapter implements java.awt.event.ActionListener {
  FrameMain adaptee;

  FrameMain_jMenuItemSearch_actionAdapter(FrameMain adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuItemSearch_actionPerformed(e);
  }
}
