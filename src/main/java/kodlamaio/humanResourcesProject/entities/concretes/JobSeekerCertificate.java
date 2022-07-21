package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_certificates")
public class JobSeekerCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "certificate_title")
    private String certificateTitle;

    @NotNull
    @Column(name = "certificate_year")
    private int certificateYear;

    @NotNull
    @Column(name= "user_id")
    private int userId;
}
