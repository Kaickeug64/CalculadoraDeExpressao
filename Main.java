import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora cal1 = new Calculadora();
        cal1.setOperacao(sc.next());
        cal1.resolver4(cal1.getOperacao());
    }
}