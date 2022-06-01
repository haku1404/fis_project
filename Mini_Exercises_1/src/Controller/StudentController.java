package Controller;
import Model.Student;
import java.util.ArrayList;

public class StudentController {
    ArrayList<Student> listStudent = new ArrayList<>();

    public void addStudent(ArrayList<Student> listPerson, Student student) {
        listStudent.add(student);
    }
}
