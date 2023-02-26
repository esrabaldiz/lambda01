package lambdapracticeday01;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        //SORU1: List elemanlarının çift ve pozitif olanlarını, Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın
        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        ciftVePozitifElemanYazdir(sayi);
        System.out.println("\n **********");
        ciftVePozitifMetRef(sayi);
        System.out.println("\n **********");
        kareYazdir(sayi);
        System.out.println("\n **********");
        ;
        kareTekrarsiz(sayi);
        System.out.println("\n **********");
        kareTekrarsiz(sayi);
        System.out.println("\n **********");
        pozitifKupBirlerBasamagiBes(sayi);
        System.out.println("\n **********");
        toplamMetRef(sayi);
        System.out.println("\n **********");
        toplamLambdaEx(sayi);
        System.out.println("\n **********");
        System.out.println(pozitifElCarpimLamEx(sayi));
        System.out.println("\n **********");
        System.out.println(ciftElKareKucBuySirla(sayi));
    }

    public static void ciftVePozitifElemanYazdir(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını, Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifMetRef(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(Utils::yazdir);

    }

    //soru3:List elemanlarinin karelerini , aralarinda bosluk birakarak yaziniz
    public static void kareYazdir(List<Integer> sayi) {
        //  sayi.stream().map(t -> t * t).forEach(Utils::yazdir);
        sayi.stream().map(Utils::kareAl).forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareTekrarsiz(List<Integer> sayi) {
        sayi.stream().map(Utils::kareAl).distinct().forEach(Utils::yazdir);
    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın
    public static void buyuktenKucugeSirala(List<Integer> sayi) {
        sayi.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);

    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız
    public static void pozitifKupBirlerBasamagiBes(List<Integer> sayi) {
        sayi.stream().filter(Utils::pozitifMi).map(Utils::intkupAl).filter(Utils::onaBol).forEach(Utils::yazdir);

    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
    public static void toplamMetRef(List<Integer> sayi) {
        Optional<Integer> sonuc = sayi.stream().reduce(Integer::sum);
        System.out.println(sonuc);

    }

    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın//reduce() terminal methoddur o yuzden ondan sonra nokta koyunca
// bir method gelmez yani akis biter ve bu yuzden yazdirmak icin sout kullaniriz
    public static void toplamLambdaEx(List<Integer> sayi) {
        int sonuc = sayi.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sonuc);
    }

    //SORU9 : Listin pozitif elemanlarının, carpımını Lambda Expression ile return ederek yazdırın
    //reduce()methodu : coklu datayi teke indirmek icin kullanilir
    public static int pozitifElCarpimLamEx(List<Integer> sayi) {
        int sonuc = sayi.stream().filter(t -> t > 0).reduce(1, (a, b) -> a * b);
        return sonuc;
        /*
        Orn; reduce( 0,(t,u)->t+u) ==>  "t" ilk degeri "sifir" dan alir, daha sonraki degerleri toplamanin sonucundan alir.
        "u" ise degerlerini her zaman "stream " den yani akista bize ne verilmis ise (orn List) oradan alir .
//reduce( 0,(t,u)->t+u) burada bu codu int bir konteyner a koydugumuzda kizarmaz
//cunku herhalukarda  "0" bir deger oldugu icin "Optional Integer" a da gerek kalmaz.
//Aksi takdirde "0 Identity"  olmadiginda Java, Ya listte hic eleman yoksa(null ise)!!!  diye kizarir.
//Java null i Integer kabul etmedigi icin hata verir , bunu engellemek icin java "Optional IInteger" a cevirir
    */
    }

    //SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız
    public static List<Integer> ciftElKareKucBuySirla(List<Integer> sayi) {
        List<Integer> sonuc = sayi.stream().filter(t -> t % 2 == 0).map(t -> t * t).sorted().collect(Collectors.toList());
        return sonuc;
    }
}