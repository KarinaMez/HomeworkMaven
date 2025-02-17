package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы для элементов
    private final By blockTitle = By.xpath("//section/div/h2");
    private final By paymentSystemLogos = By.xpath("*//section/div/div[2]/ul");
    private final By moreInfoLink = By.linkText("Подробнее о сервисе");
    private final By phoneNumberField = By.xpath("//*[@id='connection-phone']");
    private final By amountField = By.id("connection-sum");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private final By emptyFieldErrorMessage = By.xpath("//div[@class='error-message']");
    // Локатор iframe
    private final By iFrame = By.xpath(".//iframe[@class='bepaid-iframe']");

    // Локаторы для полей ввода реквизитов карты

    private final By cardNumberLabel = By.xpath("//label[text()='Номер карты']");
    private final By cardExpiryLabel = By.xpath("//label[text()='Срок действия']");
    private final By cardCVCLabel = By.xpath("//label[text()='CVC']");
    private final By cardHolderNameLabel = By.xpath("//label[text()='Имя держателя (как на карте)']");
    private final By paymentSystemIcons = By.xpath("(//input[@value=''])[4]");

    // Локаторы для элементов, появляющихся после нажатия кнопки "Продолжить"
    private final By displayedPhoneNumber = By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Оплата: Услуги связи')]");
    private final By displayedAmount = By.xpath("//span[contains(text(), '10.00 BYN')]");
    private final By paymentButton = By.xpath("//div[2]/span");

    // Локаторы для полей формы "Услуги связи"
    private final By commServicesPhoneField = By.xpath("//input[@id='connection-phone']");
    private final By commServicesAmountField = By.xpath("//input[@id='connection-sum']");
    private final By commServicesEmailField = By.xpath("//input[@id='connection-email']");

    // Локаторы для полей формы "Домашний интернет"
    private final By homeInternetOption = By.cssSelector(".select__item:nth-child(2) .select__option");
    private final By homeInternetAccountField = By.xpath("//input[@id='internet-phone']");
    private final By homeInternetAmountField = By.xpath("//input[@id='internet-sum']");
    private final By homeInternetEmailField = By.xpath("//input[@id='internet-email']");

    // Локатор выпадающего списка
    private final By installmentPlanDropdown = By.xpath("//section/div/div/div/div[2]/button");

    // Локаторы для полей формы "Рассрочка"
    private final By installmentPlanOption = By.cssSelector(".select__item:nth-child(3) .select__option");
    private final By installmentPlanContractField = By.xpath("//input[@id='score-instalment']");
    private final By installmentPlanAmountField = By.xpath("//input[@id='instalment-sum']");
    private final By installmentPlanEmailField = By.xpath("//input[@id='instalment-email']");

    // Локаторы для полей формы "Оплата задолженности"
    private final By debtPaymentOption = By.cssSelector(".select__item:nth-child(4) .select__option");
    private final By debtPaymentContractField = By.xpath("//input[@id='score-arrears']");
    private final By debtPaymentAmountField = By.xpath("//input[@id='arrears-sum']");
    private final By debtPaymentEmailField = By.xpath("//input[@id='arrears-email']");


    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для переключения на фрейм по локатору
    public void switchToFrame() {
        try {
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(iFrame));
            driver.switchTo().frame(iframeElement);
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти iframe в течение ожидаемого времени.");
        }
    }

    // Метод для переключения обратно на основной контент
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Метод для закрытия куки
    public void closeCookies() {
        try {
            WebElement cookieCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Принять')]")));
            // Кликаем по кнопке, если она видима
            if (cookieCloseButton.isDisplayed()) {
                cookieCloseButton.click();
                System.out.println("Cookies успешно закрыты.");
            } else {
                System.out.println("Кнопка закрытия куки не видима.");
            }
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти кнопку закрытия куки в течение ожидаемого времени.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при попытке закрыть куки: " + e.getMessage());
        }
    }

    // Получение текста заголовка блока
    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    // Получение количества логотипов платежных систем
    public int getPaymentSystemLogosCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentSystemLogos)).size();
    }

    // Клик по ссылке "Подробнее о сервисе"
    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click();
    }

    // Ввод номера телефона
    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    // Ввод суммы
    public void enterAmount(String amount) {
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    // Клик по кнопке "Продолжить"
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // Получение текста кнопки "Продолжить"
    public String getContinueButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).getText();
    }


    // Получение отображаемого номера телефона после нажатия кнопки "Продолжить"
    public String getDisplayedPhoneNumber() {

        String phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(displayedPhoneNumber)).getText();

        return phoneNumber;
    }

    // Получение отображаемой суммы после нажатия кнопки "Продолжить"
    public String getDisplayedAmount() {

        String amount = wait.until(ExpectedConditions.visibilityOfElementLocated(displayedAmount)).getText();

        return amount;
    }

    // Получение текста кнопки "Оплатить"
    public String getPaymentButtonText() {

        String paymentText = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton)).getText();

        return paymentText;
    }

    // Универсальный метод для получения плейсхолдера
    private String getPlaceholderForField(By fieldLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLocator)).getAttribute("placeholder");
    }

    // Получение плейсхолдера для полей формы "Услуги связи"
    public String getPlaceholderForCommServicesPhone() {
        return getPlaceholderForField(commServicesPhoneField);
    }

    public String getPlaceholderForCommServicesAmount() {
        return getPlaceholderForField(commServicesAmountField);
    }

    public String getPlaceholderForCommServicesEmail() {
        return getPlaceholderForField(commServicesEmailField);
    }

    // Получение плейсхолдера для полей формы "Рассрочка"
    public String getPlaceholderForInstallmentPlanContract() {
        return getPlaceholderForField(installmentPlanContractField);
    }

    public String getPlaceholderForInstallmentPlanAmount() {
        return getPlaceholderForField(installmentPlanAmountField);
    }

    public String getPlaceholderForInstallmentPlanEmail() {
        return getPlaceholderForField(installmentPlanEmailField);
    }

    // Получение плейсхолдера для полей формы "Домашний интернет"
    public String getPlaceholderForHomeInternetAccount() {
        return getPlaceholderForField(homeInternetAccountField);
    }

    public String getPlaceholderForHomeInternetAmount() {
        return getPlaceholderForField(homeInternetAmountField);
    }

    public String getPlaceholderForHomeInternetEmail() {
        return getPlaceholderForField(homeInternetEmailField);
    }

    // Получение плейсхолдера для полей формы "Оплата задолженности"
    public String getPlaceholderForDebtPaymentContract() {
        return getPlaceholderForField(debtPaymentContractField);
    }

    public String getPlaceholderForDebtPaymentAmount() {
        return getPlaceholderForField(debtPaymentAmountField);
    }

    public String getPlaceholderForDebtPaymentEmail() {
        return getPlaceholderForField(debtPaymentEmailField);
    }
    // Получение плейсхолдера для полей ввода реквизитов карты


    public String getCardNumberLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)).getText();
    }


    public String getPlaceholderForCardExpiry() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryLabel)).getText();
    }


    public String getPlaceholderForCardCVC() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCVCLabel)).getText();
    }


    public String getPlaceholderForCardHolderName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderNameLabel)).getText();
    }

    // Получение количества иконок платежных систем
    public int getPaymentSystemIconsCount() {

        int iconsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentSystemIcons)).size();

        return iconsCount;
    }
    // Переход на разные формы

    public void selectPaymentForm() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(installmentPlanDropdown));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption));
        option.click();
    }

    public void selectInstallmentPlanForm() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(installmentPlanDropdown));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(installmentPlanOption));
        option.click();
    }

    public void selectDebtPaymentForm() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(installmentPlanDropdown));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(debtPaymentOption));
        option.click();
    }


}

