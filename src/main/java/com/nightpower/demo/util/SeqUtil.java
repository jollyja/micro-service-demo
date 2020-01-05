/**
 * 
 */
package com.nightpower.demo.util;

import java.util.UUID;

/**
 * @author jollyja
 *
 */
public class SeqUtil {
	
	public static String genSeq() {
		return UUID.randomUUID().toString();
	}
	
}
