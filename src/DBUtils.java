import java.sql.*;

/**
 * Created by hasee on 2017/9/11.
 */
public class DBUtils {

    public static  String URL =  "jdbc:mysql://localhost:3306/student?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";;
    public static  String name = "com.mysql.jdbc.Driver";
    public static  String username ="root" ;
    public static  String password = "695509zhang";

    private DBUtils()
    {}
    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,username,password);
            return  conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取Connection对象失败"+e.toString());
            return  null;
        }
    }
    public static void close(ResultSet rs, Statement stat, Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
