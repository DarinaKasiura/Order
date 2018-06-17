package com.weborder;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\darin\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();

		Random random = new Random(101);
		int number = random.nextInt();
		String quantity = "";
		while(true) {
		if(number >= 1 && number <= 100) {
		quantity = Integer.toString(number);
		break;
		}else {
			number = random.nextInt();
		}}
		driver.findElement(By.linkText("Order")).click();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(quantity);
		driver.findElement(By.className("btn_dark")).click();
		
		Random ran = new Random();
		String[] middle = {"Jason", "Julian", "Madisen", "Bailee", "Alison", "Carelyn", "Karilyn", "Abigail"};
		String customerName = "John " + middle[ran.nextInt(8)].toString() + " Smith";
	    driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(customerName);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
		Random r = new Random();
		int[] zip = new int[5];
		StringBuilder zipcode = new StringBuilder();
		for(int i=0; i<zip.length; i++) {
			zip[i] = r.nextInt(10);
			zipcode.append(Integer.toString(zip[i]));
			}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipcode);
		
		Random rand = new Random();
		String[] cardType = {"ctl00_MainContent_fmwOrder_cardList_0", "ctl00_MainContent_fmwOrder_cardList_1", "ctl00_MainContent_fmwOrder_cardList_2"};
		String id = cardType[rand.nextInt(cardType.length-1)];
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$cardList").id(id)).click();
		
		Random ra = new Random();
		StringBuilder cardNumber = new StringBuilder();
		if(id.equals("ctl00_MainContent_fmwOrder_cardList_0")){
			cardNumber.append("4");
			for(int i=1; i<16; i++) {
				cardNumber.append(ra.nextInt(10));
			}
		}else if(id.equals("ctl00_MainContent_fmwOrder_cardList_1")) {
			cardNumber.append("5");
			for(int i=1; i<16; i++) {
				cardNumber.append(ra.nextInt(10));
			}
		}else if(id.equals("ctl00_MainContent_fmwOrder_cardList_2")) {
			cardNumber.append("3");
			for(int i=1; i<15; i++) {
				cardNumber.append(ra.nextInt(10));
			}
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);
		Random rando = new Random();
		int year = rando.nextInt(2030);
		int month = rando.nextInt(13);
		int day = rando.nextInt(28);
		LocalDate date;
		while(true) {
		if(year >= 2018 && month != 0 && day != 0) {
		date = LocalDate.of(year, month, day);
		break;
		}else {
			year = rando.nextInt(2030);
			month = rando.nextInt(13);
			day = rando.nextInt(28);
		}}
		DateTimeFormatter mm = DateTimeFormatter.ofPattern("MM");
		DateTimeFormatter yy = DateTimeFormatter.ofPattern("yy");
		String exp = date.format(mm).toString() + "/" + date.format(yy).toString();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1").id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(exp);
		
		driver.findElement(By.className("btn_light")).click();
	}

}
