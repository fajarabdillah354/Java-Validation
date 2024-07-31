package jakarta.fajar.constraints;

import jakarta.fajar.enums.CaseMode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {//implement ContraintValidator<T,U> untuk validasinya

    private CaseMode caseMode ;



    //implement method interface ContraintValidator
    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return true;

        if (caseMode == CaseMode.UPPER){
            return caseMode.equals(s.toUpperCase());
        }else if (caseMode == CaseMode.LOWER){
            return caseMode.equals(s.toLowerCase());
        }

        return false;

    }
}
