package com.microdata.osmpservice.entity.model.oracle;

/**
 * Created by Longder on 2016/9/17.
 */
public class SessionInfo {
    /**
     * 总session
     */
    private Integer activeSession;
    /**
     * 活动的sesssion
     */
    private Integer inActiveSession;

    public Integer getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(Integer activeSession) {
        this.activeSession = activeSession;
    }

    public Integer getInActiveSession() {
        return inActiveSession;
    }

    public void setInActiveSession(Integer inActiveSession) {
        this.inActiveSession = inActiveSession;
    }
}
