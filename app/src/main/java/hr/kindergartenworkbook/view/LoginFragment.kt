package hr.kindergartenworkbook.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.FragmentLoginBinding
import hr.kindergartenworkbook.utils.showShortToast

class LoginFragment(private val repo: IRepository) : Fragment() {

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
            try {
                logIn()
                switchFragment()
            } catch (e: Exception) {
                this.requireContext().showShortToast(e.message ?: "Unknown error occurred")
            }
        }
    }

    private fun logIn() {
        repo.login(
            binding.etUserName.editText?.text.toString(),
            binding.etPassword.editText?.text.toString()
        )
    }

    private fun switchFragment() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostView, ObservationFragment(repo))
            ?.addToBackStack(null)
            ?.commit() ?: Toast.makeText(this.context, "Unable to login", Toast.LENGTH_SHORT).show()
    }
}