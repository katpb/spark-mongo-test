/*
 * TransListenerAdapter.java
 *
 * Created on June 26, 2003, 12:50 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Adapter class that provides default no-op implementation methods for the
 * ITransactionListener interface.
 * @author Bhanu_N2
 */
public class TransListenerAdapter implements ITransactionListener {

    /** Creates a new instance of TransListenerAdapter */
    public TransListenerAdapter() {
    }

    /**
     * Callback method to notify of addition/ removal of item line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedLine the item line that is being added/ removed
     */
    public void notifyItemLineChange(TransOperation operation,
            ItemLine modifiedLine) {
    }

    /**
     * Callback method to notify of addition/ removal of several item lines
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedLines the item lines that are being added/ removed
     */
    public void notifyItemLineChange(TransOperation operation,
            ItemLine[] modifiedLines) {
    }

    /**
     * Callback method to notify of addition/ removal of item line
     * @param operation TransOperation.ADDITION, TransOperation.MODIFICATION or
     *        TransOperation.REMOVAL
     * @param modifiedLine the item line that is being added/ removed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine modifiedLine, ItemLine originalLine)
            throws ItemLineException {
    }

    /**
     * Callback method to notify of addition/ removal of several item lines
     * @param operation TransOperation.ADDITION, TransOperation.MODIFICATION or
     *        TransOperation.REMOVAL
     * @param modifiedLines the item lines that are being added/ removed
     * @param originalLines the item lines before being added/ removed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine[] modifiedLines, ItemLine[] originalLines) {
    }

    /**
     * Callback method to notify of addition/ removal of payment line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedPmt the payment line that is being added/ removed
     */

    public void notifyPaymentLineChange(TransOperation operation,
            PaymentLine modifiedPmt) throws PaymentLineException {
    }

    /**
     * Callback method to notify of addition/ removal of change line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedChg the change line that is being added/ removed
     */
    public void notifyChangeLineChange(TransOperation operation,
            ChangeLine modifiedChg) {
    }

    public void notifySubItemChange(final TransOperation operation,
            ItemLine modCompositeItem, ItemLine origCompositeItem, ItemLine subItem) {
    }

	public void notifyTransactionDiscountChange(final TransOperation operation,
            DiscountInfo discountInfo) {
    }
	
	public void notifyTransactionDealChange(final TransOperation operation,
            DealInfo dealInfo) {
    }
}
