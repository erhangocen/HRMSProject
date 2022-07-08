package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seekers")
public class JobSeeker extends User {

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "national_id")
    private String nationalId;

    @NotNull
    @NotBlank
    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "cover_letter")
    private String coverLetter;
}
