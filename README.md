# Bank Finder 

A simple Java program that identifies a bank based on the first three digits of an account number.

## Description
This application asks the user for a 3-digit input, connects to the National Bank of Poland (NBP) website, and searches a text file to find the matching bank.

## Features
* **User Input:** Accepts account number prefixes via the console.
* **Live Data:** Fetches the latest bank list directly from `ewib.nbp.pl`.
* **Data Parsing:** Extracts the **Abbreviated Bank Number** and **Bank Name**.
