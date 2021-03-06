package com.org.assignment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillExcahangeSystemServiceImpt implements BillExchangeSystemService {
	
	@Value("${limitOfCoinOne}")
	public int limitOfNumberOne;
	
	@Value("${limitOfCoinTwo}")
	public int limitOfNumberTwo;
	
	@Value("${limitOfCoinThree}")
	public int limitOfNumberThree;
	
	@Value("${limitOfCoinFour}")
	public int limitOfNumberFour;

	public String calculateLeastNumberOfCoinsRequiredForAmountService(double amount) {

		try {
			double[] notes = { 0.25, 0.10, 0.05, 0.01 };

			double[] noteCounter = { 0, 0, 0, 0 };

			int[] limit = { limitOfNumberOne, limitOfNumberTwo, limitOfNumberThree, limitOfNumberFour };

			double initialAmount = amount;

			for (int i = 0; i < 4; i++) {

				if (amount >= notes[i]) {
					if (limit[i] * notes[i] > amount) {
						noteCounter[i] = amount / notes[i];
						amount = amount - noteCounter[i] * notes[i];
					} else {
						var temp = amount - (notes[i] * limit[i]);

						noteCounter[i] = (notes[i] * limit[i]) / notes[i];
						amount = amount - (notes[i] * limit[i]);
					}
				}

			}

			double sum = 0;
			double fewerNumberOfCoins = 0;

			for (var i = 0; i < 4; i++) {
				if (noteCounter[i] > 0) {
					sum = sum + (notes[i] * noteCounter[i]);
				}
				fewerNumberOfCoins = fewerNumberOfCoins + noteCounter[i];
			}

			if (sum == initialAmount) {
				return "Number of coins used - " + fewerNumberOfCoins;
			} else {
				return "Machine does not have enough coins";
			}

		} catch (Exception e) {
			return "Please enter numeric values only - service";
		}

	}

	public String calculateMostNumberOfCoinsRequiredForAmountService(double amount) {

		try {
			double[] notes = { 0.01, 0.05, 0.10, 0.25 };

			double[] noteCounter = { 0, 0, 0, 0 };

			int[] limit = { limitOfNumberOne, limitOfNumberTwo, limitOfNumberThree, limitOfNumberFour };

			double initialAmount = amount;

			for (int i = 0; i < 4; i++) {

				if (amount >= notes[i]) {
					if (limit[i] * notes[i] > amount) {
						noteCounter[i] = amount / notes[i];
						amount = amount - noteCounter[i] * notes[i];
					} else {
						var temp = amount - (notes[i] * limit[i]);

						noteCounter[i] = (notes[i] * limit[i]) / notes[i];
						amount = amount - (notes[i] * limit[i]);
					}
				}

			}

			double sum = 0;
			double mostNumberOfCoins = 0;

			for (var i = 0; i < 4; i++) {
				if (noteCounter[i] > 0) {
					sum = sum + (notes[i] * noteCounter[i]);
				}
				mostNumberOfCoins = mostNumberOfCoins + noteCounter[i];
			}

			if (sum == initialAmount) {
				System.out.println("Success = " + mostNumberOfCoins);
				return "Number of coins used - " + mostNumberOfCoins;
			} else {
				System.out.println("Machine does not have enough coins = ");
				return "Machine does not have enough coins";
			}
		} catch (Exception e) {
			return "Please enter numeric values only - service";
		}

	}

}
