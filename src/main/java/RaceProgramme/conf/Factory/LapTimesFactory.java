package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Drivers;
import RaceProgramme.domain.LapTimes;

/**
 * Created by student on 2015/09/06.
 */
public class LapTimesFactory
{
    public static LapTimes createLapTimes(Long id,String lapTime,Drivers driverName,Drivers vehicle,Classes className)
    {
        LapTimes lapTimes = new LapTimes.Builder(id).lapTime(lapTime).driverName(driverName).vehicle(vehicle).className(className)
                                    .build();

        return lapTimes;
    }
}
