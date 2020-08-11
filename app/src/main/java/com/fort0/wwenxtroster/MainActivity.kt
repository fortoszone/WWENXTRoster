package com.fort0.wwenxtroster

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSuperstar: RecyclerView
    private var list: ArrayList<Superstar> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))

        rvSuperstar = findViewById(R.id.recyclerView)
        rvSuperstar.setHasFixedSize(true)

        list.addAll(SuperstarData.listData)
        showRecyclerList()

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.home)

    }

    private fun showRecyclerList() {
        rvSuperstar.layoutManager = LinearLayoutManager(this)
        val rosterAdapter = RosterAdapter(list)
        rvSuperstar.adapter = rosterAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about -> {
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
            true

        }

        else -> {
            super.onOptionsItemSelected(item)

        }
    }
}