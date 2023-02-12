package midterm01;

public class Problem14 {
    public static void main(String[] args) {
        int intDay = (int) (Math.random() * 3);
        String dayName = "";
        if (intDay == 0){
            dayName = "Friday";
        }
        else if (intDay == 1){
            dayName = "Saturday";
        }
        else if (intDay == 2){
            dayName = "Sunday";
        }
        System.out.println("You should get a pizza on " + dayName);
    }
}
