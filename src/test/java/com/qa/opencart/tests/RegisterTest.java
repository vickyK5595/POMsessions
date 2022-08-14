package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		regPage = loginPage.goToRegisterPage();
	}

//	@DataProvider
//	public Object[][] getRegData() {
//		return new Object[][] {
//			{"Riya", "automation", "riyaauto1@gmail.com", "9999898989", "riya@123", "yes"},
//			{"vijay", "automation", "vijayauto@gmail.com", "9999898910", "vijay@123", "no"},
//			{"archana", "automation", "archauto@gmail.com", "9999898911", "arch@123", "yes"},
//		};
//	}

	public String randomEmail() {
		Random random = new Random();
		String email = "automation" + random.nextInt(1000) + "@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegExcelData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegExcelData")
	public void userRegTest(String firstName, String lastName, String phone, String password, String subscribe) {

		boolean successFlag = regPage.userRegistration(firstName, lastName, randomEmail(), phone, password, subscribe);
		regPage.goToRegisterPage();
		Assert.assertEquals(successFlag, true);

	}

}