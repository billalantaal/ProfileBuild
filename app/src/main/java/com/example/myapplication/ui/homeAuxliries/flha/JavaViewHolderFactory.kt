package com.example.myapplication.ui.homeAuxliries.flha

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.business.Field

object JavaViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.multiple_choice -> Multiple_Choice_Holder(view)
            R.layout.edit_txt_layout -> Text_View_Holder(view)
            else -> {
                Multiple_Choice_Holder(view)
            }
        }
    }

    class Multiple_Choice_Holder(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Field> {

//        var textView: TextView
        init {
//            textView = itemView.findViewById(R.id.carName)
        }
        override fun bind(car: Field) {
//            textView.text = car.name
        }
    }

    class Text_View_Holder(itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<Field> {

//        var textView: TextView
        init {
//            textView = itemView.findViewById(R.id.busName)
        }
        override fun bind(bus: Field) {
//            textView.setText(bus.name)
        }
    }
}