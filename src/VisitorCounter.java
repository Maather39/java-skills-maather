public class VisitorCounter {

    private static int totalVisitors = 0;


    private int sessionVisits;
    private String visitorName;

    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++;
    }

    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {
        VisitorCounter v1 = new VisitorCounter("Ali");
        VisitorCounter v2 = new VisitorCounter("Sara");
        VisitorCounter v3 = new VisitorCounter("Mona");

        v1.recordVisit();
        v1.recordVisit();

        v2.recordVisit();
        v3.recordVisit();
        v3.recordVisit();
        v3.recordVisit();

        displayTotalVisitors();
    }
}
