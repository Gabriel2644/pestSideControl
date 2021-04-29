package com.example.cleanhouse

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanhouse.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_ads.*
import kotlinx.android.synthetic.main.fragment_contacts.*

class MainActivity : AppCompatActivity() {

        internal val number = "100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ Uri.encode(number)))
        }


        val home = Home()
        val form = Form()
        val contacts = Contacts()
        val Email = Email()
        val ads = Ads()

        makeCurrentFragment(home)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home->makeCurrentFragment(home)
                R.id.form->makeCurrentFragment(form)
                R.id.contacts->makeCurrentFragment(contacts)
                R.id.email->makeCurrentFragment(Email)
                R.id.ads->makeCurrentFragment(ads)
            }
            true
        }

    }
    private fun makeCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}