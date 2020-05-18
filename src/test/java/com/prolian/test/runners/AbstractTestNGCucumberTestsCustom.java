package com.prolian.test.runners;

import com.prolian.test.framework.helpers.DataGenerator;
import com.prolian.test.framework.helpers.Props;
 import com.prolian.test.framework.helpers.TestContext;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.leangen.geantyref.TypeFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import  com.prolian.test.framework.*;

/**
 *
 * This Class is abstract class which behaves as a running class
 * @Author -
 *
 */

@CucumberOptions(features = "src/test/resources/features/web/RegressionTest", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/RunReport",
        "json:target/cucumber-report/RunReport/cucumber.json"},glue = "com.prolian.test",tags = {"@wip"})


public class AbstractTestNGCucumberTestsCustom  {

    private TestNGCucumberRunner testNGCucumberRunner;
    public String scenarioName;
    public ExtentTest extentTestReport;
    DataGenerator dataGenerator = DataGenerator.getInstance();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {


        Class claz = this.getClass();
        CucumberOptions options = this.getClass().getAnnotation(CucumberOptions.class);
       String originalTags[] = options.tags();
        Props.loadRunConfigProps("/environment.properties");
  //  String newTags[] = ArrayUtils.addAll(originalTags, "@" + System.getProperty("locale", Props.getProp("defaultLocale")));
        Field annotationDataField =claz.getClass().getDeclaredField("annotationData");
        annotationDataField.setAccessible(true);
        Field annotationField = annotationDataField.get(claz).getClass().getDeclaredField("annotations");
        annotationField.setAccessible(true);
        Map<String,Object> annotationParameters = new HashMap<>();
        annotationParameters.put("features",options.features());
       annotationParameters.put("tags",originalTags);
        annotationParameters.put("plugin",options.plugin());
        annotationParameters.put("glue",options.glue());

        CucumberOptions newOptions = TypeFactory.annotation(CucumberOptions.class,annotationParameters);
        Map<Class<? extends Annotation>, Annotation > annotations = (Map<Class<? extends  Annotation> , Annotation>) annotationField.get(annotationDataField.get(claz));
        annotations.put(CucumberOptions.class, newOptions);

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());




    }

    @Before

public void beforeEveryScenario(Scenario scenario) {

        ReportManager.getInstance();
         scenarioName=scenario.getName();
        System.out.println(scenarioName);
      // TestContext.getInstance().setScenarioName(scenarioName);
       extentTestReport= ReportManager.startTesting(scenarioName.toString(),"Scenario desciption");
        extentTestReport.log(LogStatus.INFO,"The Set person is called");
       dataGenerator.setPerson();

    }



@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")

    public void TestrunScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable{

        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
}

@DataProvider

    public Object[][] scenarios(){

        if (testNGCucumberRunner==null) {

            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
}

@AfterClass(alwaysRun = true)

    public void tearDownClass() {

        if (testNGCucumberRunner==null) {
    return;
    }

    testNGCucumberRunner.finish();
}


@After

    public void afterEveryScenario() {

        ReportManager.stopReport(extentTestReport);
        extentTestReport.log(LogStatus.INFO,"The Delete person is called");
        dataGenerator.deletePerson();
}

}




