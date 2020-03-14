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
import kotlinx.android.synthetic.main.fragment_chooserecipient.*
import learn.nbcc.navcomponent.databinding.FragmentChooserecipientBinding

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {

    private lateinit var binding: FragmentChooserecipientBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_chooserecipient,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, SavedInstanceState: Bundle?) {
        super.onViewCreated(view, SavedInstanceState)

        navController = view.findNavController()

        binding.apply {
            next_btn.setOnClickListener {
                if (!TextUtils.isEmpty(inputRecipient.text.toString())) {
                    val bundle = bundleOf("recipient" to inputRecipient.text.toString())
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "You must provide a recipient!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            cancelBtn.setOnClickListener {
                activity!!.onBackPressed()
            }
        }
    }
}
