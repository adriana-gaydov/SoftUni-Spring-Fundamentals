package bg.softuni.mobiLeLeLe.models;

import bg.softuni.mobiLeLeLe.models.enums.RoleType;
import org.hibernate.usertype.UserType;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public UserRole() {
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
