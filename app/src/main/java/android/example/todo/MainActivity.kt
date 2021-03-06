package android.example.todo

import android.example.todo.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil

private var binding: ActivityMainBinding? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding?.topAppBar)



        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Home()).commit()
                R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Shop()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, account()).commit()
                R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, delivery()).commit()

            }
            true
        }
         binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.favoritesTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Favorites())
                        .commit()

                    true
                }

                R.id.settingsTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Settings())
                        .commit()

                    true
                }
                else -> false
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater

        menuInflater.inflate(R.menu.top_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {

                val mainMenu = MainMenu()
                mainMenu.show(
                    supportFragmentManager,
                    "main menu")

            }
        }
        return true
    }
}









