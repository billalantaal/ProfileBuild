package com.example.myapplication.ui.homeAuxliries.flha

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.Forms

class FLHAFragment : BaseFragment() ,FLHAView{


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
        viewModel.attachUI(this)
        viewModel.getDataDorFLHA()
    }

    override fun onReceivedFLHA(forms: Forms) {

    }

    override fun onError() {

    }
}
