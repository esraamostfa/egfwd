package com.esraa.egfwd.shoestore.screens.shoe_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.esraa.egfwd.shoestore.R
import com.esraa.egfwd.shoestore.databinding.FragmentShoeDetailBinding
import com.esraa.egfwd.shoestore.databinding.FragmentShoeListBinding
import com.esraa.egfwd.shoestore.screens.shoe_list.ShoeListFragmentDirections
import com.esraa.egfwd.shoestore.screens.shoe_list.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate view and obtain an instance of the binding class.
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.viewModel = viewModel

        viewModel.shoeAddedEvent.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().popBackStack()
                viewModel.onAddShoeComplete()
            }
        })

        binding.cancelButton.setOnClickListener {
           findNavController().popBackStack()
        }

        return binding.root
    }

}