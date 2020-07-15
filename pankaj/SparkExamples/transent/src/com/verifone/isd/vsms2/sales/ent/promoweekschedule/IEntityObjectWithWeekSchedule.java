/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.sales.ent.promoweekschedule;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author Bhanu_A1
 */
public interface IEntityObjectWithWeekSchedule extends IEntityObject {
    public void addItem(int dayOfWeek, PromoWeekSchedule item);
    public PromoWeekSchedule getWeeklyItem(int dayOfWeek);
    public PromoWeekSchedule[] getWeeklyItems();
    public void setWeeklyItems(PromoWeekSchedule[] promoWeekItems);
}
