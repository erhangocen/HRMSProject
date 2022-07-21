package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import kodlamaio.humanResourcesProject.entities.dtos.CvDto;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerCoverLetterDto;
import kodlamaio.humanResourcesProject.entities.dtos.JobSeekerLinksDto;

import java.util.List;

public interface IJobSeekerService {
    Result add(JobSeeker jobSeeker) throws Exception;
    Result delete(JobSeeker jobSeeker);
    DataResult<CvDto> getCv(int userId);
    Result updateLinks(JobSeekerLinksDto jobSeekerLinksDto);
    Result updateCoverLetter(JobSeekerCoverLetterDto jobSeekerCoverLetterDto);
    DataResult<List<JobSeeker>> getAll();
}
