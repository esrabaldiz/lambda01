package lambdapracticeday01;

public class Utils {
    public static void yazdir(Object a) {
        System.out.print(a + " ");
    }

    public static int kareAl(Integer a) {//void kareAlma sonra  System.out.print(a*a);
        return a * a;
    }

    public static int intkupAl(Integer a) {
        return a * a * a;
    }

    public static boolean pozitifMi(Integer b) {
        return b > 0;
    }

    public static boolean onaBol(Integer a) {
        return a % 10 == 5;
    }

  //  public static int toplamaYap(Integer a ,Integer  b) {

 //   }
}