package es.babel.easymvvm.android.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * View holder class for item representation in recycler view.
 * Extend this ViewHolder and use bind to implement the holder with the item data
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class EmaViewHolder<I>(view: View) : RecyclerView.ViewHolder(view) {

    /**
     * Methods called to implement the item view components
     * @param item shown in recycler view
     */
    abstract fun bind(item: I)
}