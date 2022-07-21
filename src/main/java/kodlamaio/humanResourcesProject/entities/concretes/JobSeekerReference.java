package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_references")
public class JobSeekerReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @NotBlank
    @Column(name = "reference_title")
    private String referenceTitle;

    @NotNull
    @NotBlank
    @Column(name = "reference_name")
    private String referenceName;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Email
    @NotNull
    @NotBlank
    @Column(name = "reference_mail")
    private String referenceMail;
}
