<!--
GitHub Note:
- GitHub sanitizes/limits CSS in README files. Inline styles are the most reliable.
- This README uses HTML + Markdown for a clean, attractive layout.
-->

<div align="center">

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

- **Gherkin Feature files** (`Given / When / Then`)
- **Step Definitions** in **Java**
- **Selenium WebDriver** for browser automation
- **Cucumber Runner** to execute tests
- **Page Object Model (POM)** with **Page Factory** for maintainable locators and actions
- **Maven** for build, dependency management, and test execution

---

## Main Software Installed (Prerequisites)

### Required
- **Java (JDK 8+)**
- **Maven**
- **IDE**: IntelliJ IDEA / Eclipse
- **Browser**: Chrome / Edge / Firefox
- **WebDriver binaries** (or WebDriverManager dependency if used)

### Recommended
- **Git**
- IDE plugins: **Cucumber for Java**, **Gherkin**

---

## Language Used
- ✅ **Java**

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

## Key Features Implemented

- ✅ **BDD scenarios** for key flows on *automationexercise.com*
- ✅ **POM/Page Factory** design:
  - Page-wise separation of locators and page actions
  - Cleaner step definitions (readable and reusable)
- ✅ **Reusable Utilities** (commonly implemented in automation frameworks):
  - wait helpers (explicit waits)
  - common actions (click/type/select)
- ✅ **Hooks (Before/After)** for:
  - browser setup
  - teardown / cleanup
  - screenshots on failure (if implemented)
- ✅ **Cucumber Reporting** (HTML/JSON via Cucumber plugins, if configured)

---

## Framework Logic / Design Approach

### 1) BDD Layer (Feature Files)
- Write scenarios in `*.feature` files using business-readable steps.

### 2) Step Definition Layer
- Step classes map Gherkin steps to Java methods.
- Step methods call Page classes to perform UI actions.

### 3) Page Layer (POM + Page Factory)
- Each page class represents one screen/module of the application.
- Elements are defined using `@FindBy` annotations (Page Factory).
- Page methods encapsulate actions like `login()`, `searchProduct()`, `addToCart()`, etc.

**Benefits:**
- Better maintainability when UI locators change
- Improved readability and reusability
- Reduced duplication across test steps

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
- Added a **safe-check** before interacting with elements:
  - detect whether an ad overlay/popup is present
  - if present, **close it** (if a close button exists) OR wait until it disappears
- As a fallback for stubborn overlays:
  - scroll the target element into view
  - use `ExpectedConditions.elementToBeClickable`
  - (optional/last resort) JavaScript click only when normal click is consistently intercepted

> This approach reduces flaky failures by ensuring the page is in a stable, interactable state before every action.

### ♻️ Reusability & Maintainability
**Problem:** duplicate code across scenarios  
**Solution:** keep Step Definitions thin and push logic into Page Objects + utilities.

---

## How to Run Tests (Maven)

### Run all tests
```bash
mvn clean test
```

### Run by Cucumber tags (if tags are implemented)
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

> If your runner uses a different property (older style), it may be:
> `-Dcucumber.options="--tags @smoke"`

---

## Target Application
- Website: **automationexercise.com**
- Automation Type: **UI Functional Testing**
- Framework: **Selenium + Cucumber (BDD)**
- Design: **POM / Page Factory**
- Build Tool: **Maven**

---

<div align="center">
  <hr style="margin: 18px auto; max-width: 950px;" />
  <sub>Built for learning, practice, and maintainable UI automation.</sub>
</div>
