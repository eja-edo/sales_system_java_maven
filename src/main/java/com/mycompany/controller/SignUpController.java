package com.mycompany.controller;

import com.mycompany.component.SignUp;
import com.mycompany.model.dao.LoginDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class SignUpController {
    private SignUp view;
    private LoginDAO model;
    
    public SignUpController(LoginDAO m, SignUp v) {
        this.view = v;
        this.model = m;
    }
    
    public class SignUpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getInpEmail();
            String pass = view.getInpPass();
            String cfpass = view.getInpPassCf();
            
            // Kiểm tra tính hợp lệ của username và password
            if (email == null || email.trim().isEmpty()) {
                view.setMessage("Vui lòng nhập Email.");
                return;
            }

            if (pass == null || pass.trim().isEmpty()) {
                view.setMessage("Vui lòng nhập mật khẩu.");
                return;
            }
            if (cfpass == null || cfpass.trim().isEmpty()) {
                view.setMessage("Vui lòng xác nhận mật khẩu.");
                return;
            }
            
            if (!isValidEmail(email)) {
                view.setMessage("Email không hợp lệ");
                return;
            }
            
            if (pass.length() < 6) {
                view.setMessage("Mật khẩu phải có ít nhất 6 ký tự.");
                return;
            }

            // Kiểm tra mật khẩu có ít nhất một chữ viết hoa và một ký tự đặc biệt
            if (!containsUpperCase(pass)) {
                view.setMessage("Mật khẩu phải chứa ít nhất một chữ viết hoa.");
                return;
            }

            if (!containsSpecialCharacter(pass)) {
                view.setMessage("Mật khẩu phải chứa ít nhất một ký tự đặc biệt.");
                return;
            }
            
            if (!pass.equals(cfpass)) {
                view.setMessage("Mật khẩu không giống nhau");
                return;
            }
            
            if (model.signUp(email, pass)) {
                view.setMessage("Đăng kí thành công");
            } else {
                view.setMessage("Đăng kí thất bại");
            }
        }
        
        // Phương thức để kiểm tra email có hợp lệ không
        private boolean isValidEmail(String email) {
            String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            return Pattern.compile(emailPattern).matcher(email).matches();
        }
        
        private boolean containsUpperCase(String password) {
            return Pattern.compile("[A-Z]").matcher(password).find();
        }

        // Phương thức kiểm tra ký tự đặc biệt trong mật khẩu
        private boolean containsSpecialCharacter(String password) {
            return Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find();
        }
    }
}
