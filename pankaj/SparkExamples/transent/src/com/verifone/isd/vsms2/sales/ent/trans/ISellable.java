/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha version
 * Created August 20, 2003                                    David C. Brown
 *
 * Define the ISellable interface.  Implementing classes can count on a
 * way to access Category, Fee and Tax entities, a way to populate the
 * Department entity and the ability to validate the composition of objects.
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Iterator;

import com.verifone.isd.vsms2.sales.ent.category.Category;
import com.verifone.isd.vsms2.sales.ent.dept.Department;
import com.verifone.isd.vsms2.sales.ent.fee.Fee;
import com.verifone.isd.vsms2.sales.ent.tax.Tax;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Define the field operators that will sell a Department item, establish
 * the validity of the objects involved in that sale, and collect the
 * references to all such objects in one place.  Helper functions set the
 * price, compute fees, etc.
 *
 * <B>NOTE:</B> This class is not intended to be serialized.  It should
 * be treated as transient for any classes within this package because it
 * is somewhat heavyweight -- keeping instances of IEntityObject internally.
 * The intention is to save database lookups during the life of a transaction
 * WITHIN a given JVM.
 *
 *
 */

public interface ISellable {

	/**
	 * Accessor for ItemLine, no restrictions are place on access
	 * before Entity has been validated.
	 *
	 * @return	ItemLine
	 */

	public ItemLine getItemLine();

	/**
	 * Convenience overload that sets all the item line fields
	 * based on department, etc.
	 *
	 * @param	il
	 */

	public void setItemLine(ItemLine il);

	/**
	 * Mutator for ItemLine, no restrictions are place on access
	 * before Entity has been validated.  Will copy name from department,
	 * and set other fields.
	 *
	 * @param il
	 * @param copy boolean to copy or not
	 */

	public void setItemLine(ItemLine il, boolean copy);

	/**
	 * Accessor for Category, no restrictions are place on access
	 * before Entity has been validated.
	 *
	 * <B>NOTE</B> null entries are valid
	 *
	 * @return	Category
	 */

	public Category getCategory();

	/**
	 * Accessor for Department, no restrictions are place on access
	 * before Entity has been validated.
	 *
	 * @return	Department
	 */

	public Department getDepartment();

	/**
	 * Accessor for Fee array, no restrictions are place on access
	 * before Entity has been validated.
	 *
	 * <B>NOTE</B> null entries are valid
	 *
	 * @return	Fee[]
	 */

	public Fee[] getFees();


	/**
	 * Accessor for Tax array, no restrictions are placed on access
	 * before Entity has been validated.
	 *
	 * <B>NOTE</B> Any taxes not applicable will have null entries
	 * in the array.
	 *
	 * @return	Tax[]
	 */

	public Tax[] getTaxes();

	/**
	 * Don't load the tax values or tax inidicator from defining entity object
	 *
	 * @param	exemptTaxes
	 */

	public void setExemptTaxes(TaxPK[] exemptTaxes);

	/**
	 * Report the settings of the tax exempt flag.
	 *
	 * @return	boolean
	 */

	public TaxPK[] getExemptTaxes();

	/**
	 * Change this item into a void line sale.
	 *
	 */

	public void setAsVoid();

	/**
	 * Change this item from a void line sale.
	 *
	 */

	public void unSetAsVoid();

	/**
	 * Report whether this item is considered void.
	 *
	 * @return	boolean
	 */

	public boolean isVoidItem();

	/**
	 * Mark this as "taken" and keep a reference to the line that voids
	 * this object.  If this object is already set as a void don't allow
	 * another void to claim it.  If this object already has a reference
	 * to a line that claims it do not allow a new assigment, only allow
	 * the reference to be cleared -- set to null.  This allows the last
	 * void line added to clean up with <ERROR CORR>.
	 *
	 * <B>NOTE:</B> This method does not bother to make sure the reference
	 * it points to has been cleared if <code>vis</code> is null.
	 *
	 * @param	vis
	 * @return	boolean
	 */

	public boolean setVoidingISellable(ISellable vis);

	/**
	 * Lets another entity see if this object is already claimed by a
	 * void line.
	 *
	 * @return	ISellable
	 */

	public ISellable getVoidingISellable();

	/**
	 * Save a reference to the object voided by this object.  Do not allow
	 * direct reassignment -- this object can be set to null first and then
	 * set again, but even that has little practical application.
	 *
	 * <B>NOTE:</B> This method does not bother to make sure the reference
	 * it points to has been cleared if <code>vis</code> is null.
	 *
	 * @param	vis
	 * @return	boolean
	 */

	public boolean setVoidedISellable(ISellable vis);

	/**
	 * Lets another entity see if this object claims another as part of
	 * a void.  This lets the caller tell the claimed object it is no
	 * longer claimed if the voiding line is removed.
	 *
	 * @return	ISellable
	 */

	public ISellable getVoidedISellable();

	/**
	 * Compare the item line with the internal copy and if enough fields are
	 * equivilant to be identical transactions return true.  Useful for void
	 * line functions.  Returns false if the classes are different.
	 *
	 * @param	il2
	 * @return	boolean
	 */

	public boolean equalItemLine(ISellable il2);

	/**
	 * Validate entity by checking all references to other entity objects
	 * are valid, and the fields have been populated by the appropriate
	 * admin.
	 *
	 * <B>NOTE:</B> Price is <B>NOT</B> calculated/updated.
	 *
	 * @return	boolean
	 */

	public boolean validate();

	/**
	 * Recompute the price to allow methods that change taxable or discount
	 * fields within the ItemLine to take effect.  If the state of this entity
	 * is <code>!valid</code> we simply return a null amount.  Otherwise we
	 * update all the <code>MoneyAmount</code> fields as well as the normalized
	 * <code>long</code> fields within the object and return.
	 *
	 * <B>NOTE</B> no price is computed and null is returned if this entity
	 * is not in a valid state
	 *
	 * @return	MoneyAmount
	 */

	public MoneyAmount calcPrice();

	/**
	 * It is anticipated that the converson to/from MoneyAmount will be
	 * bypassed at certain iternal levels for tax comp. etc.  Presently
	 * 6 decimal places provide enough guard digits for any primary
	 * currency and that is the format this method utilizes.
	 *
	 * @return	long
	 */

	public long calcNormalizedPrice();

	/**
	 * To finally make the item sellable we must know the quantity and
	 * price.  If at4amt == 0 then it is not figured into calculations.
	 * calcPrice() is automatically called.  If <code>valid</valid> is
	 * not set we try and validate.  If that fails we return.
	 *
	 * @param	price
	 * @param	qty
	 * @param	at4amt
	 * @return	boolean
	 */

	public boolean setSaleData(MoneyAmount price, long qty, long at4amt);

    /**
     * Returns the status of the ID check test.
     *
     * @return  boolean
     */

    public boolean custWasTooYoung();

	/**
	 * Notifies object that any internal fields concerning the base selling
	 * price have changed.  It will update such fields.  The old price is
	 * returned.
	 *
	 * <B>NOTE:</B> The call to <code>calcPrice()</code> must still be done
	 * to update fees, etc.
	 *
	 * @param	newprice
	 * @return	MoneyAmount
	 */

	public MoneyAmount setNewPrice(MoneyAmount newprice);

	/**
	 * Expose the blue law iterator for whatever IEntityPK this subclass
	 * of ISellable contains -- SimpleItemLine and PluItemLine don't have a
	 * common parent that lets us do this easily.
	 *
	 * @return	Iterator
	 */

	public Iterator getBlueLaws();

	/**
	 * Expose the age validation iterator for whatever IEntityPK this subclass
	 * of ISellable contains -- SimpleItemLine and PluItemLine don't have a
	 * common parent that lets us do this easily.
	 *
	 * @return	Iterator
	 */

	public Iterator getAgeValidations();

	/**
	 * Expose the PK as a string, because IEntityPK offers no such method
	 * and we don't want to apply reflection upon it just to write an error
	 * message or log entry.
	 *
	 * @return	String
	 */

	public String getPKasString();

	/**
	 * If recalling a refund, entity objects contained by this object may
	 * not be allowed.  The RestoreVisitor must set this field since the
	 * normal setting via addToTransModel() won't be called and there's no
	 * other way for this entity to know it's part of a refund.
	 *
	 * @param	refund a boolean
	 */

	public void setRefundTrans(boolean refund);

	/**
	 * Allows inspection of the transaction mode this entity thinks it's in.
	 *
	 * @return	boolean
	 */

	public boolean getRefundTrans();
}
