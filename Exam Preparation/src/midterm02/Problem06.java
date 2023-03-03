package midterm02;

public class Problem06
{
    public static void main(String[] args)
    {
        System.out.println(Problem06.find("early"));
        System.out.println(Problem06.find("hello"));
        System.out.println(Problem06.find("run"));
    }

    public static int find(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'e')
            {
                return i;
            }
        }
        return -1;
    }
}
