package org.android.go.sopt.external.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityHomeBinding
import org.android.go.sopt.external.gallery.GalleryFragment
import org.android.go.sopt.external.search.SearchFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val bottomNavigationView: BottomNavigationView by lazy { binding.bnvMain }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        viewSetup()
    }

    private fun viewSetup() {
        setContentView(binding.root)
        fragmentSetup()
        bottomNavSetup()
    }

    private fun fragmentSetup() {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcvMain.id, HomeFragment())
            .commit()
    }

    private fun bottomNavSetup() {
        bottomNavigationView.setOnItemSelectedListener { selected ->
            BottomMenu.from(selected.itemId).changeFragment(supportFragmentManager)
            true
        }
    }

    private enum class BottomMenu {
        HOME {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, HomeFragment())
                    .commit()
            }
        },
        GALLERY {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, GalleryFragment())
                    .commit()
            }
        },
        SEARCH {
            override fun changeFragment(supportFragmentManager: FragmentManager) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, SearchFragment())
                    .commit()
            }
        },
        ;

        abstract fun changeFragment(supportFragmentManager: FragmentManager)

        companion object {
            fun from(id: Int): BottomMenu {
                return when (id) {
                    R.id.bn_item_home -> HOME
                    R.id.bn_item_gallery -> GALLERY
                    R.id.bn_item_search -> SEARCH
                    else -> HOME
                }
            }
        }
    }
}