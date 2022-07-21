package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_languages")
public class JobSeekerLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @JoinColumn(name = "language_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @NotNull
    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

    @NotNull
    @Column(name = "user_id")
    private int userId;
}
