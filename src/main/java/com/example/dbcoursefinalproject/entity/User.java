package com.example.dbcoursefinalproject.entity;

public class User {
    String userId;
    String username;
    String phoneNumber;
    String email;
    String password;
    int isMuzzled;
    int administrator;
    String userIntroduction;
    String usrImg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsMuzzled() {
        return isMuzzled;
    }

    public void setIsMuzzled(int isMuzzled) {
        this.isMuzzled = isMuzzled;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getUsrImg() {
        return usrImg;
    }

    public void setUsrImg(String usrImg) {
        this.usrImg = usrImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isMuzzled=" + isMuzzled +
                ", administrator=" + administrator +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", usrImg='" + usrImg + '\'' +
                '}';
    }
}
