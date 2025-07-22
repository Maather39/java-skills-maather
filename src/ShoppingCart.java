public class ShoppingCart {

    // ✅ حساب السعر الكلي مع الخصم حسب نوع العميل
    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;

        // جمع كل الأسعار
        for (double price : prices) {
            total += price;
        }

        // تطبيق الخصم
        switch (customerType) {
            case "PREMIUM":
                total *= 0.9;  // 10% خصم
                break;
            case "VIP":
                total *= 0.8;  // 20% خصم
                break;
            case "REGULAR":
            default:
                break; // لا خصم
        }

        return total;
    }

    // ✅ إيجاد أغلى منتج
    public static double findMostExpensive(double[] prices) {
        if (prices.length == 0) return 0;

        double max = prices[0];
        for (double price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // ✅ عدد العناصر فوق حد معين
    public static int countExpensiveItems(double[] prices, double threshold) {
        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        System.out.println("Regular customer total: $" + calculateTotal(cart, "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart, "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart, "VIP"));

        System.out.println("\nMost expensive item: $" + findMostExpensive(cart));
        System.out.println("Items over $30: " + countExpensiveItems(cart, 30));
    }
}
