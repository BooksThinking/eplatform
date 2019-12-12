package entities;

public class user {
    //用来存储用户名
    private String userName;
    //用来存储用户密码
    private String userPassword;

    public user(String userName,String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    //对应属性的setter和getter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
