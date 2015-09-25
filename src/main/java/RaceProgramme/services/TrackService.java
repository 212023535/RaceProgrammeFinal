package RaceProgramme.services;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Tracks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public interface TrackService
{
    List<Tracks> getTrack(Long id);
    List<Classes> getClass(Long id);
}
