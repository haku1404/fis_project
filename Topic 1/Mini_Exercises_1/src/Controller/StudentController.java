package controller;
import model.Student;
import java.util.ArrayList;

public class StudentController {
    ArrayList<Student> listStudent = new ArrayList<>();

    public void addStudent(ArrayList<Student> listPerson, Student student) {
        listStudent.add(student);
    }

    public Student getStudentByCode(int code) {
        for (Student student: listStudent
             )if(student.getCode() == code) {
            return student;
        }
        return null;
    }

    public void removeStudent(Student student) {
        listStudent.remove(student);
    }

    public void sort(ArrayList<Student> listStudent) {
    }
}
