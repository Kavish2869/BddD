package com.cg.project.pagebeans;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import gherkin.lexer.El;

public class RegistrationPageBean {

	@FindBy(how=How.NAME,name="userid")
	private WebElement userid ;

	@FindBy(how=How.NAME,name="password")
	private WebElement password;

	@FindBy(how=How.NAME,name="username")
	private WebElement name;

	@FindBy(how=How.NAME,name="address")
	private WebElement address;

	@FindBy(how=How.NAME,name="country")
	private WebElement country;

	@FindBy(how=How.NAME,name="zip")
	private WebElement zip;

	@FindBy(how=How.NAME,name="email")
	private WebElement email;

	@FindBy(how=How.NAME,name="gender")
	private List<WebElement> sex;

	@FindBy(how=How.NAME,name="languages")
	private List<WebElement> languages;

	@FindBy(how=How.NAME,name="submit")
	private WebElement submitBtn;


	

	public String getUserid() {
		return userid.getAttribute("value");
	}

	public void setUserid(String userId) {
		this.userid.sendKeys("userId");
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getName() {
		return name.getAttribute("value");
	}

	public void setName(String username) {
		this.name.sendKeys(username);
	}

	public void setAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}

	public String getAddress() {
		return address.getAttribute("value");
	}
	
	public String getCountry() {
		return new Select(this.country).getFirstSelectedOption().getText();
	}

	public void setCountry(String country) {
		Select select=new Select(this.country);
		select.selectByVisibleText(country);
	}

	public String getZip() {
		return zip.getAttribute("zip");
	}

	public void setZip(String zip) {
		this.zip.sendKeys(zip);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);;
	}

	public String  getSex() {
		for (WebElement webElement : sex) 
			if(webElement.isSelected())
				return webElement.getAttribute("value");
			return null;
		}

		public void setSex(String gender) {
			if(gender.equalsIgnoreCase("male"))
				this.sex.get(0).click();
			else 
				this.sex.get(1).click();
		}

		public String[]  getLanguage() {
			return null;
		}

		public void setLanguage(String [] languages) {
			for (String language : languages) {
				if(language.equals("english"))
					this.languages.get(0).click();
				else if(language.equals("nonenglish"))
					this.languages.get(1).click();
			}
			
		}
	public void clickSignUp() {
			submitBtn.submit();
		}
	}