package jakarta.fajar;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ContructorValidationTest extends AbstractValidatorTest {

    @Test
    void testConstructorValidationReturnValue() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, Address.class);

        Person person = new Person("","",null);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructor, person);
        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("==================");
        }


    }


    @Test
    void testConstructorValidationParameterValue() throws NoSuchMethodException {

        String firstName ="fajar";
        String lastName = "abdillah";
        Address address = new Address();
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        address.setStreet("Radar Selatan");

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});


        for (ConstraintViolation<Person> violation : constraintViolations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=================");
        }

    }



}
