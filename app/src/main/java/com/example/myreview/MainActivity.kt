package com.example.myreview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myreview.ui.fav_review.FavoriteFragment
import com.example.myreview.ui.login.LoginFragment
import com.example.myreview.ui.login.LoginHomeFragment
import com.example.myreview.ui.movie_detail.MovieDetailFragment
import com.example.myreview.ui.movie_reviews.MovieReviewListFragment
import com.example.myreview.ui.movies_review_detail.MovieReviewDetailFragment
import com.example.myreview.ui.my_profile.MyProfileFragment
import com.example.myreview.ui.new_review.NewMovieReviewFragment
import com.example.myreview.ui.notification.NotificationFragment
import com.example.myreview.ui.reset.ForgetPasswordFragment
import com.example.myreview.ui.signup.SignupFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fragments = arrayListOf<Fragment>();


        fragments.add(LoginHomeFragment());
        fragments.add(LoginFragment());
        fragments.add(SignupFragment())
        fragments.add(ForgetPasswordFragment())

        fragments.add(MovieDetailFragment())
        fragments.add(MovieReviewListFragment())
        fragments.add(MovieReviewDetailFragment())
        fragments.add(NewMovieReviewFragment())
        fragments.add(MyProfileFragment())
        fragments.add(FavoriteFragment())
        fragments.add(NotificationFragment())




        view_pager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment {
                return fragments[position];
            }

            override fun getCount(): Int {
                return fragments.size;
            }

        }

    }
}
