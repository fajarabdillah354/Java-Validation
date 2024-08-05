package jakarta.fajar;

import jakarta.fajar.extractor.DataValueExtractor;
import jakarta.fajar.extractor.EntryValueExtractorKey;
import jakarta.fajar.extractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void beforeAll() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
        // untuk melakukan extraksi value kita menggunakan method byDefaultProvider()
        // yang kita melakukan extraksi multiple generic maka kita harus buat method addValueExtractornya sesuai banyak data yang ingin di extracsi
        validatorFactory = Validation.byDefaultProvider().configure().addValueExtractor(new DataValueExtractor()).addValueExtractor(new EntryValueExtractorValue()).addValueExtractor(new EntryValueExtractorKey()).buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }


    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }


    void validate(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("====================");
        }
    }


    void validateWithException(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        if (!validate.isEmpty()){
            throw new ConstraintViolationException(validate);
        }
    }



    void validateWithGroup(Object object, Class<?>... classes){//kita menambahkan parameter jika ingin menggunakan group untuk validasi
        for (ConstraintViolation<Object> violation : validator.validate(object, classes)) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=========================");
        }
    }


}
