/*
 * MegaMek - Copyright (C) 2000-2002 Ben Mazur (bmazur@sev.org)
 * 
 *  This program is free software; you can redistribute it and/or modify it 
 *  under the terms of the GNU General Public License as published by the Free 
 *  Software Foundation; either version 2 of the License, or (at your option) 
 *  any later version.
 * 
 *  This program is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 *  or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 *  for more details.
 */

package megamek.common;

public class PilotingRollData extends TargetRoll
{
    private boolean forSkid;
    private int entityId;
    private boolean m_bCumulative = true;
    
    public PilotingRollData(int entityId, int value, String desc) {
        super(value, desc);
        this.entityId = entityId;
	this.forSkid = false;
    }
    
    /**
     * Double-logging style for situations where the mech automatically falls,
     * but the pilot can still save to avoid damage.
     */
    public PilotingRollData(int entityId, int value, int pilotValue, String desc) {
        super(value, desc);
        addModifier(pilotValue, desc);
        this.entityId = entityId;
	this.forSkid = false;
    }

    /**
     * Record where a PSR is to avoid a skid.
     */
    public PilotingRollData(int entityId, int value, String desc, boolean isForSkid) {
        super(value, desc);
        this.entityId = entityId;
	this.forSkid = isForSkid;
    }

    public boolean isForSkid() { return this.forSkid; }
    
    public int getEntityId() {
        return entityId;
    }
    
    public void setCumulative(boolean b) {
        m_bCumulative = b;
    }
    
    public boolean isCumulative() {
        return m_bCumulative;
    }

}
