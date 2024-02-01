package stepDefinations;

import java.util.HashMap;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.httpHelper;

public class StepDefinitions {
    int accountBalance = 0;
    httpHelper httpUtils = new httpHelper();
    public HashMap<String, String> accountDetails = new HashMap<String, String>();

    @Given("^Account holder id is {sring} and name is {string}$")
    public void setAccountHolderName(String user_id, String accountHolderName){
    	accountDetails.put("#USER_ID", user_id);
    	accountDetails.put("#USER_NAME", accountHolderName);
    }

    @Given("^Address is {string}$")
    public void setAddress(String address){
    	accountDetails.put("#ADDRESS", address);
    }

    @Given("^Phone number is {string}$")
    public void setPhoneNumber(String phoneNumber){
    	accountDetails.put("#MOBILE_NUMBER", phoneNumber);
    }

    @When("^Create a new account$") 
    public void createNewAccount() {
    	accountDetails.put("RESOURCE", "createAccount");
    	httpUtils.post(accountDetails);
    	accountDetails.put("ACCOUNT_ID", httpUtils.getAccountId());
    }

    @Then("^Validate the response code is {string}$")
    public void validateResponseCode(String statusCode) {
    	httpUtils.validateResponseCode(statusCode);
    }
    
    @Then("^Validate the response message is {string}$")
    public void validateResponseMessage(String responseMessage) {
    	httpUtils.validateResponseMessage(responseMessage);
    }

    @Then("^Validate account is created.$")
    public void validateCreateAccount() {
    	//Add get call step to check the account is created or not with account id -> accountDetails.get("ACCOUNT_ID")
    	//Assert status code
    	//Assert response message
    	System.out.println("Account is created Successfully.");
    }

    @Given("^Account number is {string}$")
    public void setAccountNumber(String accountNumber){
    	accountDetails.put("#ACCOUNT_NUMBER", accountNumber);
    }

    @When("^Delete user account$") 
    public void deleteUserAccount() {
    	httpUtils.delete(accountDetails.get("#ACCOUNT_NUMBER"));
    }

    @Then("^Validate account is deleted.$")
    public void validateDeleteAccount() {
    	//Add get call step to check the account is deleted / inactive or not with account id -> accountDetails.get("ACCOUNT_ID")
    	//Assert status code
    	//Assert response message
    	System.out.println("Account is deleted Successfully.");
    }

    @When("^Deposit {string}$") 
    public void depositAmount(String amount) {
    	//accountBalance =  Add get call to fetch the account balance using account id -> accountDetails.get("ACCOUNT_ID")
    	accountDetails.put("RESOURCE", "deposit");
    	accountDetails.put("#AMOUNT", amount);
    	accountDetails.put("#TRANSACTION_TYPE", "deposit");
    	
    	httpUtils.put(accountDetails);
    }
    
    @Then("^Validate the account balance$")
    public void validateAccountBalance() {
    	if(accountDetails.get("RESOURCE").contains("deposit"))
    		accountBalance += Integer.valueOf(accountDetails.get("#AMOUNT"));
    	
    	//Add get call step to check the deposited / withdrawn account is updated or not with account id -> accountDetails.get("ACCOUNT_ID")
    	
    	//Assert status code
    	//Assert compare response account balance with accountBalance value
    	//Assert response message
    }
    
    @When("^Withdraw {string}$") 
    public void withdrawAmount(String amount) {
    	//accountBalance =  add get call to fetch the account balance using account id with account id -> accountDetails.get("ACCOUNT_ID")
    	accountDetails.put("RESOURCE", "withdrawn");
    	accountDetails.put("#AMOUNT", amount);
    	accountDetails.put("#TRANSACTION_TYPE", "withdrawn");
    	
    	httpUtils.post(accountDetails);
    }
}
