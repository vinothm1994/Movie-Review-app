package com.example.myreview.ui.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myreview.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login_home.*

/**
 * A simple [Fragment] subclass.
 */
class LoginHomeFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_home, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        create_account_btn.setOnClickListener {
            //findNavController().navigate(R.id.navigation_signup)
            findNavController().navigate(R.id.action_loginHomeFragment_to_mobile_navigation)
        }

        signin_btn.setOnClickListener {
            findNavController().navigate(R.id.navigation_login)
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        currentUser?.let {
            currentUser.displayName;
            findNavController().navigate(R.id.action_loginHomeFragment_to_mobile_navigation)

        }
    }

}
