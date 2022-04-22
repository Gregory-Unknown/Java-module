package ex03;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Volandemort", 10000);
        User user2 = new User("Newton", 100000);
        User user3 = new User("Balabanov", 10000);
        User user4 = new User("Tanos", 10000);
        User user5 = new User("Kilmonger", 100000);

        TransactionsList list = new TransactionsLinkedList();
        user1.setTransactionsList(list);
        user2.setTransactionsList(list);
        user3.setTransactionsList(list);
        user4.setTransactionsList(list);
        user5.setTransactionsList(list);

        Transaction transaction1 = Transaction.createTransaction(user2, user1, Transaction.Type.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(user1, user2, Transaction.Type.DEBIT, 500);
        Transaction transaction3 = Transaction.createTransaction(user2, user3, Transaction.Type.CREDIT, -500);
        Transaction transaction4 = Transaction.createTransaction(user3, user2, Transaction.Type.DEBIT, 500);
        Transaction transaction5 = Transaction.createTransaction(user3, user5, Transaction.Type.CREDIT, -500);
        System.out.println(transaction1);
        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);
        list.add(transaction5);

        System.out.println("-------------------");
        System.out.println("Transactions");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
        System.out.println("delete");
        assert transaction1 != null;
        assert transaction2 != null;
        assert transaction3 != null;
        assert transaction4 != null;
        assert transaction5 != null;
        list.remove(transaction1.getIdentifier().toString());
        list.remove(transaction2.getIdentifier().toString());
        list.remove(transaction3.getIdentifier().toString());
        list.remove(transaction4.getIdentifier().toString());
        list.remove(transaction5.getIdentifier().toString());
        System.out.println("-------------------");
        System.out.println("after");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
//        list.remove("");
    }
}
