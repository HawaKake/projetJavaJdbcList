package l3.data.repository.list.impl;

import java.util.ArrayList;
import java.util.List;

import l3.core.Repository;

public class RepositoryListImpl  <T> implements Repository  <T>  {

     protected ArrayList<T> data=new ArrayList<>();

    @Override
    public boolean insert(T objet) {
        return data.add(objet);

    }

    @Override
    public ArrayList<T> selectAll() {
        return data;
    }
    
}
