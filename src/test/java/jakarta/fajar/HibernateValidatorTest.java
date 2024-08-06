package jakarta.fajar;

import org.junit.jupiter.api.Test;

public class HibernateValidatorTest extends AbstractValidatorTest{

    @Test
    void testHibernateFailed() {
        Payment payment = new Payment();
        payment.setOrderId("00011111111111111111111111111");
        payment.setAmount(1L);
        payment.setCreditCard("4111");

        //karna yang menyebabkan error adalah amount dan credit card maka Validation akan mengembalikan nilai yang salah
        validate(payment);

    }

    @Test
    void testHibernateSuccess() {
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(50_000_000L);
        payment.setCreditCard("4111111111111111");//format Credit Card


        validate(payment);//test Validation jika benar maka Set<ContraintViolation> tidak mengembalikan nilai apapun(hanya mengembalikan nilai jika terdapat kesalahan

    }


}
