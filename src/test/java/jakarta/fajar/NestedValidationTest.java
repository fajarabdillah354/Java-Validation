package jakarta.fajar;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NestedValidationTest {

    /** Nested Validation
     * Secara default, jika terdapat nested object, Bean Validation tidak akan melakukan validasi terhadap data object tersebut
     * Misal kita punya class Person, dimana  memiliki field address dengan tipe class Address,  secara default isi dalam class Address tidak akan divalidasi
     * Jika kita ingin melakukan validasi terhadap nested object tersebut, kita perlu menambahkan annotation @Valid
     * @Valid juga bisa digunakan untuk nested object yang terdapat di dalam Array atau Collection
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valid
     */

    private Validator validator;

    @BeforeEach
    void beforeAll() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Test
    void testNested() {
        Person person = new Person();
        person.setFirstName("fajar");
        person.setLastName("abdillah");
        Address address = new Address();
        person.setAddress(address);

        //jika pada field address tidak ditambahkan constraint @Valid maka tidak ada terjadi error apa2 padahal kita memberikan setter di person untuk field address dari class Address, tujuan kita ingin menValidasi juga yang ada di class Address
        for (ConstraintViolation<Person> violation : validator.validate(person)) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("=========================");
        }

    }



}
