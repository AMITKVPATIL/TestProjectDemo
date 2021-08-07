package jbkProjectFramework.dataTable;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginFieldData {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] loginDataTest() {
    return new Object[][] {
      new Object[] { "TC01","blanked","","","Please enter email.","Please enter password." },
      new Object[] { "TC02","passblank","kiran@gmail.com","","","Please enter password." },
      new Object[] {"TC03","emailblanked","","123456","Please enter email",""},
      new Object[] {"TC04","passwrong","kiran@gmail.com","135658","","Please enter password 123456"},
      new Object[] {"TC05","emailwrong","amit@gmail.com","123456","Please enter email as kiran@gmail.com",""},
      new Object[] {"TC06","bothwrong","amit@gmail.com","1256","Please enter email as kiran@gmail.com","Please enter password 123456"},
      new Object[] {"TC07","bothcorrect","kiran@gmail.com","123456","",""},
      
    };
  }
}
