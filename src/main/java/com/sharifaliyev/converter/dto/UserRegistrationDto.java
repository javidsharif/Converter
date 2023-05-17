package com.sharifaliyev.converter.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {
    @NotEmpty(message = "This is a required field")
    private String password;

    @NotEmpty(message = "This is a required field")
    private String confirmPassword;

    @Email(message = "Invalid email")
    @NotEmpty(message = "This is a required field")
    private String email;

    @AssertTrue(message = "You need to accept the license agreement")
    private Boolean terms;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
