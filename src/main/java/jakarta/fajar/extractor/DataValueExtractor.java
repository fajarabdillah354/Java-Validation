package jakarta.fajar.extractor;

import jakarta.fajar.container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {//INI UNTUK EXTRACTORNYA,harus menggunakan @ExtractedValue

    @Override
    public void extractValues(Data<?> data, ValueReceiver valueReceiver) {
        Object getData = data.getData();//mengambil data
        valueReceiver.value(null, getData);//menerima data
    }
}
