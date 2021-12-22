package Code.String;

import java.util.ArrayList;
import java.util.Scanner;

public class SortCharacter {

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(System.in);
			String line = null;
			System.out.println("Input one line of word(S) : ");

			line = input.nextLine().toLowerCase();
			input.close();

			line = line.replaceAll("\\s+", "");

			System.out.println();
			char ch = '\0';
			ArrayList<Character> vowels = new ArrayList<Character>();
			ArrayList<Character> consonants = new ArrayList<Character>();

			for (int i = 0; i < line.length(); i++) {
				ch = line.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					vowels.add(ch);
				} else {
					consonants.add(ch);
				}
			}

			char[] chVowels = vowels.toString().toCharArray();
			char[] chConsonants = consonants.toString().toCharArray();

			for (int i = 1; i < chVowels.length; i++) {
				for (int j = i + 1; j < chVowels.length; j++) {
					char temp = '\0';
					if (chVowels[i] == chVowels[j] && chVowels[i] != ',' && chVowels[j] != ',' && chVowels[i] != ' '
							&& chVowels[j] != ' ') {
						temp = chVowels[i + 1];
						chVowels[i + 1] = chVowels[j];
						chVowels[j] = temp;
						if (temp >= 'a' && temp <= 'z') {
							chVowels[i + 2] = temp;
							chVowels[j] = ' ';
						}
						break;
					}
				}
			}

			for (int i = 1; i < chConsonants.length; i++) {
				for (int j = i + 1; j < chConsonants.length - 1; j++) {
					char temp = '\0';
					if (chConsonants[i] == chConsonants[j] && chConsonants[i] >= 'a' && chConsonants[i] <= 'z'
							&& chConsonants[j] >= 'a' && chConsonants[j] <= 'z') {

						temp = chConsonants[i + 1];
						chConsonants[i + 1] = chConsonants[j];
						chConsonants[j] = temp;
						if (temp >= 'a' && temp <= 'z') {
							chConsonants[i + 2] = temp;
							chConsonants[j] = ' ';
						}
						break;
					}
				}
			}
			String strVowels = String.valueOf(chVowels);
			String strConsonants = String.valueOf(chConsonants);

			System.out.print("Vowel Characters : ");
			System.out.println();
			System.out.print(strVowels.toString().replaceAll("[\\[\\]\\s+\\,\"]", ""));
			System.out.println();
			System.out.print("Consonant Characters : ");
			System.out.println();
			System.out.print(strConsonants.toString().replaceAll("[\\[\\]\\s+\\,\"]", ""));

		} catch (Exception e) {
			System.out.print("error : " + e);
		}
	}
}
