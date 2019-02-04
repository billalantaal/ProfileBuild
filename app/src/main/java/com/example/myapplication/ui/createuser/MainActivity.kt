package com.example.myapplication.ui.createuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.ui.createuser.registeruser.CreateUserFragment

class MainActivity : BaseActivity() {

    override fun initViews() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, CreateUserFragment.newInstance(), "CreateUserFragment")
                .commit()
        }
    }
}
