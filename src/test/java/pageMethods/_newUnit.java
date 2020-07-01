package pageMethods;

import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objRepository._newUnitPage;
import pageUtilities._base;
import pageUtilities._testData;
import pageUtilities._utils;

public class _newUnit extends _newUnitPage {
	
	_uiConstants s = new _uiConstants();  
	ExtentTest test = _base.test;
	ExtentTest node;
	
	public _newUnit() {
		super();
		_utils.waitForElementInVisibleByLocator(loader);
		
	}
	
	public void clickAddUnit() {
		_utils.clickAction($addUnit);
	}
	
	public void saveBtn() {
		_utils.clickAction($saveBtn);
	}
	
	public void selectClimateControl(String value) {
		_utils.selectDropDownByValue($selectCCDDL, value);
	}
	
	public void setExactMatch() {
		_utils.clickAction($sizeExactMatchChkBx);
	}
	
	public void selectUnitSize(String unitSize) {
		_utils.selectDropDownByVisibleText($selectSizeDDL, unitSize);
	}
	
	public void setStorageType(String storageType) {
		_utils.selectDropDownByVisibleText($selectStorageType, storageType);
	}
	
	public void fillUnitName(String newUnitName) {
		_utils.fillData($unitNameInput, newUnitName);
    }
	
	public void closePopup() {
		_utils.clickAction($cancelBtn);
	}
	
	
	
	public void verifyBasicUI() {
		node = test.createNode("Basic Details Verification");
		
		String basicHeader = $headerLabels(_base.driver, 1).getText();
		textComparison(basicHeader, s.basicHeader, node);
		
		String unitNameLabel = $unitNameLabel.getText();
		textComparison(unitNameLabel, s.nameLabel, node);
		
		_utils.clickAction($unitNameInput);
		_utils.clickAction($unitNameLabel);
		String unitNameValidation = $unitNameValidation.getText();
		textComparison(unitNameValidation, s.nameValidation, node);
		
		String storageTypeLabel = $storageTypeLabel.getText();
		textComparison(storageTypeLabel, s.storageTypeLabel, node);
		
		for(int i=1; i<=$storageTypeList.size(); i++) {
			String text = $storageTypeValues(_base.driver, i).getText();
			List<String> a = new LinkedList<>(s.storageTypeValue());
			textComparison(text, a.get(i-1), node);
		}
	}
	
	
	public void verifySpaceTypesUI() {
		node = test.createNode("SpaceTypes Verification");
		
		String spaceTypeHeader = $headerLabels(_base.driver, 2).getText();
		textComparison(spaceTypeHeader, s.spaceTypeHeader, node);
		
		String spcTypSelAllLabel = $spcTypSelAllLabel.getText();
		textComparison(spcTypSelAllLabel, s.spaceTypeSelectAll, node);

		 //5
		for(int i=1; i<=$noOfSpaceTypes.size(); i++) {
			String text = $spaceTypeLabels(_base.driver, i).getText();
			List<String> b = new LinkedList<>(s.spaceTypeValue());
				textComparison(text, b.get(i-1), node);
		}
	}

	public void verifySizeUI() {
		node = test.createNode("Size Details Verification");
		
		String sizeHeader = $headerLabels(_base.driver, 3).getText();
		textComparison(sizeHeader, s.sizeHeader, node);
		
		String sizePreDefLabel = $sizePredefLabel.getText();
		textComparison(sizePreDefLabel, s.sizePredefined, node);
		
		for(int i=2; i<=$sizePredefDDLCount.size()-1; i++) {
			String text = $sizeDDLValue(_base.driver, i).getText();
			List<String> b = new LinkedList<>(s.sizePredefinedValue());
				textComparison(text, b.get(i-2), node);
		}
		
		String sizePreDefEMLabel = $sizePredefEMLabel.getText();
		textComparison(sizePreDefEMLabel, s.sizeEMLabel, node);
		
		if(_testData.regId==1 && _testData.countryId==1 || _testData.regId==1 && _testData.countryId==2 || _testData.regId==2 && _testData.countryId==6 || _testData.regId==4 && _testData.countryId==11) {
			String sizePreDefWLLabel = $sizePredefWLLabel.getText();
			textComparison(sizePreDefWLLabel, s.sizeWLLabel, node);
			
			String sizeSpecLabel = $sizeSpecLabel.getText();
			textComparison(sizeSpecLabel, s.sizeSpecLabel, node);
			
			String sizeSpecWLLabel = Jsoup.parse($sizeSpecWLLabel.getText()).text();
			textComparison(sizeSpecWLLabel, s.sizeSpecWLLabel, node);
		}
		
		String sizeSqFtLabel = $sizeSqFtLabel.getText();
		textComparison(sizeSqFtLabel, s.sizeSqFootagelabel, node);
	
	}

	public void verifyFeaturesUI() {
		node = test.createNode("Features Verification");
		
		String feaHeader = $headerLabels(_base.driver, 4).getText();
		textComparison(feaHeader, s.feaHeader, node);
		
		String feaPowerLabel = $feaPowerLabel.getText();
		textComparison(feaPowerLabel, s.feaPwrHeader, node);
		
		for(int i=1; i<=$powerDDLCount.size(); i++) {
			String text = $powerDDLValue(_base.driver, i).getText();
			List<String> b = new LinkedList<>(s.feaPowerValue());
				textComparison(text, b.get(i-1), node);
		}
		
		String feaElevatorLabel = $feaElevatorLabel.getText();
		textComparison(feaElevatorLabel, s.feaEleHeader, node);
		
		for(int i=1; i<=$eleDDLCount.size(); i++) {
			String text = $eleDDLValue(_base.driver, i).getText();
			List<String> b = new LinkedList<>(s.feaElevatorValue());
				textComparison(text, b.get(i-1), node);
		}
		
		String feaDoorLabel = $feaDoorLabel.getText();
		textComparison(feaDoorLabel, s.feaDoorHeader, node);
		
		for(int i=1; i<=$doorDDLCount.size(); i++) {
			String text = $doorDDLValue(_base.driver, i).getText();
			List<String> b = new LinkedList<>(s.feaDoorValue());
				textComparison(text, b.get(i-1), node);
		}
		
		if(_testData.regId==1 && _testData.countryId!=3 || _testData.regId==1 && _testData.countryId!=4 || _testData.regId==1 && _testData.countryId!=5) {
			String feaCCLabel = $feaCCLabel.getText();
			textComparison(feaCCLabel, s.feaCCHeader, node);
			
			for(int i=1; i<=$ccDDList.size(); i++) {
				String text = $ccDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaCCValue());
					textComparison(text, b.get(i-1), node);
			}
			
			String feaAlarmLabel = $feaAlarmLabel.getText();
			textComparison(feaAlarmLabel, s.feaAlrmHeader, node);
			
			for(int i=1; i<=$alarmDDLCount.size(); i++) {
				String text = $alarmDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaAlarmValue());
					textComparison(text, b.get(i-1), node);
			}
			
			String feaDriveLabel = $feaDriveLabel.getText();
			textComparison(feaDriveLabel, s.feaDriveHeader, node);
			
			for(int i=1; i<=$driveUpDDLCount.size(); i++) {
				String text = $driveUpDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaDriveValue());
					textComparison(text, b.get(i-1), node);
			}
			
			String feaOutdoorLabel = $feaOutdoorLabel.getText();
			textComparison(feaOutdoorLabel, s.feaOutAccHeader, node);
			
			for(int i=1; i<=$outdoorDDLCount.size(); i++) {
				String text = $outdoorDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaOutdoorValue());
					textComparison(text, b.get(i-1), node);
			}
			
			String feaHumidityLabel = $feaHumidityLabel.getText();
			textComparison(feaHumidityLabel, s.feaHumHeader, node);
			
			for(int i=1; i<=$humDDLCount.size(); i++) {
				String text = $humDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaHumidityValue());
					textComparison(text, b.get(i-1), node);
			}
			
			
			
			String feaFloorLabel = $feaFloorLabel.getText();
			textComparison(feaFloorLabel, s.feaFlHeader, node);
			 
			for(int i=1; i<=$floorDDLCount.size(); i++) {
				String text = $floorDDLValue(_base.driver, i).getText();
				List<String> b = new LinkedList<>(s.feaFloorValue());
					textComparison(text, b.get(i-1), node);
			}
		}
	
	}
	
	
	public void textValidation() {
		clickAddUnit();
		_utils.waitForElementInVisibleByLocator(loader);
		verifyBasicUI();
		verifySpaceTypesUI();
		verifySizeUI();
		verifyFeaturesUI();
		closePopup();
		_utils.waitForElementInVisibleByLocator(loader);
	}
	
	
	public void clonePreDefUnits(String unitName) {
		_utils.waitForElementInVisibleByLocator(loader);
		clickAddUnit();
		_utils.waitForElementInVisibleByLocator(loader);
		String newUnitName = unitName.replace(" ", "").replace("Parking", "")+_utils.getDateMinddmm();
		
		Object ob = _predefinedUnits.invokeMethod(unitName);
	    
	    fillUnitName(newUnitName);
	    if(unitName.contains("Parking")) {
	    	setStorageType("Parking");
	    }
	    selectUnitSize(((_predefinedUnits)ob).getUnitSize());

	    if((((_predefinedUnits)ob).getExactMatch())!=0) {
			setExactMatch();
		}
		
		if((((_predefinedUnits)ob).getClimateControl())!=-1) {
			if((((_predefinedUnits)ob).getClimateControl())==1) {
				selectClimateControl("1");
			} else {
				selectClimateControl("0");
			}
		} 
		saveBtn();
		
		_utils.waitForElementVisibleByLocator(loader);
		_utils.waitForElementInVisibleByLocator(loader);
		
		System.out.println(unitName+" unit has been Added");
		
		comparePreUserValues(unitName, newUnitName);
		
	}
	
	
	public void addUnit() {
		
	}
	
	
	public void comparePreUserValues(String preDefUnit, String userDefUnit) {
		_dashboard dash = new _dashboard();
		List<String> preValues = new LinkedList<>();
		List<String> userValues = new LinkedList<>();
		preValues = dash.getSpecificUnitValue(preDefUnit);
		userValues = dash.getSpecificUnitValue(userDefUnit);
		
		for(int i=0; i<preValues.size(); i++) {
			String Header = (i==0) ? "StoresOffered" : (i==1) ? "AveragePrice" : "YourPrice";
			
			if(preValues.get(i).equals(userValues.get(i))) {
				test.log(Status.PASS, Header+" - PreDefinedValue: "+preValues.get(i)+" UserDefinedValue: "+(userValues.get(i)));
				System.out.println("Matches "+Header+": "+preValues.get(i)+" - "+(userValues.get(i)));
			} else {
				test.log(Status.FAIL, Header+" - PreDefinedValue: "+preValues.get(i)+" UserDefinedValue: "+(userValues.get(i)));
				System.out.println("Not Matches "+Header+": "+preValues.get(i)+" - "+(userValues.get(i)));
			}
		}
	}
	
	
	public void textComparison(String ui, String cons, ExtentTest node) {
		if(ui.equals(cons)) {
			node.log(Status.PASS, "Actual: "+ui+" Expected: "+cons);
			System.out.println("Matches: "+ui+" -- "+cons);
		} else {
			node.log(Status.FAIL, "Actual: "+ui+" Expected: "+cons);
			System.out.println("Not Matches: "+ui+" -- "+cons);
		}
	}
}
