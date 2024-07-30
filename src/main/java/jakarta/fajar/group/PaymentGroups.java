package jakarta.fajar.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;


/**
 * Dengan menggunakan GroupSequence kita bisa memilih urutan grop mana yang akan kita eksekusi terlebih dahulu
 * jika terjadi error akan urutan setelahnya tidak akan dieksekusi
 */

@GroupSequence(
        value = {
                Default.class,
                CreditCardPaymentGroup.class,
                VirtualAccountPaymentGroup.class
        }
)
public interface PaymentGroups {
}
