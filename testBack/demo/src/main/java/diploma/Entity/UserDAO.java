package diploma.Entity;

import diploma.DAO.UserInterface;
import diploma.Mappers.UserMapper;
import diploma.Model.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class UserDAO implements UserInterface<User> {
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUser(String email, String password, String role) {
        String SQL = "select * from user where email = ? AND password = ? AND usertype = ?";
        try {
            User result = jdbcTemplateObject.queryForObject(SQL, new UserMapper(), email, password, role);
            return result;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User regUser(User user) {
        String insertQuery = "insert into user (age, email, password, username, usertype) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(insertQuery, user.getAge(), user.getEmail(), user.getPassword(), user.getUsername(),
                "customer");
        return null;
    }
}