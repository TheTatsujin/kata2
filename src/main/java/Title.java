import java.util.List;

public record Title (String id, Type type, String name, String originalName, int releaseYear, List<Genre> genre){
    public enum Type {
        Short, Movie, TvSeries, TvMiniSeries, TvMovie, TvEpisode, TvPilot, TvSpecial, Video, TvShort, VideoGame, Null
    }
    public enum Genre {
        Action, Adult, Adventure, Animation, Biography, Comedy, Crime, Documentary, Drama, Family, Fantasy, FilmNoir, GameShow, genres, History, Horror, Music, Musical, Mystery, News, RealityTV, Romance, SciFi, Short, Sport, TalkShow, Thriller, War, Western, Null
    }

    @Override
    public String toString() {
        return "Title{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';
    }
}
