package com.linkey.core.domain.enums;

public enum TodoDoneYn {
    Y,N;

    public static TodoDoneYn getLabel(Character c) {
        if (c.equals('Y')) {
            return TodoDoneYn.Y;
        } else if (c.equals('N')) {
            return TodoDoneYn.N;
        }
        return null;
    }
}
