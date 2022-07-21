package kodlamaio.humanResourcesProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerLinksDto {
    private int userId;
    private String githubLink;
    private String linkedinLink;
    private String instagramLink;
    private String twitterLink;
}
