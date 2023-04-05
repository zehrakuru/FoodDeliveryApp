package com.example.fooddeliveryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddeliveryapp.R
import android.graphics.Color
import android.os.Build
import android.text.Html
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import android.R.string.no
import android.content.Intent
import androidx.appcompat.app.ActionBar
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.databinding.ActivityOnboardingScreenBinding
import com.example.fooddeliveryapp.ui.ViewPagerAdapter
class OnboardingScreen : AppCompatActivity() {

    private lateinit var binding:ActivityOnboardingScreenBinding
    companion object {
        const val TOTAL_SLIDE = 4
        var CURRENT_SLIDE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Making notification bar transparent
        changeStatusBarColor()
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide();
        }

        var sliderAdapter: ViewPagerAdapter? = null
        sliderAdapter= ViewPagerAdapter(this)
        binding.slideViewPager.adapter = sliderAdapter

        addDotIndicator(0)

        val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                addDotIndicator(position)
                CURRENT_SLIDE = position

                when (position) {
                    0 -> {
                        binding.backBtn.visibility = View.INVISIBLE
                    }
                    TOTAL_SLIDE - 1 -> {
                        binding.nextBtn.text = getString(R.string.btn_next)
                        binding.nextBtn.setOnClickListener {
                            val i = Intent(applicationContext,MainActivity::class.java)
                            startActivity(i)
                            finish()
                        }
                    }
                    else -> {
                        binding.backBtn.visibility = View.VISIBLE
                        binding.nextBtn.text = getString(R.string.btn_finish)
                    }
                }
            }
        }
        binding.slideViewPager.addOnPageChangeListener(viewPagerPageChangeListener)

        binding.backBtn.setOnClickListener {
            binding.slideViewPager.currentItem = CURRENT_SLIDE - 1
        }
        binding.nextBtn.setOnClickListener {
            if (CURRENT_SLIDE == TOTAL_SLIDE - 1) {
                finish()
            } else {
                binding.slideViewPager.currentItem = CURRENT_SLIDE + 1
            }
        }
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun addDotIndicator(currentPage: Int) {
        val dots = arrayListOf<TextView>()
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        binding.layoutDots.removeAllViews()
        for (i in 0 until TOTAL_SLIDE) {
            dots.add(TextView(this))
            dots[i].text = Html.fromHtml("&#8226;")
            dots[i].textSize = 35f
            dots[i].setTextColor(colorsInactive[currentPage])

            binding.layoutDots.addView(dots[i])
        }

        if (dots.size > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage])
    }
}