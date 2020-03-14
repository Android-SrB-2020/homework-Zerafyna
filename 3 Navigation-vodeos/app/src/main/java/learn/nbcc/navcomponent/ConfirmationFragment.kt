package learn.nbcc.navcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import learn.nbcc.navcomponent.databinding.FragmentConfirmationBinding
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding
    lateinit var recipientName: String
    private lateinit var amount: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipientName = arguments!!.getString("recipient") ?: "None"
        amount = arguments!!.getParcelable<Money>("amount") ?: Money(BigDecimal(0.0))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_confirmation,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name = recipientName
        binding.amount = "$${amount.amount}"
    }

}
