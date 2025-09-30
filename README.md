# 💰 Personal Budgeting System (Java)

A **console-based budgeting application** that helps users **track income, expenses, budgets, and reminders**.  
It also includes **authentication** (Sign Up & Login), **report generation**, and a **reminder service** with an email notifier.

---

## 🚀 Features

### 🔐 Authentication
- User **Sign Up** (username, email, password)
- **Login system** with credential validation
- User data stored via a **repository pattern** (`FileUserRepository`)

### 💵 Income & Expense Tracking
- Add multiple **income transactions** (with category & source)
- Add multiple **expense transactions** (with category & type)
- Stores all transactions in memory (extendable to persistent storage)

### 📊 Budget Management
- Create a monthly budget with categories (e.g., Food, Transport, Entertainment)
- **Budget calculator** tracks:
  - Total expenses
  - Remaining balance
  - Budget limit check (alerts when exceeded)

### 📑 Reports
- Generate reports with expense breakdown by category
- Uses `ReportData` & `ReportGenerator` classes for formatted summaries

### ⏰ Reminder System
- Set reminders with custom messages
- Sends simulated **email notifications** using `ReminderService` & `EmailNotifier`

---

## 📂 Project Structure

📁 budgeting-system
│── Main.java # Entry point of the application

│── UserData.java # Represents user information

│── IUserRepository.java # Repository interface for user storage

│── FileUserRepository.java # File-based implementation of IUserRepository

│── AuthService.java # Handles login & registration

│── Transaction.java # Abstract class for financial transactions

│── Income.java # Income transaction class

│── Expense.java # Expense transaction class

│── Budget.java # Budget details & categories

│── Budgetcalculator.java # Calculates remaining balance & budget checks

│── ReportData.java # Stores data for reports

│── ReportGenerator.java # Generates formatted reports

│── ReminderService.java # Manages reminders

│── EmailNotifier.java # Simulates email notifications


---

## ⚙️ How to Run

### 1️⃣ Compile the Code
```bash
javac Main.java
2️⃣ Run the Application
bash
Copy code
java Main
🖥️ Usage Flow
Start App → Choose Sign Up, Login, or Exit
```



After login, access Dashboard:

1. Add Income

2. Add Expense

3. View Budget Status

4. Generate Report

5. Set Reminder

6. Logout

📊 Example Run
markdown
Copy code
1. Sign Up
2. Log In
3. Exit
> 1
Enter username: Ahmed
Enter email: ahmed@example.com
Enter password: 1234
Registered successfully!

--- Dashboard ---
1. Add Income
2. Add Expense
3. View Budget Status
4. Generate Report
5. Set Reminder
6. Logout
