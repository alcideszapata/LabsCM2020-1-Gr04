package co.edu.udea.compumovil.gr04_20121.Lab3Architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class Preference_Fragmeng : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference__fragmeng)

        if (savedInstanceState==null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_preference, MainPreference())
                .commit()

        }else{
            title = savedInstanceState.getCharSequence(TAG_TITTLE)
        }
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount==0){
                setTitle(R.string.settings)
            }
        }

        setUpToolbar()

    }

    private fun setUpToolbar() {
       supportActionBar?.setTitle(R.string.settings)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
       supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    class MainPreference : PreferenceFragmentCompat(){
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
         setPreferencesFromResource(R.xml.rootpreference, rootKey)
        }
    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        return true
    }

    companion object{
        private val TAG_TITTLE = Preference_Fragmeng::getTitle.toString()
    }

}