public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void displayInfo() {
        System.out.println("---------- USER INFO ----------");
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Email     : " + email);
        System.out.println("Is Active : " + isActive);
        System.out.println("--------------------------------\n");
    }

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Ali", 25, "ali@example.com", true);
        UserInfo user2 = new UserInfo("Sara", 30, "sara@example.com", false);
        UserInfo user3 = new UserInfo("Khalid", 22, "khalid@example.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();


    }
}


