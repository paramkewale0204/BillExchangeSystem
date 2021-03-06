package com.adp.assignment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.org.assignment.controller.BillExchangeSystemController;
import com.org.assignment.service.BillExcahangeSystemServiceImpt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BillExchangeSystemControllerTest {

	private static final String Amount_Entered_By_User = "10";
	private static final int Amount_Entered_By_User_In_Integer = 10;
	private BillExchangeSystemController billExchangeSystemController;
	private BillExcahangeSystemServiceImpt billExcahangeSystemServiceImpt;

	@BeforeEach
	public void setUp() {
		this.billExchangeSystemController = new BillExchangeSystemController();
		this.billExcahangeSystemServiceImpt = new BillExcahangeSystemServiceImpt();
	}

	@Test
	public void amountIsSuppliedWhenCalculatingLeastNumberShouldReturnBadRequestResponse() {
		String invalidInput = "string value";
		assertThat(
				billExchangeSystemController.calculateLeastNumberOfCoinsRequiredForAmount(invalidInput).getStatusCode())
						.isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void amountIsSuppliedWhenCalculatingMostNumberShouldReturnBadRequestResponse() {
		String invalidInput = "string value";
		assertThat(
				billExchangeSystemController.calculateMostNumberOfCoinsRequiredForAmount(invalidInput).getStatusCode())
						.isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void amountIsSuppliedWhenCalculatingLeastNumberShouldReturnBadRequestResponseForNoInput() {
		String invalidInput = "";
		assertThat(
				billExchangeSystemController.calculateLeastNumberOfCoinsRequiredForAmount(invalidInput).getStatusCode())
						.isEqualTo(HttpStatus.BAD_REQUEST);
	}

	@Test
	public void amountIsSuppliedWhenCalculatingMostNumberShouldReturnBadRequestResponseForNoInput() {
		String invalidInput = "";
		assertThat(
				billExchangeSystemController.calculateMostNumberOfCoinsRequiredForAmount(invalidInput).getStatusCode())
						.isEqualTo(HttpStatus.BAD_REQUEST);
	}


}
