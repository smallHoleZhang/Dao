import java.sql.SQLException;
import java.util.List;

/**
 * Created by hasee on 2017/9/11.
 */
public class Test {
    public static void main(String[] args) {
        PersonDaolmpl personDaolmpl = new PersonDaolmpl();
       /* User user = new User();
        user.setName("晒比");
        user.setAge(12);
        user.setSex("男");
        try {
            personDaolmpl.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }*/
        try {
           personDaolmpl.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
