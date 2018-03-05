import java.util.Scanner;

public class CashRegister {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Please enter the price of the item: ");
		double price = keyboard.nextDouble();
		System.out.print("How much money was tendered by the customer? ");
		double tender = keyboard.nextDouble();

		double diff = 0;
		int whole = 0;
		double change = 0;
		int result[] = new int[4];
		int result2[] = new int[4];
		if (tender < price) {
			System.out.println("The amount tendered is less than the price of the item. You will need to pay more");
		} else if (tender == price) {
			System.out.println("Thank you! Have a nice day.");
		} else {
			diff = tender - price;
			whole = (int) (tender - price);
			change = diff - whole;

			result = wholeChange(whole);
			result2 = fractChange(roundDec(change));
		}

		int resultArr[] = arrCombine(result, result2);
		System.out.print("The amount is " + price + ". The amount tendered is " + tender + ". The result is ");
		printResults(resultArr);

	}

	public static void printResults(int arr[]) {
		String[] values1 = { "Twenty dollar bill", "Ten dollar bill", "Five dollar bill", "One dollar bill", "Quarter", "Dime", "Nickel", "Penny" };
		String[] values2 = { "Twenties", "Ten's", "Five's", "One's", "Quarters", "Nickels", "Dimes", "Pennies" };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1 && i != arrEnd(arr)) {
				System.out.print(arr[i] + " " + values1[i] + ", ");
			} else if (arr[i] > 1 && i != arrEnd(arr)) {
				System.out.print(arr[i] + " " + values2[i] + ", ");
			} else if (arr[i] == 1 && i == arrEnd(arr)) {
				System.out.print(arr[i] + " " + values1[i] + ".");
			} else if (arr[i] > 1 && i == arrEnd(arr)) {
				System.out.print(arr[i] + " " + values2[i] + ".");
			}
		}
	}

	public static int[] fractChange(int change) {
		int returnArr[] = new int[4];
		int array[] = { 25, 10, 5, 1 };
		for (int i = 0; i < array.length; i++) {
			if (change / array[i] >= 1) {
				returnArr[i] = change / array[i];
				change = change - (change / array[i]) * array[i];
			} else {
				returnArr[i] = 0;
			}

		}
		return returnArr;

	}

	public static int[] wholeChange(int whole) {
		int returnArr[] = new int[4];
		int array[] = { 20, 10, 5, 1 };
		int newWhole = whole;
		for (int i = 0; i < array.length; i++) {
			if (whole / array[i] >= 1) {
				returnArr[i] = newWhole / array[i];
				newWhole = newWhole - (newWhole / array[i]) * array[i];
			} else {
				returnArr[i] = 0;
			}

		}
		return returnArr;

	}

	public static int roundDec(double number) {

		double x = (number * 100);
		double y = x - (int) (x);
		if (y > .5) {
			return (int) (x) + 1;
		} else {
			return (int) (x);
		}

	}

	public static int arrEnd(int arr[]) {
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				end = i;
			}
		}
		return end;
	}

	public static int[] arrCombine(int arr1[], int arr2[]) {
		int num = arr1.length + arr2.length;
		int returnArr[] = new int[num];
		for (int i = 0; i < num; i++) {
			if (i < arr1.length) {
				returnArr[i] = arr1[i];
			} else {
				returnArr[i] = arr2[i - arr1.length];
			}
		}
		return returnArr;
	}

}
