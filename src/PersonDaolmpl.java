import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2017/9/11.
 */
public class PersonDaolmpl implements PersonDao {
    private JdbcTemplete jdbcTemplete;
    public PersonDaolmpl(){
        jdbcTemplete = new JdbcTemplete();
    }



    @Override
    public void add(User user) throws SQLException {
        String sql = "insert into person(name,age,sex)values(?,?,?)";
        jdbcTemplete.update(sql,user.getName(),user.getAge(),user.getSex());

    }

    @Override
    public void update(User user) throws SQLException {
        String sql = "update person set name=?,age=?,description=? where id=?";
        jdbcTemplete.update(sql, user.getName(),user.getAge(),user.getSex(),user.getId());

    }

    @Override
    public void deletle(int id) throws SQLException {
        String sql = "delete from person where id=?";
        jdbcTemplete.update(sql, id);

    }

    @Override
    public User findbyid(int id) throws SQLException {
        String sql = "select name,age,sex from person where id = ?";
        return (User) jdbcTemplete.query(sql, new ResultSetHandler() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                User user = null;
                if(rs.next())
                {
                    user = new User();
                    user.setId(id);
                    user.setName(rs.getString(1));
                    user.setAge(rs.getInt(2));
                    user.setSex(rs.getString(3));
                }
                return  user;
            }
        }, id);

    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "select id,name,age,sex from person";
         return (List<User>) jdbcTemplete.query(sql, new ResultSetHandler() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                List<User> persons = new ArrayList<>();
                User user = null;
                if(rs.next())
                {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setName(rs.getString(2));
                    user.setAge(rs.getInt(3));
                    user.setSex(rs.getString(4));
                    persons.add(user);

                }
                return  persons;
            }
        });

    }
}
