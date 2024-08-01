package jakarta.fajar;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {
    /**Contraint
     * Constraint merupakan Annotation yang digunakan sebagai penanda untuk target yang kita tambahkan (misal Field, Method, dan lain-lain)
     * Bean Validation sudah menyediakan banyak sekali Constraint yang bisa langsung kita  gunakan
     * Jika kita butuh validasi yang berbeda, kita juga bisa membuat constraint secara manual, yang akan kita bahas nanti di chapter tersendiri
     * Semua Constraint di Bean Validation terdapat di package jakarta.validation.constrains
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html
     */


    //Dengan constaint ini kita akan melakukan validation, tidak menggunakan if-else lagi
    @Size(max = 20,message = "firstName length max must 20 char")
    @NotBlank(message = "firstName can't Not Blank")
    private String firstName;

    @Size(max = 20, message = "lastName length max must 20 char")
    @NotBlank(message = "lastName can't Not Blank")
    private String lastName;

    //dibawah ini adalah contoh penambahan field yang tipenya Object agar bisa tervalidasi kita harus menambahkan Contraint @Valid diatas field yang bertipe Object
    @NotNull(message = "address can not null")
    @Valid
    private Address address;//variable address dengan tipe Object Class Address


    @Valid
//    @NotBlank(message = "hobby can not blank")//disini adalah contoh yang salah karna List<> tidak bisa ditambahkan constraint NotBlank(), NotBlank() hanya untuk string saja
    private List<@NotBlank(message = "hoby can not blank") String> hobbies; //yang benar adalah contraintnya ditambahkan ke dalam generic typenya


    @Valid
    public Person() {
    }

    @Valid
    public Person(@NotBlank(message = "first name can not blank") String firstName,
                  @NotBlank(message = "last name can not blank")String lastName,
                  @NotNull(message = "address can not null")@Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String   toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }

    //DIBAWAH INI ADALAH CONTOH PENGGUNAAAN DARI METHOD VALIDATION, yaitu kita dapat menambahkan validation dalam parameternya
    public void sayHello(@NotBlank(message = "name must not blank") String name){
        System.out.println("hello "+name+" , my name is "+firstName);
    }

    @NotBlank(message = "fullname Can not Blank")
    public String fullName(){
        return firstName + lastName;
    }


}
