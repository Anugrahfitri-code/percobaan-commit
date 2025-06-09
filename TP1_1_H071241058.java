package Tugas_Praktikum_1;
import java.util.Scanner;
public class TP1_1_H071241058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan sebuah kalimat: ");
        try {
            String input = scanner.nextLine();
            String capitalized = capitalizeFirstLetter(input);
            System.out.println(capitalized);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Masukkan huruf ");
        }
    }

    public static String capitalizeFirstLetter(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i<words.length; i++) {
            result += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ";
        }
        return result.trim();
    }
}
