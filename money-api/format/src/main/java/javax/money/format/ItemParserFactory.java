/*
 * Copyright (c) 2012-2013, Credit Suisse
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-354 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.money.format;

import java.util.Enumeration;
import java.util.Locale;

import javax.money.format.spi.ItemParserFactorySpi;

/**
 * This class represent the accessor interface for creating different kind of
 * {@link ItemParser} instances.
 * 
 * @see ItemParser
 * @author Anatole Tresch
 */
public interface ItemParserFactory {

	/**
	 * Return the style id's supported by this {@link ItemParserFactorySpi}
	 * instance.
	 * 
	 * @see LocalizationStyle#getId()
	 * @return the supported style ids, never {@code null}.
	 */
	public Enumeration<String> getSupportedStyleIds(Class<?> targetType);

	/**
	 * Method allows to check if a named style is supported.
	 * 
	 * @param styleId
	 *            The style id.
	 * @return true, if a spi implementation is able to provide an
	 *         {@link ItemParser} for the given style.
	 */
	public boolean isSupportedStyle(Class<?> targetType, String styleId);

	/**
	 * This method returns an instance of an {@link ItemParser} .
	 * 
	 * @param targetType
	 *            the target type, never {@code null}.
	 * @param style
	 *            the {@link LocalizationStyle} to be attached to this
	 *            {@link ItemParser}, which also contains the target
	 *            {@link Locale} instances to be used, as well as other
	 *            attributes configuring this instance.
	 * @return the matching parser, if available.
	 * @throws IllegalArgumentException
	 *             If no matching {@link ItemParser} could be provided.
	 */
	public <T> ItemParser<T> getItemParser(Class<T> targetType,
			LocalizationStyle style);

	/**
	 * This method returns an instance of a fixed styled {@link ItemParser}.
	 * This method is a convenience method for
	 * {@code getItemParser(targetType, LocalizationStyle.of(locale)) }.
	 * 
	 * @param targetType
	 *            the target type, never {@code null}.
	 * @param locale
	 *            The target locale.
	 * @return the formatter required, if available.
	 * @throws IllegalArgumentException
	 *             If no matching {@link ItemParser} could be provided.
	 */
	public <T> ItemParser<T> getItemParser(Class<T> targetType, Locale locale);


}