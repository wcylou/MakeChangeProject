package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter price of item");
		double price = sc.nextDouble();
		System.out.println("Price of item is: " + price);
		System.out.println("Money tendered by the customer?");
		double money = sc.nextDouble();
		double exactChange = money - price;
		if (exactChange == 0) {
			System.out.println("Exact change given");
		} else if (price < money) {
			provideChange(exactChange, money, price);
		} else {
			do {
				System.out.println(
						"Item is more than money tendered, please ask for more money and re-enter amount tendered");
				money = sc.nextDouble();
				exactChange = money - price;
			} while (price > money);
			provideChange(exactChange, money, price);
		}
	}

	private void provideChange(double exactChange, double money, double price) {
		int change2 = (int) (Math.round((money - price) * 100));
		System.out.print("Change will be provided: ");
		System.out.printf("%.2f", exactChange);
		System.out.println();

		int twenty = (int) (change2 / 2000);
		int change3 = (int) (change2 % 2000);
		System.out.println("20:" + twenty);

		int ten = (int) (change3 / 1000);
		int change4 = (int) (change3 % 1000);
		System.out.println("10:" + ten);

		int five = (int) (change4 / 500);
		int change5 = (int) (change4 % 500);
		System.out.println("5:" + five);

		int two = (int) (change5 / 200);
		int change6 = (int) (change5 % 200);
		System.out.println("2:" + two);

		int one = (int) (change6 / 100);
		int change7 = (int) (change6 % 100);
		System.out.println("1:" + one);

		int half = (int) (change7 / 50);
		int change8 = (int) (change7 % 50);
		System.out.println("0.5:" + half);

		int quarter = (int) (change8 / 25);
		int change9 = (int) (change8 % 25);
		System.out.println("0.25:" + quarter);

		int dime = (int) (change9 / 10);
		int change10 = (int) (change9 % 10);
		System.out.println("0.10: " + dime);

		int nickel = (int) (change10 / 5);
		int change11 = (int) (change10 % 5);
		System.out.println("0.05: " + nickel);

		int penny = (int) (change11 / 1);
		System.out.println("0.01: " + penny);
	}
}