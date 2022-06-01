package View;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);
    public static String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_DATE = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
    public static final String REGEX_YN = "[yYnN]";
    /**
     *
     * @param mess
     * @param error
     * @param min
     * @param max
     * @return
     */
    public static int getInt(String mess, String error, int min, int max) {
        while (true) {
            String Regex = "[0-9]+";
            System.out.print(mess);
            String input = scanner.nextLine();
            //if input is empty, print out message
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
                //if input not matches required regex, print out error message
            } else if (input.matches(Regex) == false) {
                System.out.println(error);
            } else {
                try {
                    int number = Integer.parseInt(input);
                    //if number is in valid range, return number
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Number Is Not In Range ( From " + min + " To " + max + ")");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }
            }
        }

    }

    public static double getDouble(String mess, String error, double min, double max) {
        while (true) {
            String Regex = "[0-9.]+";
            System.out.print(mess);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
            } else if (input.matches(Regex) == false) {
                System.out.println(error);
            } else {
                try {
                    double number = Double.parseDouble(input);
                    if (number < min || number > max) {
                        System.out.println("Input must be in range from " + min + " to " + max);
                    } else if (!(number % 0.5 == 0)) {
                        System.out.println("Input must be divide to 0.5");
                    } else {
                        return number;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }
            }
        }

    }

    public static String getString(String mess, String error, String regex) {
        while (true) {
            System.out.print(mess);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input Field Can Not Be Empty!");
            } else if (input.matches(regex) == false) {
                System.out.println(error);
            } else {
                return input;
            }
        }

    }

    public static String getDate(String message, String error, String regex) {
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine(); //24/3/2022

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (!input.matches(regex)) {
                    System.out.println(error);
                } else {

                    try {
                        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        dateFormat.setLenient(false);

                        Date dateInput = new Date();
                        //parse ra ngay thang nhap vao theo dung format
                        dateInput = dateFormat.parse(input);

                        //format ngay thang hien tai theo format
                        Date currentDate = new Date();
                        String currentDatString = dateFormat.format(currentDate);
                        boolean check_Less_Than_Current_Date = checkDate1LessThanDate2(input, currentDatString);
                        if (check_Less_Than_Current_Date == true) {
                            System.out.println("Date must be equal or greater than " + currentDatString);
                        } else {
                            return input;
                        }

                    } catch (ParseException ex) {
                        System.out.println("Date does not exist !!!");
                    }

                }
            }
        }
    }

    private static boolean checkDate1LessThanDate2(String input, String currentDatString) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date firstDate = dateFormat.parse(input);
            Date secondDate = dateFormat.parse(currentDatString);

            if (firstDate.before(secondDate)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

    }
}
