package jakarta.fajar.constraints;

import jakarta.fajar.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})//menggunakan CheckCaseValidator sebagai validasinya
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {
    CaseMode mode();;



    // 3 field dibawah ini wajib ditambahkan sebagai syarat dari pembuatan costum contraint
    String message() default "Invalid Format Case";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
