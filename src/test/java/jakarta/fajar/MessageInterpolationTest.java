package jakarta.fajar;

import jakarta.fajar.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest{


    /** Message Interpolation
     * Message Interpolation merupakan proses membuat pesan error ketika terjadi kesalahan pada constraint
     * Secara default, pesan kesalahan akan diambil dari method message() milik constraint
     * Message Interpolation memiliki karakter spesial yaitu { dan }, oleh karena itu jika kita ingin menggunakan karakter tersebut, kita perlu tambahkan \ didepannya, misal \{ atau \}
     * Kadang ketika kita membuat pesan kesalahan, kita ingin  mengambil value dari constraint nya, kita bisa menambahkan {method} yang terdapat di constraint nya, secara otomatis nilai di constraint  akan ditambahkan ke message nya
     *
     */


    /** Resource Bundle
     * Selain hardcode pesan di dalam method message(), Bean Validation juga mendukung resource bundle, dimana kita bisa menyimpan semua pesan kesalahan di file properties
     * Hal ini sangat bagus ketika kita butuh mendukung pesan kesalahan dengan beberapa bahasa
     * Caranya kita cukup buat file ValidationMessages.properties
     */


    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("CS-0000000021421421");
        payment.setAmount(12L);
        payment.setVirtualAccount("6124172154");
        Costumer costumer = new Costumer("fajardillah@gmail.com", "fajar abdillah ahmad");
        payment.setCostumer(costumer);



        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}
