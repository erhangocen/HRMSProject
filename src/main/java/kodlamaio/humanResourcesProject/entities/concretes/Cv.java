package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @NotNull
    @NotBlank
    @Column(name = "user_id")
    private int userId;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobSeekerSchool> jobSeekerSchools;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobSeekerExperience> jobSeekerExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobSeekerSkill> jobSeekerSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobSeekerLanguage> jobSeekerLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<JobSeekerPosition> jobSeekerPositions;
}
