package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.payload.EmailErrorPayload;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    /**
     * kita bisa menambahkan informasi tambahan dengan menggunakan payload
     * Untuk melakukan konversi group, kita bisa menggunakan annotation @ConvertGroup, lalu tentukan dari group apa ke group apa
     * Method payload() itu sendiri sebenarnya tidak digunakan sama sekali oleh Bean Validation, namun method ini bisa digunakan oleh kita untuk menambah informasi ketika menggunakan constraint
     */


    @Test
    void testPayload() {

        Payment payment = new Payment();
        payment.setOrderId("CS-001");
        payment.setAmount(10_000_000L);
        payment.setCreditCard("31111");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            
            Set<Class<? extends  Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> aClass : payload) {
                if (aClass == EmailErrorPayload.class){
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("===============================");

        }


    }
}
