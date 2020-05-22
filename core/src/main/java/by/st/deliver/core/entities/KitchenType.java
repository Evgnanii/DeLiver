package by.st.deliver.core.entities;

public enum KitchenType {
    BELARUSIAN("Belarusian"),
    FASTFOOD("FastFood"),
    ITALIAN("Italian");
    private final String value;
    private KitchenType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
