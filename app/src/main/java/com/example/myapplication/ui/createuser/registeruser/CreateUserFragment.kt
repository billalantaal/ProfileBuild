package com.example.myapplication.ui.createuser.registeruser

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.business.User
import com.example.myapplication.ui.createuser.registerviewmodel.CreateUserView
import com.example.myapplication.ui.createuser.registerviewmodel.CreateUserViewModel

class CreateUserFragment : BaseFragment() ,CreateUserView{


    companion object {
        fun newInstance() = CreateUserFragment()
    }

    private lateinit var viewModel: CreateUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateUserViewModel::class.java)
        viewModel.attachUI(this)
    }

    override fun onCategoryDataReceived(usersData: List<User>) {
        Toast.makeText(activity, "Success 1", Toast.LENGTH_SHORT).show()
        viewModel.getCategoryData()
    }

    override fun onCategoriesReceived(user: User) {
        Toast.makeText(activity, "Success 1", Toast.LENGTH_SHORT).show()
    }

    override fun onError() {
        Toast.makeText(activity, "Opps Error", Toast.LENGTH_SHORT).show()
    }

}
