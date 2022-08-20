package com.example.projectcnpm.service;

import com.example.projectcnpm.dao.AccountDao;
import com.example.projectcnpm.modal.Account;

public class AccountService {
    private static  AccountService instance;

    private AccountService(){
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    public Account checkAccountExist(String user,String email){
        return AccountDao.getInstance().checkAccountExist(user,email);
    }

    public void changePassword(Account a, String newPass){
        AccountDao.getInstance().changePassword(a,newPass);
    }

}
