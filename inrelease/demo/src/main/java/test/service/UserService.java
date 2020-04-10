package test.service;

import java.util.List;

import javax.sql.DataSource;

import test.model.User;

public interface UserService<T> {
    void setDataSource(DataSource ds);
    User register(User user);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    void delete(Long id);
}