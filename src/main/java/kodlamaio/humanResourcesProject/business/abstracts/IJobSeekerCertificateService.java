package kodlamaio.humanResourcesProject.business.abstracts;

import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerCertificate;

import java.security.cert.Certificate;
import java.util.List;

public interface IJobSeekerCertificateService {
    Result add(JobSeekerCertificate jobSeekerCertificate);
    Result delete(JobSeekerCertificate jobSeekerCertificate);

    DataResult<List<JobSeekerCertificate>> getAllCertificatesByUserId(int id);
}
