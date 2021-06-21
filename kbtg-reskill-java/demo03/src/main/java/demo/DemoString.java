package demo;

public class DemoString {

    public static void main(String[] args) {
        String name="Thongchai";
        String name2="Fluke";

        System.out.println(name.length());
        System.out.println(name2.length());


        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }

        int i=0;
        while (i<name.length()){
            System.out.println(name.charAt(i++));
        }


    }
}
