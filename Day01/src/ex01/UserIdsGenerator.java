package ex01;

public final class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private static Integer id = 0;
    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    public static int getId() {
        return ++id;
    }
}