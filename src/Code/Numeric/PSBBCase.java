package Code.Numeric;

import java.util.Scanner;

public class PSBBCase {

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(System.in);
			int maxPickup = 4;

			System.out.println("Input the number of families : ");
			int nFamily = input.nextInt();

			System.out.println("Input the number of members in the family : ");
			int[] arrayMember = new int[nFamily];

			String line = input.next();
			line = line.concat(input.nextLine());
			String[] numberStr = line.split("\\s+");

			for (int i = 0; i < nFamily; i++) {
				arrayMember[i] = Integer.parseInt(numberStr[i]);
			}
			input.close();

			System.out.print("Minimun bus required is :" + Result(arrayMember, maxPickup));
		} catch (Exception e) {
			System.out.print("Input must be equal with count of family");
		}
	}

	public static String Result(int[] arrayMember, int maxPickup) {
		String result = null;

		for (int i = 0; i < arrayMember.length; i++) {
			for (int j = i + 1; j < arrayMember.length; j++) {
				int temp = 0;
				if (arrayMember[i] < arrayMember[j]) {
					temp = arrayMember[i];
					arrayMember[i] = arrayMember[j];
					arrayMember[j] = temp;
				}
			}
		}

		for (int i = 0; i < arrayMember.length; i++) {
			for (int j = i + 1; j < arrayMember.length; j++) {
				int temp = 0;
				if (arrayMember[i] == maxPickup - 1 && arrayMember[i + 1] == maxPickup - 1
						&& (arrayMember[i] + arrayMember[j] == 4)) {
					temp = arrayMember[i];
					arrayMember[i + 1] = arrayMember[j];
					arrayMember[j] = temp;
				}
			}
//			System.out.print(arrayMember[i] + " ");
		}
		System.out.println();

		int count = 0;
		for (int i = 0; i < arrayMember.length; i++) {
			if (arrayMember[i] == maxPickup && arrayMember[i] != 0) {
				count++;
			}
			if (arrayMember[i] == 3) {
				count++;
				if ((arrayMember[i] + arrayMember[i + 1]) == maxPickup) {
					arrayMember[i + 1] = 0;
				}
			}
			if (arrayMember[i] < maxPickup && i < arrayMember.length - 1 && arrayMember[i] != 0
					&& arrayMember[i] != 3) {
				arrayMember[i] = arrayMember[i] + arrayMember[i + 1];
				if (arrayMember[i] <= maxPickup) {
					count++;
					arrayMember[i + 1] = 0;
				} else if (arrayMember[i] > maxPickup) {
					count++;
					arrayMember[i + 1] = arrayMember[i] - maxPickup;
				}
			}
			if (arrayMember[i] < maxPickup && i == arrayMember.length - 1 && arrayMember[i] != 0) {
				count++;
			}
		}
		result = " " + count;

		return result;
	}
}
