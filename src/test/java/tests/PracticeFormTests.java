package tests;

import manager.ApplicationManager;
import manager.dto.StudentDTO;
import manager.enums.Gender;
import org.testng.annotations.Test;
import pages.HomePages;

public class PracticeFormTests extends ApplicationManager {

    @Test
    public void practiceFormPositiveTest(){

        //sobiraem object student
        StudentDTO student = new StudentDTO();
        //dla etogo chto to pologit cherez setteri
        student.setName("Stive");
        student.setLastName("Silver");
        student.setEmail("silver123@gmail.com");
        student.setGender(Gender.MALE);


        new HomePages(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .fillStudentsForm(student);
    }
}
