import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(7,"Peter");
        Student s2 = new Student(8,"Harry");
        Student s3 = new Student(9,"Sloan");
        Student s4 = new Student(4,"Anne");
        Student s5 = new Student(6,"Klaus");

        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);
        List<Student> temp = new ArrayList<>();
        List<Student> temp1 = new ArrayList<>();


        temp = list.stream().filter(sv -> sv.getName().startsWith("A")).collect(Collectors.toList());
        System.out.println(temp.toString());

        temp1 = list.stream().sorted(Comparator.comparingInt(Student::getGrade).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(temp1.toString());

        list.stream().filter(sv -> sv.getName().startsWith("K")).filter(sv -> sv.getGrade()>5).forEach(System.out::println);

//Dùng generic để cài đặt một Collection mới Queue/Stack.
//pop, push, top, count,...
    }


}
