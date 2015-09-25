package RaceProgramme.services;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public interface ClassesService
{
    List<Classes> getClasses();
    List<Drivers> getDriver(Long id);
}
