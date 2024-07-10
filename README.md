# Library_Book_Management


---

# Library Management System (Java)

This project is a comprehensive library management system implemented in Java, allowing users to manage various operations related to library books, including adding, borrowing, returning, and purchasing books.

## Features

- **Add Book:** Add new books to the library inventory.
- **Borrow Book:** Allow users to borrow books from the library.
- **Return Book:** Facilitate the return of borrowed books to the library.
- **Purchase Book:** Add new books to the library's collection.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- Basic understanding of Java programming.
- Command-line interface (CLI) familiarity.

### Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your/repository.git
   cd repository-name
   ```

2. Compile the Java files:

   ```bash
   javac LibraryManagementSystem.java
   ```

### Usage

1. Run the application:

   ```bash
   java LibraryManagementSystem
   ```

2. Choose from the following options:

   - **1. Add Book:** Enter details such as title, author, ISBN, and quantity to add a book to the library inventory.
   - **2. Borrow Book:** Search for a book by title or ISBN and borrow it by providing user details.
   - **3. Return Book:** Enter the book details to return it to the library.
   - **4. Purchase Book:** Add new books to the library's collection by providing details like title, author, and quantity.

3. Follow the prompts displayed on the console to complete each operation.

### Project Structure

```
library-management-system/
│
├── Main.java       # Main Java file to run the application
├── Book.java       # Book class definition and functions related to book operations
├── Library.java    # Library class definition and functions for library operations
├── User.java       # User class definition and functions related to user operations
└── README.md       # Documentation file you are currently reading
```
