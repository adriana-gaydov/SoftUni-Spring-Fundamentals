package bg.softuni.spotifyplaylist.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static bg.softuni.spotifyplaylist.utils.messages.InvalidMessages.INVALID_PASSWORD_LENGTH;
import static bg.softuni.spotifyplaylist.utils.messages.InvalidMessages.INVALID_USERNAME_LENGTH;

public class UserLoginBindingModel {

    @NotNull
    @Size(min = 3, max = 20, message = INVALID_USERNAME_LENGTH)
    private String username;

    @NotNull
    @Size(min = 3, max = 20, message = INVALID_PASSWORD_LENGTH)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
