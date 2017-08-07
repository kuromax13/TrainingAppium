**Overall**
This is a test plan for training course "QA ENGINEER TO MOBILE QA ENGINEER". Application under test is iOS application named "VPN On".

Testing should be performed on several iOS simulators. Default device - iPhone 6s.

**Scope**

_Testing shall ensure:_

 1. User is able to launch app. Main Page is displayed at first launch
 2. User is able to navigate through app
    2.1 User is able to navigate to Information page
    2.2 User is able to navigate to Acknowledgments page
    2.3 User is able to navigate to App Store from the app
    2.4 User is able to navigate to the Domains page
    2.5 User is able to navigate to the Configuration page
 3. User is able to add new domains
 4. User is able to update existing domains
 5. User is able to delete existing domains
 6. User is able to add new configuration
 7. User is able to update existing configuration
 8. User is able to duplicate existing configuration

**Assumptions**
None

**Preconditions**
QE has application under test and iOS simulators are launched.

**Test Cases**

**_TC01 Main page overview_**
1. Launch app
2. Observe the page
3. _{Verify}_ Page contains title equals 'VPN On'
4. _{Verify}_ Page contains refresh button and it's disabled
5. _{Verify}_ Page contains button named '⌥'
6. _{Verify}_ Page contains Connection section with toggle
7. _{Verify}_ Page contains On demand section with toggle
8. _{Verify}_ Page contains button named 'Add new configuration...'

**_TC02 Navigation. Information page overview_**
1. Launch app
2. Tap Acknowledgments button
3. _{Verify}_ Page contains title equals 'VPN On'
4. _{Verify}_ Page contains back button named 'VPN On'
5. _{Verify}_ Page contains button named 'Acknowledgments'
6. _{Verify}_ Page contains button named 'Review On App Store'
7. _{Verify}_ Page contains app version equals '1.0'

**_TC03 Navigation. Acknowledgments page overview_**
1. Launch app
2. Tap '⌥' button
3. Tap 'Acknowledgments' button
4. _{Verify}_ Page contains title equals 'Acknowledgments'
5. _{Verify}_ Page contains back button named 'VPN On'
6. _{Verify}_ Page contains 4 information sections

**_TC04 Navigation. Domains page overview_**
1. Launch app
2. Turn 'On Demand' toggle on
3. _{Verify}_ New section named 'Domains relies on VPN' is displayed
4. _{Verify}_ '0 Domains' text is displayed next to new section
5. Tap '0 Domains'
6. _{Verify}_ Page contains title equals 'Domains'
7. _{Verify}_ Page contains back button named 'VPN On'
8. _{Verify}_ Page contains 'Save' button
9. _{Verify}_ Page contains 'Domains relies on VPN' input section
10. _{Verify}_ Page contains description under input section

**_TC05 Navigation. Configuration page overview_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. _{Verify}_ Configuration page contains back button
4. _{Verify}_ Configuration page contains 'Configuration' title
5. _{Verify}_ Configuration page contains 'Save' button
6. _{Verify}_ 'Save' button is disabled by default
7. _{Verify}_ Configuration page contains 'Cisco IPSec' button
8. _{Verify}_ 'Cisco IPSec' button is selected by default
9. _{Verify}_ Configuration page contains 'IKEv2' button
10. _{Verify}_ 'IKEv2' button is NOT selected by default
11. _{Verify}_ Configuration page contains 'Description' input field
12. _{Verify}_ Configuration page contains 'Server' input field
13. _{Verify}_ Configuration page contains 'Account' input field
14. _{Verify}_ Configuration page contains 'Password' input field
15. _{Verify}_ Configuration page contains 'Secret' input field
16. _{Verify}_ Configuration page contains 'Group' input field
17. _{Verify}_ Configuration page contains 'Remote ID' input field
18. _{Verify}_ Configuration page contains 'Group' input field
19. _{Verify}_ Configuration page contains 'Always ON' toggle
20. _{Verify}_ 'Always ON' toggle is enabled by default

**_TC06 Add new domain_**
1. Launch app
2. Turn 'On Demand' toggle on
3. Tap '0 Domains'
4. On 'Domains' page input text into input field (e.g. "Test")
5. Tap 'Save' button
6. _{Verify}_ User is redirected to the Main page
7. _{Verify}_ '1 Domains' text is displayed next to new section

**_TC07 Update existing domain_**
1. Launch app
2. Turn 'On Demand' toggle on
3. Tap '0 Domains'
4. On 'Domains' page input text into input field (e.g. "Test")
5. Tap 'Save' button
6. On Main page tap '1 Domains'
7. On 'Domains' page insert new text to the new line (e.g. "Test 2")
8. Tap 'Save' button
9. _{Verify}_ User is redirected to the Main page
10. _{Verify}_ '2 Domains' text is displayed

**_TC08 Delete existing domain_**
1. Launch app
2. Turn 'On Demand' toggle on
3. Tap '0 Domains'
4. On 'Domains' page input text into input field (e.g. "Test")
5. Tap 'Save' button
6. On Main page tap '1 Domains'
7. On 'Domains' page clear input section
8. Tap 'Save' button
9. _{Verify}_ User is redirected to the Main page
10. _{Verify}_ '0 Domains' text is displayed

**_TC09 Add new configuration_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. _{Verify}_ 'Save' button is disabled
4. _{Verify}_ 'Cisco IPSec' is selected
5. Enter into 'Description' input field text (e.g. 'Test')
6. Enter into 'Server' input field text (e.g. '127.0.0.1')
7. Enter into 'Account' input field text (e.g. 'Test')
8. _{Verify}_ 'Save' button is enabled
9. _{Verify}_ 'Delete VPN' button is displayed
10. Tap 'Save' button
11. _{Verify}_ User is redirected to the Main page
12. _{Verify}_ 'VPN CONFIGURATIONS' section is displayed
13. _{Verify}_ New configuration is displayed and has description and server from step 3, 4
14. _{Verify}_ (i) icon displayed next to the configuration description
15. _{Verify}_ 'Refresh' button is enabled

**_TC10 Update existing configuration_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. Enter into 'Description' input field text (e.g. 'New 1')
4. Enter into 'Server' input field text (e.g. '127.0.0.1')
5. Enter into 'Account' input field text (e.g. '4')
6. Tap 'Save' button
7. Tap (i) icon
8. Tap 'IKEv2' button
9. Enter into 'Description' input field text (e.g. '1234567890')
10. Enter into 'Server' input field text (e.g. '10.255.255.1')
11. Enter into 'Account' input field text (e.g. 'qwerty')
12. Enter into 'Password' input field text (e.g. 'password')
13. Enter into 'Secret' input field text (e.g. 'secret')
14. Enter into 'Group' input field text (e.g. 'Group')
15. Enter into 'Remote ID' input field text (e.g. '13')
16. Tap 'Save' button
17. _{Verify}_ User is redirected to the Main page
18. _{Verify}_ New configuration is displayed and has description and server from step 9, 10
19. _{Verify}_ New configuration has 'IKEv2' label

**_TC11 Duplicate existing configuration_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. Enter into 'Description' input field text (e.g. 'Test ')
4. Enter into 'Server' input field text (e.g. '127.0.0.1')
5. Enter into 'Account' input field text (e.g. 'Account')
6. Tap 'Save' button
7. Tap (i) icon
8. Tap 'Duplicate' button
9. _{Verify}_ Two configurations are displayed on main page
10. _{Verify}_ New configuration is displayed and has name 'Test  1'

**_TC12 Delete existing configuration_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. Enter into 'Description' input field text (e.g. 'New 1')
4. Enter into 'Server' input field text (e.g. '127.0.0.1')
5. Enter into 'Account' input field text (e.g. '4')
6. Tap 'Save' button
7. Tap (i) icon
8. Tap 'Delete VPN' button 
9. _{Verify}_ Confirmation pop-up message is displayed
10. Tap 'Delete' button on confirmation pop-up
11. _{Verify}_ User is redirected to the Main page
12. _{Verify}_ 'Add VPN configuration...' button is displayed
13. _{Verify}_ 'VPN CONFIGURATIONS' section is NOT displayed

**_TC13 Cancel deleting existing configuration_**
1. Launch app
2. Tap 'Add VPN configuration...' button
3. Enter into 'Description' input field text (e.g. 'New 1')
4. Enter into 'Server' input field text (e.g. '127.0.0.1')
5. Enter into 'Account' input field text (e.g. '4')
6. Tap 'Save' button
7. Tap (i) icon
8. Tap 'Delete VPN' button 
9. Tap 'Cancel' button on confirmation pop-up
10. _{Verify}_ User is on 'Configuration' page
11. Tap 'Save' button
12. _{Verify}_'VPN CONFIGURATIONS' section is displayed