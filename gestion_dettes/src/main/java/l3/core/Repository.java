package l3.core;

import java.util.ArrayList;
import java.util.List;

public interface Repository<T>  {
    boolean insert(T objet);
    ArrayList<T> selectAll();
 
}
