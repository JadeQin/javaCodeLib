package org.jsoup.nodes;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.Validate;

/**
 * A single key + value attribute. Keys are trimmed and normalised to
 * lower-case.
 * 
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class Attribute {
	private String key;
	private String value;

	/**
	 * Create a new attribute from unencoded (raw) key and value.
	 * 
	 * @param key
	 *            attribute key
	 * @param value
	 *            attribute value
	 * @see #createFromEncoded
	 */
	public Attribute(String key, String value) {
		Validate.notEmpty(key);
		Validate.notNull(value);
		this.key = key.trim().toLowerCase();
		this.value = value;
	}

	/**
	 * Get the attribute key.
	 * 
	 * @return the attribute key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the attribute key. Gets normalised as per the constructor method.
	 * 
	 * @param key
	 *            the new key; must not be null
	 */
	public void setKey(String key) {
		Validate.notEmpty(key);
		this.key = key.trim().toLowerCase();
	}

	/**
	 * Get the attribute value.
	 * 
	 * @return the attribute value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the attribute value.
	 * 
	 * @param value
	 *            the new attribute value; must not be null
	 */
	public void setValue(String value) {
		Validate.notNull(value);
		this.value = value;
	}

	/**
	 * Get the HTML representation of this attribute; e.g.
	 * {@code href="index.html"}.
	 * 
	 * @return HTML
	 */
	public String html() {
		return String.format("%s=\"%s\"", key,
				StringEscapeUtils.escapeHtml(value));
	}

	/**
	 * Get the string representation of this attribute, implemented as
	 * {@link #html()}.
	 * 
	 * @return string
	 */
	public String toString() {
		return html();
	}

	/**
	 * Create a new Attribute from an unencoded key and a HMTL attribute encoded
	 * value.
	 * 
	 * @param unencodedKey
	 *            assumes the key is not encoded, as can be only run of simple
	 *            \w chars.
	 * @param encodedValue
	 *            HTML attribute encoded value
	 * @return attribute
	 */
	public static Attribute createFromEncoded(String unencodedKey,
			String encodedValue) {
		String value = StringEscapeUtils.unescapeHtml(encodedValue);
		return new Attribute(unencodedKey, value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Attribute))
			return false;

		Attribute attribute = (Attribute) o;

		if (key != null ? !key.equals(attribute.key) : attribute.key != null)
			return false;
		if (value != null ? !value.equals(attribute.value)
				: attribute.value != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = key != null ? key.hashCode() : 0;
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}
}
