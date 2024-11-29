# Stock Lookup App

The **Stock Lookup App** is an Android application built in **Kotlin** using **Android Studio**. It allows users to fetch and view stock information, including the highest and lowest prices of a stock, using an external API.

## Getting Started

### Installation

1. Download the APK from the provided link or install it via Android Studio if you are a developer.
2. Open the APK file and follow the on-screen instructions to install the app on your device.

### Requirements

- **Android Version**: 5.0 (Lollipop) or higher.
- **Internet Connection**: Required for retrieving stock data.

---

## User Interface Overview

### Main Screen

The main screen of the application contains the following elements:

- **Search Bar**: A text field where users can enter the stock symbol they wish to look up.
- **Search Button**: A button that, when clicked, triggers the search for stock information.
- **Stock Information Display**: A text area where the stock information (date, highest price, lowest price, etc.) is displayed.

---

## Using the App

### Searching for Stock Information

1. **Enter Stock Symbol**: Type the stock symbol (e.g., `AAPL` for Apple, `TSLA` for Tesla) into the search bar.
2. **Click the Search Button**: Press the search button to initiate the search for stock information.

### Viewing Stock Data

Upon successful retrieval of data, the stock information will be displayed, including:

- **Date**: The date of the stock data.
- **Opened at Price**: The opening price of the stock on that date.
- **Highest Price**: The highest price the stock reached during that trading day.
- **Lowest Price**: The lowest price the stock reached during that trading day.
- **Closed at Price**: The closing price of the stock on that date.

If no data is found, a message stating **"No stock data found"** will appear.

---

## API Information
API Used: Yahoo Finance API via RapidAPI.
HTTP Method: GET.
Endpoint: /stock/v3/get-historical-data.
Query Parameters:
symbol: The stock symbol (e.g., AAPL).
region: The region code (default is "US").

### API Overview

The **Stock Lookup App** utilizes the **Yahoo Finance API** via **RapidAPI** to fetch historical stock data. The API provides reliable and up-to-date stock information.

### API Details

- **Base URL**:
- https://yh-finance.p.rapidapi.com/stock/v3/get-historical-data?symbol=AMRN&region=US

- 
- **Endpoint**: `/stock/v3/get-historical-data`
- **HTTP Method**: `GET`

### Query Parameters

- **symbol**: The stock symbol of the company (e.g., `AAPL` for Apple).
- **region**: The region code (default is `"US"`).

### API Response Structure

The API returns a JSON object with the following structure:

```json
{
"prices": [
  {
    "date": "2024-11-29",
    "open": 132.50,
    "high": 135.00,
    "low": 131.20,
    "close": 134.80
  }
]
}
