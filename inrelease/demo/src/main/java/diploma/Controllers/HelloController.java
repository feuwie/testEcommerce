package diploma.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diploma.Model.Student;
import diploma.Services.StudentService;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

   private StudentService studentService;

   HelloController(StudentService studentService) {
      this.studentService = studentService;
   }

   @GetMapping
   public String list() {
      return "Hello, teacher";
   }

   @GetMapping("/all")
   public List<Student> testGet() {
      return studentService.getAllUsers();
   }

   @PostMapping(path = "/{id}")
   public List<Student> listUser(@RequestBody Student student) {
      Integer id = student.getId();
      System.out.println(studentService.getUser(id));
      return studentService.getUser(id);
   }

   @PostMapping(path = "/add")
   public Student addMember(@RequestBody Student student) {
      String name = student.getName();
      Integer age = student.getAge();
      return studentService.addStudent(name, age);
   }

   @PostMapping(path = "/delete")
   public Student delMember(@RequestBody Student student) {
      Integer id = student.getId();
      return studentService.delStudent(id);
   }

   @PostMapping(path = "/update")
   public Student updMember(@RequestBody Student student) {
      Integer id = student.getId();
      String name = student.getName();
      Integer age = student.getAge();
      return studentService.updStudent(id, name, age);
   }
}