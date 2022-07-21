package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val activityViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_item,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())


    }





}