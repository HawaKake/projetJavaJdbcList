package l3.data.enums;
public enum StatutUser {
    ACTIF,
    DESACTIF;

    public static StatutUser getValue(String value) {
        for (StatutUser statut : StatutUser.values()) {
            if (statut.name().compareToIgnoreCase(value) == 0) {
                return statut;
            }
        }
        return null;
    }
    
}
