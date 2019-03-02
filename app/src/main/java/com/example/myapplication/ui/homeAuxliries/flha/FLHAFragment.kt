package com.example.myapplication.ui.homeAuxliries.flha

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.SunCor
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.ui.homeAuxliries.flha.flha_child.FLHAAdapter
import kotlinx.android.synthetic.main.edit_txt_layout.*
import kotlinx.android.synthetic.main.flha_fragment.*
import kotlinx.android.synthetic.main.multiple_choice.*

class FLHAFragment : BaseFragment() {

    companion object {
        fun newInstance() = FLHAFragment()
    }

    private lateinit var viewModel: FLHAViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.flha_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FLHAViewModel::class.java)
        mRecyclerView.layoutManager=LinearLayoutManager(context)
        val adapter=FLHAAdapter(this.context!!,SunCor.flha)
        mRecyclerView.adapter=adapter

/*        if (SunCor.flha[0].Type.equals("MultipleChoice",ignoreCase = true)){
            multiple_choice.visibility=View.VISIBLE
            fieldName.text=SunCor.flha[0].Name
            radioButton.text=SunCor.flha[0].FieldsOptions[0]?.Name
            radioButton2.text=SunCor.flha[0].FieldsOptions[1]?.Name
            radioButton3.text=SunCor.flha[0].FieldsOptions[2]?.Name
            radioButton4.text=SunCor.flha[0].FieldsOptions[3]?.Name
        }
        if(SunCor.flha[1].Type.equals("Date",ignoreCase = true)){
            edtname.text=SunCor.flha[0].Name
        }


        radioButton.setOnClickListener {
            radioButton2.isChecked = false
            radioButton3.isChecked = false
            radioButton4.isChecked = false
            Toast.makeText(activity, "" + radioButton.text, Toast.LENGTH_LONG).show()
        }
        radioButton2.setOnClickListener {
            radioButton.isChecked = false
            radioButton3.isChecked = false
            radioButton4.isChecked = false
            Toast.makeText(activity, "" + radioButton2.text, Toast.LENGTH_LONG).show()
        }
        radioButton3.setOnClickListener {
            radioButton.isChecked = false
            radioButton2.isChecked = false
            radioButton4.isChecked = false
            Toast.makeText(activity, "" + radioButton3.text, Toast.LENGTH_LONG).show()
        }
        radioButton4.setOnClickListener {
            radioButton.isChecked = false
            radioButton3.isChecked = false
            radioButton2.isChecked = false
            Toast.makeText(activity, "" + radioButton4.text, Toast.LENGTH_LONG).show()
        }*/
/*        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when (p1) {
                    R.id.radioButton -> {
                        radioButton2.isChecked = false
                        radioButton3.isChecked = false
                        radioButton4.isChecked = false
                        Toast.makeText(activity, "" + radioButton.text, Toast.LENGTH_LONG).show()
                    }
                    R.id.radioButton2 -> {
                        radioButton.isChecked = false
                        radioButton3.isChecked = false
                        radioButton4.isChecked = false
                        Toast.makeText(activity, "" + radioButton2.text, Toast.LENGTH_LONG).show()
                    }
                    R.id.radioButton3 -> {
                        radioButton.isChecked = false
                        radioButton2.isChecked = false
                        radioButton4.isChecked = false
                        Toast.makeText(activity, "" + radioButton3.text, Toast.LENGTH_LONG).show()
                    }
                    R.id.radioButton4 -> {
                        radioButton.isChecked = false
                        radioButton3.isChecked = false
                        radioButton2.isChecked = false
                        Toast.makeText(activity, "" + radioButton4.text, Toast.LENGTH_LONG).show()

                    }
                }
            }

        })*/
    }


}
