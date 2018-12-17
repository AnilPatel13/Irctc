package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import journey.details.JourneyDetails;
import journey.details.SelectQuota;
import journey.details.TrainSelect;
import passerngers.details.Passsengers;

public class IrctcController implements Initializable {

	@FXML
	private TextField txtFrom;

	@FXML
	private TextField txtTo;

	@FXML
	private TextField txtDate;

	@FXML
	private TextField txttrainName;

	@FXML
	private TextField txtTrainSequence;

	@FXML
	private TextField txtPassenge1;
	@FXML
	private TextField txtPassenge2;
	@FXML
	private TextField txtPassenge3;
	@FXML
	private TextField txtPassenge4;
	@FXML
	private TextField txtPassenge5;
	@FXML
	private TextField txtPassenge6;

	@FXML
	private TextField txtPassAge1;
	@FXML
	private TextField txtPassAge2;
	@FXML
	private TextField txtPassAge3;
	@FXML
	private TextField txtPassAge4;
	@FXML
	private TextField txtPassAge5;
	@FXML
	private TextField txtPassAge6;

	@FXML
	private TextField txtPhoneNo;

	@FXML
	private TextField txtCardNumber;

	@FXML
	private TextField txtValidTo;

	@FXML
	private TextField txtExpiryDate;

	@FXML
	private TextField txtCardHolderName;

	@FXML
	private TextField txtPin;

	@FXML
	private ComboBox<String> Quota;
	ObservableList<String> trainQuota = FXCollections.observableArrayList("GENERAL", "LOWER BERTH/SR.CITIZEN", "LADIES",
			"DIVYAANG", "TATKAL", "PREMIUM TATKAL");

	@FXML
	private ComboBox<String> Gender1;
	ObservableList<String> gender1 = FXCollections.observableArrayList("Male", "Female", "Transgender");

	@FXML
	private ComboBox<String> Gender2;
	ObservableList<String> gender2 = FXCollections.observableArrayList("Male", "Female", "Transgender");
	@FXML
	private ComboBox<String> Gender3;
	ObservableList<String> gender3 = FXCollections.observableArrayList("Male", "Female", "Transgender");
	@FXML
	private ComboBox<String> Gender4;
	ObservableList<String> gender4 = FXCollections.observableArrayList("Male", "Female", "Transgender");
	@FXML
	private ComboBox<String> Gender5;
	ObservableList<String> gender5 = FXCollections.observableArrayList("Male", "Female", "Transgender");
	@FXML
	private ComboBox<String> Gender6;
	ObservableList<String> gender6 = FXCollections.observableArrayList("Male", "Female", "Transgender");

	@FXML
	private ComboBox<String> Preference1;
	ObservableList<String> preference1 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Preference2;
	ObservableList<String> preference2 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Preference3;
	ObservableList<String> preference3 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Preference4;
	ObservableList<String> preference4 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Preference5;
	ObservableList<String> preference5 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Preference6;
	ObservableList<String> preference6 = FXCollections.observableArrayList("Lower", "Middle", "Upper", "Side Lower",
			"Side Upper");
	@FXML
	private ComboBox<String> Passengers;
	ObservableList<String> NoOfPassengers = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
	@FXML
	private ComboBox<String> TrainClass;
	ObservableList<String> Coach = FXCollections.observableArrayList("Anubhuti Class (EA)", "AC First Class (1A)",
			"Exec. Chair Car (EC)", "AC 2 Tier (2A)", "First Class (FC)", "AC 3 Tier (3A)", "AC 3 Economy (3E)",
			"AC Chair car (CC)", "Sleeper (SL)", "Second Sitting (2S)");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Quota.setItems(trainQuota);
		TrainClass.setItems(Coach);
		Passengers.setItems(NoOfPassengers);
		Gender1.setItems(gender1);
		Gender2.setItems(gender2);
		Gender3.setItems(gender3);
		Gender4.setItems(gender4);
		Gender5.setItems(gender5);
		Gender6.setItems(gender6);
		Preference1.setItems(preference1);
		Preference2.setItems(preference2);
		Preference3.setItems(preference3);
		Preference4.setItems(preference4);
		Preference5.setItems(preference5);
		Preference6.setItems(preference6);
	}

	public void BookNow(ActionEvent event) throws IOException, InterruptedException {
		String url = "https://www.irctc.co.in/nget/train-search";
		String driverPath = null;
		driverPath = System.getProperty("user.dir") + "/drivers/linux/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Irctc Test");
		driver.get(url);
		System.out.println(driver.getTitle());
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?");
		if (result == JOptionPane.YES_OPTION) {
			WebDriverWait wait = new WebDriverWait(driver, 59);
			String from = txtFrom.getText();
			String to = txtTo.getText();
			String date = txtDate.getText();
			JourneyDetails.journey(driver, from, to, date,wait);
			String Coach_Class = TrainClass.getValue();
			JourneyDetails.journeyClass(driver, Coach_Class,wait);
			JourneyDetails.findTrain(driver,wait);

			String TrainName = txttrainName.getText();
			
			String QuotaClass = Quota.getValue();
			SelectQuota.TrainQuota(driver, QuotaClass,wait,TrainName);
		
				
			String TrainSequence = txtTrainSequence.getText();
			TrainSelect.trainSelect(driver, wait, TrainName, TrainSequence);

			int Passenger_count = Integer.parseInt(Passengers.getValue());
			String pass1gender = Gender1.getValue();
			String pass2gender = Gender2.getValue();
			String pass3gender = Gender3.getValue();
			String pass4gender = Gender4.getValue();
			String pass5gender = Gender5.getValue();
			String pass6gender = Gender6.getValue();
			String pass1_pref = Preference1.getValue();
			String pass2_pref = Preference2.getValue();
			String pass3_pref = Preference3.getValue();
			String pass4_pref = Preference4.getValue();
			String pass5_pref = Preference5.getValue();
			String pass6_pref = Preference6.getValue();
			String pass1name=txtPassenge1.getText();
			String pass2name=txtPassenge2.getText();
			String pass3name=txtPassenge3.getText();
			String pass4name=txtPassenge4.getText();
			String pass5name=txtPassenge5.getText();
			String pass6name=txtPassenge6.getText();
			String pass1age=txtPassAge1.getText();
			String pass2age=txtPassAge2.getText();
			String pass3age=txtPassAge3.getText();
			String pass4age=txtPassAge4.getText();
			String pass5age=txtPassAge5.getText();
			String pass6age=txtPassAge6.getText();
			
			for (int i = 1; i <=Passenger_count ; i++) {
				if (i==1)
				{
				Passsengers.passendersDetails(driver, i, pass1name, pass1age, pass1gender, pass1_pref,wait);
				}
				if (i==2)
				{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'+ Add Passenger')]")));
				driver.findElement(By.xpath("//span[contains(text(),'+ Add Passenger')]")).click();
				Passsengers.passendersDetails(driver, i, pass2name, pass2age, pass2gender, pass2_pref,wait);
				}
				if (i==3)
				{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'+ Add Passenger')]")));
				driver.findElement(By.xpath("//span[contains(text(),'+ Add Passenger')]")).click();
				Passsengers.passendersDetails(driver, i, pass3name, pass3age, pass3gender, pass3_pref,wait);
				}
				if (i==4)
				{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'+ Add Passenger')]")));
				driver.findElement(By.xpath("//span[contains(text(),'+ Add Passenger')]")).click();
				Passsengers.passendersDetails(driver, i, pass4name, pass4age, pass4gender, pass4_pref,wait);
				}
				if (i==5)
				{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'+ Add Passenger')]")));
				driver.findElement(By.xpath("//span[contains(text(),'+ Add Passenger')]")).click();
				Passsengers.passendersDetails(driver, i, pass5name, pass5age, pass5gender, pass5_pref,wait);
				}
				if (i==6)
				{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'+ Add Passenger')]")));
				driver.findElement(By.xpath("//span[contains(text(),'+ Add Passenger')]")).click();
				Passsengers.passendersDetails(driver, i, pass6name, pass6age, pass6gender, pass6_pref,wait);
				}
			}
			
			driver.findElement(By.xpath("(//label[@class='css-label_c t_cl'])[1]")).click();
			driver.findElement(By.xpath("//label[@for='travelInsuranceOptedYes']")).click();
			driver.findElement(By.xpath("//input[@id='mobileNumber']")).clear();
			driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys(txtPhoneNo.getText());
			int b = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
			if (b == JOptionPane.YES_OPTION) {
				driver.findElement(By.xpath("//*[contains(text(),'Continue Booking')]")).click();
			}
			WebDriverWait wait5 = new WebDriverWait(driver, 59);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			wait5.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"/html/body/app-root/app-home/div/div/app-review-booking/div/div[4]/div/div[2]/div[2]/div[1]/div[6]/div/div/button[2]")));
			// Thread.sleep(2000);
			WebElement element2 = driver.findElement(By.xpath(
					"/html/body/app-root/app-home/div/div/app-review-booking/div/div[4]/div/div[2]/div[2]/div[1]/div[6]/div/div/button[2]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element2);
			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/app-root/app-home/div/div/app-review-booking/div/div[4]/div/div[2]/div[2]/div[1]/div[6]/div/div/button[2]")));
			driver.findElement(By.xpath(
					"/html/body/app-root/app-home/div/div/app-review-booking/div/div[4]/div/div[2]/div[2]/div[1]/div[6]/div/div/button[2]"))
					.click();
			wait5.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Debit Card with PIN')]")));
			driver.findElement(By.xpath("//*[contains(text(),'Debit Card with PIN')]")).click();
			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'AXIS Bank')])[1]")));
			driver.findElement(By.xpath("(//*[contains(text(),'AXIS Bank')])[1]")).click();
			wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Make Payment'])[9]")));
			driver.findElement(By.xpath("(//*[text()='Make Payment'])[9]")).click();
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='debitCardNumber']")));
			driver.findElement(By.xpath("//input[@id='debitCardNumber']")).sendKeys(txtCardNumber.getText());
			Select sel3 = new Select(driver.findElement(By.xpath("//*[@id=\"debiMonth\"]")));
			sel3.selectByVisibleText(txtValidTo.getText());
			Select sel4 = new Select(driver.findElement(By.xpath("//*[@id=\"debiYear\"]")));
			sel4.selectByVisibleText(txtExpiryDate.getText());
			driver.findElement(By.xpath("//input[@id='debitCardholderName']")).sendKeys(txtCardHolderName.getText());
			driver.findElement(By.xpath("//*[@id=\"cardPin\"]")).sendKeys(txtPin.getText());
			int c = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
			if (c == JOptionPane.YES_OPTION) {
				driver.findElement(By.xpath("//*[@id=\"proceed\"]")).click();
			}
		}
	}
}
