package jakarta.fajar;

import jakarta.fajar.container.EntryData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SampleEntryData {

    @NotNull
    private EntryData<@NotBlank String, @NotBlank String> entryData;

    public EntryData<String, String> getEntryData() {
        return entryData;
    }

    public void setEntryData(EntryData<String, String> entryData) {
        this.entryData = entryData;
    }
}
