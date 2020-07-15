/*
 * ITransactionListener.java
 *
 * Created on June 26, 2003, 12:12 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Interface to be used by listeners to get notified on any change in the
 * transaction entity object graph
 * @author Bhanu_N2
 */
public interface ITransactionListener extends java.util.EventListener {
    /**
     * Callback method to notify of addition/ removal of payment line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedPmt the payment line that is being added/ removed
     * @throws PaymentLineException if the change is not allowed
     */
    public void notifyPaymentLineChange(final TransOperation operation,
            PaymentLine modifiedPmt) throws PaymentLineException;

    /**
     * Callback method to notify of addition/ removal of change line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedChg the change line that is being added/ removed
     */
    public void notifyChangeLineChange(final TransOperation operation,
            ChangeLine modifiedChg);

    /**
     * Callback method to notify of addition/ removal of item line
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedLine the item line that is being added/ removed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine modifiedLine);

    /**
     * Callback method to notify of addition/ removal of item lines
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modifiedLines the items line that are being added/ removed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine[] modifiedLines);

    /**
     * Callback method to notify of addition/ removal of item line
     * @param operation TransOperation.ADDITION, TransOperation.MODIFICATION or
     *        TransOperation.REMOVAL
     * @param modifiedLine the item line that is being added/ removed
     * @throws ItemLineException if the change is not allowed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine modifiedLine, ItemLine originalLine)
            throws ItemLineException;

    /**
     * Callback method to notify of addition/ removal of item lines
     * @param operation TransOperation.ADDITION, TransOperation.MODIFICATION or
     *        TransOperation.REMOVAL
     * @param modifiedLines the item lines that are being added/ removed
     * @param originalLines the item lines before being added/ removed
     */
    public void notifyItemLineChange(final TransOperation operation,
            ItemLine[] modifiedLines, ItemLine[] originalLines);

    /**
     * Callback method to notify of addition/ removal of sub items
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param modCompositeItem the modified composite ItemLine
     * @param origCompositeItem the original composite ItemLine
     * @param subItem the sub item being added/ removed
     */
    public void notifySubItemChange(final TransOperation operation,
            ItemLine modCompositeItem, ItemLine origCompositeItem, ItemLine subItem);

	/**
     * Callback method to notify of addition/ removal of discount on the transaction
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param discountInfo the discount that is being added/ removed
     */
    public void notifyTransactionDiscountChange(final TransOperation operation,
            DiscountInfo discountInfo);
    
    /**
     * Callback method to notify of addition/ removal of deal on the transaction
     * @param operation TransOperation.ADDITION or TransOperation.REMOVAL
     * @param dealInfo the discount that is being added/ removed
     */
    public void notifyTransactionDealChange(final TransOperation operation,
            DealInfo dealInfo);
}
