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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.sling.api.wrappers.ValueMapDecorator;

/**
 * This class represents a Digital Marketing DataLayer driven through AEM Pages
 * and Components.
 * 
 * @author danklco
 */
public class DataLayer extends ValueMapDecorator {

	public static final String DATA_KEY_ACCESS_CATEGORY = "accessCategory";
	public static final String DATA_KEY_CART = "cart";
	public static final String DATA_KEY_COMPONENT = "component";
	public static final String DATA_KEY_EVENT = "event";
	public static final String DATA_KEY_PAGE = "page";
	public static final String DATA_KEY_PAGE_INSTANCE_ID = "pageInstanceID";
	public static final String DATA_KEY_PRIVACY = "privacy";
	public static final String DATA_KEY_PRODUCT = "product";
	public static final String DATA_KEY_TRANSACTION = "transaction";
	public static final String DATA_KEY_USER = "user";
	public static final String DATA_KEY_VERSION = "version ";

	public DataLayer() {
		super(new HashMap<String, Object>());
		put(DATA_KEY_EVENT, new ArrayList<EventInfo>());
		put(DATA_KEY_PAGE, new Page());
		put(DATA_KEY_VERSION, "1.0");
	}

	public List<AccessCategory> getAccessCategories() {
		HashMap<String, List<AccessCategory>> defaultPrivacy = new HashMap<String, List<AccessCategory>>();
		List<AccessCategory> defaultAccessCategories = new ArrayList<AccessCategory>();
		defaultPrivacy.put(DATA_KEY_ACCESS_CATEGORY, defaultAccessCategories);
		if (!containsKey(DATA_KEY_PRIVACY)) {
			put(DATA_KEY_COMPONENT, defaultPrivacy);
		}
		return get(DATA_KEY_COMPONENT, defaultPrivacy).get(DATA_KEY_ACCESS_CATEGORY);
	}

	public Cart getCart() {
		return get(DATA_KEY_CART, Cart.class);
	}

	public List<Component> getComponents() {
		List<Component> defaultComponents = new ArrayList<Component>();
		if (!containsKey(DATA_KEY_COMPONENT)) {
			put(DATA_KEY_COMPONENT, defaultComponents);
		}
		return get(DATA_KEY_COMPONENT, defaultComponents);
	}

	public List<EventInfo> getEvents() {
		return get(DATA_KEY_EVENT, new ArrayList<EventInfo>());
	}

	public Page getPage() {
		return get(DATA_KEY_PAGE, Page.class);
	}

	public String getPageInstanceID() {
		return this.get(DATA_KEY_PAGE_INSTANCE_ID, String.class);
	}

	public List<Product> getProducts() {
		List<Product> defaultProducts = new ArrayList<Product>();
		if (!containsKey(DATA_KEY_PRODUCT)) {
			put(DATA_KEY_PRODUCT, defaultProducts);
		}
		return get(DATA_KEY_PRODUCT, defaultProducts);
	}

	public Transaction getTransaction() {
		return get(DATA_KEY_TRANSACTION, Transaction.class);
	}

	public List<User> getUsers() {
		List<User> defaultUsers = new ArrayList<User>();
		if (!containsKey(DATA_KEY_USER)) {
			put(DATA_KEY_USER, defaultUsers);
		}
		return get(DATA_KEY_USER, defaultUsers);
	}

	public String getVersion() {
		return get(DATA_KEY_VERSION, String.class);
	}

	public void setAccessCategories(List<AccessCategory> accessCategories) {
		HashMap<String, List<AccessCategory>> defaultPrivacy = new HashMap<String, List<AccessCategory>>();
		if (!containsKey(DATA_KEY_PRIVACY)) {
			put(DATA_KEY_COMPONENT, defaultPrivacy);
		}
		get(DATA_KEY_COMPONENT, defaultPrivacy).put(DATA_KEY_ACCESS_CATEGORY, accessCategories);
	}

	public void setCart(Cart cart) {
		put(DATA_KEY_CART, cart);
	}

	public void setComponents(List<Component> components) {
		put(DATA_KEY_COMPONENT, components);
	}

	public void setEvents(List<EventInfo> events) {
		put(DATA_KEY_EVENT, events);
	}

	public void setPage(Page page) {
		put(DATA_KEY_PAGE, page);
	}

	public void setPageInstanceID(String pageInstanceID) {
		put(DATA_KEY_PAGE_INSTANCE_ID, pageInstanceID);
	}

	public void setTransaction(Transaction transaction) {
		put(DATA_KEY_TRANSACTION, transaction);
	}

	public void setUsers(List<User> users) {
		put(DATA_KEY_USER, users);
	}

}