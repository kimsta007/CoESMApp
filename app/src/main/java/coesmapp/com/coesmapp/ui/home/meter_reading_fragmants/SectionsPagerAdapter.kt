package coesmapp.com.coesmapp.ui.home.meter_reading_fragmants

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                println("Section Position Choose Date : $position")
                ChooseDateFragment()
            }
            1 -> {
                println("Section Position AgentDetails : $position")
                AgentDetailsFragment()
            }
            2 -> {
                println("Section Position Confirmation : $position")
                ConfirmationCodeFragment()
            }
             else -> ChooseDateFragment()
        }
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}