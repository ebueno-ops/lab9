package services;

import dataaccess.UserDB;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }

    public boolean forgotPassword(String email, String path) {
        UserDB userDB = new UserDB();

        try {
            User user = userDB.get(email);
            if (email.equals(user.getEmail())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Notes App Forgot Password";
                String template = path + "/emailtemplates/emailMessage.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("email", user.getEmail());

                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
                String pwd = RandomStringUtils.random( 8, characters );
                tags.put("password", pwd);

                GmailService.sendMail(to, subject, template, tags);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
            return false;
    }

}

