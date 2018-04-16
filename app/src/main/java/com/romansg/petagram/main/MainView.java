package com.romansg.petagram.main;

import android.support.v4.app.Fragment;

/**
 * Created by roman on 11/04/18.
 */

/**
 * Dispone el paginador de la vista principal
 * @param fragments fragmentos que va a manejar el paginador
 * @param tabTitles títulos de los fragmentos (se eflejan en las pestañas de la vista)
 */
public interface MainView {
    void setupPagerAdapter(Fragment[] fragments, String[] tabTitles);
}
