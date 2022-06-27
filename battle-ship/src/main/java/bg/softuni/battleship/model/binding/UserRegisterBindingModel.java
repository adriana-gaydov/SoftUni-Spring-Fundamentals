package bg.softuni.battleship.model.binding;

import bg.softuni.battleship.validation.UniqueUsername;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters.")
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters.")
    private String fullName;

    @NotEmpty(message = "Enter valid email address.")
    @Email(message = "Enter valid email address.")
    private String email;

    @NotNull
    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String password;

    @NotNull
    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
