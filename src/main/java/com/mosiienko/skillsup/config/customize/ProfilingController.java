package com.mosiienko.skillsup.config.customize;

/**
 * Class {@link ProfilingController
 * Controller for on/off profiling in real time for Java VisualVM
 * @author RomanMosiienko
 * @version 1.0
 * @since 07.12.15
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }
}
