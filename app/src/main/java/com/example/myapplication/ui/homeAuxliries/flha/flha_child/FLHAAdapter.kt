package com.example.myapplication.ui.homeAuxliries.flha.flha_child

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.View
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton
import com.example.myapplication.R
import com.example.myapplication.business.Field
import kotlinx.android.synthetic.main.date_view.view.*
import kotlinx.android.synthetic.main.edit_txt_layout.view.*
import kotlinx.android.synthetic.main.multiple_choice.view.*
import kotlinx.android.synthetic.main.mutiple_choice_second.view.*


class FLHAAdapter(mContext: Context, mFeildList: List<Field>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val MULTIPLE_CHOICE_TYPE = 1
    val TEXT_VIEW_TYPE = 2
    val DATE_VIEW_TYPE = 3
    val MULTIPLE_CHOICE_TYPE_SECOND = 4

    private var mContext: Context? = null
    private var mFormList: List<Field>? = null

    init {
        this.mContext = mContext
        this.mFormList = mFeildList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        when (viewType) {

            TEXT_VIEW_TYPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.edit_txt_layout, parent, false)
                return TextViewHolder(view)

            }
            MULTIPLE_CHOICE_TYPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.multiple_choice, parent, false)
                return MultipleChoiceHolder(view)
            }

            DATE_VIEW_TYPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.date_view, parent, false)
                return DateViewHolder(view)

            }
            MULTIPLE_CHOICE_TYPE_SECOND -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.mutiple_choice_second, parent, false)
                return MultipleChoiceSecondHolder(view)

            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.edit_txt_layout, parent, false)
                return TextViewHolder(view)
            }
        }

    }

    override fun getItemCount(): Int {
        return mFormList?.size!!

    }

    override fun getItemViewType(position: Int): Int {
        if ((mFormList?.get(position)?.Type.equals("MultipleChoice", ignoreCase = true)) && (mFormList?.get(position)?.Section!!.equals("Primary Information"))) {
            return MULTIPLE_CHOICE_TYPE
        } else if (mFormList?.get(position)?.Type.equals("TextBox", ignoreCase = true)) {
            return TEXT_VIEW_TYPE
        } else if (mFormList?.get(position)?.Type.equals("Date", ignoreCase = true)) {
            return DATE_VIEW_TYPE
        } else if ((mFormList?.get(position)?.Type.equals("MultipleChoice", ignoreCase = true)) && (!mFormList?.get(position)?.Section!!.equals("Primary Information"))) {
            return MULTIPLE_CHOICE_TYPE_SECOND
        }else{
            return -1
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val field = this.mFormList!![position]
        when (holder.itemViewType) {
            MULTIPLE_CHOICE_TYPE -> (holder as MultipleChoiceHolder).bind(this.mContext!!, field)
            TEXT_VIEW_TYPE -> (holder as TextViewHolder).bind(this.mContext!!, field)
            DATE_VIEW_TYPE -> (holder as DateViewHolder).bind(this.mContext!!, field)
            MULTIPLE_CHOICE_TYPE_SECOND -> (holder as MultipleChoiceSecondHolder).bind(this.mContext!!, field)
            else->(holder as TextViewHolder).bind(this.mContext!!, field)
        }
    }

    private inner class MultipleChoiceHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var fieldNameMC: TextView
        var radioButton1: AppCompatRadioButton
        var radioButton2: AppCompatRadioButton
        var radioButton3: AppCompatRadioButton
        var radioButton4: AppCompatRadioButton


        init {
            fieldNameMC = itemView.fieldName
            radioButton1 = itemView.radioButton
            radioButton2 = itemView.radioButton2
            radioButton3 = itemView.radioButton3
            radioButton4 = itemView.radioButton4

        }

        internal fun bind(
            context: Context,
            field: Field
        ) {
            fieldNameMC.text = field.Name
            radioButton1.text = field.FieldsOptions[0]?.Name
            radioButton2.text = field.FieldsOptions[1]?.Name
            radioButton3.text = field.FieldsOptions[2]?.Name
            radioButton4.text = field.FieldsOptions[3]?.Name

        }
    }

    private inner class TextViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text_view_name: TextView
        var editText_field: EditText

        init {
            text_view_name = itemView.edt_name
            editText_field = itemView.edtfield
        }

        internal fun bind(
            context: Context,
            field: Field
        ) {
            text_view_name.text = field.Name
        }
    }

    private inner class DateViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text_view_name: TextView
        var editText_field: EditText

        init {
            text_view_name = itemView.dateName
            editText_field = itemView.edtDate
        }

        internal fun bind(
            context: Context,
            field: Field
        ) {
            text_view_name.text = field.Name
        }
    }

    private inner class MultipleChoiceSecondHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var fieldNameMCSecond: TextView
        internal var radioButton1: AppCompatRadioButton
        internal var radioButton2: AppCompatRadioButton
        internal var radioButton3: AppCompatRadioButton
        internal var radioButton4: AppCompatRadioButton
        internal var radioButton5: AppCompatRadioButton


        init {
            fieldNameMCSecond = itemView.txtNameMC_scnd
            radioButton1 = itemView.radioB1
            radioButton2 = itemView.radioB2
            radioButton3 = itemView.radioB3
            radioButton4 = itemView.radioB4
            radioButton5 = itemView.radioB5


        }

        internal fun bind(
            context: Context,
            field: Field
        ) {
            fieldNameMCSecond.text = field.Name
            radioButton1.text = field.FieldsOptions[0]?.Name
            radioButton2.text = field.FieldsOptions[1]?.Name
            radioButton3.text = field.FieldsOptions[2]?.Name
            radioButton4.text = field.FieldsOptions[3]?.Name
            radioButton5.text = field.FieldsOptions[4]?.Name


        }
    }
}