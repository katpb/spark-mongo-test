/*
 * EntityVisitor.java
 * Created by: JoswillP1
 *
 * COPYRIGHT (c) 2018 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sales.ent;

/**
 *
 * @author JoswillP1
 */
public interface IEntityVisitor<V> {
	public void visit(V v) throws Exception;
}
