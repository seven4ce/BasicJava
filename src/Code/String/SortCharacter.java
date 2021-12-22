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

			char[] chVowles = vowels.toString().toCharArray();
			char[] chConsonants = consonants.toString().toCharArray();

			for (int i = 1; i < chVowles.length; i++) {
				for (int j = i + 1; j < chVowles.length; j++) {
					char temp = '\0';
					if (chVowles[i] == chVowles[j] && chVowles[i] != ',' && chVowles[i] != ',' && chVowles[i] != ' '
							&& chVowles[j] != ' ') {
						temp = chVowles[i + 1];
						chVowles[i + 1] = chVowles[j];
						chVowles[j] = temp;
					}
				}
			}

			for (int i = 1; i < chConsonants.length; i++) {
				for (int j = i + 1; j < chConsonants.length; j++) {
					char temp = '\0';
					if (chConsonants[i] == chConsonants[j] && chConsonants[i] != ',' && chConsonants[i] != ','
							&& chConsonants[i] != ' ' && chConsonants[j] != ' ') {
						temp = chConsonants[i + 1];
						chConsonants[i + 1] = chConsonants[j];
						chConsonants[j] = temp;
					}
				}
			}
			String strVowels = String.valueOf(chVowles);
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
