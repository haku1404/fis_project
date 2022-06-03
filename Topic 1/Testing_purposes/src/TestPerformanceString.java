public class TestPerformanceString {
    public static void main(String[] args) {
        test();
    }

    public static String test(){
        try{
            return "1";
        }catch(Exception e){
            return "2";
        }finally {
            return "3";
        }
    }
}
