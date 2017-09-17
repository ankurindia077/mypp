package com.serenity.demo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/googlesearch2/serenity_bdd_search_2.feature")
public class SerenityBDDSearch2 {}
