package kodlamaio.humanResourcesProject.entities.concretes;

import kodlamaio.humanResourcesProject.entities.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_positions")
public class JobSeekerPosition implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "job_position_id")
    private int jobPositionId;
}
