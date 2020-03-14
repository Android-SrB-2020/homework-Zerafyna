package learn.nbcc.navcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import learn.nbcc.navcomponent.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, SavedInstanceState: Bundle?) {
        super.onViewCreated(view, SavedInstanceState)

        navController = view.findNavController()

        binding.apply {
            sendMoneyBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToChooseRecipientFragment())
            }

            viewTransactionsBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToViewTransactionFragment())
            }

            viewBalanceBtn.setOnClickListener {
                navController.navigate(MainFragmentDirections.actionMainFragmentToViewBalanceFragment())
            }
        }
    }

}
