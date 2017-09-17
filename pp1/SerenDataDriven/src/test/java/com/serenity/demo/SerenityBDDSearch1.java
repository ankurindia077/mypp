package com.serenity.demo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/googlesearch1/serenity_bdd_search_1.feature")
public class SerenityBDDSearch1 {}
