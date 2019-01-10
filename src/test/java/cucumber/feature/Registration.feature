Feature: Registration new infomation from Test master

Scenario: Show message invalid email
Given I vist Registration page
When I input invalid email
And I click button Dang ky
Then Show message invalid email

Scenario: Show message blank email
Given I vist Registration page
When I input blank email
And I click button Dang ky
Then Show message invalid email

Scenario: Show extra form for valid email
Given I vist Registration page
When I input valid email
And I click button Dang ky
Then Show extra form

Scenario: Show message for blank Ho va ten
Given I vist extra form
When I input blank Ho va ten
And I click button Dong y
Then Show message required field

Scenario: Show message registration success from valid Ho và ten
Given I vist extra form
When I input valid Ho va ten
And I choose gender is Nu
And I choose news type is Nhan tat ca loai tin
And I click bttuon Dong y
Then Show message registration success