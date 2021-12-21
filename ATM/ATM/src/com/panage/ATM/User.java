package com.panage.ATM;

public class User {
    private String user_name;//用户名
    private String user_password;//卡号
    private String password_text;//密码
    private Integer  money_number=0;//账户余额

    public User() {
    }

    public User(String user_name, String user_password, String password_text) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.password_text = password_text;
    }

    public Integer getMoney_number() {
        return money_number;
    }

    public void setMoney_number(Integer money_number) {
        this.money_number = money_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPassword_text() {
        return password_text;
    }

    public void setPassword_text(String password_text) {
        this.password_text = password_text;
    }
}
