public class Library {
    public static void main(String[] args) {
        // كتب عادية
        Book b1 = new Book("Clean Code", "Robert C. Martin", 464);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 416);

        // كتاب دراسي
        Textbook t1 = new Textbook("Data Structures", "Narasimha", 500, "Computer Science", 3);

        // تجربة استعارة وإرجاع
        b1.borrowBook();
        b2.borrowBook();
        b2.returnBook();

        // عرض المعلومات
        System.out.println("\nBook 1:");
        b1.displayInfo();

        System.out.println("\nBook 2:");
        b2.displayInfo();

        System.out.println("\nTextbook:");
        t1.displayInfo();
    }
}
