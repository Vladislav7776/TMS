package bunkou.tms.HomeWork5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import bunkou.tms.R
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nav = findNavController()
        addSort.setOnClickListener {
            nav.navigate(R.id.action_firstFragment_to_addFragment)
            //   Log.e("tag", "addSort")
        }
        viewSort.setOnClickListener {
            nav.navigate(R.id.action_firstFragment_to_viewFragment)
            //    Log.e("tag", "ViewSort")
        }
    }
}