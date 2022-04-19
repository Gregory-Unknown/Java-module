package ex02;

public interface UsersList {
    void addUser(User user);
    User getById(Integer id);
    User getByIndex(Integer id);
    Integer getCount();
}
