package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","cities","job","job_advertisments","jobAdvertisments"})
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "position_name")
    private String positionName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSeekerExperience> jobSeekerExperiences;

    @JsonIgnore(value = true)
    @OneToMany(mappedBy = "jobPosition", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSeekerPosition> jobSeekerPositions;
}
