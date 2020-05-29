package by.st.deliver.core.entities;

public enum OrderStatus {
    ONREST("OnRest"),
    ONPATH("OnPath"),
    COMPLETE("Complete");
    private final String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    }
