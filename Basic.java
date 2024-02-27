import java.util.Scanner;

public class Basic {
    public static void main(String[] arg) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of inputs : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number in array " + (i + 1) + " : ");
            arr[i] = scn.nextInt();
        }
        scn.close();
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.print("The largest value is : " + max);
    }
}
