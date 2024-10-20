package tests;

import manager.ApplicationManager;
import manager.dto.StudentDTO;
import manager.enums.Gender;
import manager.enums.Hobbies;
import manager.enums.StateCity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePages;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends ApplicationManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void practiceFormPositiveTest() {
        List<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);

        //sobiraem object student
        StudentDTO student = new StudentDTO("Steve", "Silver", "silver123@gmail.com", Gender.OTHER,
                "1234567890", "12 Sep 1900", "Math, Physics, Economics", listHobbies, "", "Haifa st 1 app 2",
                StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[2]);

        //sobiraem object student

        //StudentDTO studentDTO = new StudentDTO();

        //dla etogo chto to pologit cherez setteri
        //student.setName("Stive");
        //student.setLastName("Silver");
        //student.setEmail("silver123@gmail.com");
        //student.setGender(Gender.MALE);


        Assert.assertTrue(new HomePages(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .fillStudentsForm(student)
                .clickBtnSubmit()
                .isTextToBePresent_textThanksFor());
    }

//        new HomePages(getDriver())
//                .clickBtnForms()
//                .clickBtnPracticeForm()
//                .fillStudentsForm(student)
//                .clickBtnSubmit()
//                .isTextToBePresent_textThanksFor();
//    }


    @Test
    public void practiceFormPositiveTestSoft() {
        List<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);

        StudentDTO student = new StudentDTO("Steve","Silver","silver123@gmail.com",Gender.OTHER,
                "1234567890","12 Sep 1900","Math, Physics, Economics",listHobbies,"","Haifa st 1 app 2",
                StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[2]);

//        StudentDTO student = new StudentDTO();
//        student.setName("Steve");
//        student.setLastName("Silver");
//        student.setEmail("silver123@gmail.com");
//        student.setGender(Gender.OTHER);


        new HomePages(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .fillStudentsForm(student)
                .clickBtnSubmit()
        ;

        WebElement elementNameFamily = getDriver().findElement(By.xpath("//tbody/tr[1]/td[last()]"));
        softAssert.assertEquals(elementNameFamily.getText(),"Steve Silver");

        WebElement elementEmail = getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]"));
        softAssert.assertEquals(elementEmail.getText(),"silver123@gmail.com");

        softAssert.assertAll();
    }

}
