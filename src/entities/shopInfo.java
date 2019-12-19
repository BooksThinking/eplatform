package entities;

public class shopInfo {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count = 0;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userPassword;
}
