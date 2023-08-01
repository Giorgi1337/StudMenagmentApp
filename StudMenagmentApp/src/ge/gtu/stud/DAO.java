package ge.gtu.stud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static Connection connectToDB() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbinfstud?useSSL=false";
            Connection jdbcConnection = DriverManager.getConnection(
                    url,
                    "root",
                    "qwerty"
            );
            return jdbcConnection;
        } catch (ClassNotFoundException e) {
            throw new Exception(e.getMessage());

        } catch (SQLException e1) {
            throw new Exception(e1.getMessage());
        }

    }

    public static void insertStudentToDB(Connection con, Student st,Groupe gr) {
        //  write dat to db
        try {
            String sqlInsertSt = "INSERT INTO dbinfstud.student (FName, LName, Age) VALUES (?,?,?)";
            PreparedStatement  p = con.prepareStatement(sqlInsertSt,PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1,st.getfName());
            p.setString(2, st.getlName());
            p.setInt(3, st.getAge());

            int resId = p.executeUpdate();
            // ბოლო ჩანაწერის აიდ-ის გამოთვლა
            ResultSet generatedKeysResultSet = p.getGeneratedKeys();
            generatedKeysResultSet.next();
            int stId = generatedKeysResultSet.getInt(1);
            //გამოვითვალეთ ჩაწერილი სტუდენტის აიდი
            if ( gr != null) {

                int grId = gr.getId();
                String sqlInsertGr = "INSERT INTO `dbinfstud`.`studentgroup` (`StudentId`, `GroupId`) VALUES (?,?)";
                PreparedStatement  p1 = con.prepareStatement(sqlInsertGr);
                p1.setInt(1, stId);
                p1.setInt(2, grId);
                p1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudentToDB(Connection con/*, Student st*/) {
        //  write dat to db
        try {
            Statement cmd_statement = con.createStatement();
            String sqUpdate = "UPDATE dbinfstud.student SET LName = 'ვარდოშვილი' WHERE (id = '8')";
            cmd_statement.executeUpdate(sqUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentFromDB(Connection con,int studId) {
        Student st = null;
        try {


            String sql = "SELECT * FROM dbinfstud.student where id =?";
            PreparedStatement  p = con.prepareStatement(sql);
            p.setInt(1,studId);
            ResultSet resultSet = p.executeQuery(sql);
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString("FName");
                String lname = resultSet.getString("LName");
                int age = resultSet.getInt(4);
                 st = new Student(id,fname,lname,age);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static List<Student> findStudentFromDB(Connection con, String filter) {
        //  write dat to db
        List<Student> lst = null;

        try {
            if (filter==null) filter="";
            Statement cmd_statement = con.createStatement();
            String sql = "SELECT * FROM dbinfstud.student "+filter;
            lst = new ArrayList<Student>();

            ResultSet resultSet = cmd_statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString("FName");
                String lname = resultSet.getString("LName");
                int age = resultSet.getInt(4);
                Student st = new Student(id,fname,lname,age);
                lst.add(st);
                //System.out.println("id=" + id + " fname=" + fname + " lname=" + lname + " age=" + age);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }
    public static List<LStudent> findLStudentFromDB(Connection con, String filter) {
        //  write dat to db
        List<LStudent> lst = null;

        try {
            if (filter==null) filter="";
            Statement cmd_statement = con.createStatement();
            String sql = "SELECT st.*,gr.*" +
                    " FROM dbinfstud.student st" +
                    " join dbinfstud.studentgroup stgr on  st.id= stgr.StudentId" +
                    " join dbinfstud.group gr on stgr.GroupId = gr.id"+filter;
            lst = new ArrayList<LStudent>();

            ResultSet resultSet = cmd_statement.executeQuery(sql);
            while (resultSet.next()) {
                int stid = resultSet.getInt(1);
                String fname = resultSet.getString("FName");
                String lname = resultSet.getString("LName");
                int age = resultSet.getInt(4);
                int grid = resultSet.getInt(5);
                String num = resultSet.getString("Num");
                String spec = resultSet.getString("spec");

                LStudent st = new LStudent(stid,fname,lname,age,grid,num,spec);
                lst.add(st);
                //System.out.println("id=" + id + " fname=" + fname + " lname=" + lname + " age=" + age);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }
    public static void insertGroupToDB(Connection con, Groupe gr) throws Exception{
        try {
            String sqlInsertSt = "INSERT INTO dbinfstud.group (Num, spec) VALUES (?,?)";
            PreparedStatement  p = con.prepareStatement(sqlInsertSt);
            p.setString(1,gr.getNum());
            p.setString(2, gr.getSpeciality());
            int resId = p.executeUpdate();

        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Groupe getGroupeFromDB(Connection con,int grId) {
        Groupe gr = null;
        try {
            String sql = "SELECT * FROM dbinfstud.group where id =?";
            PreparedStatement  p = con.prepareStatement(sql);
            p.setInt(1,grId);
            ResultSet resultSet = p.executeQuery(sql);
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String num = resultSet.getString("Num");
                String spec = resultSet.getString("spec");
                gr = new Groupe(spec,  num ,   id );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gr;
    }


    public static void updateGroupToDB(Connection con, Groupe gr) {

    }
    public static List<Groupe> getGroupsFromDB(Connection con) {
        //  write dat to db
        List<Groupe> lstgr = null;

        try {
            Statement cmd_statement = con.createStatement();
            String sql = "SELECT distinct id,Num FROM dbinfstud.group";
            lstgr = new ArrayList<Groupe>();

            ResultSet resultSet = cmd_statement.executeQuery(sql);
            while (resultSet.next()) {
                String num = resultSet.getString("Num");
                int id =  resultSet.getInt("id");
                String spec =  resultSet.getString("Num");
                Groupe gr= new Groupe(spec,num,id);
                lstgr.add(gr);
                //System.out.println("id=" + id + " fname=" + fname + " lname=" + lname + " age=" + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstgr;
    }
}
