import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("./src/main/resources/title.basics.tsv");
        TitleReader reader = new TsvFileTitleReader(file);
        List<Title> titles = reader.read();


        Map<Title.Genre, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            Title.Genre genre = (title.genre().isEmpty()) ? Title.Genre.Null : title.genre().getFirst();
            histogram.put(genre, histogram.getOrDefault(genre, 0) + 1);
        }

        System.out.println(histogram);

    }
}
