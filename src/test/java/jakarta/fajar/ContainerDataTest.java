package jakarta.fajar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerDataTest extends AbstractValidatorTest{

    /** Container Data
     * Saat kita membuat class, kadang sering kita gunakan tipe data container, seperti misalnya Optional, Collection, List, Set, Map dan lain-lain
     * Secara default, jika kita isi data tersebut dengan data Object, misal @Valid List<Address>, maka secara otomatis Bean Validation akan melakukan validasi semua data object Address sesuai dengan constraint yang ada di dalam class Address
     * Tapi bagaimana jika kita memiliki misal field List<String>, atau Map<String, String>, bagaimana melakukan validasinya? Misal kita ingin semua data string di List tidak boleh kosong
     * Untungnya, Bean Validation mendukung validasi terhadap data container seperti ini
     */


    @Test
    void testContainerData() {
        Person person = new Person();

        person.setFirstName("fajar");
        person.setLastName("ahmad");
        person.setAddress(new Address());
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setCity("Jakarta");
        person.getAddress().setStreet("Duren Sawit");

        /** Validate Container Data
         * Untuk melakukan validasi data jenis container, Bean Validation membutuhkan yang namanya Value Extractor
         * Value Extractor ini menjadikan Bean Validation bisa melakukan ekstraksi data dari container
         * Secara default, Bean Validation mendukung semua data container yang tersedia di Java, seperti Optional, Collection, List, Iterable, Set dan Map
         * Yang kita butuhkan, hanya dengan menambahkan Constraint pada generic type container tersebut
         */

        person.setHobbies(new ArrayList<>());//NotBlank() harus di level generic typenya untuk menvaalidasi container data
        person.getHobbies().add("renang");
        person.getHobbies().add("");//disini akan tampil error validasinya dimana hobby NotBlank()
        person.getHobbies().add("main bola");

        validate(person);



    }
}
