import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random test = new Random();
        int b = 0;
        String c = "abcde";
        while (b != 0){
        b = test.nextInt(5)+1;
        }
        System.out.println(c.length());
    }
}