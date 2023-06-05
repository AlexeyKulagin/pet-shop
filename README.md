# Pet Store Web app
[Pet Store](https://petstore.octoperf.com)

## Web Automation 

### Tech Stack

* Java 17
* Selenium, TestNG, Maven
* Chrome browser
* IntelliJ IDEA
* Git, GitHub

### End-to-end Test Case

**TC #1: Make an order**

**Test Data:**

* Base URL: https://petstore.octoperf.com/
* UserLogin: qa
* UserPassword: test
* ProductID: FL-DSH-01	Manx
* ItemID: EST-15

**Preconditions:**

* User is logged in
* User is landed on the Home page https://petstore.octoperf.com/actions/Catalog.action
* Shopping card is empty

**Steps:**

1. Go to Cats clicking on Cat pic from Home page
2. Select ProductID: FL-DSH-01 Manx
3. Select ItemID: EST-15
4. Add Item to the card
5. Confirm Item is available in the stock
6. Proceed to Checkout
7. Ship to the same address and Continue
8. Confirm the order

**Expected Result:**

* New Order was successful: "Thank you, your order has been submitted" message occur
* New Order is not in Old Order List
* New Order is in New Order list
* New Order List has one order more than the Old one
