import java.sql.SQLException;
import java.util.List;

/**
 * Created by hasee on 2017/9/11.
 */
public interface PersonDao {
    public  void  add(User user)throws SQLException;
    public  void  update(User user)throws SQLException;
    public  void  deletle(int id)throws SQLException;
    public  User  findbyid(int user)throws SQLException;
    public List<User> findAll()throws SQLException;
}
