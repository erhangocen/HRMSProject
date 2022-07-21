package kodlamaio.humanResourcesProject.entities.concretes;

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
@Table(name = "job_seeker_schools")
public class JobSeekerSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "school_name")
    private String schoolName;


    @Column(name = "department_name")
    private String departmentName;

    @NotNull
    @Column(name = "start_year")
    private int startYear;


    @Column(name = "finish_year")
    private int finishYear;

    @NotNull
    @Column(name = "user_id")
    private int userId;

}
