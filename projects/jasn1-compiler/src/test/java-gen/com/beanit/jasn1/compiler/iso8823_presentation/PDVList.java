/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.iso8823_presentation;

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


public class PDVList implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class PresentationDataValues implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public byte[] code = null;
		public BerAny singleASN1Type = null;
		public BerOctetString octetAligned = null;
		public BerBitString arbitrary = null;
		
		public PresentationDataValues() {
		}

		public PresentationDataValues(byte[] code) {
			this.code = code;
		}

		public PresentationDataValues(BerAny singleASN1Type, BerOctetString octetAligned, BerBitString arbitrary) {
			this.singleASN1Type = singleASN1Type;
			this.octetAligned = octetAligned;
			this.arbitrary = arbitrary;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					reverseOS.write(code[i]);
				}
				return code.length;
			}

			int codeLength = 0;
			int sublength;

			if (arbitrary != null) {
				codeLength += arbitrary.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				reverseOS.write(0x82);
				codeLength += 1;
				return codeLength;
			}
			
			if (octetAligned != null) {
				codeLength += octetAligned.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				reverseOS.write(0x81);
				codeLength += 1;
				return codeLength;
			}
			
			if (singleASN1Type != null) {
				sublength = singleASN1Type.encode(reverseOS);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(reverseOS, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
				reverseOS.write(0xA0);
				codeLength += 1;
				return codeLength;
			}
			
			throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, null);
		}

		public int decode(InputStream is, BerTag berTag) throws IOException {

			int tlvByteCount = 0;
			boolean tagWasPassed = (berTag != null);

			if (berTag == null) {
				berTag = new BerTag();
				tlvByteCount += berTag.decode(is);
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				BerLength explicitTagLength = new BerLength();
				tlvByteCount += explicitTagLength.decode(is);
				singleASN1Type = new BerAny();
				tlvByteCount += singleASN1Type.decode(is, null);
				tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				octetAligned = new BerOctetString();
				tlvByteCount += octetAligned.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
				arbitrary = new BerBitString();
				tlvByteCount += arbitrary.decode(is, false);
				return tlvByteCount;
			}

			if (tagWasPassed) {
				return 0;
			}

			throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			if (singleASN1Type != null) {
				sb.append("singleASN1Type: ").append(singleASN1Type);
				return;
			}

			if (octetAligned != null) {
				sb.append("octetAligned: ").append(octetAligned);
				return;
			}

			if (arbitrary != null) {
				sb.append("arbitrary: ").append(arbitrary);
				return;
			}

			sb.append("<none>");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public TransferSyntaxName transferSyntaxName = null;
	public PresentationContextIdentifier presentationContextIdentifier = null;
	public PresentationDataValues presentationDataValues = null;
	
	public PDVList() {
	}

	public PDVList(byte[] code) {
		this.code = code;
	}

	public PDVList(TransferSyntaxName transferSyntaxName, PresentationContextIdentifier presentationContextIdentifier, PresentationDataValues presentationDataValues) {
		this.transferSyntaxName = transferSyntaxName;
		this.presentationContextIdentifier = presentationContextIdentifier;
		this.presentationDataValues = presentationDataValues;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += presentationDataValues.encode(reverseOS);
		
		codeLength += presentationContextIdentifier.encode(reverseOS, true);
		
		if (transferSyntaxName != null) {
			codeLength += transferSyntaxName.encode(reverseOS, true);
		}
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(TransferSyntaxName.tag)) {
			transferSyntaxName = new TransferSyntaxName();
			vByteCount += transferSyntaxName.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(PresentationContextIdentifier.tag)) {
			presentationContextIdentifier = new PresentationContextIdentifier();
			vByteCount += presentationContextIdentifier.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		presentationDataValues = new PresentationDataValues();
		numDecodedBytes = presentationDataValues.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (transferSyntaxName != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transferSyntaxName: ").append(transferSyntaxName);
			firstSelectedElement = false;
		}
		
		if (!firstSelectedElement) {
			sb.append(",\n");
		}
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (presentationContextIdentifier != null) {
			sb.append("presentationContextIdentifier: ").append(presentationContextIdentifier);
		}
		else {
			sb.append("presentationContextIdentifier: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (presentationDataValues != null) {
			sb.append("presentationDataValues: ");
			presentationDataValues.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("presentationDataValues: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

