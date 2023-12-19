package com.ohgiraffers.semilogin.common;

public enum UserAuth {
    USER("USER"), ADMIN("ADMIN");
    private String auth;

    UserAuth(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "auth='" + auth + '\'' +
                '}';
    }
}
