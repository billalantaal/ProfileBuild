package com.example.myapplication.ui.homeAuxliries.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.SunCor
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.Forms
import com.example.myapplication.ui.homeAuxliries.flha.FLHAFragment
import com.example.myapplication.utils.AppConst
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment(),homeView {


    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var success=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.attachUI(this)
        viewModel.getDataForms()
        txtViewflha.setOnClickListener {
            if (SunCor.flha.isNotEmpty()){
                navToFLHAFragment()
            }else{
                Toast.makeText(this.context!!,"please wait",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navToFLHAFragment(){
        val frg = FLHAFragment()
        val fm = activity!!.supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.container, frg, AppConst.FRGTAG.FLHAFragment)
        ft.addToBackStack(AppConst.FRGTAG.HomeFragment)
        ft.hide(this)
        ft.commit()
    }
    override fun onReceivedHomeData(forms: Forms) {
        if ((forms.IsSuccess)&&(forms.Message.equals("Success",ignoreCase = true))){
            if (forms.Result[0].Type.equals("FLHA",ignoreCase = true)){
                SunCor.flha= forms.Result[0].Fields
                success=true
            }
        }
    }

    override fun onError() {

    }

}
