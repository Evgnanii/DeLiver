package by.st.deliver.core.entities;

public enum CourierStatus {
    READY("Ready"), ONORDER("OnOrder"), NOTWORKING("NotWorking");

    private final String value;

    private CourierStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
