package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "title")
    private String title;

    @NotBlank
    @NotNull
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "min_salary")
    private int minSalary;

    @NotBlank
    @Column(name = "max_salary")
    private int maxSalary;

    @NotBlank
    @NotNull
    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @NotBlank
    @Null
    @Column(name = "release_date")
    private LocalDateTime releaseDate = LocalDateTime.now();

    @NotBlank
    @Null
    @Column(name = "is_active")
    private boolean isActive = true;

    @NotBlank
    @NotNull
    @Column(name = "open_position_count")
    private int openPositionCount;

    @NotBlank
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @NotBlank
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotBlank
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}
