package week_10;

import java.util.Scanner;

class vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter word");
        String word =  sc.nextLine();
        word=word.toLowerCase();
        int vowels=0,consonants=0;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        }
        
    }

