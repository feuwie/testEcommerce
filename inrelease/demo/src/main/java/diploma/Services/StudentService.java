package diploma.Services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import diploma.Entity.StudentDAO;
import diploma.Model.Student;

import java.util.List;

@Component
public class StudentService {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    StudentDAO studentDAO = (StudentDAO) context.getBean("studentJDBC");
    
    public List<Student> getAllUsers() {
        List<Student> student = studentDAO.getAll();
        return student;
    }

    public List<Student> getUser(Integer id) {
        List<Student> student = studentDAO.getOne(id);
        return student;
    }
    public Student addStudent(String name, Integer age) {
        Student student = studentDAO.create(name, age);
        return student;
    }
    public Student delStudent(Integer id) {
        Student student = studentDAO.delete(id);
        return student;
    }
    public Student updStudent(Integer id, String name, Integer age) {
        Student student = studentDAO.update(id, name, age);
        return student;
    }


}