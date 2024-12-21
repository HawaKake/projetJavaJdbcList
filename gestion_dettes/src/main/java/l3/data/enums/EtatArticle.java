package l3.data.enums;

public enum EtatArticle {
    DISPONIBLE,
    INDISPONIBLE;

    

    public static EtatArticle getValue(String value) {
        for (EtatArticle e : EtatArticle.values()) {
            if (e.name().compareToIgnoreCase(value) == 0) {
                return e;
            }
        }
        return null;
    }

    
    
     }

