package tests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by pc on 06.05.2016.
 */
public class Testik {

    @DataProvider(name = "test")
    public static Object[][] primeNumbers() {
        Reporter.log("dataprovider", true);
        return new Object[][] {{1,1}, {2,2}};
    }

    @Test(dataProvider = "test", groups = "real")
    public void real(int i, int j){
        Reporter.log("real " + i, true);
        Reporter.log("<br/>");
        Reporter.log("1 "+ i, true);
    }

    @Test(dataProvider = "test", groups = "fun")
    public void fun(int i, int j){
        Reporter.log("fun " + i, true);
        Reporter.log("<br/>");
        Reporter.log("2 " + i, true);
    }
}
