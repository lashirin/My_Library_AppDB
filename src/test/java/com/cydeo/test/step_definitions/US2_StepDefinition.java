package com.cydeo.test.step_definitions;


import com.cydeo.test.pages.DashBoardPage;
import com.cydeo.test.pages.LoginPage;
import com.cydeo.test.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_StepDefinition {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    Integer actualborrowedBooksNumber;


    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login("librarian");

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        actualborrowedBooksNumber = Integer.valueOf(dashBoardPage.borrowedBooksNumber.getText());
        System.out.println(dashBoardPage.borrowedBooksNumber.getText());

    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow\n" +
                "where is_returned=0");
        Integer expectedBorrowBooksNumber = Integer.valueOf(DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(expectedBorrowBooksNumber,actualborrowedBooksNumber);
    }

    @Then("borrowed books number information must match with D")
    public void borrowedBooksNumberInformationMustMatchWithD() {
        
    }
}


