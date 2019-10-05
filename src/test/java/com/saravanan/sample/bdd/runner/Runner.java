package com.saravanan.sample.bdd.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "com.saravanan.sample.bdd")
//@CucumberOptions(features = "classpath:features")
public class Runner {
}