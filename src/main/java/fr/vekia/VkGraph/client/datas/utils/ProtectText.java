package fr.vekia.VkGraph.client.datas.utils;

public class ProtectText {

	public static String protect(String value) {
		if (!value.startsWith("'")) {
			return "'" + value + "'";
		}
		return value;
	}
}
