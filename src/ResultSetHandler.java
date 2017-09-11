import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hasee on 2017/9/11.
 */
public interface ResultSetHandler {
    public Object doHandler(ResultSet rs)throws SQLException;
}
