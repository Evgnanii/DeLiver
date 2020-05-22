package by.st.deliver.core.entities;


public enum PrivilegeLevel {
    GOLD("Gold"),
    SILVER("Silver"),
    DIAMOND("Diamond");
    private final String value;
    private PrivilegeLevel(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
