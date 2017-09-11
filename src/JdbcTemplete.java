import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hasee on 2017/9/11.
 */
public class JdbcTemplete {
    public int update(String sql,Object...args)
    {
        Connection connection =null;
        PreparedStatement pstm = null;
        try {
            connection = DBUtils.getConnection();
            pstm = connection.prepareStatement(sql);
            if(args!= null)
            {
                for(int i = 0;i<args.length;i++)
                {
                    pstm.setObject(i+1,args[i]);
                }
            }
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return  -1;
        }
        finally{
            DBUtils.close(null, pstm, connection);
        }
    }
    public  Object query(String sql,ResultSetHandler handler,Object...args)
    {
        Connection conn  = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        conn = DBUtils.getConnection();
        try {
            pstm = conn.prepareStatement(sql);
            if(args!=null)
            {
                for(int i = 0 ; i<args.length;i++)
                {
                    pstm.setObject(i+1,args[i]);
                }
            }
            rs = pstm.executeQuery();
            return handler.doHandler(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
