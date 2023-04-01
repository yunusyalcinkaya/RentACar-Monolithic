package kodlama.io.rentACars.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelResponse {
    private int id;
    private int brandId;
    private String name;
}
