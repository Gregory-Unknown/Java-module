package ex03;

class TransactionNotFoundException extends RuntimeException {}

public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node end;
    private Integer count;

    public TransactionsLinkedList() {
        head = new Node(null);
        end = new Node(null);

        head.next = end;
        end.prev = head;
        count = 0;
    }

    @Override
    public void add(Transaction transaction)
    {
        (new Node(transaction)).pushBack(end);
        ++count;
    }

    @Override
    public Transaction remove(String uuid)
    {
        Node tmp = head.next;
        while (tmp != end) {
            if (uuid.equals(tmp.getTransaction().getIdentifier().toString())) {
                tmp.delete();
                --count;
                return tmp.getTransaction();
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException();
    }
    @Override
    public Transaction[] toArray()
    {
        Transaction[] transactions = new Transaction[count];
        Node tmp = head.next;
        for (int i = 0; i < count; ++i, tmp = tmp.next)
            transactions[i] = tmp.getTransaction();
        return transactions;
    }

    private class Node {
        private Transaction transaction;
        private Node next;
        private Node prev;

        public Node(Transaction transaction) {
            this.transaction = transaction;
        }

        public void pushBack(Node end) {
            prev = end.prev;
            prev.next = this;
            end.prev = this;
            next = end;
        }

        public void delete() {
            next.prev = prev;
            prev.next = next;
            next = null;
            prev = null;
        }

        public Transaction getTransaction() {
            return transaction;
        }
    }
}
