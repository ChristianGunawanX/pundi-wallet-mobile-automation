package test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.PundiAiNetwork;
import org.testng.annotations.Test;
import utils.TestDataUtils;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        String sendAddress = TestDataUtils.getTestData("send_address");
        PundiAiNetwork pundiAiNetwork = new PundiAiNetwork(driver);
        pundiAiNetwork.clickPundiAiToken();
        pundiAiNetwork.clickSendButton();
        pundiAiNetwork.enterSendToAddress(sendAddress);

    }
}
