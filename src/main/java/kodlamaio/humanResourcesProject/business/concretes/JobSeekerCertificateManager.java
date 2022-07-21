package kodlamaio.humanResourcesProject.business.concretes;

import kodlamaio.humanResourcesProject.business.abstracts.IJobSeekerCertificateService;
import kodlamaio.humanResourcesProject.core.utilities.results.DataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessDataResult;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.dataAccess.abstracts.IJobSeekerCertificateDao;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeekerCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.Certificate;
import java.util.List;

@Service
public class JobSeekerCertificateManager implements IJobSeekerCertificateService {

    private IJobSeekerCertificateDao _jobSeekerCertificateDao;

    @Autowired
    public JobSeekerCertificateManager(IJobSeekerCertificateDao jobSeekerCertificateDao) {
        _jobSeekerCertificateDao = jobSeekerCertificateDao;
    }


    @Override
    public Result add(JobSeekerCertificate jobSeekerCertificate) {
        _jobSeekerCertificateDao.save(jobSeekerCertificate);
        return new SuccessResult();
    }

    @Override
    public Result delete(JobSeekerCertificate jobSeekerCertificate) {
        _jobSeekerCertificateDao.delete(jobSeekerCertificate);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobSeekerCertificate>> getAllCertificatesByUserId(int id) {
        return new SuccessDataResult<List<JobSeekerCertificate>>(_jobSeekerCertificateDao.findByUserIdOrderByCertificateYearDesc(id));
    }
}
