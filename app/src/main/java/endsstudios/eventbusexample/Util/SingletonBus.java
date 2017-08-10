package endsstudios.eventbusexample.Util;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by MEHMET on 9.08.2017.
 */

public class SingletonBus {

    private static EventBus eventBus;

    public static EventBus getBus() {
        if (eventBus == null)
            eventBus = EventBus.getDefault();
        return eventBus;
    }

}
