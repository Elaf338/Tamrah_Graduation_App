# 🔴 Tamrah App

---

## 🔴 Overview

Tamrah App is a modern Android application built using Jetpack Compose that showcases the rich heritage of Saudi dates.  
The app allows users to explore different types of dates, learn about their regions, uses, and nutritional value, and view dynamic content powered by local data + public APIs.

The application focuses on:
- Clean UI
- Smooth navigation
- Proper state management

While following a clear separation between:
- UI Layer (Presentation)
- Data Layer

Tamrah supports Arabic and English, with proper RTL / LTR behavior.

---

## 🔴 Project Scope (Graduation Project)

This is a small-scale application created to demonstrate:
- Correct mobile development fundamentals
- Public API integration
- UI state handling (Loading / Success / Error)
- Clear code separation and maintainable structure

---

## 🔴 Screens & Features

### 🔴 1) Splash Screen
- Displays the Tamrah logo
- Smooth launch animation
- Navigates automatically to the Home screen

---

### 🔴 2) Home Screen (Main Screen)

The main landing screen of the application.

Home Screen includes:
- Hero Banner (top section)
- Search Button
    - Opens the Search Screen
- Language Toggle Button
    - Switches between Arabic / English
    - Updates layout direction automatically (RTL / LTR)
- API Section (Jon / JSONPlaceholder)
    - Loads content from a public API
    - Shows proper states:
        - Loading: progress indicator appears
        - Success: list of items is displayed
        - Error: message + retry button
    - User can tap any API item and open its details
- Local Dates Catalog
    - Displays the list of date varieties stored locally (static data)
    - Each card shows:
        - Date name (AR / EN)
        - Region (AR / EN)
        - Image
    - Clicking any date navigates to the Details Screen

Key Purpose of Home Screen:
- Demonstrates a real application flow:  
  UI + state handling + navigation + API integration + local content

---

### 🔴 3) Search Screen (API Search)

The Search screen is designed to behave like a real-world search feature.

Search Screen includes:
- Search input field
- Search action triggers an API request
- Proper state handling:
    - Loading: progress indicator appears while fetching results
    - Success: list of results is displayed
    - Error: message shown if API fails
- User can type queries related to dates  
  (example: *“Sukkari”, “Ajwa”, “dates”*)
- Clicking a result navigates to the Details Screen

Goal of Search Screen:
- Demonstrates API-based search + clean state management + navigation

---

### 🔴 4) Details Screen

Displays details based on what the user clicked.

#### 🔴 A) Date Details (Local Data)
Shows full details about a selected date from the local catalog:
- Region
- Overview
- Color & Texture
- Uses
- Freshness Tips
- Nutritional information

Details Screen also includes:
- Back navigation
- Language toggle (AR / EN)

---

### 🔴 5) Camera Screen
- Allows user to interact with camera / gallery
- Prepared for future features (image-based functionality)

---

### 🔴 6) Settings Screen

Contains app preferences and navigation.

Includes:
- Language toggle (Arabic / English)
- Navigation to:
    - Help
    - About
    - Privacy Policy

---

### 🔴 7) Help Screen
- Displays basic help / support information
- Simple and clear content for end users

---

### 🔴 8) About Screen
- Presents the purpose of Tamrah
- Quick overview of what the application provides

---

### 🔴 9) Privacy Policy Screen
- Displays privacy and data usage notes
- Ensures transparency for users

---

## 🔴 Architecture

This project follows a clear separation of responsibilities:

### 🔴 UI Layer (Presentation)
- Jetpack Compose screens
- ViewModels
- UiState handling:
    - Loading
    - Success
    - Error

### 🔴 Domain Layer
- UseCases to keep business logic clean and reusable  
  (Example: GetPostsUseCase, `GetPostUseCase`)

### 🔴 Data Layer
- API Services (Retrofit)
- DTO models
- Repository implementation

---

## 🔴 APIs Used

### 🔴 JSONPlaceholder API (Jon)

Used as a public API to simulate realistic networking and demonstrate:
- Fetching list data in Home
- Fetching details by id
- Proper state management (Loading / Success / Error)

---

### 🔴 Search API

Search screen is connected to a public API to demonstrate:
- API search requests
- Results list rendering
- Navigation to details

---

## 🔴 Application Flow

1. Splash Screen launches
2. Home Screen loads:
    - Local dates catalog
    - API content from JSONPlaceholder (Jon)
3. User can:
    - Switch language
    - Open Search and search via API
    - Open Details for either local date or API item
4. Settings contains supporting pages (Help / About / Privacy)

---

## 🔴 Getting Started

1. Open the project in Android Studio
2. Sync Gradle files
3. Run the app on an emulator or real device

---

## 🔴 Version Control

This project uses Git with clear commits that represent:
- Feature additions
- Fixes and refactors
- UI updates
- API integration updates