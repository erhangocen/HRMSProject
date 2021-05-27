package kodlamaio.humanResourcesProject.entities.concretes;

import kodlamaio.humanResourcesProject.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
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
public class SystemUser extends User implements IEntity {

    public SystemUser(String email, String password) {
        super(email, password);
    }

}
