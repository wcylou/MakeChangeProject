package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public void run() {
		//ask for price of item and money tendered
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter price of item");
		double price = sc.nextDouble();
		System.out.print("Price of item is: ");
		System.out.printf("%.2f", price);
		System.out.println();
		System.out.println("Money tendered by the customer?");
		double money = sc.nextDouble();
		
		//calculate change required or ask for more money
		double exactChange = money - price;
		if (exactChange == 0) {
			System.out.println("Exact change given. Ta!");
		} else if (price < money) {
			//call on calculate change method
			provideChange(exactChange, money, price);
		} else {
			//keep asking for more money until greater than price
			do {
				System.out.print("The price of ");
				System.out.printf("%.2f", price);
				System.out.print (" is more than ");
				System.out.printf("%.2f", money);
				System.out.println(" tendered");
				System.out.print("Please re-enter money greater than ");
				System.out.printf("%.2f", price);
				money = sc.nextDouble();
				exactChange = money - price;
			} while (price > money);
			//call on calculate change method once money tendered is greater than price
			provideChange(exactChange, money, price);
		}
	}

	public void provideChange(double exactChange, double money, double price) {
		//calculate change
		int change2 = (int) (Math.round((money - price) * 100));
		//display how much change required
		System.out.print("Change will be provided: ");
		System.out.printf("%.2f", exactChange);
		System.out.println();

		//divide change by denominations and use int to truncate
		//take the modulus and assign that to new change value
		int twenty = (int) (change2 / 2000);
		int change3 = (int) (change2 % 2000);

		int ten = (int) (change3 / 1000);
		int change4 = (int) (change3 % 1000);

		int five = (int) (change4 / 500);
		int change5 = (int) (change4 % 500);

		int two = (int) (change5 / 200);
		int change6 = (int) (change5 % 200);

		int one = (int) (change6 / 100);
		int change7 = (int) (change6 % 100);

		int half = (int) (change7 / 50);
		int change8 = (int) (change7 % 50);

		int quarter = (int) (change8 / 25);
		int change9 = (int) (change8 % 25);

		int dime = (int) (change9 / 10);
		int change10 = (int) (change9 % 10);

		int nickel = (int) (change10 / 5);
		int change11 = (int) (change10 % 5);

		int penny = (int) (change11 / 1);

		int denominations[] = { twenty, ten, five, two, one, half, quarter, dime, nickel, penny };
		String denoms[] = { "Twenties", "Tens", "Fives", "Twos", "Ones", "Halves", "Quarters", "Dimes", "Nickels",
				"Pennies" };

		//if count is 0, do not show
		for (int i = 0; i < denominations.length; i++) {
			if (!(denominations[i] == 0)) {
				System.out.println(denoms[i] + ":" + denominations[i]);
			}
		}

	}
}