package RaceProgramme.services.Impl;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.repositories.ClassesRepository;
import RaceProgramme.services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@Service
public class ClassesImpl implements ClassesService
{
    @Autowired
    ClassesRepository repository;
    public List<Classes> getClasses()
    {
        List<Classes> allClasses = new ArrayList<Classes>();

        Iterable<Classes> classes = repository.findAll();
        for(Classes classes1 : classes)
        {
            allClasses.add(classes1);
        }
        return allClasses;
    }

    @Override
    public List<Drivers> getDriver(Long id)
    {
        return repository.findOne(id).getDrivers();
    }
}
