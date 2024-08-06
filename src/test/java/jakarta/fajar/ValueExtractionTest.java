package jakarta.fajar;

import jakarta.fajar.container.Data;
import jakarta.fajar.container.EntryData;
import org.junit.jupiter.api.Test;

public class ValueExtractionTest extends AbstractValidatorTest{


    /** Value Extraction
     * Value Extraction merupakan proses melakukan ekstraksi nilai dari data jenis container (kumpulan data), sehingga nilai-nilai nya bisa di validasi
     * Sebelumnya sudah dijelaskan bahwa secara default Bean Validation mendukung value extraction terdapat data container yang ada di Java
     * Bagaimana jika kita misal menggunakan data container sendiri atau misal menggunakan library bukan bawaan Java? Maka secara otomatis Bean Validation tidak bisa melakukan ekstraksi nilai yang terdapat di container, perlu kita lakukan secara manual
     * Cara untuk memberi tahu Bean Validation cara melakukan ekstraksi, adalah dengan cara membuat ValueExtractor sendiri
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valueextraction/valueextractor
     */




    //single generic parameter
    @Test
    void testValueExtraction() {

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());

        sampleData.getData().setData(" ");



        validate(sampleData);


    }


    /** Multiple Generic Parameter Type
     * Secara default, saat kita membuat Value Extractor, annotation @ExtractedValue hanya bisa digunakan satu kali
     * Oleh karena itu, jika kita membuat container class generic yang menggunakan lebih dari satu generic parameter type, maka kita harus membuat Value Extractor nya sebanyak jumlah generic parameter type nya
     */


    //multiple generic parameter
    @Test
    void testSampleEntry() {
        SampleEntryData sampleEntryData = new SampleEntryData();
        sampleEntryData.setEntryData(new EntryData<>());
        sampleEntryData.getEntryData().setValue(" ");
        sampleEntryData.getEntryData().setKey(" ");

        validate(sampleEntryData);
    }
}
