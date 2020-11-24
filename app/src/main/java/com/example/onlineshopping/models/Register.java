package com.example.onlineshopping.models;

public class Register {
    String InputName;
    String InputEmail;
    String InputPassword;

    public Register(String inputName, String inputEmail, String inputPassword) {
        InputName = inputName;
        InputEmail = inputEmail;
        InputPassword = inputPassword;
    }

    public Register() {
    }

    public String getInputName() {
        return InputName;
    }

    public void setInputName(String inputName) {
        InputName = inputName;
    }

    public String getInputEmail() {
        return InputEmail;
    }

    public void setInputEmail(String inputEmail) {
        InputEmail = inputEmail;
    }

    public String getInputPassword() {
        return InputPassword;
    }

    public void setInputPassword(String inputPassword) {
        InputPassword = inputPassword;
    }
}

