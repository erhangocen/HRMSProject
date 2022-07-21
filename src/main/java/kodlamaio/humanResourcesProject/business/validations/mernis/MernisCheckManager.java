package kodlamaio.humanResourcesProject.business.validations.mernis;

import kodlamaio.humanResourcesProject.business.validations.mernis.IMernisCheckService;
import kodlamaio.humanResourcesProject.core.Security.Mernis.KPSPublicSoapProxy;
import kodlamaio.humanResourcesProject.core.utilities.results.ErrorResult;
import kodlamaio.humanResourcesProject.core.utilities.results.Result;
import kodlamaio.humanResourcesProject.core.utilities.results.SuccessResult;
import kodlamaio.humanResourcesProject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MernisCheckManager implements IMernisCheckService {

    @Override
    public Result checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

        boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()),
                jobSeeker.getFirstName().toUpperCase(new Locale("tr","TR")),
                jobSeeker.getLastName().toUpperCase(new Locale("tr","TR")),
                Integer.parseInt(jobSeeker.getBirthYear()));

        if(!result) {
            return new ErrorResult("Your identity authentication is incorrect");
        }
        return new SuccessResult();
    }
}
