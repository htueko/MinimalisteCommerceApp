package io.htueko.minimalistecommerceapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        // set the tool bar
        setSupportActionBar(toolbar_detail)

        // get the title and price
        val intent = intent
        val title = intent.getStringExtra(ShopAdapter.TITLE)
        val price = intent.getStringExtra(ShopAdapter.PRICE)

        txt_toolbar_title_detail.text = title
        txt_title_detail.text = title
        txt_description_detail.text = title
        txt_price_detail.text = price

        toolbar_detail.setNavigationOnClickListener { finish() }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayShowTitleEnabled(false)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.heart_menu_detail -> Toast.makeText(this, "The heart menu pressed", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
