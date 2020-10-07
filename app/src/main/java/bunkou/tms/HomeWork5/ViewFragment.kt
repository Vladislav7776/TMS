package bunkou.tms.HomeWork5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import bunkou.tms.HomeWork5.СollectionVariety.CoffeCollection
import bunkou.tms.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_third.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (DataCoffe in CoffeCollection) {

            addSort(DataCoffe)
        }
    }

    private fun addSort(coffee: DataCoffe) {
        val brand = context?.let { // получаем доступ к ресурсам
            ConstraintLayout(it)  // аргумент it является не nullable-версией исходного объекта.
        }
        val imageView =
            ImageView(context).apply {// применяем цепочку вызовов к объекту, возвращает Unit(обратный вызов)

                id = View.generateViewId()
                layoutParams = ViewGroup.LayoutParams(350, 350)
            }
        Picasso.get().load(coffee.imageURL).into(imageView)
        val textViewSortName = TextView(context).apply {
            text = coffee.sort
            id = View.generateViewId()
            textSize = 30f
        }
        val textViewPrice = TextView(context).apply {
            text = coffee.price.toString()
            id = View.generateViewId()
        }
        val horizontalLine = View(context).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2)
            setBackgroundColor(ContextCompat.getColor(context, R.color.black95))
        }
        brand?.let {
            with(it) {
                addView(imageView)
                addView(textViewSortName)
                addView(textViewPrice)
                addView(horizontalLine)
            }
        }

        val set = ConstraintSet()
        set.constrainWidth(ConstraintSet.PARENT_ID, showCollection.width)
        set.clone(brand)
        set.connect(
            imageView.id,
            ConstraintSet.START,
            ConstraintSet.PARENT_ID,
            ConstraintSet.START,
            25
        )
        set.connect(imageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 10)
        set.connect(
            textViewSortName.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END,
            25
        )
        set.connect(
            textViewSortName.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP,
            25
        )
        set.connect(
            textViewPrice.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END,
            25
        )
        set.connect(
            textViewPrice.id,
            ConstraintSet.TOP,
            textViewSortName.id,
            ConstraintSet.BOTTOM,
            25
        )
        set.connect(
            horizontalLine.id,
            ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID,
            ConstraintSet.BOTTOM
        )
        set.applyTo(brand)
        showCollection.addView(brand)
    }

}



