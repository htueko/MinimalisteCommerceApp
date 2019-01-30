package io.htueko.minimalistecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ShopItem>()
        for (i in 0..12) {
            items.add(ShopItem("Plotted plant", "Plotted plant", 19.99))
        }

       recycler_view_main.apply {
           layoutManager = GridLayoutManager(this@MainActivity, 2)
           adapter = ShopAdapter(items)
       }
    }

}
