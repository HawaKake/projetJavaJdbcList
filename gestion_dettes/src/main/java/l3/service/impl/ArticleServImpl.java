package l3.service.impl;

import java.util.ArrayList;

import l3.core.Repository;
import l3.data.entity.Article;
import l3.data.entity.Client;
import l3.service.ArticleServ;
import l3.service.ClientServ;

public class ArticleServImpl  implements ArticleServ{
    private Repository<Article> articleRepo;

    public ArticleServImpl(Repository<Article> articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    public void Create(Article ob) {
       articleRepo.insert(ob);
    }

    @Override
    public ArrayList<Article> show() {
       return articleRepo.selectAll();
       
    }
    
}
