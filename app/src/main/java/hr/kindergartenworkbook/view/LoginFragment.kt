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

class LoginFragment(private val repo: IRepository) : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var parent: ActionBarChangeable

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parent = context as ActionBarChangeable
    }

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
        val user = repo.login(
            binding.etUserName.editText?.text.toString(),
            binding.etPassword.editText?.text.toString()
        )

        parent.changeActionBarTitle(user.groupName)
    }

    private fun switchFragment(){
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navHostView, ObservationFragment(repo))
            ?.addToBackStack(null)
            ?.commit() ?: Toast.makeText(this.context, "Unable to login", Toast.LENGTH_SHORT).show()
    }
}