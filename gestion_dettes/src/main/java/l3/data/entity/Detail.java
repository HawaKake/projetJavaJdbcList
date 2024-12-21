package l3.data.entity;

import lombok.Data;

@Data

public class Detail {
    private int qteArticles;
    private Article article;
    private Dette dette;
    public Detail() {
    }
    public Detail(int qteArticles, Article article, Dette dette) {
        this.qteArticles = qteArticles;
        this.article = article;
        this.dette = dette;
    }

    
}
