package coesmapp.com.coesmapp.ui.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import coesmapp.com.coesmapp.ui.common.BaseFragment
import coesmapp.com.coesmapp.ui.home.meter_reading_fragmants.AgentDetailsFragment
import coesmapp.com.coesmapp.ui.home.meter_reading_fragmants.ChooseDateFragment
import coesmapp.com.coesmapp.ui.home.meter_reading_fragmants.ConfirmationCodeFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): BaseFragment {
        println("Section Position : $position")

        return when (position) {
            1 -> {
                println("Section Position Choose Date : $position")
                ChooseDateFragment.newInstance(position)
            }
            2 -> {
                println("Section Position AgentDetails : $position")
                AgentDetailsFragment.newInstance(position)
            }
            3 -> {
                println("Section Position Confirmation : $position")
                ConfirmationCodeFragment.newInstance(position)
            }
            else -> ChooseDateFragment.newInstance(position)
        }
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 4
    }
}