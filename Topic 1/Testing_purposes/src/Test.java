public class Test<V> {

    public static void main(String[] args) {

        Foo f = new Foo();
        f = new Test<Foo>().testParams(f);
    }


    V testParams(V foo){
       V obj = foo;
        return obj;
    }


}
