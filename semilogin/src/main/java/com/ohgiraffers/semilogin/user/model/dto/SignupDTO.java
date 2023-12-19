package com.ohgiraffers.semilogin.user.model.dto;

import java.util.Date;

public class SignupDTO {
    private String userEmail;
    private String userNickName;
    private String password;
    private String auth;
    private String userStatus;
    private int petCode;
    private Date registDate;
    private Date updateDate;

    public SignupDTO() {
    }

    public SignupDTO(String userEmail, String userNickName, String password, String auth, String userStatus, int petCode, Date registDate, Date updateDate) {
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.password = password;
        this.auth = auth;
        this.userStatus = userStatus;
        this.petCode = petCode;
        this.registDate = registDate;
        this.updateDate = updateDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public int getPetCode() {
        return petCode;
    }

    public void setPetCode(int petCode) {
        this.petCode = petCode;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", password='" + password + '\'' +
                ", auth='" + auth + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", petCode=" + petCode +
                ", registDate=" + registDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
