<!--
GitHub Note:
- GitHub sanitizes/limits CSS in README files. Inline styles are the most reliable.
- This README uses HTML + Markdown for a clean, attractive layout.
-->

<div align="center">

<!-- Topic image -->
<img src="https://raw.githubusercontent.com/Sneha5839/Selenium-cucumber-project/main/assets/selenium-cucumber-banner.png" alt="Selenium + Cucumber BDD Framework" width="900" />

<h1 style="margin: 0;">Selenium + Cucumber BDD Automation Framework</h1>
<p style="margin: 8px 0 0; max-width: 900px;">
Java-based UI test automation framework using <b>Selenium WebDriver</b> + <b>Cucumber</b> with <b>BDD</b>,
built with <b>Maven</b> and designed using <b>Page Object Model (POM)</b> / <b>Page Factory</b>.
Test site: <a href="https://automationexercise.com" target="_blank" rel="noopener noreferrer"><b>automationexercise.com</b></a>.
</p>

<p style="margin: 14px 0 0;">
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>Java</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>Maven</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>Selenium</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>Cucumber</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>BDD</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>POM</b></span>
  <span style="display:inline-block;padding:6px 12px;border-radius:999px;border:1px solid #d0d7de;margin:2px;background:#f6f8fa;"><b>Page Factory</b></span>
</p>

<hr style="margin: 18px auto; max-width: 950px;" />
</div>

## Overview

This project automates UI functional scenarios for **automationexercise.com** using a clean BDD structure:

<ul>
  <li>❖ <b>Gherkin Feature files</b> (<code>Given / When / Then</code>)</li>
  <li>❖ <b>Step Definitions</b> in <b>Java</b></li>
  <li>❖ <b>Selenium WebDriver</b> for browser automation</li>
  <li>❖ <b>Cucumber Runner</b> to execute tests</li>
  <li>❖ <b>Page Object Model (POM)</b> with <b>Page Factory</b> for maintainable locators and actions</li>
  <li>❖ <b>Maven</b> for build, dependency management, and test execution</li>
</ul>

---

## Main Software Installed (Prerequisites)

### Required
<ul>
  <li>❖ <b>Java (JDK 8+)</b></li>
  <li>❖ <b>Maven</b></li>
  <li>❖ <b>IDE</b>: IntelliJ IDEA / Eclipse</li>
  <li>❖ <b>Browser</b>: Chrome / Edge / Firefox</li>
  <li>❖ <b>WebDriver binaries</b> (or WebDriverManager dependency if used)</li>
</ul>

### Recommended
<ul>
  <li>❖ <b>Git</b></li>
  <li>❖ IDE plugins: <b>Cucumber for Java</b>, <b>Gherkin</b></li>
</ul>

---

## Language Used
<ul>
  <li>❖ ✅ <b>Java</b></li>
</ul>

---

## Technologies Used

<table>
  <thead>
    <tr>
      <th align="left">Category</th>
      <th align="left">Tools</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>Automation</b></td>
      <td>Selenium WebDriver</td>
    </tr>
    <tr>
      <td><b>BDD</b></td>
      <td>Cucumber + Gherkin</td>
    </tr>
    <tr>
      <td><b>Build</b></td>
      <td>Maven</td>
    </tr>
    <tr>
      <td><b>Design Pattern</b></td>
      <td>Page Object Model (POM) / Page Factory</td>
    </tr>
  </tbody>
</table>

---

## Modules / Test Scenarios Implemented

The framework covers end-to-end workflows on **automationexercise.com**, including:

<ul>
  <li>
    ❖ <b>Sign Up (New User Registration)</b>
    <ul>
      <li>❖ Register a new user with valid details</li>
      <li>❖ Validate successful account creation</li>
    </ul>
  </li>

  <li>
    ❖ <b>Login (Existing User)</b>
    <ul>
      <li>❖ Login with valid credentials</li>
      <li>❖ Negative login (invalid credentials) validation</li>
    </ul>
  </li>

  <li>
    ❖ <b>Product Search</b>
    <ul>
      <li>❖ Search for a product using the search functionality</li>
      <li>❖ Validate relevant products are displayed</li>
    </ul>
  </li>

  <li>
    ❖ <b>Add to Cart</b>
    <ul>
      <li>❖ Add a product to the cart</li>
      <li>❖ Validate cart contents and product details</li>
    </ul>
  </li>

  <li>
    ❖ <b>Purchase / Checkout Flow</b>
    <ul>
      <li>
        ❖ Complete purchase after logging in as:
        <ul>
          <li>❖ a <b>new user</b> (register → login → checkout)</li>
          <li>❖ an <b>existing user</b> (login → checkout)</li>
        </ul>
      </li>
      <li>❖ Proceed through address/summary steps</li>
      <li>❖ <b>Complete payment process</b> and validate order placement</li>
    </ul>
  </li>

  <li>
    ❖ <b>Account Deletion (Cleanup)</b>
    <ul>
      <li>❖ Delete the user account after order completion (where applicable)</li>
      <li>❖ Validate account deletion confirmation</li>
    </ul>
  </li>
</ul>

---

## Key Features Implemented

<ul>
  <li>❖ ✅ <b>BDD scenarios</b> for key flows on <i>automationexercise.com</i></li>

  <li>
    ❖ ✅ <b>POM/Page Factory</b> design:
    <ul>
      <li>❖ Page-wise separation of locators and page actions</li>
      <li>❖ Cleaner step definitions (readable and reusable)</li>
    </ul>
  </li>

  <li>
    ❖ ✅ <b>Reusable Utilities</b> (commonly implemented in automation frameworks):
    <ul>
      <li>❖ wait helpers (explicit waits)</li>
      <li>❖ common actions (click/type/select)</li>
    </ul>
  </li>

  <li>
    ❖ ✅ <b>Hooks (Before/After)</b> for:
    <ul>
      <li>❖ browser setup</li>
      <li>❖ teardown / cleanup</li>
      <li>❖ screenshots on failure (if implemented)</li>
    </ul>
  </li>

  <li>❖ ✅ <b>Cucumber Reporting</b> (HTML/JSON via Cucumber plugins, if configured)</li>
</ul>

---

## Framework Logic / Design Approach

### 1) BDD Layer (Feature Files)
<ul>
  <li>❖ Write scenarios in <code>*.feature</code> files using business-readable steps.</li>
</ul>

### 2) Step Definition Layer
<ul>
  <li>❖ Step classes map Gherkin steps to Java methods.</li>
  <li>❖ Step methods call Page classes to perform UI actions.</li>
</ul>

### 3) Page Layer (POM + Page Factory)
<ul>
  <li>❖ Each page class represents one screen/module of the application.</li>
  <li>❖ Elements are defined using <code>@FindBy</code> annotations (Page Factory).</li>
  <li>❖ Page methods encapsulate actions like <code>login()</code>, <code>searchProduct()</code>, <code>addToCart()</code>, etc.</li>
</ul>

<b>Benefits:</b>
<ul>
  <li>❖ Better maintainability when UI locators change</li>
  <li>❖ Improved readability and reusability</li>
  <li>❖ Reduced duplication across test steps</li>
</ul>

---

## Project Structure

```text
Selenium-cucumber-project/
├─ pom.xml
├─ testng.xml
├─ automation_test_run_output.bat
├─ src/
│  ├─ main/
│  └─ test/
│     ├─ java/
│     │  ├─ Initial.java
│     │  └─ com/
│     │     └─ Sneha/
│     │        └─ Automation_exercise/
│     │           ├─ Pages/
│     │           │  ├─ CartPage.java
│     │           │  ├─ ContactUsPage.java
│     │           │  ├─ LoginFailPage.java
│     │           │  ├─ LoginPage.java
│     │           │  ├─ LogoutPage.java
│     │           │  ├─ ProductDetailsPage.java
│     │           │  ├─ ProductsPage.java
│     │           │  ├─ SignUpExistingEmailPage.java
│     │           │  ├─ SignUppage.java
│     │           │  └─ TestCasesPage.java
│     │           ├─ Runners/
│     │           │  └─ CucumberRunner.java
│     │           ├─ stepdefinitions/
│     │           │  ├─ AddToCartSteps.java
│     │           │  ├─ ContactUsSteps.java
│     │           │  ├─ LoginFailSteps.java
│     │           │  ├─ LoginSteps.java
│     │           │  ├─ LogoutSteps.java
│     │           │  ├─ ProductsSteps.java
│     │           │  ├─ SignUpExistingEmailSteps.java
│     │           │  ├─ SignupSteps.java
│     │           │  └─ TestCasesSteps.java
│     │           └─ utils/
│     │              ├─ BrowserUtils.java
│     │              ├─ Driver.java
│     │              ├─ Property.java
│     │              ├─ ScenarioContext.java
│     │              └─ WaitTime.java
│     └─ resources/
│        ├─ Features/
│        └─ test-files/
├─ target/
└─ test-output/
```

### What each folder/package is for

<ul>
  <li>
    ❖ <code>src/test/resources/Features/</code><br/>
    Contains the <b>Cucumber <code>.feature</code> files</b> written in <b>Gherkin</b> (BDD scenarios).
  </li>

  <li>
    ❖ <code>src/test/java/com/Sneha/Automation_exercise/stepdefinitions/</code><br/>
    Contains <b>Step Definition</b> classes that map <code>Given/When/Then</code> steps to Java code.
  </li>

  <li>
    ❖ <code>src/test/java/com/Sneha/Automation_exercise/Pages/</code><br/>
    Contains <b>Page Object Model (POM)</b> classes implemented using <b>Page Factory</b> (<code>@FindBy</code> locators + page actions).
  </li>

  <li>
    ❖ <code>src/test/java/com/Sneha/Automation_exercise/Runners/CucumberRunner.java</code><br/>
    The <b>Cucumber runner</b> used to execute the test suite.
  </li>

  <li>
    ❖ <code>src/test/java/com/Sneha/Automation_exercise/utils/</code><br/>
    Framework utilities like:
    <ul>
      <li>❖ <code>Driver.java</code> (WebDriver lifecycle)</li>
      <li>❖ <code>BrowserUtils.java</code> (common helpers: waits, scrolling, element actions, etc.)</li>
      <li>❖ <code>Property.java</code> (config/property reader)</li>
      <li>❖ <code>ScenarioContext.java</code> (scenario-level shared context)</li>
      <li>❖ <code>WaitTime.java</code> (wait constants)</li>
    </ul>
  </li>

  <li>
    ❖ <code>pom.xml</code><br/>
    Maven dependencies + test execution configuration.
  </li>

  <li>
    ❖ <code>testng.xml</code><br/>
    TestNG suite file (if running via TestNG integration).
  </li>
</ul>

---

## Common Hurdles Faced (and How They’re Solved)

### ⏳ Synchronization / Timing Issues
**Problem:** elements not clickable/visible due to load time  
**Solution:** use **Explicit Waits** (WebDriverWait + ExpectedConditions).

### 🧩 Dynamic DOM / Stale Element Reference
**Problem:** element reference becomes stale after DOM refresh  
**Solution:** re-locate element via Page methods + wait for stable state.

### 🚫 Click Intercepted (Overlays/Popups)
**Problem:** overlays block the element  
**Solution:** wait for overlays to disappear; scroll into view before clicking.

### 📢 Advertisements / Random Pop-ups Appearing
**Problem:** ads (banners/iframes/popups) intermittently appear and block clicks or hide elements, causing flaky failures.  
**How it was resolved:**
<ul>
  <li>
    ❖ Added a <b>safe-check</b> before interacting with elements:
    <ul>
      <li>❖ detect whether an ad overlay/popup is present</li>
      <li>❖ if present, <b>close it</b> (if a close button exists) OR wait until it disappears</li>
    </ul>
  </li>
  <li>
    ❖ As a fallback for stubborn overlays:
    <ul>
      <li>❖ scroll the target element into view</li>
      <li>❖ use <code>ExpectedConditions.elementToBeClickable</code></li>
      <li>❖ (optional/last resort) JavaScript click only when normal click is consistently intercepted</li>
    </ul>
  </li>
</ul>

> This approach reduces flaky failures by ensuring the page is in a stable, interactable state before every action.

### ♻️ Reusability & Maintainability
**Problem:** duplicate code across scenarios  
**Solution:** keep Step Definitions thin and push logic into Page Objects + utilities.