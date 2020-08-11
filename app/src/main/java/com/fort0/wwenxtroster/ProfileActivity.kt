package com.fort0.wwenxtroster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(findViewById(R.id.main_toolbar))

        initActionBar()

    }

    private fun initActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.about)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

}