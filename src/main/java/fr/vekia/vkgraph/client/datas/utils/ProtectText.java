package fr.vekia.vkgraph.client.datas.utils;

public class ProtectText {
    private ProtectText() {
    }

    public static String protect(String value) {
        if (!value.startsWith("'")) {
            return "'" + value + "'";
        }
        return value;
    }
}
