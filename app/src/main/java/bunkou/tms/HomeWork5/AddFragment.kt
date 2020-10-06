package bunkou.tms.HomeWork5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import bunkou.tms.HomeWork5.СollectionVariety.CoffeCollection
import bunkou.tms.R
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        button_addInMassiv.setOnClickListener {
            if (
                editTextSort.text.isBlank() ||  // проверяем не пустая ли
                editTextPrice.text.isBlank() ||
                editTextTextURL.text.isBlank()
            ) {
                Toast.makeText(context, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
        }

        CoffeCollection.add(
            DataCoffe(
                editTextSort.text.toString(),  // добавляем
                editTextPrice.text.toString().toDouble(),
                editTextTextURL.text.toString()
            )
        )

        Toast.makeText(context, "Добавлено!!!", Toast.LENGTH_SHORT).show()
        editTextSort.text.clear() // удаляет все элементы из коллекции
        editTextPrice.text.clear()
        editTextTextURL.text.clear()

    }
}