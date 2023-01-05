package com.esraa.egfwd.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.esraa.egfwd.aboutme.data.MyName
import com.esraa.egfwd.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myName : MyName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myName = MyName(name = resources.getString(R.string.name))
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            submitNickname(it)
        }
    }

    private fun submitNickname(view: View) {
             binding.apply {
                 myName?.nickname = nicknameEditText.text.toString()
                 invalidateAll()
                 nicknameText.visibility = View.VISIBLE
                 nicknameEditText.visibility = View.GONE
                 doneButton.visibility = View.GONE

             }
                // Hide the keyboard.
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}