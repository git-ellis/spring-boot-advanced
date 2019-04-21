package com.example.demo.form;

import com.example.demo.domain.Client;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClientForm implements BaseForm<Client> {

    @NotEmpty
    private String name;
    @Length(min = 6, message = "密碼長度至少6個字以上")
    private String password;
    @NotBlank
    private String confirmedPwd;
    @NotBlank
    private String phone;
    @NotBlank
    private String gender;
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPwd() {
        return confirmedPwd;
    }

    public void setConfirmedPwd(String confirmedPwd) {
        this.confirmedPwd = confirmedPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean confirmPassword() {
        return this.password.equals(this.confirmedPwd);
    }

    @Override
    public Client covert() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }
}

