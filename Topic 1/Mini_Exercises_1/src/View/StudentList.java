package View;
import Controller.StudentController;
import Model.Student;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
    StudentController control = new StudentController();
    public final int MAX=100;
    private Student[] student;
    private int count;
    private ISortStrategy  sortStrategy;

    static List<Student> list = new ArrayList<>();

    public void addStudent(ArrayList<Student> listStudent) throws ParseException {
        int code = getCode();
        String name = getName();
        String birthdate = getBirthDate();
        Student student = new Student(code, name, birthdate);
        control.addStudent(listStudent, student);


    }

    public void removeStudent(){
        int code = getCode();
        Student student = control.getStudentByCode(code);
        if(student == null){
            System.out.println("Not Found!");
        }else{
            control.removeStudent(student);
            System.out.println("Delete Successful!");
        }
    }

    void display(ArrayList<Student> listStudent){
        for (Student student: listStudent
             ) {
            System.out.println(student);
        }
    }

    void sort(ArrayList<Student> listStudent){
        control.sort(listStudent);
    }

    private String getBirthDate() {
        String birthdate = Utility.getDate("Enter Date of Birth: ", "Format must be dd-MM-yyy", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        return birthdate;
    }

    private String getName() {
        String name = Utility.getString("Enter Student Name: ", "Invalid Name!", Utility.REGEX_STRING);
        return name;
    }

    private int getCode() {
        int code = Utility.getInt("Enter Student Code: ", "Invalid Code!", 0, 10000);
        return code;
    }
}
