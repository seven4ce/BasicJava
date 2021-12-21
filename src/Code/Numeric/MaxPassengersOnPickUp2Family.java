package Code.Numeric;

import java.util.Scanner;

public class MaxPassengersOnPickUp2Family {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int maxPickup = 4;

		System.out.println("Input the number of families : ");
		int nFamily = input.nextInt();

		System.out.println("Input the number of members in the family : ");
		int[] arrayMember = new int[nFamily];

		for (int i = 0; i < nFamily; i++) {
			int nMember = input.nextInt();
			arrayMember[i] = nMember;
		}
		input.close();

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
//			System.out.print(arrayMember[i]+" ");
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
		System.out.print("Minimun bus required is : " + count);
	}
}
