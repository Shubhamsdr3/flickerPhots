package com.pandey.shubham.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pandey.shubham.photos.ui.FlickerPhotoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startFragment(FlickerPhotoListFragment.newInstance())
    }

    private fun startFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragmentContainer, fragment, fragment::class.java.simpleName)
        ft.addToBackStack(fragment::class.java.simpleName)
        ft.commit()
    }
}