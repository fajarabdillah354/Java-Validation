package jakarta.fajar;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    /** Validator
     * Validator adalah class utama dalam Bean Validation
     * Validator digunakan sebagai object untuk mengeksekusi validation
     * Validator adalah object yang berat, oleh karena itu sebaiknya hanya dibuat satu kali saja dalam aplikasi
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/validator
     */


    /** ValidatorFactory
     * Validator merupakan sebuah Interface, untuk membuatnya kita butuh bantuan object ValidatorFactory
     * ValidatorFactory merupakan sebuah interface yang digunakan untuk membuat object-object yang ada di Bean Validation
     * Salah satu method nya adalah getValidator(), yang digunakan untuk mendapatkan object Validator
     * ValidatorFactory cukup dibuat sekali di setiap aplikasi, karena object ini merupakan object yang berat, dan untuk membuatnya kita bisa menggunakan class Validation dan method buildDefaultValidatorFactory()
     */

    @Test
    void testCreateValidation() {
        //create ValidatorFactory with class Validation
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        // get validator and return Validator
        Validator validator = validatorFactory.getValidator();

        //check validator
        Assertions.assertNotNull(validator);

        //close validatorFactory
        validatorFactory.close();

    }


}
