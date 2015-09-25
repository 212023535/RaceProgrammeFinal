package RaceProgramme.conf.Factory;

import RaceProgramme.domain.Classes;
import RaceProgramme.domain.Schedule;

/**
 * Created by student on 2015/09/06.
 */
public class ScheduleFactory
{
    public static Schedule createSchedule(Long id,String time,Classes className)
    {
        Schedule schedule = new Schedule.Builder(id).className(className).time(time).build();

        return schedule;
    }
}
