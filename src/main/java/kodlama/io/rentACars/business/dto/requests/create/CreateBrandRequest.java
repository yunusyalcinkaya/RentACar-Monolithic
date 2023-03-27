package kodlama.io.rentACars.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandRequest {
    private String name; // veri eklemek için sadece name kısmına ihtiyacım var, id otomatik
}
