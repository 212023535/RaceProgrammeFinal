package RaceProgramme.domain;

import sun.security.provider.certpath.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/09/06.
 */
@Entity
public class Tracks implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackName;

    @Embedded
    private List<Classes> className;

    private Tracks(){}

    public Tracks(Builder builder)
    {
        this.id = builder.id;
        this.trackName = builder.trackName;
        this.className = builder.className;
    }

    //getters
    public Long getId() {
        return id;
    }

    public List<Classes> getClassName() {
        return className;
    }

    public String getTrackName() {
        return trackName;
    }

    public static class Builder
    {
        private Long id;
        private String trackName;
        private List<Classes> className;

        public Builder(String trackName)
        {
            this.trackName = trackName;
        }

        public Builder className(List<Classes> className)
        {
            this.className = className;
            return this;
        }

        public Builder trackName(String trackName)
        {
            this.trackName = trackName;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Tracks tracks)
        {
            this.id = tracks.id;
            this.className = tracks.className;
            this.trackName = tracks.trackName;

            return this;
        }

        public Tracks build() {return new Tracks(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tracks tracks = (Tracks) o;

        return id.equals(tracks.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "trackName='" + trackName + '\'' +
                ", className=" + className +
                '}';
    }
}
