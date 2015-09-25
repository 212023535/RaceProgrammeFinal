package RaceProgramme.services.Impl;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Tracks;
import RaceProgramme.repositories.TracksRepository;
import RaceProgramme.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public abstract class TracksImpl implements TrackService
{
    @Autowired
    TracksRepository repository;

    public List<Tracks> getTrack()
    {
        List<Tracks> allTracks = new ArrayList<Tracks>();

        Iterable<Tracks> tracks = repository.findAll();
        for(Tracks tr : tracks)
        {
            allTracks.add(tr);
        }
        return allTracks;
    }

    @Override
    public List<Classes> getClass(Long id)
    {
        return repository.findOne(id).getClassName();
    }
}
