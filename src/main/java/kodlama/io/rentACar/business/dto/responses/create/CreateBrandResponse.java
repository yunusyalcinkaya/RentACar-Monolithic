package kodlama.io.rentACar.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBrandResponse { // sadece oluşturulan nesne ile alakalıları döndür
    private int id;
    private String name;
}
