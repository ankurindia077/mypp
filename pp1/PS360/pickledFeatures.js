jsonPWrapper ({
  "Features": [
    {
      "RelativeFolder": "PS360.feature",
      "Feature": {
        "Name": "Test PS360 Feature",
        "Description": "",
        "FeatureElements": [
          {
            "Name": "67388_67389 Verify that Powerscribe client minimizes when study is minimized",
            "Slug": "6738867389-verify-that-powerscribe-client-minimizes-when-study-is-minimized",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I opened study for the Accession 'A12861#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I dictated the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client displayed the existing report",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I launched Patient Folder in restore mode",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I 'minimize' the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall 'minimize'",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_12174",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_67388_67389",
              "@PRIORITY",
              "1"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "45436_45437 Verify that Powerscribe360 client logs out when user logs out of UV.",
            "Slug": "4543645437-verify-that-powerscribe360-client-logs-out-when-user-logs-out-of-uv",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I opened study for the Accession 'A45436#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I dictated the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client displayed the existing report with 'report text'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I close the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "log out of study list",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall log out and 'close'.",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_12332_12335",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_45436_45437",
              "@PRIORITY",
              "2"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "12871 _Verify that study is dictated when report is saved as Draft.",
            "Slug": "12871-verify-that-study-is-dictated-when-report-is-saved-as-draft",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I opened study for the Accession 'A12871#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I dictate the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I create a draft with the text 'Draft created'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "report shall be saved as 'Draft'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client shall 'minimize'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "the study shall be marked as Dictated in the studylist",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_12175_12281_12173_12186_12233",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_12871",
              "@PRIORITY",
              "3"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Examples": [
              {
                "Name": "",
                "TableArgument": {
                  "HeaderRow": [
                    "Enabled_option",
                    "launch_behavior"
                  ],
                  "DataRows": [
                    [
                      "Enable",
                      "Launch"
                    ],
                    [
                      "Disable",
                      "Not launch"
                    ]
                  ]
                }
              }
            ],
            "Name": "56999_57003 Verify the Powerscribe client behaviour on study launch based on Autolaunch Dictation setting",
            "Slug": "5699957003-verify-the-powerscribe-client-behaviour-on-study-launch-based-on-autolaunch-dictation-setting",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I '<enabled_option>' Autolaunch Dictation",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I open study for the Accession 'A56999#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall '<launch_behavior>' with the report section for the 'A56999#'",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_42011_42014",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_56999_57003",
              "@PRIORITY",
              "4"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "57004 Verify that when Autolaunch Dictation is un- checked Powerscribe will launch only on dictating the study",
            "Slug": "57004-verify-that-when-autolaunch-dictation-is-un--checked-powerscribe-will-launch-only-on-dictating-the-study",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I disabled 'Autolaunch Dictation'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I open study for the Accession 'A57004#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I dictate the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall be launched with the report section for the 'A57004#'",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_42011_42014",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_57004",
              "@PRIORITY",
              "5"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "12862 Verify that Powerscribe creates a temporary order if report is not available in Powerscribe.",
            "Slug": "12862-verify-that-powerscribe-creates-a-temporary-order-if-report-is-not-available-in-powerscribe",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I opened study absent in PS worklist for the Accession 'A12862#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I dictated the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I confirm creation of temporary order",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I create and save the report with text 'Temporary order'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall display the report status as 'Draft'.",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Draft section count shall be '1'",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_12174_12232_12173_12186",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_12862",
              "@PRIORITY",
              "6"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "57005 Verify Auto Close of Viewer on PS report signoff when Close Viewer on signoff is Checked",
            "Slug": "57005-verify-auto-close-of-viewer-on-ps-report-signoff-when-close-viewer-on-signoff-is-checked",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I 'enable' Autolaunch Dictation",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'enable' Closer Viewer on Signoff",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I open study for the Accession 'A57005#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client is launched with the report section for the 'A57005#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I create and sign the report with text ' Report created'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "provide the password for the user",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "the study will close after the signing the report",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client shall 'minimize'.",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_41839_42011_42014_42013",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_57005",
              "@PRIORITY",
              "7"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "57007 Verify Viewer does not close on Discard of PS report when Close viewer on Signoff  is Checked",
            "Slug": "57007-verify-viewer-does-not-close-on-discard-of-ps-report-when-close-viewer-on-signoff-is-checked",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I 'enable' Autolaunch Dictation",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'enable' Closer Viewer on Signoff",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I open study for the Accession 'A57007#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'create and discard' the report with text 'Sign Report'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "I shall be able to discard the report on accepting the delete message",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "Powerscribe client shall 'minimize'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "the study shall not close",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_41839_42011_42014_42013",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_57007",
              "@PRIORITY",
              "8"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "57006 Verify Closing of viewer on Signoff of PS report for a study launched through Dictate icon, when Close Viewer on Signoff is Checked",
            "Slug": "57006-verify-closing-of-viewer-on-signoff-of-ps-report-for-a-study-launched-through-dictate-icon-when-close-viewer-on-signoff-is-checked",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I 'disable' Autolaunch Dictation",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'enable' Close Viewer on Signoff",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I opened study for the Accession 'A57006#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I dictate the study",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'create and sign' the report with text ' Report created'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "provide the password for the user",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "the study will close after the signing the report.",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_41839_42011_42014_42013",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_57006",
              "@PRIORITY",
              "9"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          },
          {
            "Name": "57008 Verify Viewer is not closed on signing report as preliminary in PS when Close viewer on Signoff  is Checked",
            "Slug": "57008-verify-viewer-is-not-closed-on-signing-report-as-preliminary-in-ps-when-close-viewer-on-signoff-is-checked",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Given ",
                "Name": "I 'enable' Autolaunch Dictation",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I 'enable' Closer Viewer on Signoff",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "When",
                "NativeKeyword": "When ",
                "Name": "I open study for the Accession 'A57008#'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "I create and sign the report as Preliminary with text ' Preliminary report created'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "Then",
                "NativeKeyword": "Then ",
                "Name": "Powerscribe client shall 'minimize'",
                "StepComments": [],
                "AfterLastStepComments": []
              },
              {
                "Keyword": "And",
                "NativeKeyword": "And ",
                "Name": "the study shall not close",
                "StepComments": [],
                "AfterLastStepComments": []
              }
            ],
            "Tags": [
              "@req_id_41838_41839_42011_42014_42013",
              "@backend_cpacs",
              "@backend_iw",
              "@monitor_single",
              "@test_id_57008",
              "@PRIORITY",
              "10"
            ],
            "Result": {
              "WasExecuted": false,
              "WasSuccessful": false
            }
          }
        ],
        "Background": {
          "Name": "",
          "Description": "",
          "Steps": [
            {
              "Keyword": "Given",
              "NativeKeyword": "Given ",
              "Name": "I sent a report to Powerscribe server using HL7 simulator",
              "StepComments": [],
              "AfterLastStepComments": []
            },
            {
              "Keyword": "And",
              "NativeKeyword": "And ",
              "Name": "I am logged in as 'Radiologist'",
              "StepComments": [],
              "AfterLastStepComments": []
            },
            {
              "Keyword": "And",
              "NativeKeyword": "And ",
              "Name": "Powerscribe client is launched and minimized",
              "StepComments": [],
              "AfterLastStepComments": []
            }
          ],
          "Tags": [],
          "Result": {
            "WasExecuted": false,
            "WasSuccessful": false
          }
        },
        "Result": {
          "WasExecuted": false,
          "WasSuccessful": false
        },
        "Tags": []
      },
      "Result": {
        "WasExecuted": false,
        "WasSuccessful": false
      }
    }
  ],
  "Summary": {
    "Tags": [
      {
        "Tag": "@req_id_12174",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@backend_cpacs",
        "Total": 10,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 10
      },
      {
        "Tag": "@backend_iw",
        "Total": 10,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 10
      },
      {
        "Tag": "@monitor_single",
        "Total": 10,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 10
      },
      {
        "Tag": "@test_id_67388_67389",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@PRIORITY",
        "Total": 10,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 10
      },
      {
        "Tag": "1",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@req_id_12332_12335",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_45436_45437",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "2",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@req_id_12175_12281_12173_12186_12233",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_12871",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "3",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@req_id_41838_42011_42014",
        "Total": 2,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 2
      },
      {
        "Tag": "@test_id_56999_57003",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "4",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_57004",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "5",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@req_id_12174_12232_12173_12186",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_12862",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "6",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@req_id_41838_41839_42011_42014_42013",
        "Total": 4,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 4
      },
      {
        "Tag": "@test_id_57005",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "7",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_57007",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "8",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_57006",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "9",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "@test_id_57008",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      },
      {
        "Tag": "10",
        "Total": 1,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 1
      }
    ],
    "Folders": [
      {
        "Folder": "PS360.feature",
        "Total": 10,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 10
      }
    ],
    "NotTestedFolders": [
      {
        "Folder": "PS360.feature",
        "Total": 0,
        "Passing": 0,
        "Failing": 0,
        "Inconclusive": 0
      }
    ],
    "Scenarios": {
      "Total": 10,
      "Passing": 0,
      "Failing": 0,
      "Inconclusive": 10
    },
    "Features": {
      "Total": 1,
      "Passing": 0,
      "Failing": 0,
      "Inconclusive": 1
    }
  },
  "Configuration": {
    "SutName": "Universal Viewer Test Automation",
    "SutVersion": "1.1",
    "GeneratedOn": "4 January 2017 21:41:31"
  }
});