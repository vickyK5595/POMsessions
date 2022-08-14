package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final int SMALL_DEFAULT_TIME_OUT = 5;
	public static final int MEDIUM_DEFAULT_TIME_OUT = 10;
	public static final int LONG_DEFAULT_TIME_OUT = 20;

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	public static final String ACCOUNTS_PAGE_URL_FRACTION = "route=account/account";

	public static final String ACCOUNTS_PAGE_TITLE = "My Account";

	public static final List<String> EXPECTED_ACCOUNTS_HEADERS_LIST = 
			Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static final String REGISTER_SHEET_NAME = "register";
	public static final String PRODUCT_SHEET_NAME = "product";

	

}