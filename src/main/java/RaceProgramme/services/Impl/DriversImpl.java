package RaceProgramme.services.Impl;

import RaceProgramme.domain.Drivers;
import RaceProgramme.repositories.DriversRepository;
import RaceProgramme.services.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class DriversImpl implements DriversService
{
    @Autowired
    DriversRepository repository;

    public List<Drivers> getDrivers()
    {
        List<Drivers> allDrivers = new ArrayList<Drivers>();
        Iterable<Drivers> drivers = repository.findAll();

        for(Drivers drivers1 : drivers)
        {
            allDrivers.add(drivers1);
        }
        return allDrivers;
    }

}
