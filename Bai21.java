import java.util.Scanner;

public class Bai21 {
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();
        
        System.out.print("Các số nguyên tố đầu tiên là: ");
        int count = 0;
        int number = 2;
        
        while (count < n) {
            if (isPrime(number)) {
                System.out.print(number + " ");
                count++;
            }
            
            number++;
        }
        
        scanner.close();
    }
}
