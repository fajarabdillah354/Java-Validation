package jakarta.fajar;

import jakarta.fajar.group.PaymentGroups;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest{

    /**
     * Saat kita melakukan validasi dengan beberapa group, tidak ada jaminan bahwa sebuah group akan dijalankan sebelum group yang lain
     * Bean Validation memiliki annotation GroupSequence, ini digunakan untuk menentukan tahapan grup mana terlebih dahulu yang akan di validasi
     * Kita bisa membuat group baru, lalu tambahkan annotation @GroupSequence, atau langsung di class nya
     * Saat terjadi error validasi pada sebuah group, maka secara otomatis tidak akan dilanjutkan ke group selanjutnya
     */

    @Test
    void testGroupSeqeunce() {
        Payment payment = new Payment();
        //sekarang kita coba mengisi beberapa value dengan haparan membuat Group VirtualAccountPaymentError
        payment.setOrderId("Cs-001");
        payment.setAmount(50_000_000L);
        payment.setCreditCard("4111111111111111");



        validateWithGroup(payment, PaymentGroups.class);


    }
}
