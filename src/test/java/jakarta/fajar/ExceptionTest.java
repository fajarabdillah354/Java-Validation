package jakarta.fajar;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest{
    /** Constraint Violation Exception
     * Bean Validation secara default tidak membuat Exception ketika terjadi validasi error
     * Bean Validation hanya mengembalikan error validasi dalam bentuk Set berisi Constraint Violation
     * Beberapa framework atau library, kadang menginginkan Exception jika terjadi validasi error
     * Kita tidak butuh  membuat exception secara manual, Bean Validation sudah menyediakannya, yaitu ConstraintViolationException
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolationexception
     */


    @Test
    void testException() {

        Person person = new Person();
        validateWithException(person);// dengan seperti ini kita bisa langsung throw error dan mengetahui error pada constraint
    }

    @Test
    void testAssertThrow() {
        //akan tidak throw error jika memang benar menyebabkan error

        Assertions.assertThrows(ConstraintViolationException.class, () ->{
            Person person = new Person();
            validateWithException(person);
        });
    }
}
