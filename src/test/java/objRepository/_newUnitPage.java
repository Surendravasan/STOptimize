package objRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtilities._base;

public class _newUnitPage {
	
	public _newUnitPage() {
		PageFactory.initElements(_base.driver, this);
	}
	
	protected By loader = By.cssSelector("div.loading");
	
	@FindBy(css="a[class='add-Market-Dashboard']")
	protected WebElement $addUnit;
	
	/* Basic Details */
	protected WebElement $headerLabels(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("(//div[@class='modal-content']//form//h4)["+nth+"]"));
	}
	
	@FindBy(xpath="//input[@id='Name']/preceding-sibling::label")
	protected WebElement $unitNameLabel;
	
	@FindBy(id="Name")
	protected WebElement $unitNameInput;
	
	@FindBy(css="input[id='Name']+div")
	protected WebElement $unitNameValidation;
	
//	@FindBy(xpath="//select[@id='SpaceType']/../label")
	@FindBy(xpath="//select[contains(@id,'SpaceType')]/../label")
	protected WebElement $storageTypeLabel;
	
//	@FindBy(css="select[id='SpaceType']")
	@FindBy(css="select[id*='SpaceType']")
	protected WebElement $selectStorageType;
	
//	@FindBy(css="select[id='SpaceType']>option")
	@FindBy(css="select[id*='SpaceType']>option")
	protected List<WebElement> $storageTypeList;
	
	protected WebElement $storageTypeValues(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select[id='SpaceType']>option:nth-child("+nth+")"));
	}
	
	/* Space Type */
	@FindBy(css="div.space-type-checkbox>span")
	protected WebElement $spcTypSelAllChkBx;
	
	@FindBy(css="div.space-type-checkbox>label")
	protected WebElement $spcTypSelAllLabel;
	
	@FindBy(xpath="//h4[contains(text(),'Space Types')]/../following-sibling::div/div/div")
	protected List<WebElement> $noOfSpaceTypes;
	
	protected WebElement $spaceTypeLabels(WebDriver driver, int nth) {
		return driver.findElement(By.xpath("//h4[contains(text(),'Space Types')]/../following-sibling::div/div/div["+nth+"]/label"));
	}
	
	/* Size */
	@FindBy(xpath="//select[@id='sizes']/../../../div/label")
	protected WebElement $sizePredefLabel;
	
	@FindBy(css="select#sizes>option")
	protected List<WebElement> $sizePredefDDLCount;
	
	protected WebElement $sizeDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#sizes>option:nth-child("+nth+")"));
	}
	
	@FindBy(css="select#sizes")
	protected WebElement $selectSizeDDL;
	
	
//	@FindBy(xpath="(//select[@id='sizes']/../../../div[3]//label)[1]")
	@FindBy(xpath="//input[@name='exactMatch']/../../following-sibling::label")
	protected WebElement $sizePredefEMLabel;
	
	@FindBy(xpath="//h4[contains(text(),'Size')]/following::div[1]//input[@name='exactMatch']")
	protected WebElement $sizeExactMatchChkBx;
	
	
	@FindBy(xpath="(//select[@id='sizes']/../../../div[3]//label)[2]")
	protected WebElement $sizePredefWLLabel;
	
	@FindBy(xpath="(//label[contains(@class,'label-field')])[2]")
	protected WebElement $sizeSpecLabel;
	
	@FindBy(xpath="//label[contains(@class,'new-label')]")
	protected WebElement $sizeSpecWLLabel;
	
	@FindBy(xpath="(//label[contains(@class,'label-field')])[3]")
	protected WebElement $sizeSqFtLabel;
	
			
	/* Unit Features */
	@FindBy(xpath="//select[contains(@id,'Climate')]/../label")
	protected WebElement $feaCCLabel;
	
	@FindBy(css="select#ClimateControlled>option")
	protected List<WebElement> $ccDDList;
	
	@FindBy(css="select#ClimateControlled")
	protected WebElement $selectCCDDL;
	
	protected WebElement $ccDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#ClimateControlled>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Alarm')]/../label")
	protected WebElement $feaAlarmLabel;
	
	@FindBy(css="select#Alarm>option")
	protected List<WebElement> $alarmDDLCount;
	
	protected WebElement $alarmDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#Alarm>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Drive')]/../label")
	protected WebElement $feaDriveLabel;
	
	@FindBy(css="select#DriveUp>option")
	protected List<WebElement> $driveUpDDLCount;
	
	protected WebElement $driveUpDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#DriveUp>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Power')]/../label")
	protected WebElement $feaPowerLabel;
	
	@FindBy(css="select#Power>option")
	protected List<WebElement> $powerDDLCount;
	
	protected WebElement $powerDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#Power>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Outdoor')]/../label")
	protected WebElement $feaOutdoorLabel;
	
	@FindBy(css="select#OutdoorAccess>option")
	protected List<WebElement> $outdoorDDLCount;
	
	protected WebElement $outdoorDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#OutdoorAccess>option:nth-child("+nth+")"));
	}

	@FindBy(xpath="//select[contains(@id,'Elevator')]/../label")
	protected WebElement $feaElevatorLabel;
	
	@FindBy(css="select#Elevator>option")
	protected List<WebElement> $eleDDLCount;
	
	protected WebElement $eleDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#Elevator>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Humidity')]/../label")
	protected WebElement $feaHumidityLabel;
	
	@FindBy(css="select#HumidityControlled>option")
	protected List<WebElement> $humDDLCount;
	
	protected WebElement $humDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#HumidityControlled>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Door')]/../label")
	protected WebElement $feaDoorLabel;
	
	@FindBy(css="select#DoorType>option")
	protected List<WebElement> $doorDDLCount;
	
	protected WebElement $doorDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#DoorType>option:nth-child("+nth+")"));
	}
	
	@FindBy(xpath="//select[contains(@id,'Floor')]/../label")
	protected WebElement $feaFloorLabel;
	
	@FindBy(css="select#Floor>option")
	protected List<WebElement> $floorDDLCount;
	
	protected WebElement $floorDDLValue(WebDriver driver, int nth) {
		return driver.findElement(By.cssSelector("select#Floor>option:nth-child("+nth+")"));
	}
	
	@FindBy(css="button[class*='submit']")
	protected WebElement $saveBtn;
	
	@FindBy(css="button[class*='cancel']")
	protected WebElement $cancelBtn;
	
	
}
