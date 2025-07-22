public class PayrollCalculator {

    // ✅ 1. حساب الراتب الأسبوعي حسب نوع الموظف
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double pay = 0;

        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked <= 40) {
                    pay = hoursWorked * hourlyRate;
                } else {
                    pay = (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                }
                break;

            case "PART_TIME":
                pay = (hoursWorked > 25) ? 25 * hourlyRate : hoursWorked * hourlyRate;
                break;

            case "CONTRACTOR":
                pay = hoursWorked * hourlyRate;
                break;

            case "INTERN":
                if (hoursWorked > 20) hoursWorked = 20;
                pay = hoursWorked * (hourlyRate * 0.8);
                break;

            default:
                System.out.println("Invalid employee type.");
                return -1;
        }

        return pay;
    }

    // ✅ 2. حساب الضريبة
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxRate;

        if (grossPay <= 500) taxRate = 0.10;
        else if (grossPay <= 1000) taxRate = 0.15;
        else if (grossPay <= 2000) taxRate = 0.20;
        else taxRate = 0.25;

        double tax = grossPay * taxRate;

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    // ✅ 3. معالجة بيانات مجموعة موظفين
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        if (employeeTypes.length != hours.length || hours.length != rates.length || rates.length != names.length) {
            System.out.println("Error: Mismatched array lengths.");
            return;
        }

        double highestPay = Double.MIN_VALUE;
        double lowestPay = Double.MAX_VALUE;
        String highestName = "", lowestName = "";
        double totalPay = 0;
        int overtimeCount = 0;

        System.out.printf("%-10s | %-12s | %-10s\n", "Name", "Type", "Gross Pay");
        System.out.println("-----------------------------------");

        for (int i = 0; i < names.length; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            System.out.printf("%-10s | %-12s | $%-9.2f\n", names[i], employeeTypes[i], gross);

            if (gross > highestPay) {
                highestPay = gross;
                highestName = names[i];
            }
            if (gross < lowestPay) {
                lowestPay = gross;
                lowestName = names[i];
            }
            if (hours[i] > 40) overtimeCount++;

            totalPay += gross;
        }

        double average = totalPay / names.length;

        System.out.println("\nHighest Paid: " + highestName + " ($" + highestPay + ")");
        System.out.println("Lowest Paid: " + lowestName + " ($" + lowestPay + ")");
        System.out.println("Average Pay: $" + average);
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    // ✅ 4. Main method للاختبار
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types, hours, rates, names);
    }
}
