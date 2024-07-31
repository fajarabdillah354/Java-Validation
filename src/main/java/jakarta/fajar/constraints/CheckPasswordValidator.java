package jakarta.fajar.constraints;

import jakarta.fajar.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//class validasi dari annotation CheckPassword
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {//implement ConstraintValidator dengan generic type annotation checknya dan object yang mau di check

    private String messageTemplete;//untuk mendapatkan message asli dari getPropery()

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplete = constraintAnnotation.message();//mengambil nilai dari message()
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {
        if (register.getPassword() == null || register.getConfirmPassword() == null) return true;


        boolean isValid = register.getPassword().equals(register.getConfirmPassword());

        /**
         * untuk menambahkan property yang hilang di constraint level class kita harus menambahkan constraintValidatorContex.buildConstraintViolationWithTemplate()
         */

        if (!isValid){
            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplete).addPropertyNode("Password").addConstraintViolation();

            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplete).addPropertyNode("Confirm Password").addConstraintViolation();
        }



        return (isValid);
    }



}
