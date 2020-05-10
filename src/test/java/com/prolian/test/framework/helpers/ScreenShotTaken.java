package com.prolian.test.framework.helpers;

import com.prolian.test.framework.PageObject;
import com.prolian.test.framework.ReportManager;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.SystemUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShotTaken  {


    public  static void testTakingFullScreenShot()  {

        Date dp = new Date();

        String screenShotPath = SystemUtils.getUserDir().toString()+"/target/screenshot_"+ dp.toString().replaceAll(" ","_").replaceAll(":","_")+".png";


        Screenshot screenshot= new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(WebDriverHelper.getWebDriver());

        try {
            ImageIO.write(screenshot.getImage(),"PNG",
                    new File(screenShotPath));

            ReportManager.extentTest.log(LogStatus.FAIL,"Sanp shot"+ReportManager.extentTest.addScreenCapture(screenShotPath));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
