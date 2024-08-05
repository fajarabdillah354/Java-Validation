package jakarta.fajar;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.Set;

public class ConstraintViolationTest {

    /**
     * Setelah kita menambahkan annotation Constraint ke class yang akan kita validasi, selanjutnya kita bisa mulai melakukan validasi terhadap object class tersebut menggunakan method validate() milik class Validator
     * Hasil kembalian dari method validate() adalah Set<ConstraintViolation>, dimana ConstraintViolation tersebut merupakan representasi kesalaha dari constraint
     * Jika terdapat kesalahan, otomatis terdapat ConstraintViolation, namun jika tidak ada kesalahan, maka tidak akan terdapat ConstraintViolation, alias Set nya akan berisi data kosong
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolation
     */


    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void beforeAll() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }


    /** Object Metadata
     * Jika kita perhatikan, pada Constraint Violation, tidak hanya message error yang bisa kita lihat, kita juga bisa melihat field mana yang error, dari object mana, dan lain-lain
     * Ini sangat bagus ketika kita ingin melakukan debugging field mana yang error
     */

    @Test
    void testValidationFailed() {

        Person person = new Person();
        //akan menyebabkan constraint bagian Size
        person.setFirstName("ffffffffffffffffffffffffffffffffjaaaaaaaaarigajgegaegad");
        person.setLastName("ahaaaaaaaaaaaaaaaaaaaaammmmmmmmaddddddddddddddddddddddddddddddd");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message :"+violation.getMessage());//get Error message
            //kita juga bisa melihat field mana saja yang error dalam CostraintViolation, ini bagus memberi tahu pengguna
            System.out.println("Bean :"+violation.getLeafBean());//get object LEAF
            System.out.println("Constraint : "+violation.getConstraintDescriptor().getAnnotation());//get anntotaion causes error
            System.out.println("Invalid Value : "+violation.getInvalidValue());//get invalid value
            System.out.println("Path : "+violation.getPropertyPath());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
//            System.out.println(violation);
        }
    }


    @Test
    void testValidationSuccess() {
        //Ini adalah contoh penggunaan Bean Validation untuk Validasi

        Person person = new Person();
        //Ini contoh yang tidak terkena Constraint
        person.setFirstName("fajar abdillah ");
        person.setLastName("ahmad");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());
//
//        for (ConstraintViolation<Person> violation : violations) {
//            System.out.println("Message :"+violation.getMessage());//get Error message
//            //kita juga bisa melihat field mana saja yang error dalam CostraintViolation, ini bagus memberi tahu pengguna
//            System.out.println("Bean :"+violation.getLeafBean());//get object LEAF
//            System.out.println("Constraint : "+violation.getConstraintDescriptor().getAnnotation());//get anntotaion causes error
//            System.out.println("Invalid Value : "+violation.getInvalidValue());//get invalid value
//            System.out.println("Path : "+violation.getPropertyPath());
//            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
////            System.out.println(violation);
//        }
    }

}
