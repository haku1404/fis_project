package vn.fis.training.domain;

import javafx.util.converter.LocalDateStringConverter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


public class Customer {
    final String REGEX_NAME = "[a-zA-Z ]{5,50}";
    final String REGEX_PHONE = "[0][0-9]{10}";
    /** ID cua Customer la duy nhat trong toan bo he thong
       Su dung @java.util.UUID de tao id gan cho tung customer
    */
    private String id;

    /** Constraints:
        1. Khong duoc trong (NOT NULL OR BLANK)
        2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
        3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
            Qui tac chuan hoa:
                *. Bo cac ky tu trang o dau va cuoi
                *. Upper case chu cai dau tien truoc cac tu
                   VD: nGuyen van    BinH      -> Nguyen Van Binh
    **/
    private String name;
    /** Constraints:
        1. Khong duoc trong
        2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
     **/
    private LocalDate birthDay;
    /** Constraints:
    *   1. Do dai 10 ky tu bat dau bang ky tu 0, chi bao gom cac so tu 0->9
     *  2. So dien thoai la duy nhat trong toan bo he thong. Duoc su dung de kiem tra duplicate khach hang
     *  3. Chuan hoa lai truong so dien thoai truoc khi cap nhat vao he thong. Bo cac ky tu trang o dau, giua va cuoi
     *     Vidu: 0921 000 008 --> 0921000008
    * */
    private String mobile;

    /** Constraints:
     * NOT NULL
     * */

    private CustomerStatus status;

    /**
     * Thoi gian tao doi tuong. mac dinh la thoi diem hien tai
     */

    private LocalDateTime createDateTime;

    // TODO: Implement Getters, Setters, Constructors, Equals

    /**
     *
     * @return customer's id
     */
    public String getId() {
        return id;
    }

    /**
     * set customer's id
     * @param id
     * @throws Exception
     */
    public void setId(String id) throws Exception {
        if(id != null){
            UUID uuid = UUID.randomUUID();
            this.id = String.valueOf(uuid);
        }else{
            throw new Exception("Invalid Id!");
        }
    }

    /**
     *
     * @return customer's name
     */

    public String getName() {
        return name;
    }

    /**
     * set customer's name
     * @param name
     */
    public void setName(String name) throws Exception {
        String[] words = name.split("\\s");
        String capitalized = "";
        for(String w:words){
            String first = w.substring(0,1);
            String afterFirst = w.substring(1);
            capitalized += first.toUpperCase() + afterFirst +"";
        }
        String finalName = capitalized.trim();

        if(name.matches(REGEX_NAME) == false){
            throw new Exception("Invalid Name!");
        }else if(name == null){
            throw new Exception("Name can't be blank!");
        }else{
            this.name = finalName;
        }
    }

    /**
     *
     * @return customer's birthday
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
     * set customer's birthday
     * @param birthDay
     */
    public void setBirthDay(LocalDate birthDay) throws Exception {
        LocalDate date = LocalDate.now();
        if(birthDay == null) {
            throw new Exception("Date of birth can't be empty!");
        }else{
            this.birthDay = birthDay;
        }
    }

    /**
     *
     * @return customer's phone number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * set customer's phone number
     * @param mobile
     */
    public void setMobile(String mobile) throws Exception {
        if(mobile == null){
            throw new Exception("Phone Number can't be empty!");
        }else if(mobile.matches(REGEX_PHONE) == false){
            throw new Exception("Invalid Phone Number!");
        }else {
            this.mobile = mobile;
        }

    }

    /**
     *
     * @return customer's status
     */
    public CustomerStatus getStatus() {
        return status;
    }

    /**
     * set customer's status
     * @param status
     */
    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    /**
     *
     * @param createDateTime
     */
    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * constructor with no parameter
     */
    public Customer() {
    }

    /**
     * constructor with bellow parameters
     * @param id
     * @param name
     * @param birthDay
     * @param mobile
     * @param status
     */
    public Customer(String id, String name, LocalDate birthDay, String mobile, CustomerStatus status) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.mobile = mobile;
        this.status = status;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!id.equals(customer.id)) return false;
        if (!name.equals(customer.name)) return false;
        if (!birthDay.equals(customer.birthDay)) return false;
        if (!mobile.equals(customer.mobile)) return false;
        if (status != customer.status) return false;
        return createDateTime != null ? createDateTime.equals(customer.createDateTime) : customer.createDateTime == null;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + birthDay.hashCode();
        result = 31 * result + mobile.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (createDateTime != null ? createDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                '}';
    }


}
