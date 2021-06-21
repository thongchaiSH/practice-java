package demo;

public class DemoArray {
    public static void main(String[] args) {
        int[] scores={1,2,3};
        System.out.println(scores.length);

        for (int score : scores) {
            System.out.println(score);
        }
    }
}
