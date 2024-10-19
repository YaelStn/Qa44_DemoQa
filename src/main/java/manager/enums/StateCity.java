package manager.enums;

public enum StateCity {
    NCR("NCR", new String[]{"Delhi", "Gurgaon", "Noida"}),
    UTTAR_PRADESH("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"}),
    HARYANA("Haryana", new String[]{"Karnal", "Panipat"}),
    RAJASTHAN("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    private final String state;
    private final String[] city;

    StateCity(String state, String[] city) {
        this.city = city;
        this.state = state;
    }

    public String[] getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}