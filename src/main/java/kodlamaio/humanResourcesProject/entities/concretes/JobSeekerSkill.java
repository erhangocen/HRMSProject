package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seekers_skills")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeekerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @JoinColumn(name = "skill_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;

    @NotBlank
    @NotNull
    @Column(name = "user_id")
    private int userId;
}
