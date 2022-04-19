package ex02;
class UserNotFoundException extends RuntimeException {}

public class UsersArrayList implements UsersList{
    private User[] array;
    private Integer count;

    public UsersArrayList() {
        this.array = new User[10];
        this.count = 0;
    }

    @Override
    public void addUser(User user) {
        if (this.count == array.length) {
            User[] newArray = new User[count * 2];
            for (int i = 0; i < array.length; ++i)
                newArray[i] = array[i];
            array = newArray;
        }
        array[count] = user;
        ++count;
    }
    @Override
    public User getById(Integer id){
        for (int i = 0; i < count; ++i) {
            if (id.equals(array[i].getIdentifier())) {
                return array[i];
            }
        }
        throw new UserNotFoundException();
    }
    @Override
    public User getByIndex(Integer id){
        if (id >= count || id < 0)
            throw new ArrayIndexOutOfBoundsException();
        return array[id];
    }
    @Override
    public Integer getCount(){
        return count;
    }
}