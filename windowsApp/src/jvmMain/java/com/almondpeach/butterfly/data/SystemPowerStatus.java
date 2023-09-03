package com.almondpeach.butterfly.data;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// todo package nicely

/**
 * Contains information about the power status of the system.
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-system_power_status">SYSTEM_POWER_STATUS</a>
 */
public class SystemPowerStatus extends Structure {
    public byte acLineStatus;
    public byte batteryFlag;
    public byte batteryLifePercent;
    public byte systemStatusFlag;
    public int batteryLifeTime;
    public int batteryFullLifeTime;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "acLineStatus",
                "batteryFlag",
                "batteryLifePercent",
                "systemStatusFlag",
                "batteryLifeTime",
                "batteryFullLifeTime"
        );
    }
}
