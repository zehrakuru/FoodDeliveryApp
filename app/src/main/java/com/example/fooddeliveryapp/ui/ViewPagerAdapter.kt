package com.example.fooddeliveryapp.ui

import androidx.viewpager.widget.PagerAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.SliderFragment1Binding

class ViewPagerAdapter(context: Context) : PagerAdapter() {

    private val mContext = context
    private lateinit var layoutInflater: LayoutInflater


    private val slideImage = arrayListOf(
        R.drawable.food,
        R.drawable.food,
        R.drawable.food,
        R.drawable.food,
    )
    private val slideTitle = arrayListOf(
        R.string.onboard_heading_one,
        R.string.onboard_heading_two,
        R.string.onboard_heading_three,
        R.string.onboard_heading_fourth
    )
    private val slideDesc = arrayListOf(
        R.string.onboard_desc_one,
        R.string.onboard_desc_two,
        R.string.onboard_desc_three,
        R.string.onboard_desc_fourth,
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = slideTitle.size


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = SliderFragment1Binding.inflate(LayoutInflater.from(mContext), container, false)
        binding.titleImage.setImageResource(slideImage[position])
        binding.textTitle.text = mContext.getText(slideTitle[position])
        binding.textDescription.text = mContext.getText(slideDesc[position])

        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}