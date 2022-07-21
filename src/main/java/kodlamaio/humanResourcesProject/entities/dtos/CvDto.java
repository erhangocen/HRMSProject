package kodlamaio.humanResourcesProject.entities.dtos;

import kodlamaio.humanResourcesProject.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {
    private JobSeeker jobSeeker;
    private Photo photo;
    private List<JobSeekerCertificate> jobSeekerCertificates;
    private List<JobSeekerReference> jobSeekerReferences;
    private List<JobSeekerSkill> jobSeekerSkills;
    private List<JobSeekerExperience> jobSeekerExperiences;
    private List<JobSeekerPosition> jobSeekerPositions;
    private List<JobSeekerLanguage> jobSeekerLanguages;
    private List<JobSeekerSchool> jobSeekerSchools;
}
