package kodlamaio.humanResourcesProject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean // instance oluşturuyor.
    public Cloudinary cloudinary() {

        return	new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dbzf16o0x",
                "api_key", "984229161941283",
                "api_secret", "zENnZeCqMoC1KwBVp8L6GtWeHcQ"
        ));
    }
}
