package ex02;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Volandemort", 10000);
        User user2 = new User("Newton", 100000);
        User user3 = new User("Balabanov", -1000);
        User user4 = new User("Tanos", -10000);
        User user5 = new User("Kilmonger", -100000);

        UsersList list = new UsersArrayList();
        list.addUser(user1);
        list.addUser(user2);
        list.addUser(user3);
        list.addUser(user4);
        list.addUser(user5);

        System.out.println(list.getByIndex(0));
        System.out.println(user1);
        System.out.println(list.getByIndex(1));
        System.out.println(user2);
        System.out.println(list.getByIndex(2));
        System.out.println(user3);
        System.out.println(list.getByIndex(3));
        System.out.println(user4);
        System.out.println(list.getByIndex(4));
        System.out.println(user5);
        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());
        System.out.println(user4.getIdentifier());
        System.out.println(user5.getIdentifier());
        System.out.println(list.getById(1).getIdentifier());
        System.out.println(list.getById(2).getIdentifier());
        System.out.println(list.getById(3).getIdentifier());
        System.out.println(list.getById(4).getIdentifier());
        System.out.println(list.getById(5).getIdentifier());

        System.out.println("count = " + list.getCount());
    }
}
