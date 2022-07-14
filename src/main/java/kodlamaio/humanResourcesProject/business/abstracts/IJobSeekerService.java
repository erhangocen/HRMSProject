package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import kodlamaio.humanResourcesProject.entities.dtos.CvDto;

import javax.xml.crypto.Data;
import java.util.List;

public interface IJobSeekerService {
    Result add(JobSeeker jobSeeker) throws Exception;
    Result delete(JobSeeker jobSeeker);
    DataResult<CvDto> getCv(int userId);
    Result updateGithub(int userId,String link);
    Result updateLinkedin(int userId,String link);
    Result updateCoverLetter(int userId,String coverLetter);
    DataResult<List<JobSeeker>> getAll();
}
