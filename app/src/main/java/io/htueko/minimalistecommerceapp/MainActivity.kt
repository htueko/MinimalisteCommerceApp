package io.htueko.minimalistecommerceapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set the toolbar
        setSupportActionBar(toolbar_main)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_apps)
            setDisplayShowTitleEnabled(false)
        }

        val items = arrayListOf<ShopItem>()
        for (i in 0..11) {
            items.add(ShopItem("Plotted plant", "Plotted plant $i", "$19.09"))
        }

        recycler_view_main.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = ShopAdapter(items)
        }

        bottomNavigation_main.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.bottom_nav_menu_search -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Search")
                        .setMessage("Here goes the search")
                        .setIcon(R.drawable.ic_search)
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.cancel()
                        }.show()
                }
                R.id.bottom_nav_menu_profile -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Profile")
                        .setMessage("let the user to sign up or sign in")
                        .setIcon(R.drawable.ic_profile)
                        .setPositiveButton("Enter") { dialog, which ->
                            dialog.cancel()
                        }.show()
                }

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.shopping_bag_menu_main -> Toast.makeText(this, "Shopping bag is pressed", Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }

}
