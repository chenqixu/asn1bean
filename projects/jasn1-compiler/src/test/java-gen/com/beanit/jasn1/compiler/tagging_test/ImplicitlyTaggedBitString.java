/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.tagging_test;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class ImplicitlyTaggedBitString extends BerBitString {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 33);

	public ImplicitlyTaggedBitString() {
	}

	public ImplicitlyTaggedBitString(byte[] code) {
		super(code);
	}

	public ImplicitlyTaggedBitString(byte[] value, int numBits) {
		super(value, numBits);
	}

	public ImplicitlyTaggedBitString(boolean[] value) {
		super(value);
	}

	@Override public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength;

		codeLength = super.encode(reverseOS, false);
		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;
	}

	@Override public int decode(InputStream is, boolean withTag) throws IOException {

		int codeLength = 0;

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += super.decode(is, false);

		return codeLength;
	}

}
