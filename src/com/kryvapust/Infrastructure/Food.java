package com.kryvapust.Infrastructure;

public enum Food {
    FOR_LITTLE("A", 3),
    FOR_MIDDLE("B", 4),
    FOR_OLD("C", 3);

    String type;
    int amount;

    Food(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "food{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
