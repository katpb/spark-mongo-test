/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz alpha version
 * Created June 26, 2003                                      David C. Brown
 *
 * This is the abstract class for the transaction visitor.  Any implementation
 * of this class will be able to construct a representation of the transaction
 * with at least as much information as a printed receipt.
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * By using overloads of the common visit method the visitor can accumulate
 * transaction totals and payments applied against the balance due for a ticket.
 * It is up to a given visitor implementation to decide what to do with the
 * accumulated values and values it obtains during any entity it visits -- sum,
 * render in XML, etc.
 *
 * Almost every method will throw the general Exception class.  This is because
 * a visitor implementation will encounter exceptions unique to it -- Jpos for
 * a receipt printer visitor, SAX for an XML serializer visitor, etc.  The only
 * common class for these is <code>Exception</code>.
 *
 * @author	David C. Brown
 * @version	1.0
 */

public abstract class TransactionVisitor {

    public void visit(ITransaction trans) throws Exception {
    }
    
	/**
	 * Most likely the bulk of the work happens here.  Either cycle through
	 * elements in an array (ItemLines, PaymentLines, etc) or collect grand
	 * totals.
	 *
	 * @param		trans
	 * @exception	Exception;
	 */

	public void visit(Transaction trans) throws Exception {
    }
    
    public void visit(TillAdjustment tadj) throws Exception {}

	/**
	 * Object being visited is actually a FuelItemLine so do more specific
	 * processing -- grade & price/gal come to mind.
	 *
	 * @param		fuel
	 * @exception	Exception
	 */

	public abstract void visit(FuelItemLine fuel) throws Exception ;

        /**
	 * Object being visited is actually a PrepayItemLine so do more specific
	 * processing -- grade & price/gal come to mind.
	 *
	 * @param		fuel
	 * @exception	Exception
	 */

	public abstract void visit(PrepayItemLine fuel) throws Exception ;
        
	/**
	 * For receipt printing there isn't a need for this, ItemLine is enough.
	 * Perhaps for XML serializers or some future visitor we want to know the
	 * exact data type?
	 *
	 * @param		plu
	 * @exception	Exception
	 */

	public abstract void visit(PluItemLine plu) throws Exception ;
	
	/**
	 * This for the printing of special discount item lines.
	 * @param specialDiscountItemLine
	 * @throws Exception
	 */
	
	public void visit(SpecialDiscountItemLine specialDiscountItemLine) throws Exception {
    }


	/**
	 * Most generic method for receipt line item printing.  Description, qty
	 * and total price are all available here.  Tax flags too.
	 *
	 * @param		il
	 * @exception	Exception
	 */

	public abstract void visit(SimpleItemLine il) throws Exception ;
    
	/**
	 * Most generic method for receipt line item printing.  Description, qty
	 * and total price are all available here.  Tax flags too.
	 *
	 * @param		il
	 * @exception	Exception
	 */

	public abstract void visit(ItemLine il) throws Exception ;

	/**
	 * Specific credit processing -- approval number, etc.
	 *
	 * @param		pay
	 * @exception	Exception
	 */

	public abstract void visit(CreditPaymentLine pay) throws Exception ;

	/**
	 * General pay line info, totals are available from Transaction entity
	 * itself.
	 *
	 * @param		pay
	 * @exception	Exception
	 */

	public abstract void visit(PaymentLine pay) throws Exception ;

	/**
	 * More useful to serializer visitor implementations.
	 *
	 * @param		cl
	 * @exception	Exception
	 */

	public abstract void visit(ChangeLine cl) throws Exception ;

	/**
	 * Again, totals will be better accessed elsewhere for receipt printing,
	 * but serializer visitors may find this method helpful.
	 *
	 * @param		txl
	 * @exception	Exception
	 */

	public abstract void visit(TaxLine txl) throws Exception ;
        
        /**
	 * Visitor for credit card related information stored within the transaction
	 *
	 * @param      netInfo
	 * @exception	Exception
	 */

	public abstract void visit(NetPayInfo netInfo) throws Exception ;
        
        /**
	 * Visitor for SVC activation related information stored within the transaction
	 *
	 * @param       svcInfo
	 * @exception	Exception
	 */

	public abstract void visit(SvcActInfo svcInfo) throws Exception ;
        
         /**
	 * Visitor for PrePaidInfo related information stored within the transaction
	 *
	 * @param      prePaidInfo
	 * @exception	Exception
	 */

	public abstract void visit(PrePaidInfo prePaidInfo) throws Exception ;



        /**
	 * Visitor for Electronic Check n related information stored within the transaction
	 *
	 * @param       ECheckInfo
	 * @return      void
	 * @exception	Exception
	 */

	public abstract void visit(ECheckInfo eCheckInfo) throws Exception ;
	
    /**
	 * Visitor for Third Party Product Provier related information stored within the transaction
	 *
	 * @param       svcInfo
	 * @exception	Exception
	 */

	public abstract void visit(TpppVoucherInfo tpppVoucherInfo) throws Exception ;

}
