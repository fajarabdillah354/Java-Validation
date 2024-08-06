package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class CustomConstraintTest extends AbstractValidatorTest{

    /** Custom Constraint
     * Sampai saat ini, kita hanya menggunakan Constraint Built-In yang terdapat di Bean Validation dan Hibernate Validator
     * Bagaimana jika ternyata Constraint Built-In tersebut tidak bisa memenuhi kebutuhan validasi kita?
     * Maka kita bisa membuat Constraint sendiri, atau istilahnya Custom Constraint
     * Untuk membuat Constraint, kita perlu mengikuti aturan nya, pertama kita buat Constraint Annotation, lalu kita buat ConstraintValidator
     */


    /** Misal Check Case Constraint
     * Misal, sekarang kita akan membuat sebuah constraint validation yang digunakan untuk melakukan pengecekan case sebuah string
     * Agar dinamis, kita akan tambahkan method mode() nya di constraint, yang bisa dipilih apakah harus UPPER atau lower
     */

    @Test
    void testUpper() {
        Locale.setDefault(new Locale("in","ID"));//penggunaan I18N dengan Class Locale


        Payment payment = new Payment();
        payment.setOrderId("fj-90");

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }
}
