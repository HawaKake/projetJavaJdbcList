package l3.data.enums;

public enum EtatDette {
    ARCHIVER,  
    DESARCHIVER;

    public static EtatDette getValue(String value) {
        for (EtatDette e : EtatDette.values()) {
            if (e.name().compareToIgnoreCase(value) == 0) {
                return e;
            }
        }
        return null; 
    }
}
