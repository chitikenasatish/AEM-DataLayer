/*
 *  Copyright 2017 - Perficient
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
 */
package com.perficient.aem.datalayer.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.wrappers.ValueMapDecorator;

/**
 * Basic data object which extends ValueMapDecorator allowing for arbitrary keys
 * while still providing named fields.
 * 
 * @author danklco
 */
public class BaseDataObject extends ValueMapDecorator {

	public BaseDataObject() {
		super(new HashMap<String, Object>());
	}

	public Map<String, Object> getAttributes() {
		if (!containsKey(DataLayerConstants.DATA_KEY_ATTRIBUTES)) {
			put(DataLayerConstants.DATA_KEY_ATTRIBUTES, new HashMap<String, Object>());
		}
		return get(DataLayerConstants.DATA_KEY_ATTRIBUTES, new HashMap<String, Object>());
	}

	public Category getCategory() {
		if (!containsKey(DataLayerConstants.DATA_KEY_CATEGORY)) {
			put(DataLayerConstants.DATA_KEY_ATTRIBUTES, new Category());
		}
		return get(DataLayerConstants.DATA_KEY_CATEGORY, Category.class);
	}

	public void setAttributes(Map<String, Object> attributes) {
		put(DataLayerConstants.DATA_KEY_ATTRIBUTES, attributes);
	}

	public void setCategory(Category category) {
		put(DataLayerConstants.DATA_KEY_CATEGORY, category);
	}
}