package Model;
import java.sql.Date;

public class Student {
    private int code;
    private String name;
    Date birthDate;

    /**
     * Constructor with no parameter
     */
    public Student() {
    }

    /**
     *
     * @param code
     * @param name
     * @param birthDate
     */
    public Student(int code, String name, Date birthDate) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     *
     * @return Code
     */
    public int getCode() {
        return code;
    }

    /**
     * Set Student's code
     * @param code
     * @throws Exception
     */
    public void setCode(int code) throws Exception {
        if(code >= 0) {
            this.code = code;
        }else{
            throw new Exception("Invalid Code!");
        }
    }

    /**
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set student's name
     * @param name
     * @throws Exception
     */
    public void setName(String name) throws Exception {
        if(name != null){
            this.name = name;
        }else{
            throw new Exception("Invalid Name!");
        }
    }

    /**
     *
     * @return date of birth
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * set student's birthdate
     * @param birthDate
     * @throws Exception
     */
    public void setBirthDate(Date birthDate) throws Exception {
        if(birthDate != null) {
            this.birthDate = birthDate;
        }else{
            throw new Exception("Invalid Date of Birth!");
        }
    }

    /**
     *
     * @return information of a student
     */
    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (code != student.code) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return birthDate != null ? birthDate.equals(student.birthDate) : student.birthDate == null;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }
}
