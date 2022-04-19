package ex02;

public class User {
    private String name;
    private Integer identifier;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
        this.identifier = UserIdsGenerator.getInstance().getId();
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        if (identifier > 0)
            this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance > 0)
            this.balance = balance;
    }
    @Override
    public String toString() {
        return  "|Name: " + name + "| |ID: " + identifier + "| |balance: " + balance + "|";
    }
}
