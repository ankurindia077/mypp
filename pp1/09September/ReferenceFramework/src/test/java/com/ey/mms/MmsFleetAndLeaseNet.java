/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 */

package com.ey.mms;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
* <h1>Runner Class</h1>
* MMS Runner Class for Configuration Theme containing Feature MMS fleet and lease net.
* @author  Ankur Chaudhry
* @version 1.1
* @since   2016-07-17
*/

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/ey_mms_configuration/mms_fleet_and_lease_net.feature")
public class MmsFleetAndLeaseNet{}
