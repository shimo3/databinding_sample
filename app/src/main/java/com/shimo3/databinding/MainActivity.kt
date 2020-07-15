package com.shimo3.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.shimo3.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyListener {
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main)

        user = User()
        user.firstName.set("名前を")
        user.lastName.set("入力してネ")
        binding.user = user
        binding.listener = this

    }

    override fun onClick(v: View) {
//        user.firstName.set("changed")
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()

        Toast.makeText(this, "姓：${firstName}, 名：${lastName}", Toast.LENGTH_LONG)

        user.firstName.set(firstName)
        user.lastName.set(lastName)
    }
}