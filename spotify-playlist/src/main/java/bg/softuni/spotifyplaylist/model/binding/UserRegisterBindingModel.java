package bg.softuni.spotifyplaylist.model.binding;

import bg.softuni.spotifyplaylist.utils.validation.UniqueEmail;
import bg.softuni.spotifyplaylist.utils.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static bg.softuni.spotifyplaylist.utils.messages.InvalidMessages.*;

public class UserRegisterBindingModel {

    @UniqueUsername
    @NotNull
    @Size(min = 3, max = 20, message = INVALID_USERNAME_LENGTH)
    private String username;

    @UniqueEmail
    @NotEmpty(message = EMPTY_EMAIL)
    @Email(message = INVALID_EMAIL)
    private String email;

    @NotNull
    @Size(min = 3, max = 20, message = INVALID_PASSWORD_LENGTH)
    private String password;

    @NotNull
    @Size(min = 3, max = 20, message = INVALID_PASSWORD_LENGTH)
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
