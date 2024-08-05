package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class ConstraintComposisionTest extends AbstractValidatorTest{

    /** Constraint Composition
     * Jika kita perhatikan pada Order.id, kita lihat terdapat 3 constraint annotation, @Size, @NotBlank dan @CheckCase. Bahkan pada skenario tertentu, bisa jadi akan sangat banyak sekali constraint pada sebuah field, yang semakin lama akan semakin membingungkan
     * Bean Validation mendukung Constraint Composition, dimana kita bisa membuat Constraint baru yang didalamnya sebenarnya adalah kumpulan Constraint lainnya
     * Caranya sangat mudah,  kita cukup membuat Constraint Annotation, lalu tambahkan Constraint Annotation lain pada Constraint yang kita buat
     */



    @Test
    void testConstraintComposision() {
        Locale.setDefault(new Locale("in","ID"));//penggunaan I18N dengan Class Locale


        Payment payment = new Payment();
        payment.setOrderId("fj-90");

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}
