package kodlamaio.humanResourcesProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_seekers_skills")
public class JobSeekerSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
