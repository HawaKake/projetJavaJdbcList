package l3.data.enums;

public enum EtatDemandeDette {
    ANNULEE,
    ENCOURS;

    public static EtatArticle getValue(String value) {
        for (EtatArticle e : EtatArticle.values()) {
            if (e.name().compareToIgnoreCase(value) == 0) {
                return e;
            }
        }
        return null; 
    }

    
    

}

