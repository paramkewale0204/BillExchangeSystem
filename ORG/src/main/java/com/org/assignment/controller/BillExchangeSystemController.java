package com.org.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.assignment.service.BillExchangeSystemService;


@RestController
@RequestMapping("/count-coins")
public class BillExchangeSystemController {
	
	@Autowired
	private BillExchangeSystemService exchangeService;

	@GetMapping("/bill-least")
	public ResponseEntity<String> calculateLeastNumberOfCoinsRequiredForAmount(String amount) {
		
		System.out.println("amount = " + amount);
		
		try {
			
			int amountEnteredByUser = Integer.parseInt(amount);
			String result = exchangeService.calculateLeastNumberOfCoinsRequiredForAmountService(amountEnteredByUser);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch(NumberFormatException e) {
			System.out.println("In catch block");
			return new ResponseEntity<>("Please check the input value again and enter numeric value only", HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			System.out.println("In catch block");
			return new ResponseEntity<>("Something went wrong. Please enter numeric values only", HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/bill-most")
	public ResponseEntity<String> calculateMostNumberOfCoinsRequiredForAmount(String amount) {

		try {
			int amountEnteredByUser = Integer.parseInt(amount);
			String result = exchangeService.calculateMostNumberOfCoinsRequiredForAmountService(amountEnteredByUser);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch(NullPointerException e) {
			System.out.println("In catch block");
			return new ResponseEntity<>("Input value is null. Please enter numeric values only", HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			System.out.println("In catch block");
			return new ResponseEntity<>("Input value is not numeric. Please enter numeric values only", HttpStatus.BAD_REQUEST);
		}
	}

}
