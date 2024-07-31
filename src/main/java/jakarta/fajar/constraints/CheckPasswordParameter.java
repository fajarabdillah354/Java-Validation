package jakarta.fajar.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})// validate dengan class CheckPasswordValidator
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.TYPE, ElementType.METHOD})//target harus ditambah METHOD agar bisa dipakai di method
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();

    int confirmPassword();

    String message() default "password and confirm password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
