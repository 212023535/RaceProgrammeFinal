package RaceProgramme.domain;

import RaceProgramme.conf.Factory.TracksFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2015/09/11.
 */
public class TrackTest
{
    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testCreateTrack() throws Exception
    {
        List<Classes> classList = new ArrayList();

        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").build();
        classList.add(classes);
        Tracks track = new TracksFactory().createTrack("Killarney Motor Racing Complex",classList);
        Assert.assertEquals("Killarney Motor Racing Complex",track.getTrackName());
    }

    @Test
    public void testUpdateTrack() throws Exception
    {
        List<Classes> classList = new ArrayList();

        Classes classes = new Classes.Builder("S&GT").className("Sports & GT").build();
        classList.add(classes);

        Tracks track = new TracksFactory().createTrack("Killarney Motor Racing Complex",classList);

        Tracks track2 = new Tracks.Builder(track.getTrackName()).copy(track).trackName("Kyalami GP Circuit").build();

        Assert.assertEquals("Killarney Motor Racing Complex",track.getTrackName());
        Assert.assertEquals("Kyalami GP Circuit",track2.getTrackName());
    }
}
