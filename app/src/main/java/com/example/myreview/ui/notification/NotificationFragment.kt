package com.example.myreview.ui.notification


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myreview.R
import kotlinx.android.synthetic.main.fragment_movie_review_list.*


/**
 * A simple [Fragment] subclass.
 */
class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addView(R.layout.notification_list_item);
        addView(R.layout.notification_list_item);
        addView(R.layout.notification_list_item);
        addView(R.layout.notification_list_item);


    }

    private fun addView(id: Int) {
        temp_ly.addView(
            LayoutInflater.from(requireContext()).inflate(
                id,
                null
            )
        )
    }


}
