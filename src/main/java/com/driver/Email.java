package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }



    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(getPassword()) && newPassword.length()>=8 && containsOneUpperCase(newPassword) && containsOneLowerCase(newPassword)
        && containsOneDigit(newPassword) && containsOneSpecial(newPassword) ){
            setPassword(newPassword);
        }
    }

    private boolean containsOneUpperCase(String newPassword) {
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)>='A' && newPassword.charAt(i)<='Z'){
                return true;
            }
        }
        return false;
    }

    private boolean containsOneLowerCase(String newPassword) {
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)>='a' && newPassword.charAt(i)<='z'){
                return true;
            }
        }
        return false;
    }

    private boolean containsOneDigit(String newPassword) {
        for(int i=0; i<newPassword.length(); i++){
            if(newPassword.charAt(i)>='0' && newPassword.charAt(i)<='9'){
                return true;
            }
        }
        return false;
    }
    private boolean containsOneSpecial(String newPassword) {
        for(int i=0; i<newPassword.length(); i++){
            char ch = newPassword.charAt(i);
            if(!containsOneDigit(""+ch) && !containsOneUpperCase(""+ch) && !containsOneLowerCase(""+ch) ){
                return true;
            }
        }
        return false;
    }


}
