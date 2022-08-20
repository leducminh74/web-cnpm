package com.example.projectcnpm.controller;

import com.example.projectcnpm.mail.Mail;
import com.example.projectcnpm.modal.Account;
import com.example.projectcnpm.random.Random;
import com.example.projectcnpm.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordControler", value = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

// 5. Gọi checkAccountExist(username,email) để kiểm tra thông tin username và email -> return Account or null
        Account a = AccountService.getInstance().checkAccountExist(username,email);
        String subject = "Forgot Password";

//      6. If (checkAccountExist(username,email)) return Account
        if(a!=null){
//            7. Gọi randomPassword() để tạo mk ngẫu nhiên -> 8. return newPassword
            String newPass = Random.randomPassword();

//            9. Gọi changePassword(account,newPass) để thay đổi mk hiện tại = mk mới -> 10. Thay đổi mk người dùng thành newPass
            AccountService.getInstance().changePassword(a,newPass);
            String content = "Your password is " + newPass;

//            11. Gọi sendMail(email,subject,content) để gửi mail đến người dùng -> 12. Một email kèm mật khẩu mới được gửi đến email người dùng
            Mail.sendMail(email,subject,content);

//            13. Gửi thông báo lên trang forgotpassword (trường hợp thông tin username và email chính xác)
            request.setAttribute("message", "Your password has been sent. Please check in your email and login again.");
            request.setAttribute("success","success");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);

//      5.1. If (checkAccountExist(username,email)) return null
        }else{

//          5.2. Gửi thông báo lên trang forgotpassword (trường hợp thông tin username và email không chính xác)
            request.setAttribute("message", "Username and email do not match. Please check again!!");
            request.setAttribute("success","");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);
        }

    }
}
