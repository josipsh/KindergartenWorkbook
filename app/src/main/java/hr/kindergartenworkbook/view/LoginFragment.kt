package hr.kindergartenworkbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogIn.setOnClickListener {
            logIn()
            switchFragment()
        }
    }

    private fun logIn() {

    }

    private fun switchFragment(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostView, ObservationFragment())
            ?.addToBackStack(null)
            ?.commit() ?: Toast.makeText(this.context, "Unable to login", Toast.LENGTH_SHORT).show()
    }
}