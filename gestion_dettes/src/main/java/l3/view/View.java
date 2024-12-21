package l3.view;

import java.util.ArrayList;
import java.util.Scanner;

public interface View<T> {
    T saisie();
    void affiche(ArrayList<T> datas);
}
