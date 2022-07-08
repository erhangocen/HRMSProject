package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_languages")
public class JobSeekerLanguages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "language_id")
    private Language language;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
