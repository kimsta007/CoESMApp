package coesmapp.com.coesmapp.ui.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import coesmapp.com.coesmapp.R
import coesmapp.com.coesmapp.ui.common.BaseActivity
import coesmapp.com.coesmapp.ui.home.meter_reading_fragmants.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_meter_reading_schedule.*

class MeterReadingScheduleActivity : BaseActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private lateinit var mSectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meter_reading_schedule)

        setSupportActionBar(findViewById(R.id.toolbar_reading_schedule))
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

}
