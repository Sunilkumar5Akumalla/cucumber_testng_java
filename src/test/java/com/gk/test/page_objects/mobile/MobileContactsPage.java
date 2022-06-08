package com.gk.test.page_objects.mobile;

import com.gk.test.framework.AndroidObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileContactsPage extends AndroidObject {

    private By addContactButton = By.name("Add Contact");
    private String contactFormFields = ("android.widget.EditText");
    private String saveButton = ("Save");


    public void clickOnAddContact() {
        getAndroidDriver().findElement(addContactButton).click();
    }

    public List<WebElement> getContactFormFields() {
        return getAndroidDriver().findElements(new By.ByClassName(contactFormFields));
    }

    public void saveContact() {
        getAndroidDriver().findElement(By.name(saveButton)).click();
    }
}
