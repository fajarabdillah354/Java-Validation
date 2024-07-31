package jakarta.fajar.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})// validate dengan class CheckPasswordValidator
@Target({ElementType.FIELD, ElementType.TYPE})//target harus diubah ke TYPE untuk bisa menvalidasi class
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {

    String message() default "password and confirm password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
