// package test.service.impl;

// import test.mappers.UserMapper;
// import test.model.Role;
// import test.model.User;
// import test.repository.RoleRepository;
// import test.repository.UserRepository;
// import test.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Component;

// import java.util.ArrayList;
// import java.util.List;
// import javax.sql.DataSource;

// @Component
// public class UserServiceImpl implements UserService<User> {
//     public DataSource dataSource;
//     public JdbcTemplate jdbcTemplateObject;

//     private final BCryptPasswordEncoder passwordEncoder;

//     @Autowired
//     public UserServiceImpl(BCryptPasswordEncoder passwordEncoder) {
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public void setDataSource(DataSource dataSource) {
//         this.dataSource = dataSource;
//         this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//     }

//     @Override
//     public User register(User user) {
//         // String SQL = "select * from Roles where name = ?";
//         // Role roleUser = (Role) jdbcTemplateObject.query(SQL, new UserMapper(),
//         // "ROLE_USER");
//         // List<Role> userRoles = new ArrayList<>();
//         // userRoles.add(roleUser);
//         String insertQuery = "insert into Users (username, email, first_name, last_name, password, status) values (?, ?, ?, ?, ?, ?)";
//         jdbcTemplateObject.update(insertQuery, username, email, first_name, last_name, passwordEncoder.encode(password),
//                 "ACTIVE");
//         return null;
//     }

//     @Override
//     public List<User> getAll() {
//         String SQL = "select * from Users";
//         List<User> result = jdbcTemplateObject.query(SQL, new UserMapper());
//         return result;
//     }

//     @Override
//     public User findByUsername(String username) {
//         String SQL = "select * from Users where username = ?";
//         // User result = jdbcTemplateObject.query(SQL, new UserMapper(), username);
//         jdbcTemplateObject.query(SQL, new UserMapper(), username);
//         return null;
//     }

//     @Override
//     public User findById(Long id) {
//         String SQL = "select * from Users where id = ?";
//         // User result = jdbcTemplateObject.query(SQL, new UserMapper(), id);
//         jdbcTemplateObject.query(SQL, new UserMapper(), id);
//         return null;
//     }

//     @Override
//     public void delete(Long id) {
//         String SQL = "delete from Wishlist where id = ?";
//         jdbcTemplateObject.update(SQL, id);
//     }
// }