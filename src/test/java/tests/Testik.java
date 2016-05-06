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
        return new Object[][] {{1}, {2}, {3}};
    }

    @Test(dataProvider = "test", groups = "real")
    public void real(int i){
        Reporter.log("real " + i, true);
    }

    @Test(dataProvider = "test", groups = "fun")
    public void fun(int i){
        Reporter.log("fun " + i, true);
    }
}
