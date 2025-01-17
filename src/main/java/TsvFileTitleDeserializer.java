import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String titleTableRow) {
        return deserialize(titleTableRow.split("\t"));
    }

    private Title deserialize(String[] row) {
        return new Title(
                row[0], // ID
                getType(row[1]), // TYPE
                row[2], // Name
                row[3], // OriginalName
                getYear(row[5]), // Year
                getGenres(row[8]) // Genres
        );
    }

    private List<Title.Genre> getGenres(String genresField) {
        if (isNullField(genresField)) return new ArrayList<>();
        List<Title.Genre> genres = new ArrayList<>();
        for (String genre : genresField.split(",")) {
            genres.add(Title.Genre.valueOf(convertToGenreName(genre)));
        }
        return genres;
    }

    private String convertToGenreName(String genre) {
        return genre.replaceAll("-", "");
    }

    private int getYear(String yearField) {
        if (isNullField(yearField)) return -1;
        return Integer.parseInt(yearField);
    }

    private Title.Type getType(String typeField) {
        if (isNullField(typeField)) return Title.Type.Null;
        return Title.Type.valueOf(convertToTypeName(typeField));
    }

    private String convertToTypeName(String typeField) {
        return String.valueOf(typeField.charAt(0)).toUpperCase() + typeField.substring(1);
    }

    private boolean isNullField(String field) {
        return field.equals("\\N");
    }


}
