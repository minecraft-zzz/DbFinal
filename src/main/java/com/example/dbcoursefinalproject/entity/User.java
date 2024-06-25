package com.example.dbcoursefinalproject.entity;

public class User {

    int userId;
    String userName;
    String phoneNumber;
    String email;
    String password;
    int isMuzzled;
    int administrator;
    String userIntroduction;
    String userImg;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserImg() {
        return userImg;
    }

    public void setUsrImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isMuzzled=" + isMuzzled +
                ", administrator=" + administrator +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", usrImg='" + userImg + '\'' +
                '}';
    }
}
