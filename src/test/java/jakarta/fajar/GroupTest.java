package jakarta.fajar;

import jakarta.fajar.group.VirtualAccountPaymentGroup;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.junit.jupiter.api.Test;

public class GroupTest extends AbstractValidatorTest{


    @Test
    void testCreditCardGroup() {
        //ini contoh yang tidak valid
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");


        /**
         * Ketika kita sudah menambahkan grouping kita harus mention grupnya
         * jika tidak mention maka akan mendapatkan Default group
         */
        validateWithGroup(payment, VirtualAccountPaymentGroup.class);//yang error hanya jika ada field yang grouping ke class interface VirtualAccountPaymentGroup


    }
}
