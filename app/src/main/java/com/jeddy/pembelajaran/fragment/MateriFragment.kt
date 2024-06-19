package com.jeddy.pembelajaran.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.jeddy.pembelajaran.R
import com.jeddy.pembelajaran.databinding.FragmentMateriBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MateriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MateriFragment : Fragment() {
    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    private var currentPage = 0
    private val materiList = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.logo,
        R.drawable.ic_launcher_background
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateMateri()

        binding.btnNext.setOnClickListener {
            if (currentPage < materiList.size - 1) {
                currentPage++
                updateMateri()
            } else {
                Toast.makeText(requireContext(), "Materi terakhir", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBack.setOnClickListener {
            if (currentPage > 0) {
                currentPage--
                updateMateri()
            } else {
                Toast.makeText(requireContext(), "Materi pertama", Toast.LENGTH_SHORT).show()
            }
        }

        binding.etSearch.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.btnSearch.visibility = View.VISIBLE
            } else {
                binding.btnSearch.visibility = View.GONE
            }
        }

        binding.root.setOnClickListener {
            // Ketika area di luar etSearch, btnBack, dan btnNext diklik
            // Hilangkan fokus dari etSearch dan sembunyikan btnSearch
            binding.etSearch.clearFocus()
        }

        binding.btnSearch.setOnClickListener {
            val searchText = binding.etSearch.text.toString()
            Toast.makeText(requireContext(), "Pencarian: $searchText", Toast.LENGTH_SHORT).show()
            // Implementasikan logika pencarian materi

            // Sembunyikan tombol pencarian setelah pencarian selesai
            binding.btnSearch.visibility = View.GONE
        }

        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchText = binding.etSearch.text.toString()
                Toast.makeText(requireContext(), "Pencarian: $searchText", Toast.LENGTH_SHORT).show()
                // Implementasikan logika pencarian materi

                // Sembunyikan tombol pencarian setelah pencarian selesai
                binding.btnSearch.visibility = View.GONE
                true
            } else {
                false
            }
        }
    }

    private fun updateMateri() {
        binding.ivMateri.setImageResource(materiList[currentPage])
        binding.tvPageNumber.text = "Materi ${currentPage + 1} dari ${materiList.size}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}