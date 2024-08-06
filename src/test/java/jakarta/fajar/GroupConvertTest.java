package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest{

    /** Group Conversion
     * Kadang ada kasus dimana terdapat sebuah class yang sudah memiliki field group, namun ternyata kita membutuhkan class tersebut di embed di class lain, sedangkan class lain menggunakan group berbeda
     * Pada kasus seperti ini, kita bisa melakukan konversi grup
     * Untuk melakukan konversi group, kita bisa menggunakan annotation @ConvertGroup, lalu tentukan dari group apa ke group apa
     */

    @Test
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("Cs-001");
        payment.setAmount(10_000_000L);
        payment.setCreditCard("4111111111111111");


//        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }
}
