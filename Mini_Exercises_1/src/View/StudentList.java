package View;
import Model.Student;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
    public final int MAX=100;
    private Student[] student;
    private int count;
    private ISortStrategy  sortStrategy;
    static Scanner scanner = new Scanner(System.in);
    static Student st = new Student();
    static List<Student> list = new ArrayList<>();
    public void addStudent() throws ParseException {
        System.out.println("Enter Student Code: ");
        try {
            st.setCode(scanner.nextInt());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter Student Name: ");
        scanner.nextLine();
        try {
            st.setName(scanner.nextLine());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter Student BirthDate(dd/MM/yyyy): ");
        try {
            st.setBirthDate((Date) new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        list.add(st);


    }
}
