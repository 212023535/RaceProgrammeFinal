package RaceProgramme.model;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Tracks;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/06.
 */
public class TracksResource extends ResourceSupport
{
    private Long id;
    private String trackName;
    private Classes className;
    private Classes classes;

    private TracksResource(){}

    private TracksResource(Builder builder)
    {
        this.id = builder.id;
        this.trackName = builder.trackName;
        this.className = builder.className;
        this.classes = builder.classes;
    }

    public String getTrackName() {
        return trackName;
    }

    public Classes getClassName() {
        return className;
    }

    public Classes getClasses() {
        return classes;
    }

    public static class Builder
    {
        private Long id;
        private String trackName;
        private Classes className;
        private Classes classes;

        public Builder(String trackName)
        {
            this.trackName = trackName;
        }

        public Builder className(Classes className)
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

        public Builder classes(Classes classes)
        {
            this.classes = classes;
            return this;
        }

        public Builder copy(TracksResource tracksR)
        {
            this.id = tracksR.id;
            this.className = tracksR.className;
            this.trackName = tracksR.trackName;
            this.classes = tracksR.classes;

            return this;
        }

        public TracksResource build() {return new TracksResource(this);}
    }
}
