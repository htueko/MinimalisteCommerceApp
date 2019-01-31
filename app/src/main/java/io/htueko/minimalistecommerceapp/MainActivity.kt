package io.htueko.minimalistecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        }

        val items = arrayListOf<ShopItem>()
        for (i in 0..11) {
            items.add(ShopItem("Plotted plant", "Plotted plant", 19.99))
        }

       recycler_view_main.apply {
           layoutManager = GridLayoutManager(this@MainActivity, 2)
           adapter = ShopAdapter(items)
       }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.shopping_bag_menu_main -> Toast.makeText(this, "Shopping bag is pressed", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
