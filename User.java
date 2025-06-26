public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}
