package kodlama.io.rentacar.common.utils.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// bu projede anotasyonlar dto lar içindeki field'lar için kullanıldı
// parametreler içinde kullanılabilir
@Target({ElementType.FIELD,ElementType.PARAMETER})
// anotasyon runtime boyunca geçerli olsun
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotFutureYearValidator.class)
public @interface NotFutureYear {
    String message() default "Model year value cannot be in the future";
    // farklı kullanıcı gruplarına özelleştirilmiş işlemler özellikler tanımlamak için kullanılır
    // örneğin admine özel işlemler
    Class<?>[] groups() default {};
    // veri transfer nesnelerinde belirli bir grubun mesajlarını taşımak için kullanılır.
    Class<? extends Payload>[] payload() default {};
}
