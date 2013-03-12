/*
 *  Copyright (c) 2012, 2013, Werner Keil, Credit Suisse (Anatole Tresch).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * 
 * Contributors:
 *    Anatole Tresch - initial version.
 */
package javax.money.provider.impl;

import javax.money.provider.ExposedExtensionType;
import javax.money.provider.MonetaryExtension;
import javax.money.provider.ext.TestExtension;

/**
 * Simple completely useles (despite testing) implementation of a
 * {@link ExposedExtensionType}.
 * 
 * @author Anatole Tresch
 * 
 */
@ExposedExtensionType(TestExtension.class)
public class TestExtensionImpl implements TestExtension, MonetaryExtension {

	@Override
	public String sayHello() {
		return "Hello!";
	}

}
