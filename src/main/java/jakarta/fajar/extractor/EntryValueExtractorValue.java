package jakarta.fajar.extractor;

import jakarta.fajar.container.EntryData;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

// contoh membuat valueExtractor pada multiple generic

//ini adalah bagian ValueExtractor untuk field value pada class EntryData

public class EntryValueExtractorValue implements ValueExtractor<EntryData<?, @ExtractedValue ?>> {

    @Override
    public void extractValues(EntryData<?, ?> entryData, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "value", entryData.getKey());
    }
}
