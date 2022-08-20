package com.example.projectcnpm.dao;

import com.example.projectcnpm.db.DBConnect;
import com.example.projectcnpm.modal.Account;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {
    private static AccountDao instance;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private AccountDao() {
    }

    public static AccountDao getInstance() {
        if (instance == null) {
            instance = new AccountDao();
        }
        return instance;
    }

    public Account checkAccountExist(String username,String email){
        String query ="select * from account where `username` = ? and `email` = ?";
        try{
            conn = DBConnect.connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,email);
            rs = ps.executeQuery();
            while (rs.next()){
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        }catch (Exception e){

        }
        return null;
    }

    public void changePassword(Account a, String newPass){
        int user_id = a.getUserId();
        String query ="update account set password = ? where user_id = ?";
        try{
            conn = DBConnect.connect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,hashPassword(newPass));
            ps.setInt(2,user_id);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }


    private String hashPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            BigInteger number = new BigInteger(1,byteData);
            return number.toString(16);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        Account b = AccountDao.getInstance().checkAccountExist("minh","ducminh0573@gmail.com");
//        System.out.println(AccountDao.getInstance().hashPassword("abc"));
        AccountDao a1 = new AccountDao();
        System.out.println(a1.checkAccountExist("minh","ducminh0573@gmail.com"));

    }


}
