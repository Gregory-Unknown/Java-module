package ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("John", 10_000);
        User user2 = new User("Mike", 100_000);
        System.out.printf("%s %d\n", user1.getName(), user1.getIdentifier());
        System.out.printf("%s %d\n", user2.getName(), user2.getIdentifier());
        System.out.printf("%s %d\n", user1.getName(), user1.getIdentifier());
        System.out.printf("%s %d\n", user2.getName(), user2.getIdentifier());
    }
}
