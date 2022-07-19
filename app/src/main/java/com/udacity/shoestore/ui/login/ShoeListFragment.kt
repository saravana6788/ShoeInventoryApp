package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {


    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoeListFragmentBinding
    private val activityViewModel: SharedViewModel by activityViewModels()
    private val args: ShoeListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShoeListFragmentBinding.inflate(inflater)
        args.shoe?.let { activityViewModel.addNewShoe(it) }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        // TODO: Use the ViewModel
        activityViewModel.showShoesListData()

        activityViewModel.shoesListData.observe(viewLifecycleOwner, Observer { shoesList ->
            for (shoe in shoesList) {
                val showInfoLayout =
                    LayoutInflater.from(this.context).inflate(R.layout.shoe_info, null)
                showInfoLayout.findViewById<TextView>(R.id.shoeName).text = shoe.name
                showInfoLayout.findViewById<TextView>(R.id.shoeCompany).text = shoe.company
                showInfoLayout.findViewById<TextView>(R.id.shoeSize).text = shoe.size.toString()
                showInfoLayout.findViewById<TextView>(R.id.shoeDescription).text = shoe.description
                binding.shoeList.addView(showInfoLayout)
            }
        })

        binding.addShoe.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShowDetailFragment())
        }


    }

}