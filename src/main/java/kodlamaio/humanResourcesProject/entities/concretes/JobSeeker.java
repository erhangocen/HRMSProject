package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seeker")
public class JobSeeker extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "birth_year")
    private int birthYear;

    public JobSeeker(String email, String password, String firstName, String lastName, String nationalId, int birthYear) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.birthYear = birthYear;
    }

}
