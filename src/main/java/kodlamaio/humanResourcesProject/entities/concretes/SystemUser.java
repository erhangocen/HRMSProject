package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@Table(name = "system_users")
public class SystemUser extends User {

    public SystemUser(String email, String password) {
        super(email, password);
    }

}
