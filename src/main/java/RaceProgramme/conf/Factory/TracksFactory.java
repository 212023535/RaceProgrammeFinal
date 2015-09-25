package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Tracks;

import java.util.List;

/**
 * Created by student on 2015/09/06.
 */
public class TracksFactory
{
    public static Tracks createTrack(String trackName,List<Classes> classes)
    {
        Tracks tracks = new Tracks.Builder(trackName).className(classes).build();

        return tracks;
    }
}
