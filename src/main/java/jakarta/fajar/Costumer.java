package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public class Costumer {

    //saat kita tidk menambahkan group maka default nya class Default, sehingga jika kita ingin menambahkan validasi ke class kita perlu melakukan convert apabila ada class lain yang menggunakan class ini dengan menambahkan @ConvertGroup(from=,to=)

    //contoh di class Payment ada variaabel yang menggunakan class ini jadi kita perlu lakukan convert disana


    @Email(message = "email must valid format")
    @NotBlank(message = "email can not blank")
    private String email;

    @NotBlank(message = "name can not blank")
    private String name;

    public Costumer(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
