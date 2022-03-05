package android.example.todo


import android.example.todo.databinding.FragmentShopBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil



class Shop : Fragment(),View.OnClickListener {


    private var binding:FragmentShopBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false)
        binding?.button?.setOnClickListener(this)
        return binding?.root
    }



    override fun onClick(view: View?) {

        val detail = Detail()

        val parameters = Bundle()

        parameters.putString("nameMovie", binding?.nameMovie?.text?.toString())
        parameters.putString("rangeMovie", binding?.rangeMovie?.text?.toString())
        parameters.putString("actorMovie", binding?.actorsMovie?.text?.toString())

        detail.arguments = parameters

        detail.show(parentFragmentManager, "detail")

    }



}