package com.fort0.wwenxtroster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhotoDetail: ImageView = findViewById(R.id.superstar_detail_image)
        val tvName: TextView = findViewById(R.id.superstar_name)
        val tvDetail: TextView = findViewById(R.id.superstar_detail)

        val image = intent.getStringExtra(EXTRA_IMAGE)
        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAILS)

        Glide.with(this)
            .load(image)
            .apply(RequestOptions())
            .into(imgPhotoDetail)
        tvName.text = name
        tvDetail.text = detail

        val mToolbar = findViewById<Toolbar>(R.id.detail_toolbar)
        setSupportActionBar(mToolbar)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DETAILS = "extra_details"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}