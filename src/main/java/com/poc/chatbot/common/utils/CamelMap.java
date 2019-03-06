package com.poc.chatbot.common.utils;

import org.apache.commons.collections4.map.ListOrderedMap;

public class CamelMap extends ListOrderedMap<Object, Object> {
	private static final long serialVersionUID = 6723434363565852261L;

	public Object put(Object key, Object value) {
		return super.put(CamelUtil.convert2CamelCase((String) key), value);
	}
}