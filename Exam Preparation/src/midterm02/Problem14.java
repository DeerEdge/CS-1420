package midterm02;

public class Problem14
{
    private double feet;
    private double inches;

    public Problem14(double f, double i)
    {
        feet = f;
        inches = i;
    }

    public double getFeet()
    {
        return feet;
    }

    public double getInches()
    {
        return inches;
    }

    public void simplify(double f, double i)
    {
        feet = feet + (int) i/12;
        inches = i%12;
    }

    public String toString()
    {
        return "" + feet + " " + inches;
    }

    public static void main(String[] args) {
        Problem14 test = new Problem14(10, 13);
        System.out.println(test.toString());
        test.simplify(10, 13);
        System.out.println(test.toString());
    }
}

