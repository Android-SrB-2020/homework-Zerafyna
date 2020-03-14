package learn.nbcc.navcomponent


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import learn.nbcc.navcomponent.databinding.FragmentSpecityAmountBinding
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment: Fragment() {

    private lateinit var binding:FragmentSpecityAmountBinding
    private lateinit var navController: NavController
    lateinit var recipientName: String

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        recipientName = arguments?.getString("recipient") ?: "None"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_specity_amount,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, SavedInstanceState: Bundle?){
        super.onViewCreated(view, SavedInstanceState)

        navController = view.findNavController()
        binding.message = recipientName

        binding.apply {
            sendBtn.setOnClickListener {

                if(!TextUtils.isEmpty(inputAmount.text.toString())){
                    val amount = Money(BigDecimal(inputAmount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipientName,
                        "amount" to amount
                    )
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
                }else{
                    Toast.makeText(activity, "You must provide an Amount!", Toast.LENGTH_SHORT).show()
                }

            }
            cancelBtn.setOnClickListener {
                activity!!.onBackPressed()
            }
        }
    }

}
