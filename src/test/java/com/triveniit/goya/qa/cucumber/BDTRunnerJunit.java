package com.triveniit.goya.qa.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //tags = { "@debug" },

          features =  {//"src/test/resources/features/LoginFunctionality.feature" ,
                       //"src/test/resources/features/CreateOrder.feature",
                       "src/test/resources/features/SmartOrder.feature"

                       },

          glue =      {"com.triveniit.goya.qa.framework.steps"},

          plugin =    {
                       "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                       "html:target/cucumber-test-report",
                       "json:target/cucumber-test-report/cucumber-report.json",
                       "junit:target/cucumber-test-report/test-report.xml",
                       "html:target/cucumber-reports"
          }


  )


public class BDTRunnerJunit {

}
