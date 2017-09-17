@MMSLOGIN
Feature: MMS fleet and Lease Net

@MMSLOGIN-001
Scenario: Log into MMS application.
Given User is logged in as 'kcsadmin' and 'admin' as password.
When User Clicks on MMS Login Button.
Then User navigates to mms home page.

@MMSLOGIN-002
Scenario: Click on Fleet List.
Given User navigate through configuration.
When User selects fleets and clicks fleets list.
Then User navigates to fleets list page.

@MMSLOGIN-003
Scenario: Click on Filter Button.
Given User clicks on filter button.
When User enters car initial and click on save.
Then filter should apply and verify results.