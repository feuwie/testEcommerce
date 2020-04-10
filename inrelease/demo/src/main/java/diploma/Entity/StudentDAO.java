package diploma.Entity;

import diploma.DAO.StudentInterface;
import diploma.Mappers.StudentMapper;
import diploma.Model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.sql.DataSource;

@Component
public class StudentDAO implements StudentInterface<Student> {
   public DataSource dataSource;
   public JdbcTemplate jdbcTemplateObject;

   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   @Override
   public List<Student> getAll() {
      String SQL = "select * from Student";
      List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
      return students;
   }

   @Override
   public List<Student> getOne(Integer id) {
      String SQL = "select * from Student where id = ?";
      List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper(), id);
      return students;
   }

   @Override
   public Student update(Integer id, String name, Integer age) {
      String SQL = "update Student set name = ?, age = ? where id = ?";
      jdbcTemplateObject.update(SQL, name, age, id);
      System.out.println("Updated Record with ID = " + id);
      return null;
   }

   @Override
   public Student create(String name, Integer age) {
      String insertQuery = "insert into Student (name, age) values (?, ?)";
      jdbcTemplateObject.update(insertQuery, name, age);
      System.out.println("Created Record Name = " + name + " Age = " + age);
      return null;
   }

   @Override
   public Student delete(Integer id) {
      String SQL = "delete from student where id = ?";
      jdbcTemplateObject.update(SQL, id);
      return null;
   }

}