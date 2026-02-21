# 📦 Inventory Management System

A console-based **Java Inventory Management System** that demonstrates advanced usage of the **Java Collections Framework** including:

- HashSet
- LinkedList
- Stack
- Queue
- Comparable
- Comparator
- Generics

---

## 🚀 Project Overview

This project simulates a real-world inventory system where products can be:

- ➕ Added
- 🔄 Updated
- 📊 Sorted by multiple criteria
- 📜 Tracked through transaction history
- ⚠ Monitored for low stock
- ↩ Reverted using undo functionality

The main goal of this project is to demonstrate efficient use of Java data structures in a practical application.

---

## 🛠 Technologies Used

- Java (JDK 8+)
- Java Collections Framework
- Object-Oriented Programming
- Comparable & Comparator Interfaces
- Generics

---

## 📂 Project Structure
InventoryManagementSystem/
│
├── Main.java
├── Product.java
├── Transaction.java
├── InventoryUtils.java
├── InventoryManagementSystem.java
├── PriceComparator.java
├── NameComparator.java
└── ValueComparator.java



---

## 📌 Features

### ✅ Product Management
- Add new products
- Update product quantity
- Prevent duplicate SKUs using HashSet

### 📊 Sorting Options
Products can be sorted by:
- SKU (Natural sorting using Comparable)
- Price
- Name
- Total Inventory Value

### 🔄 Undo Functionality
- Uses Stack (LIFO principle)
- Reverts the last add/update operation

### 📜 Transaction History
- Tracks inventory changes
- Uses LinkedList for efficient insertions

### ⚠ Low Stock Alerts
- Detects products below stock threshold
- Uses Queue (FIFO principle)

### 📈 Inventory Statistics
- Total number of products
- Total inventory value calculation

---

## 🧠 Data Structures Used

| Feature | Data Structure | Purpose |
|----------|---------------|---------|
| Unique Product Storage | HashSet | Ensures no duplicate SKUs |
| Transaction History | LinkedList | Fast insertion at beginning |
| Undo Operations | Stack | LIFO behavior |
| Low Stock Alerts | Queue | FIFO behavior |
| Sorting | List + Comparator | Flexible sorting |

---

## ⏱ Time Complexity Overview

| Operation | Time Complexity |
|------------|----------------|
| Add Product | O(1) |
| Search Product | O(1) |
| Update Quantity | O(1) |
| View Sorted Products | O(n log n) |
| Undo Operation | O(1) |
| Add Transaction | O(1) |

---

## ▶ How to Run

1. Open the project in your IDE (VS Code / IntelliJ / Eclipse).
2. Make sure all `.java` files are in the same folder.
3. Compile and run:

javac *.java
java Main


---

## 📷 Sample Console Menu


=== INVENTORY MANAGEMENT SYSTEM ===

Add Product

Update Quantity

View Products (Sorted)

Low Stock Alerts

Transaction History

Inventory Statistics

Undo Last Update

Exit


---

## 🔮 Future Enhancements

- 🔁 Add Redo functionality
- 💾 Save & load inventory from file
- 🗄 Database integration
- 🖥 GUI version (JavaFX/Swing)
- 🧵 Multi-threaded version

---

## 🎯 Learning Outcomes

This project demonstrates:

- Practical use of Java Collections Framework
- Understanding of data structures
- Implementation of Comparable & Comparator
- Clean OOP design
- Real-world system simulation
