/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms.util;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
* <h1>Framework Utility Functions Library</h1>
* Frame Work Utility Class. Contains functions which 
* can be reuse across entire test scripts
*
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-12
*/

public class EY_FW_Utility {
	private static WebDriver driver = EY_GettersSetters.getDriver();
	private static Logger APP_LOGS = null;
	private static Logger setLogger(){
		if (APP_LOGS==null)
			APP_LOGS = LogManager.getLogger(EY_FW_Utility.class.getName());
		return APP_LOGS;	
	}

   /**
    ***************************************************************************************
	* Wait time so that script will wait to continue to next step.
	* @param milliSeconds This is wait time in milli seconds.
	***************************************************************************************
	*/
	public static void doWait(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			setLogger().error("[EY_FW_Utility: doWait] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	 **************************************************************************************
	 * Wait till the page loads with in the provided time units.
	 * @param loadTime This is load time in seconds
	 **************************************************************************************
	 */
	public static void waitTillPageLoad(int loadTime) {
		driver.manage().timeouts().pageLoadTimeout(loadTime, TimeUnit.SECONDS);
	}

	/**
	 **************************************************************************************
	 * Select the Name from the drop down of the given drop down locator.
	 * @param locatorPath This is locator path in String format.
	 * @param Name	This is name which needs to be selected in String format.
	 **************************************************************************************
	 */
	public static void selectElementByName(String locatorPath, String Name) {
		try{
		Select selectitem = new Select(
				getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY));
		selectitem.selectByVisibleText(Name);}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: selectElementByName] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	 ***************************************************************************************
	 * Select the Value from the drop down of the given drop down locator.
	 * @param locatorPath This is locator path in String format.
	 * @param value This is value which needs to be selected in String format.
	 ***************************************************************************************
	 */
	public static void selectElementByValue(String locatorPath, String value) {
		try{
		Select selectitem = new Select(
				getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY));
		selectitem.selectByValue(value); }
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: selectElementByValue] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	*****************************************************************************************
	* Select the Index from the drop down of the given drop down locator.
	* @param locatorPath This is locator path in String format.
	* @param index This is index which needs to be selected in Integer format.
	*****************************************************************************************
	*/
	public static void selectElementByIndex(String locatorPath, int index) {
		try{
		Select selectitem = new Select(
				getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY));
		selectitem.selectByIndex(index);}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: selectElementByIndex] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	******************************************************************************************
	* Click any element from given List.
	* @param locatorPath This is locator path in String format.
	* @param valueToSelect This is value to select in String format.
	******************************************************************************************
	*/
	public static void clickAnyElementFromListOptions(String locatorPath, String valueToSelect) {
		try{
		List<WebElement> lst = getAllElementsByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
		for (WebElement f : lst) {
			System.out.println("value in the list : " + f.getText());
			if (valueToSelect.equals(f.getText())) {
				f.click();
				break;
			}
		}}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: clickAnyElementFromListOptions] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	*****************************************************************************************
	* Click on sub element from given List.
	* @param locatorPath This is locator path in String format.
	* @param subElement This is sub Element name in String format.
	* @param valueToSelect This is value to select in String format.
	*****************************************************************************************
	*/
	public static void clickAnySubElementFromList(String locatorPath, String subElement, String valueToSelect) {
		try{
		WebElement mainElement = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
		List<WebElement> subList = mainElement.findElements(By.xpath("//" + subElement));
		for (WebElement f : subList) {
			if (valueToSelect.equals(f.getText())) {
				f.click();
				break;
			}
		}}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: clickAnySubElementFromList] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	*****************************************************************************************
	* Click on the given radio button if not selected.
	* @param locatorPath This is locator path in String format.
	*****************************************************************************************
	*/
	public static void radioButton_Select(String locatorPath) {
		try{
		WebElement radio = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
		boolean checkstatus;
		checkstatus = radio.isSelected();
		if (checkstatus == false) {
			radio.click();
		}}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: radioButton_Select] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	*****************************************************************************************
	* Click on the given radio button if selected.
	* @param locatorPath This is locator path in String format.
	*****************************************************************************************
	*/
	public static void radioButton_DeSelect(String locatorPath) {
		try{
		WebElement radio = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
		boolean checkstatus;
		checkstatus = radio.isSelected();
		if (checkstatus == true) {
			radio.click();
		}}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: radioButton_DeSelect] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	****************************************************************************************
	* Find element based on the input locator path.
	* @param locatorPath This is locator path in String format.
	* @return WebElement.
	***************************************************************************************
	*/
	public static WebElement getAnyElementByAnyLocator(String locatorPath) {
		try{
		if (locatorPath.startsWith("css_")) {
			String s = locatorPath.replace("css_", "");
			return driver.findElement(By.cssSelector(s));
		} else if (locatorPath.startsWith("xpath_")) {
			return driver.findElement(By.xpath(locatorPath.replace("xpath_", "")));
		} else if (locatorPath.startsWith("id_")) {
			return driver.findElement(By.id(locatorPath.replace("id_", "")));
		} else if (locatorPath.startsWith("name_")) {
			return driver.findElement(By.name(locatorPath.replace("name_", "")));
		} else if (locatorPath.startsWith("link_")) {
			return driver.findElement(By.linkText(locatorPath.replace("link_", "")));
		} else if (locatorPath.startsWith("partiallink_")) {
			return driver.findElement(By.partialLinkText(locatorPath.replace("partiallink_", "")));
		} else if (locatorPath.startsWith("class_")) {
			return driver.findElement(By.xpath(locatorPath.replace("class_", "")));
		} else if (locatorPath.startsWith("tag_")) {
			return driver.findElement(By.tagName(locatorPath.replace("tag_", "")));
		} else
			return null; }
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: getAnyElementByAnyLocator] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}

	/**
	 ******************************************************************************************
	 * Find element based on the input locator path and wait time.
	 * @param locatorPath This is locator path in String format.
	 * @param waitTime This is wait time in Seconds Long format.
	 * @return WebElement.
	 *****************************************************************************************
	 */
	public static WebElement getAnyElementByAnyLocatorSpecificWait(String locatorPath, long waitTime) {
		try{
		WebDriverWait w = new WebDriverWait(driver, waitTime);
		if (locatorPath.startsWith("css_")) {
			WebElement we = w
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorPath.replace("css_", ""))));
			return we;
		} else if (locatorPath.startsWith("xpath_")) {
			WebElement we = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorPath.replace("xpath_", ""))));
			return we;
		} else if (locatorPath.startsWith("id_")) {
			WebElement we = w.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorPath.replace("id_", ""))));
			return we;
		} else if (locatorPath.startsWith("name_")) {
			WebElement we = w.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorPath.replace("name_", ""))));
			return we;
		} else if (locatorPath.startsWith("link_")) {
			WebElement we = w
					.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorPath.replace("link_", ""))));
			return we;
		} else if (locatorPath.startsWith("partial_")) {
			WebElement we = w.until(
					ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorPath.replace("partial_", ""))));
			return we;
		} else if (locatorPath.startsWith("class_")) {
			WebElement we = w
					.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorPath.replace("class_", ""))));
			return we;
		} else if (locatorPath.startsWith("tag_")) {
			WebElement we = w.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorPath.replace("tag_", ""))));
			return we;
		} else
			return null;}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: getAnyElementByAnyLocatorSpecificWait] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}

	/**
	 ***************************************************************************************
	 * Find list of Web elements based on the input locator path.
	 * @param locatorPath This is locator path in String format.
	 * @return List of WebElements.
	 ***************************************************************************************
	 */
	public static List<WebElement> getAllElementsByAnyLocator(String locatorPath) {
		try{
		if (locatorPath.startsWith("css_")) {
			String s = locatorPath.replace("css_", "");
			return driver.findElements(By.cssSelector(s));
		} else if (locatorPath.startsWith("xpath_")) {
			return driver.findElements(By.xpath(locatorPath.replace("xpath_", "")));
		} else if (locatorPath.startsWith("id_")) {
			return driver.findElements(By.id(locatorPath.replace("id_", "")));
		} else if (locatorPath.startsWith("name_")) {
			return driver.findElements(By.name(locatorPath.replace("name_", "")));
		} else if (locatorPath.startsWith("link_")) {
			return driver.findElements(By.linkText(locatorPath.replace("link_", "")));
		} else if (locatorPath.startsWith("partiallink_")) {
			return driver.findElements(By.partialLinkText(locatorPath.replace("partiallink_", "")));
		} else if (locatorPath.startsWith("class_")) {
			return driver.findElements(By.xpath(locatorPath.replace("class_", "")));
		} else if (locatorPath.startsWith("tag_")) {
			return driver.findElements(By.tagName(locatorPath.replace("tag_", "")));
		} else
			return null;}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: getAllElementsByAnyLocator] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}

	/**
	 ***************************************************************************************
	 * Find list of Web elements based on the input locator path and wait time.
	 * @param locatorPath This is locator path in String format.
	 * @param waitTime This is wait time in Seconds Long format.
	 * @return List of WebElements.
	 ****************************************************************************************
	 */
	public static List<WebElement> getAllElementsByAnyLocatorSpecificWait(String locatorPath, long waitTime) {
		try{
		WebDriverWait w = new WebDriverWait(driver, waitTime);
		if (locatorPath.startsWith("css_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("css_", ""))));
		} else if (locatorPath.startsWith("xpath_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("xpath_", ""))));
		} else if (locatorPath.startsWith("id_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("id_", ""))));
		} else if (locatorPath.startsWith("name_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("name_", ""))));
		} else if (locatorPath.startsWith("link_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("link_", ""))));
		} else if (locatorPath.startsWith("partialink_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorPath.replace("partial_", ""))));
		} else if (locatorPath.startsWith("class_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locatorPath.replace("class_", ""))));
		} else if (locatorPath.startsWith("tag_")) {
			return w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(locatorPath.replace("tag_", ""))));
		} else
			return null;}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: getAllElementsByAnyLocatorSpecificWait] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}

	/**
	 *******************************************************************************************
	 * Verify the given element is present or not.
	 * @param locatorPath This is locator path in String format.
	 * @return boolean True / False  
	 *******************************************************************************************/
	public static boolean isElementPresent(String locatorPath) {
		try {
			getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY).isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: isElementPresent] Exception thrown -- " + getStackTrace(e));
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	/**
	 ******************************************************************************************
	 * Will give a CurrentPageTitle.
	 * @return pageTitle This is Page title in String format.
	 ******************************************************************************************
	 */
	public static String getCurrentPageTitle() {
		try{
		return driver.getTitle();}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: getCurrentPageTitle] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return null;
		}
	}
	
	/**
	 ******************************************************************************************
	 * Will Check Alert present or not. And if alert present accept.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean checkAlert_Accept() {
		try {
		Alert a = driver.switchTo().alert();
		a.accept();
		return true;
		} catch (Exception e) {
			setLogger().error("[EY_FW_Utility: checkAlert_Accept] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
		}

	/**
	 ******************************************************************************************
	 * Will Check Alert present or not. And if alert present dismiss.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean checkAlert_Dismiss() {
		try {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		return true;
		} catch (Exception e) {
			setLogger().error("[EY_FW_Utility: checkAlert_Dismiss] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
		}

	/**
	 ******************************************************************************************
	 * Perform Scrolling till it finds the element specified.
	 * @param locatorPath This is locator path in String format.
	 ******************************************************************************************
	 */
	public static void scrolltoElement(String locatorPath) {
		try{
			WebElement mainElement = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			Coordinates coordinate = ((Locatable) mainElement).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();
			}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: scrolltoElement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	 ******************************************************************************************
	 * Perform double click on the element specified.
	 * @param locatorPath This is locator path in String format.
	 ******************************************************************************************
	 */
	public static void doubleClickWebelement(String locatorPath){
		try{
			WebElement doubleclickonWebElement = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			Actions builder = new Actions(driver);
			builder.doubleClick(doubleclickonWebElement).perform();
			doWait(2000);
			}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: doubleClickWebelement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 ******************************************************************************************
	 * Perform switch To child Window operation when there is child and parent window .
	 ******************************************************************************************
	 */
	public static void switchToChildWindow() {
		try{
			@SuppressWarnings("rawtypes")
			Set s = driver.getWindowHandles();
			@SuppressWarnings("rawtypes")
			Iterator itr = s.iterator();
			@SuppressWarnings("unused")
			String w1 = (String) itr.next();
			String w2 = (String) itr.next();
			driver.switchTo().window(w2);
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: switchToChildWindow] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 ******************************************************************************************
	 * Perform switch To parent Window operation when there is child and parent window .
	 ******************************************************************************************
	 */
	public static void switchToParentWindow() {
		try{
			@SuppressWarnings("rawtypes")
			Set s = driver.getWindowHandles();
			@SuppressWarnings("rawtypes")
			Iterator itr = s.iterator();
			String w1 = (String) itr.next();
			driver.switchTo().window(w1);
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: switchToParentWindow] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}

	/**
	 *******************************************************************************************
	 * Verify the given value is present or not in particular column of web table.
	 * @param locatorPath This is locator path in String format.
	 * @param colNumber This is column Number need to be checked for presence of given value
	 * @param expectedValue This is expected value which column should contain
	 *******************************************************************************************
	 */
	public static void verifyTableColumnContains(String locatorPath, int colNumber, String expectedValue) {
		try{
			String part1 = locatorPath; // Example: locatorPath = "xpath_//table[@class='dataTable']/tbody/tr"
			String part2= "[";
			String part3 = "]/td[";
			String part4 = Integer.toString(colNumber);
			String part5 = "]";
			int count = EY_FW_Utility.getAllElementsByAnyLocator(part1).size();
			int i = 1;
			String actualValue = null;
			while(i<=count){
				String extractedValue = getAnyElementByAnyLocatorSpecificWait(part1+part2+i+part3+part4+part5, 
																				EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY).getText();
				if(extractedValue.equals(expectedValue)){
				actualValue = extractedValue;
				break;
				}
				i++;
			}
			doWait(2000);
			MatcherAssert.assertThat(actualValue, equalTo(expectedValue));
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyTableColumnContains] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 *******************************************************************************************
	 * Verify the given value is present or not in particular row of web table.
	 * @param locatorPath This is locator path in String format.
	 * @param rowNumber This is row Number need to be checked for presence of given value
	 * @param expectedValue This is expected value which row should contain
	 *******************************************************************************************
	 */
	public static void verifyTableRowContains(String locatorPath, int rowNumber, String expectedValue) {
		try{
			String part1 = locatorPath; // Example: locatorPath = "xpath_//table[@class='dataTable']/tbody/tr"
			String part2 = "[";
			String part3 = Integer.toString(rowNumber);
			String part4 = "]/td[";
			String part5 = "]";
			int i =1;
			String actualValue = null;
			while(isElementPresent(part1+part2+part3+part4+i+part5)){
				String extractedValue = getAnyElementByAnyLocatorSpecificWait(part1+part2+part3+part4+i+part5, 
																				EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY).getText();
				if(extractedValue.equals(expectedValue)){
				actualValue = extractedValue;
				break;
				}
				i++;
			}
			doWait(2000);
			MatcherAssert.assertThat(actualValue, equalTo(expectedValue));
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyTableRowContains] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage()); 
		}
	}
	
	/**
	 *******************************************************************************************
	 * Verify the given value is present or not in particular row,column of web table.
	 * @param locatorPath This is locator path in String format.
	 * @param rowNumber This is row Number need to be checked for presence of given value.
	 * @param colNumber This is column Number need to be checked for presence of given value.
	 * @param expectedValue This is expected value which row,column should contain.
	 *******************************************************************************************
	 */
	public static void verifyTableCellContains(String locatorPath, int rowNumber,int colNumber, String expectedValue) {
		try{
			String part1 = locatorPath; // Example: locatorPath = "xpath_//table[@class='dataTable']/tbody/tr"
			String part2 = "[";
			String part3 = Integer.toString(rowNumber);
			String part4 = "]/td[";
			String part5 = Integer.toString(colNumber);
			String part6 = "]";
			String actualValue = null;
			String extractedValue = getAnyElementByAnyLocatorSpecificWait(part1+part2+part3+part4+part5+part6, 
																			EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY).getText();
			if(extractedValue.equals(expectedValue)){
				actualValue = extractedValue;
			}
			doWait(2000);
			MatcherAssert.assertThat(actualValue, equalTo(expectedValue));
			}
			catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyTableCellContains] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	/**
	 *******************************************************************************************
	 * Converts StackTrace generated at time of Exception thrown into Message String format.
	 * @param throwable This is Exception thrown.
	 * @return String This is Exception message in String format.
	 *******************************************************************************************
	 */
	public static String getStackTrace(final Throwable throwable) {
	  try{
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	  }
	  catch (Exception e){
			setLogger().error("[EY_FW_Utility: getStackTrace] Exception thrown -- " + getStackTrace(e));
			Assert.assertTrue(false, e.getMessage());
			return null;
	  }
	}

	/**
	 ******************************************************************************************
	 * Will Check Alert present or not.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert(); 
	        return true; 
		} catch (NoAlertPresentException  e) {
			setLogger().error("[EY_FW_Utility: isAlertPresent] No Alert Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: isAlertPresent] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	
	/**
	 ******************************************************************************************
	 * Will Check Whether Page Contains given text or not.
	 * @param pageText This is text in string format to be checked on Web Page.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean verifyPageContainsText(String pageText) {
		try {
			List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + pageText + "')]"));
			if(list.size() > 0){
				return true; 
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyPageContainsText] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
		
	}
	
	
	/**
	 ******************************************************************************************
	 * Will Check Whether Page Contains given WebElement or not.
	 * @param locatorPath This is locator path in String format.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean verifyPageContainsElement(String locatorPath) {
		try {
			List<WebElement> element = getAllElementsByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			if (element.size() != 0){
			return true;
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyPageContainsElement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
		
	}
	
	/**
	 ******************************************************************************************
	 * Will Check Whether given WebElement Visible or not.
	 * @param locatorPath This is locator path in String format.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean verifyPageContainsVisibleElement(String locatorPath) {
		try {
			WebElement element = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			if(element.isDisplayed()){
			return true;
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyPageContainsVisibleElement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	
	/**
	 ******************************************************************************************
	 * Will Check Whether given WebElement Enabled or not.
	 * @param locatorPath This is locator path in String format.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean verifyPageContainsEnabledElement(String locatorPath) {
		try {
			WebElement element = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			if(element.isEnabled()){
			return true;
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyPageContainsEnabledElement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	/**
	 ******************************************************************************************
	 * Will Check Whether text field contains given value or not
	 * @param locatorPath This is locator path in String format.
	 * @param value This is value to be checked in the text field.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean verifyTextFieldContainsValue(String locatorPath, String value) {
		try {
			WebElement element = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			if(element.getAttribute("value").equals(value)){
			return true;
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: verifyTextFieldContainsValue] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	
	/**
	 ******************************************************************************************
	 * Will Check Whether frame contains given text or not using frame index
	 * @param index This is frame index to be switched in.
	 * @param pageText This is text in string format to be checked on Frame inside Web Page.
	 * @return boolean True / False.
	 ******************************************************************************************
	 */
	public static boolean VerifyFrameContainsTextUsingIndex(int index, String pageText) {
		try {
			driver.switchTo().frame(index);
			List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + pageText + "')]"));
			if(list.size() > 0){
				return true; 
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: VerifyFrameContainsTextUsingIndex] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	/**
	 *****************************************************************************************************
	 * Will Check Whether frame contains given text or not using name of the frame or id of frame element.
	 * @param name This is frame name to be switched in.
	 * @param pageText This is text in string format to be checked on Frame inside Web Page.
	 * @return boolean True / False.
	 *****************************************************************************************************
	 */
	public static boolean VerifyFrameContainsTextUsingName(String name, String pageText) {
		try {
			driver.switchTo().frame(name);
			List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + pageText + "')]"));
			if(list.size() > 0){
				return true; 
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: VerifyFrameContainsTextUsingName] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
	/**
	 *****************************************************************************************************
	 * Will Check Whether frame contains given text or not using its previously located WebElement.
	 * @param locatorPath This is locator path in String format of previously located frame.
	 * @param pageText This is text in string format to be checked on Frame inside Web Page.
	 * @return boolean True / False.
	 *****************************************************************************************************
	 */
	public static boolean VerifyFrameContainsTextUsingElement(String locatorPath, String pageText) {
		try {
			if(isElementPresent(locatorPath)){
			WebElement element = getAnyElementByAnyLocatorSpecificWait(locatorPath, EY_MMS_FW_Constants.MAX_WAIT_TIME_ONE_TWENTY);
			driver.switchTo().frame(element);
			List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + pageText + "')]"));
			if(list.size() > 0){
				return true; 
			}
			}
			return false;
		}
		catch (Exception e) {
			setLogger().error("[EY_FW_Utility: VerifyFrameContainsTextUsingElement] Exception thrown -- " + getStackTrace(e));	
			Assert.assertTrue(false, e.getMessage());
			return false;
		}
	}
	
}
