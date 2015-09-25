package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.domain.Tracks;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/09/06.
 */
public class ClassesFactory
{
    public static Classes createClass(Map<String, String> value)
    {
        Classes classes = new Classes.Builder(value.get("ClassCode")).className(value.get("className")).build();

        return classes;
    }
}
