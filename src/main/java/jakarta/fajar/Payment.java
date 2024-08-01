package jakarta.fajar;

import jakarta.fajar.constraints.CheckCase;
import jakarta.fajar.constraints.CheckOrderId;
import jakarta.fajar.enums.CaseMode;
import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import jakarta.fajar.payload.EmailErrorPayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    /** Message Interpolation
     * Message Interpolation merupakan proses membuat pesan error ketika terjadi kesalahan pada constraint
     * Secara default, pesan kesalahan akan diambil dari method message() milik constraint
     * Message Interpolation memiliki karakter spesial yaitu { dan }, oleh karena itu jika kita ingin menggunakan karakter tersebut, kita perlu tambahkan \ didepannya, misal \{ atau \}
     * Kadang ketika kita membuat pesan kesalahan, kita ingin  mengambil value dari constraint nya, kita bisa menambahkan {method} yang terdapat di constraint nya, secara otomatis nilai di constraint  akan ditambahkan ke message nya
     *
     */



    //pada java bean jika tidak ada group yang disebutkan maka akan kembali ke interface Default Group, kita bisa menambahkannya jika kita mau yaitu dengan menambahkan Default.class

    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.invalid}")
    private String orderId;

    //Setelah membuat interface sebagai grup kita bisa menambahkankannya kedalam annotation yang ada dengan kata kunci groups = namaGroupnya
    @NotNull(message = "amount must not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},min = 10_000L, max = 100_000_000L, message = "{amount.range}")
    private Long amount;

    @NotBlank(message = "credit card must not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class},message = "credit card must valid number", payload = EmailErrorPayload.class)
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can not blank")
    private String virtualAccount;

    /**
     * saat kita menggunakaan group ke class lain kita perlu lakukan convert ke class default pada Class yang ingin di validasi ini bertujuan validasi yang dilakukan di class tersebut bisa terbaca oleh class group yang dipilih

     */

    @Valid
    @NotNull(groups = {
            CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class
    },message = "costumer can not null")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Costumer costumer;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", costumer=" + costumer +
                '}';
    }
}
