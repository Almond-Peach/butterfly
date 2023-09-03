package com.almondpeach.butterfly.data;

import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {
    /**
     * Fills the {@link SystemPowerStatus} structure fields.
     *
     * @see <a href="https://learn.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getsystempowerstatus">GetSystemPowerStatus</a>
     */
    int getSystemPowerStatus(SystemPowerStatus result);
}
