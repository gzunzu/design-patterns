package dto.nutritionist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PatientFactoryDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("isoCode")
    private String isoCode;
}
