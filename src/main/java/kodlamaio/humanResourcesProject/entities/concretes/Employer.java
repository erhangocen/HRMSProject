package kodlamaio.humanResourcesProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers","cities","job","job_advertisments","jobAdvertisments"})
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "employer", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;
}
