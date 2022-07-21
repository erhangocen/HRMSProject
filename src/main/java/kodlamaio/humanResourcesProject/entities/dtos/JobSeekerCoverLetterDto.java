package kodlamaio.humanResourcesProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerCoverLetterDto {
    private int userId;
    private String coverLetter;
}
