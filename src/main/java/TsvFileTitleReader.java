import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private final File file;
    private TitleDeserializer deserializer;


    public TsvFileTitleReader(File file) {
        this.file = file;
        this.deserializer =  new TsvFileTitleDeserializer();
    }

    @Override
    public List<Title> read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            return getContent(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> getContent(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        String row;
        while((row = reader.readLine()) != null) titles.add(deserializer.deserialize(row));
        return titles;
    }

    public File getFile() {
        return file;
    }
}
