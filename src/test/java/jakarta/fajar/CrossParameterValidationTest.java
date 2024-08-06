package jakarta.fajar;

import jakarta.fajar.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest{

    /** Cross-Parameter Constraint
     * Untuk melakukan validasi beberapa Field, kita bisa menggunakan fitur Class-Level Constraint
     * Sekarang bagaimana jika kita ingin melakukan validasi beberapa Parameter? Misal pada Method Parameter atau Constructor Parameter?
     * Hal ini tidak bisa menggunakan Class-Level Constraint, namun ada cara sendiri untuk melakukan hal ini
     * Yaitu dengan menggunakan Annotation @SupportedValidationTarget
     * Kita bisa menggunakan @SupportedValidationTarget pada ConstraintValidator, untuk melakukan validasi semua parameter di Method atau Constructor
     * @throws NoSuchMethodException
     */



    @Test
    void testCrossParameter() throws NoSuchMethodException {
        UserService userService = new UserService();


        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "fajar abdillah ahmad";
        String password = "fajar123";
        String confirmPassword = "fajar";

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{username, password, confirmPassword});

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("======================");
        }


    }
}
