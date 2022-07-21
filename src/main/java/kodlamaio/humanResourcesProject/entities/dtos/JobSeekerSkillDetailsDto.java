package kodlamaio.humanResourcesProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerSkillDetailsDto {
    private int id;
    private int skillId;
    private int userId;
    private String skillName;
}
