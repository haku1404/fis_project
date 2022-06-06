package core.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StudentList implements ISortStrategy{
    @Override
    public void sort(Comparable[] data, int count) {

    }

    public final int MAX = 100;
    private Student[] student;
    private int count;
    private ISortStrategy  sortStrategy;

    static ArrayList<Student> listStudent = new ArrayList<>();

    /**
     * Constructor with all parameter
     */
    public StudentList() {
        this.count = 0;
        this.student = new Student[MAX];
    }

    /**
     * add a new student
     * @param student
     * @throws ParseException
     */
    public void addStudent(Student student) throws ParseException {

        listStudent.add(student);
    }

    /**
     * remove a student by code
     * @param code
     */
    public void removeStudent(int code){
        listStudent.removeIf(t->t.getCode()==code);
    }

    /**
     * display all student in list
     */
    public void display(){
        listStudent.forEach(System.out::print);
    }

    /**
     * sort student then display
     */
    public void sort(){
        ArrayList<Student> listSort = new ArrayList<>();
        listSort = (ArrayList<Student>) listStudent.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println(listSort);
    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }
}
