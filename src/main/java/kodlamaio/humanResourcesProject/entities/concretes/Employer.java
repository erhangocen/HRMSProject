package kodlamaio.humanResourcesProject.entities.concretes;

import kodlamaio.humanResourcesProject.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends User implements IEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Employer(String email, String password, String companyName, String webAddress, String phoneNumber) {
        super(email, password);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }
}