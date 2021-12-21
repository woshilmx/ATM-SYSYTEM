package com.panage.ATM;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class atm_main {
   static Scanner sc=new Scanner(System.in);
   static ArrayList<User> users=new ArrayList<>();
   static String PASSWORD_KU="0123456789";

    public static void main(String[] args) {
        //显示登录界面
        Menu1();
        //根据用户选择做出相应反应
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    User u=listed();
                    if (u!=null) {
                        Menu2();
                        while (true) {
                            choice = sc.nextInt();
                            switch (choice) {
                                case 0:
                                    System.exit(0);
                                    break;
                                case 1:
                                    draw_money(u);
                                    break;
                                case 2:
                                    save_money(u);
                                    break;
                                case 3:
                                    serch_money(u);
                                    break;
                                case 4:
                                    clear_money(u);
                                    break;
                                default:
                                    System.out.println("输入错误,请重新输入");
                            }
                        }
                    }
                    break;
                case 2:
                    creat_user();
                    System.out.println(users.get(0).getUser_name());
                    break;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }
//注销账户
    private static void clear_money(User u) {
        users.remove(u);
        System.out.println("账户已注销");
    }

    //查询余额
    private static void serch_money(User u) {
        System.out.println("用户名"+u.getUser_name());
        System.out.println("账户余额"+u.getMoney_number());

    }

    //存钱
    private static void save_money(User u) {
        System.out.println("请输入存钱的金额");
       int money=sc.nextInt();
        u.setMoney_number(u.getMoney_number()+money);
        if (u.getMoney_number()!=0){
            System.out.println("存了"+money+"元");
        }


    }

    //取钱
    private static void draw_money(User u) {
        System.out.println("请输入取钱的金额");
        int money=sc.nextInt();
        if(u.getMoney_number()<money){
            System.out.println("余额不足");
            return;
        }
        u.setMoney_number(u.getMoney_number()-money);
        if (u.getMoney_number()!=0){
            System.out.println("取了"+money+"元");
        }

    }

    //退出系统
    private static void exit() {
        System.out.println("系统已退出");
        System.exit(0);
    }
//操作界面菜单
    private static void Menu2() {
        System.out.println("--------操作界面--------");
        System.out.println("1.取   钱");
        System.out.println("2.存   钱");
        System.out.println("3.查询余额");
        System.out.println("4.注销账户");
        System.out.println("0.退出系统");}

    //注册账户
    private static void creat_user() {
        Random ran=new Random();

        System.out.println("请输入用户名");
        String name=sc.next();
        System.out.println("请输入密码");
        String password_text=sc.next();
        String password="";
        for (int i = 0; i < 6; i++) {
            int j = ran.nextInt(10);
            password+=PASSWORD_KU.charAt(j);
        }
        User u=new User(name,password,password_text);
        users.add(u);
        System.out.println("卡号："+u.getUser_password());
        System.out.println("密码："+u.getPassword_text());
        System.out.println("用户名："+u.getUser_name());



    }
    //登录账户
    private static User listed() {

        System.out.println("请输入卡号");
        String card=sc.next();
        System.out.println("请输入密码");
        String pw=sc.next();
        for (int  i= 0;  i<users.size() ; i++) {
            if (users.get(i).getUser_password().equals(card)){
                if (users.get(i).getPassword_text().equals(pw)){
                    System.out.println("登录成功");
                    return users.get(i);

                }
                else System.out.println("密码错误");
            }
            if (i==users.size()-1){
                System.out.println("用户不存在");
            }

        }
            return null;
    }
    private static void Menu1() {
        System.out.println("--------登录界面--------");
        System.out.println("1.登录账户");
        System.out.println("2.创建账户");
    }
}
