package com.esraa.egfwd.shoestore.screens.shoe_list
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.setMargins
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.esraa.egfwd.shoestore.R
import com.esraa.egfwd.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeListViewModel>()
private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class.
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        binding.addFab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        addShoeListViews(requireActivity())

        setupMenu()

        return binding.root
    }


    private fun  addShoeListViews(context: Context){

        viewModel.shoeList.value?.let {
            for(shoe in it)  {
                val shoeView = CardView(context)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(16)
                shoeView.layoutParams = params
                shoeView.cardElevation = 5.0F
                shoeView.radius = 20.0f
                val shoeContainer = LinearLayout(context)
                shoeContainer.orientation = LinearLayout.VERTICAL
                shoeContainer.setPadding(16, 16, 16, 16)
                val shoeNameTextView = TextView(context)
                val shoeSizeTextView = TextView(context)
                val shoeCompanyTextView = TextView(context)
                val shoeDescriptionTextView = TextView(context)
                shoeNameTextView.text = shoe.name
                shoeSizeTextView.text = shoe.size.toString()
                shoeCompanyTextView.text = shoe.company
                shoeDescriptionTextView.text = shoe.description
                shoeView.addView(shoeContainer)
                shoeContainer.addView(shoeNameTextView)
                shoeContainer.addView(shoeSizeTextView)
                shoeContainer.addView(shoeCompanyTextView)
                shoeContainer.addView(shoeDescriptionTextView)
                binding.shoeListContainer.addView(shoeView)


            }
        }

    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Validate and handle the selected menu item
                return   NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}