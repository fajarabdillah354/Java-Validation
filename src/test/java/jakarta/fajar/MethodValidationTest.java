package jakarta.fajar;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest{


    /** Method Validation
     * Sampai saat ini kita baru hanya melakukan validasi pada object yang kita buat secara manual
     * Bean Validation sendiri bisa digunakan untuk melakukan validasi di Method, baik itu Method Parameter atau Return Value
     * Fitur ini memudahkan kita karena cukup menambahkan Annotation Constraint di Method Parameter
     * @throws NoSuchMethodException
     */


    /** ExecutableValidator
     * Untuk melakukan validasi di Method, kita butuh object ExecutableValidator
     * Untuk membuat ExecutableValidator, kita bisa gunakan method forExecutables() di Validator
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/executable/executablevalidator
     * @throws NoSuchMethodException
     */


    //contoh method validation tanpa return value yaitu dengan menggunakan method validateParameters()
    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();

        String name = "";

        Method method = Person.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : constraintViolations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===========================");
        }

    }



    //contoh method validation dengan menggunakan return value yaitu dengan menggunakan method validateReturnValue()
    @Test
    void testValidasiReturnValue() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        String returnValue = person.fullName();

        Method method = Person.class.getMethod("fullName");


        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.validateReturnValue(person, method, returnValue);
        for (ConstraintViolation<Person> violation : constraintViolations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=================");
        }

    }
}
