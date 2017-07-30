package org.belchan;

public class ApplicationInfo {
    public static String getVersion() {
        return "0.2";
    }

    public static String getChangeSet() {
        StringBuilder cs = new StringBuilder("BELCHAN CHANGES:\n");
        appendToCS(cs,"0.2","Subscribe service added to BelchanBot (31.05.2017)");
        appendToCS(cs,"0.1","Init application. Contains simple @BelchanBot and read-only imageBoard");
        return cs.toString();
    }

    private static void appendToCS(StringBuilder cs, String version, String text) {
        cs.append(version);
        cs.append("\n");
        cs.append(text);
        cs.append("\n");
    }


}
