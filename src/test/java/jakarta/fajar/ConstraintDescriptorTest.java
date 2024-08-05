package jakarta.fajar;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidatorTest{

    /**
     * kita bisa mendapatkan detail dari constraintnya ketika setelah melakukan validasi kita bisa menggunakan ConstraintDescriptor
     *
     */



    @Test
    void testConstraintDescriptor() {
        Payment payment = new Payment();

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);

        for (ConstraintViolation<Payment> violation : violations) {
            ConstraintDescriptor<?> constraintDescriptor = violation.getConstraintDescriptor();
            System.out.println(constraintDescriptor.getAnnotation());
            System.out.println(constraintDescriptor.getAttributes());
            System.out.println(constraintDescriptor.getPayload());
            System.out.println(constraintDescriptor.getGroups());
            System.out.println(("================"));
        }


    }
}
