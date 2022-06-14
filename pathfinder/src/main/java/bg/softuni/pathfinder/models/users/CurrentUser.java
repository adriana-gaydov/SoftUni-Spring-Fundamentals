package bg.softuni.pathfinder.models.users;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;
    private boolean isLogged;
    private boolean isAdmin;

    public CurrentUser() {
    }

    public CurrentUser(String name, boolean isLogged) {
        this.name = name;
        this.isLogged = isLogged;
    }

    public String getName() {
        return name;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public boolean isAnonymous() {
        return !isLogged;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void clear() {
        this.name = null;
        this.isLogged = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public CurrentUser setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }
}
