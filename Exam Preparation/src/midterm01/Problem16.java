package midterm01;

public class Problem16 {
    public static void main(String[] args) {
        int num = 1;
        double largestValue = 0.0;
        while (num < 73) {
            double value = Math.random();
            if (value > largestValue) {
                largestValue = value;
            }
            num++;
        }
        System.out.println(largestValue);
    }
}
