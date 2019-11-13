package com.example.myreview.ui.signup


import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myreview.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_signup.*


/**
 * A simple [Fragment] subclass.
 */
class SignupFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        signin_btn.setOnClickListener {
            findNavController().navigate(R.id.navigation_login)
        }
        signup_btn.setOnClickListener {
            validate()
        }


    }


    private fun validate() {
        val fullname = fullNameField.text.toString()
        val email = emailField.text.toString()
        val password: String = passwordField.text.toString()
        val confirmPassword: String = confirmPasswordField.text.toString()
        val userName = userNameField.text.toString()
        fullnameLy.error = null
        emailLy.error = null
        confirmPasswordLy.error = null
        passwordLy.error = null
        usernameLy.error = null

        if (fullname.isEmpty() || fullname.length < 5) {
            fullnameLy.error = "Invalid Naame"
        } else if (email.isEmpty() || !isValidEmail(email)) {
            emailLy.error = "Invalid email"
        } else if (password.length < 8) {
            passwordLy.error = "Invalid password"
        } else if (!password.equals(confirmPassword)) {
            confirmPasswordLy.error = "Password not match"
        } else if (userName.length < 5) {
            usernameLy.error = "Invalid User Name"
        } else {
            createUser(email, password)
        }

    }




    private fun createUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = mAuth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            requireContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }

                }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            findNavController().navigate(R.id.action_signupFragment_to_mobile_navigation)
        }

    }

    companion object {
        var TAG: String = "signUp_fragment"

       public fun isValidEmail(target: CharSequence): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}
