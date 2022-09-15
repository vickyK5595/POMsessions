package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. By locator - OR
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	private By registerLink = By.linkText("Register");

	// 2. page const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions:
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("login page title : " + title);
		return title;
	}

	public String getLoginPageUrl() {
		String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIME_OUT, AppConstants.LOGIN_PAGE_URL_FRACTION);
		System.out.println("login page current url : " + url);
		return url;
	}

	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementPresence(forgotPwdLink, AppConstants.SMALL_DEFAULT_TIME_OUT).isDisplayed();
	}

	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("app creds: " + username + ":" + pwd);
		eleUtil.doSendKeysWithWait(emailId, AppConstants.MEDIUM_DEFAULT_TIME_OUT, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		// return eleUtil.waitForTitleToBe(AppConstants.ACCOUNTS_PAGE_TITLE,
		// AppConstants.SMALL_DEFAULT_TIME_OUT);
		return new AccountsPage(driver);
	}

	public SearchResultsPage performSearch(String name) {
		System.out.println("product name : " + name);
		AccountsPage accPage = new AccountsPage(driver);
		return accPage.doSearch(name);

	}

	public RegisterPage goToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}